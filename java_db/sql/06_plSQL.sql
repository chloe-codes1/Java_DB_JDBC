--PL/SQL

SET SERVEROUTPUT ON ;

Create Procedure SALARY_CAL
    실행가능한 모듈이 데이터베이스에 만들어진다.  
   
##############################
   Procedure
   
##############################
--procedure 생성
create or replace procedure update_sal(v_empno in number)  --> v_empno가 local variable (매개변수)
is -- 변수 선언부가 올 수 있음
begin -- 여기부터 procedure 
 update emp
 set sal=sal*1.1
 where empno=v_empno;
end;
/  --> 이거 까지 입력해야 컴파일이 되고 생성됨! (Procedure created)


select*from emp;
--procedure 실행
execute update_sal(7369); --smith의 사번
commit;
  --> commit; 날려야함!

select*from emp;

--procedure 삭제
drop procedure update_sal;

--procedure 생성
create or replace procedure update_sal(v_deptno in number)
is
begin
update emp
set sal= sal*2
where deptno=v_deptno;
end;
/

execute update_sal(20);
select *from emp;
rollback;

--연습) procedure 생성
create or replace procedure deduct_sal (input_empno in number)
is 
begin
update emp
set sal= sal/2
where empno = input_empno;
end;
/

--king의 sal 반으로 줄이기 
execute deduct_sal (7839);
select*from emp;


*******************

Drop table book;

CREATE TABLE Book (
  bookid      NUMBER(2) constraint book_pk PRIMARY KEY,
  bookname    VARCHAR2(40),
  publisher   VARCHAR2(40),
  price       NUMBER(8) 
);

--procedure 생성
CREATE OR REPLACE PROCEDURE InsertBook(  --> 괄호 안에가 매개변수임!
    myBookID IN NUMBER,
     myBookName IN VARCHAR2,
     myPublisher IN VARCHAR2,
     myPrice IN NUMBER)
 AS
 BEGIN
      INSERT INTO Book(bookid, bookname, publisher, price)
      VALUES(myBookID, myBookName, myPublisher, myPrice);
             --> book id는 이렇게 입력받는 방법 말고 sequence나 함수로 증가하게 할 수도 있다!
 END;
/

--() 정보 넘겨줄테니까 InsertBook procedure 실행해
execute InsertBook(1,'java~~~', '한빛 출판사',27000);
       --> execute or esec 입력 라면 됨

rollbck;

select from book;


**********************************
동일한 도서가 있는지 점검한 후 삽입하는 프로시저(BookInsertOrUpdate)
**********************************

CREATE OR REPLACE PROCEDURE BookInsertOrUpdate(
    myBookID NUMBER,
    myBookName VARCHAR2,
    myPublisher VARCHAR2,
    myPrice INT) --int나 float을 써도 되지만 내부적으로 다 number로 처리됨 (int, float은 ANSI 기반!)
 AS
    mycount NUMBER; --변수 선언 (NUMBER type의 mycount 선언)
 BEGIN
   SELECT COUNT(*) INTO mycount FROM Book --count한 값을 mycount에 집어 넣고 있음
     WHERE bookname LIKE myBookName;
   IF mycount!=0 THEN  --if구문 시작
     UPDATE Book SET price = myPrice   --> mycount를 기준으로 이미 있으면 update 구문 수행
       WHERE bookname LIKE myBookName;
   ELSE
     INSERT INTO Book(bookid, bookname, publisher, price)   --> 없으면 insert 구문 수행
       VALUES(myBookID, myBookName, myPublisher, myPrice);
   END IF;  --if구문이 여기서 끝난다는걸 알려주기 (END IF)
 END;
/

--procedure 실행하기
exec BookInsertOrUpdate(1,'db','bit 출판사',0);
    -->exec 대신 execute 해도 됨!

--다시 실행해서 update 가능
execute BookInsertOrUpdate(1,'db','bit 출판사',200);


##########################################
FUNCTION

: Oracle에서 제공하는 내장함수, 사용자 정의 함수
########################################

** procedure과 function의 차이점 **
: function은 반드시!! return type이 있어야함!! void가 안됨!!!!!

--사용자 정의 function 만들기
CREATE OR REPLACE FUNCTION fn1(price NUMBER) RETURN INT
  IS
     myInterest NUMBER; --변수선언
  BEGIN
  /* price가 3000원 이상이면 10%, 3000원 미만이면 5% */
    IF Price >= 3000 THEN myInterest := Price * 0.1;
    ELSE myInterest := Price * 0.05;  --> pl/sql에서는 '='
    이 아니라 ':=' 사용!
   END IF;
   RETURN myInterest; --> function은 반드시! return 값이 있어야 한다!
  END;
/

--사용자 정의 function 실행하기
select empno, ename, sal, fn1(sal) from emp;




########################################################################
trigger
: 데이터의 변경 (INSERT, DELETE, UPDATE)문이 실행될 때 자동으로 같이 실행되는 프로시저

########################################################################


create table item(
  code char(6) primary key, --물품 코드
  name varchar2(15) not null,
  company varchar2(15),
  price number(8),
  cnt number default 0 -- 재고 수량  
);


create table warehouse(
   num number(6) primary key, --입고 번호
   code char(6) references item(code), --> fk 설정되어 있음 (item table의 pk code를 reference 함)
   indate date default sysdate, --입고날짜
   incnt number(6),
   inprice number(6),
   totalprice number(8)
);

insert into item(code, name, company, price)
values('c0001', '에어컨', '삼성', 1000000);

insert into item(code, name, company, price)
values('c0002', '선풍기', 'LG', 50000);

commit;

SELECT * FROM item;

--재고 수량 증가시 갱신하기 위한 트리거 생성
create or replace trigger cnt_add
after insert on warehouse --warehouse에 item이 추가되면
for each row
  begin
     update item set cnt = cnt + :new.incnt  --수를 세서 저장하겠어
     where code=:new.code; --new 선언은 insert문, update문에서만 사용
end;
/

--재고 수량 감소시 갱신하기 위한 트리거도 만들어보기!! warehouse에 delete가 일어날때 ~


insert into warehouse(num, code, incnt, inprice, totalprice)
values(1,'c0001',10, 900000, 9000000 );

SELECT * FROM item;
SELECT * FROM warehouse;

#################################################
Trigger  book  p270

=> Trigger는 호출하지 않아도 자동으로 동작한다
################################################
set serveroutput on;

drop table book;

CREATE TABLE Book (
  bookid      NUMBER(2) PRIMARY KEY,
  bookname    VARCHAR2(40),
  publisher   VARCHAR2(40),
  price       NUMBER(8) 
);

drop table book_log;

 CREATE TABLE Book_log(
    bookid_l NUMBER,
    bookname_l VARCHAR2(40),
    publisher_l VARCHAR2(40),
    price_l NUMBER
 );

--trigger 생성         
CREATE OR REPLACE TRIGGER AfterInsertBook
     AFTER INSERT ON Book FOR EACH ROW  --book table에 insert 작업이 일어난 이후에 알아서 자동으로 동작할꺼야
     DECLARE

     BEGIN
        INSERT INTO Book_log   --book_log라는 이름의 backup file에 저장하겠어
           VALUES(:new.bookid, :new.bookname, :new.publisher, :new.price); --> :new.bookid..등등 = 방금 insert 된 data 뜻함!
        DBMS_OUTPUT.PUT_LINE('Book_log 테이블에 백업..'); 
        		--> console 창에 이 메세지를 띄워줘... (이거 하려면 set serveroutput on; 해아함!)
     END;
/

set serveroutput on;

insert into book values(1,'java 주현','주현 출판사',9900);
insert into book values(2,'sql 주현','주현 출판사',10000);


         
######################################################################
CURSOR  -p268 => 잘 안쓰니까 한번 책 보기나 해봐라~

######################################################################

drop PROCEDURE Interest;
CREATE OR REPLACE PROCEDURE Interest
 AS
    myInterest NUMERIC;
    Price NUMERIC;
    CURSOR InterestCursor IS SELECT saleprice FROM Orders;
 BEGIN
   myInterest := 0.0;
   OPEN InterestCursor;
   LOOP
       FETCH InterestCursor INTO Price;
       EXIT WHEN InterestCursor%NOTFOUND;
       IF Price >= 30000 THEN
           myInterest := myInterest + Price * 0.1;
       ELSE
           myInterest := myInterest + Price * 0.05;
       END IF;
    END LOOP;
    CLOSE InterestCursor;
    DBMS_OUTPUT.PUT_LINE(' 전체 이익 금액 = ' || myInterest);
 END;
 /