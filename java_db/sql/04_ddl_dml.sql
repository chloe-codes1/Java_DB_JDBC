#####################################
Table 생성

DDL (Data Definition Language)
: 취소가 안 됨 (Auto commit)
  -> rollback의 여지가 없다              
Table은 실제로 데이터들이 저장되는 곳이라고 생각하면 쉽게 이해 할 수 있으며,
CREATE TABLE 명령어를 이용해서 table을 생성 할 수 있다
#####################################

_______________________________________________________

데이터타입설명
	VARCHAR2 타입
	- 가변길이 문자형 데이터 타입 
	- 최대 길이 : 2000 바이트(반드시 길이 지정) 
	- 다른 타입에 비해 제한이 적다 
	- 일부만 입력시 뒷부분은 NULL 
	- 입력한 값의 뒷부분에 있는 BLANK도 같이 입력 
	- 전혀 값을 주지 않으면 NULL 상태 입력 
	- 지정된 길이보다 길면 입력시 에러 발생 
	- 컬럼 길이의 편차가 심한 경우, NULL 로 입력되는 경우가 많은 경우 VARCHAR2 사용 

	NUMBER 타입
	- 숫자형 데이타 타입, 음수, ZERO, 양수 저장 
	- 전체 자리수는 38자리를 넘을 수 없다 
	- 소수점이 지정되지 않았을 때 소수점이 입력되거나, 지정된 소수점자리 이상 입력되면 반올림되어 저장 
	- 지정한 정수 자리수 이상 입력시 에러 발생 
	- 연산이 필요한 컬럼은 NUMBER타입으로 지정한다. 
	- NUMBER(p,s) 로 지정시 p는 s의 자리수를 포함한 길이므로 감안하여 P의 자리수를 결정 
	- NUMBER 타입은 항상 가변길이므로 충분하게 지정할 것 

	DATE 타입
	- 일자와 시간을 저장하는 날짜형 타입 
	- 일자나 시간의 연산이 빈번한 경우 사용 
	- 포함정보 : 세기, 년도, 월, 일, 시간, 분, 초 
	- NLS_DATE_FORMAT을 이용하여 국가별 특수성을 해결 
	- 특별히 시간을 지정하지 않으면 00:00:00로 입력 됨 
	- 특별히 일자를 지정하지 않았다면 현재월의 1일로 지정 됨 
	- SYSDATE는 현재일과 시간을 제공 

_______________________________________________________
	

-- [ table 삭제 ]
drop table book;
     --> drop table로 삭제 된것은 취소 불가! auto commit
     --> rollback의 여지가 없다!
     
-- [ table 생성 ]

--DOS 창에 입력하면 Table created라고 뜸
--Oracle에서는 Table을 Object라고 함!
create table book(
	bookno  number(5),
	title   varchar2(30), --> varchar2 = 가변 길이 string
	author  varchar2(30),
	pubdate date 
);




----DOS창에서 보기 편하려고..----
col bookno for 9999;
col title for a14;
col author for a14;
col price for 999999;

select*from book;     

#####################################
DML (Data Manipulate Language)
 -> Eclipse 창 말고 DOS창에서 실행하기!
 
#####################################

insert into book values(1,'java','kim', sysdate);
       --> 이렇게 DOS창에 입력하면 1 row created 라고 뜸
       --> 하지만 Oracle SQL Developer나 다른 DOS창에 다시 SCOTT/TIGER 로그인 해보면 추가 안되어 있음
	   --> why? Commit이 안되어 있어서! 
	   --> Commit을 해야 확정이 된다 (확정 후에는 취소 불가!)
	   
insert into book values(2,'jsp','홍',sysdate);
insert into book values(3,'jsp','홍',sysdate);
insert into book values(4,'jsp','홍',sysdate);
insert into book values(5,'jsp','홍','19/02/02');

commit;
--> commit을 해야 확정이 되어서 다른 client들도 볼 수 있게 됨!

rollback;
--> 마지막으로 commit한 시점까지 insert 등 변경한 내용이 취소 됨

insert into book values(6,'db');
--> not enough values 라고 뜸   => book이 갖고있는 column을 충족하지 않아서! 

--입력한 column이 어떤건지 ()로 알려주기
insert into book (bookno, title) values(6,'db');

--이렇게 column을 명시 하고 insert 하는게 좋음
insert into book (bookno, title, author, pubdate) 
values(7,'db', null,null);

-- [ Delete ]
-- book table에 있는 data 삭제
-- 아무런 조건을 주지 않으면 모든 row가 사라짐  => 보통은 조건이 따라다님
-- commit을 하기 전까지는 rollback의 여지가 있다!
delete from book;

rollback;

delete from book where title = 'db';
delete from book where author is null;
delete from book where author = '홍';

--book table의 구조를 보여줘!
desc book;

## table 구조(column) 변경하기

[ add() ] =>  column 추가
alter table book add (price number(7));
--> alter는 ddl이라서 (auto-commit이라서) 그전에 commit하지 않은 내용들까지 다 commit 해버림

--추가한 column (price) 포함하는 data insert 하기
insert into book (bookno, title, author, pubdate, price) 
values(7,'db', null,null,900);


[ update() ] => 이미 들어간 data 수정
update book set price = 10;
--> 모든 book table의 price가 10이 됨
rollback;

update book set price = 1000.99;
--> 소수점 이하 자리를 입력했더니, number는 정수형이라서 자동으로 반올림 된 값 (1001)이 출력됨
commit;

--조건을 줘서 title이 'java'인 책의 price 변경하기
update book set price=900 where title = 'java';
commit;

--여러개의 column 한번에 update 하기
update book set author = '김주현', price = 10000, pubdate = '95/08/25' where bookno = 3;


[ table 수정하기 ] -> alter는 ddl이므로 auto-commit!
--price의 type을 실수로 변경하기
alter table book modify(price number(7,2));
      --> 이미 data가 들어있어서 " column to be modified must be empty to decrease precision or scale" 라고 뜸

--null값 다 넣어놓고 table 수정함
update book set price = null;
alter table book modify(price number(7,2));

--이제 실수도 입력 가능함
update book set price = 1000.99;


[ table의 column 삭제하기 ]
alter table book drop column price;
--> ddl이라 rollback의 여지가 없다! auto-commit


[ table의 이름 변경하기 ]
rename book to book2;
--> rollback의 여지 없음 (auto-commit)

rename book2 to book;


#############################################################
-- DDL & DML 정리  

[ ddl ]

drop table book;
create table book(
	bookno  number(5),
	title   varchar2(30), --> varchar2 = 가변 길이 string
	author  varchar2(30),
	pubdate date 
);
alter table book add (price number(7));
alter table book modify(price number(7,2));
alter table book drop column price;
rename book to book2;
rename book2 to book;



[ dml ]

insert into book(bookno, title, author, pubdate) values (4,'db',null,null);
delete from book where author = '홍';
update book set author = '김주현', price = 10000, pubdate = '95/08/25' where bookno = 3;


delete from book;     =>  rollback; 의 여지가 있음 + table 남아 있음
truncate table book;  =>  rollback; 의 여지 없음 (auto-commit) + table 남아 있음
     --> 마치 ddl처럼 rollback 안되지만, drop과는 다르게 table이 남아 있음
     --> ＊ TRUNCATE 란 ?
     --  개별 행 삭제를 로깅하지 않고 모든 행을 테이블에서 제거 .
     --  TRUNCATE  TABLE은 기능상 Where절이 없는 DELETE문과 동일하지만 더 빠르고
     --  시스템 및 트랜잭션 로그 리소스를 덜 사용

drop table book;      => rollback; 의 여지 없음 (auto-commit) & table 남지 않음

#############################################################



select*from emp;
select*from dept;


## 기존의 table의 select 결과를 바탕으로 데이터를 가져다가 새로운 table을 만들 수 있음!

--emp table과 똑같은 emp2 table만들기
create table emp2 as select*from emp;

--dept table과 똑같은 emp2 table만들기
create table dept2 as select*from dept;

--내가 원하는 column만 골라서 table만들 수도 있음
create table dept3 as select deptno,dname from dept;


##새로운 deptno가 포함된 row 추가하기

--dept는 제약조건이 있고, dept2는 제약조건 없음
insert into dept values(50, 'EDU', 'Seoul');
insert into dept2 values(50, 'EDU', 'Seoul');
--> 일단 여기까지는 둘다 insert 됨 (deptno가 50이 없었기 때문)
commit;


##중복되는 deptno가 포함된 row 추가하기

insert into dept values(10, 'EDU', 'Seoul');
    --> dept의 제약조건 때문에 10 안들어감!!
    --> primary key는 중복을 불허하는데 deptno로 이미 있는 10이 insert 되었기 때문!
    --> "unique constraint (SCOTT.PK_DEPT) violated" 라고 뜸
    
insert into dept2 values(10, 'EDU', 'Seoul');
    --> dept2는 따로 제약조건 없어서 중복되어도 그냥 들어감


##존재하지 않는 deptno를 갖는 emp 추가하기

insert into emp (empno, ename, job, sal,deptno) 
            values(9999,'홍길동','MANAGER',2000,90);
--> 이거 실행하자 "ORA-02291: integrity constraint (SCOTT.FK_DEPTNO) violated - parent key not found" 라고 뜸
--> deptno 90이 존재하지 않아서 insert 할 수 없다고 Oracle이 알려주는 것! (무결성)  => emp table의 제약조건 때문

insert into emp2 (empno, ename, job, sal,deptno) 
            values(9999,'홍길동','MANAGER',2000,90);
--> emp2에는 따로 제약조건이 없어서 deptno 90번이 존재하지 않아도 insert 가능함
--> 중복도 허용해서 위의 같은 내용 계속 넣었는데 primary key가 없어서 empno가 중복되어도 계속 insert 가능함
     ==> table을 생성 할 때는 적절한 제약조건이 있어야 하며, primary key는 반드시 있어야 한다!

     
     
     
####################################################
Transaction

: 동기화
####################################################
create table emp2 as select*from emp;
select*from emp2;

Dos 창1
delete from emp2 where deptno = 10;
--> commit이나 rollback 명령 내리지 않은 상태

Dos 창2
update emp2 set comm=0 where deptno =10;
--> block 됨! 창1에서 commit or rollback 명령 수행하면 lock 풀림 (그때까지 커서만 깜빡깜빡 하고 있음)
--> 창1에서 rollback하자 바로 동작함



### 다시 book table

select*from book;
drop table book;


### table 생성 시 제약조건 주기 ###

create table book(               --> 제약조건 이름 부여 (내 맘)
	bookno  number(5) constraint scott_book_pk primary key, --> unique하면서 null을 불허
	title   varchar2(30) constraint scott_book_title_unique unique,  --> unique (중복 불허): null을 허용
	author  varchar2(30),
	price number(7,2) constraint book_price_check check(price>0),
	pubdate date  sysdate
);

insert into book (bookno, title, author, price, pubdate) 
values(1,'db', '홍길동', 1000, sysdate);
--> 이걸 두번 insert 하자, 에러가 뜸 "unique constraint (SCOTT.SCOTT_BOOK_PK) violated"
--> table 생성 시 primary key 제약조건을 줘서!!

insert into book (bookno, title, author, price, pubdate) 
values(2,'db', '홍길동', 1000, sysdate);
--> 이거 insert 하자 "ORA-00001: unique constraint (SCOTT.SCOTT_BOOK_TITLE_UNIQUE) violated" 라고 에러 뜸
--> table 생성 시 title에 unique 제약조건을 줘서!!

insert into book (bookno, title, author, price, pubdate) 
values(2,'jsp', '홍길동', -1000, sysdate);
--> "check constraint (SCOTT.BOOK_PRICE_CHECK) violated" 에러 뜸
--> table 생성 시 price > 0 제약조건을 줘서!


insert into book (bookno, title, author, price, pubdate) 
values(3,'java', '김길동', 32000, );

commit;

## 제약조건 확인하기
select CONSTRAINT_name
from user_cons_columns
where table_name = 'BOOK';
                   --> 여기 table명만 다르게 해서 다 확인해봐롸~


drop table book;

--primary key 있는 book table 생성
create table book(               --> 제약조건 이름 부여 (내 맘)  => 제약조건 이름도 충돌 남! 중복되면 안됨!
	bookno  number(5) primary key, --> unique하면서 null을 불허
	title   varchar2(30) unique,  --> unique (중복 불허): null을 허용
	author  varchar2(30),
	price number(7,2) check(price>0),
	pubdate date  sysdate --> 언급하지 않으면  값이 들어 갈 것임
);
--시험
create table Customer (
	custid number(5) constraint customer_pk primary key,
	name varchar2(40),
	address varchar2(40),
	phone varchar2(30)
);





drop table book;

--primary key 없는 book table 생성     => 따로 밖에서 제약조건 걸으려구~
create table book(
     bookno number(5),
     title varchar2(30) unique,
     author varchar2(30),
     price number(7,2) check(price>0),
     pubdate date  sysdate
);

--primary key 제약조건 추가하기   => add
alter table book add CONSTRAINT book_bookno_pk primary key(bookno);

--제약조건 삭제    => drop
alter table book drop CONSTRAINT book_bookno_pk;


insert into book (bookno, title, author, price, pubdate) 
            values(3,'java', '김길동', 32000, );

insert into book (bookno,title,author,price)
            values(2, null, '박길동' ,22000);

insert into book (bookno,title, author,price, pubdate)
            values(1,null, '이길동' , 20000, );
            
select*from book;
	  
	  
	  
drop table book;	  

--primary key 없는 book table
create table book(               
	bookno  number(5),
	title   varchar2(30) unique,  
	author  varchar2(30),
	price number(7,2) check(price>0),
	pubdate date default sysdate
);	

--시험
create table Orders(
	orderid NUMBER(5) CONSTRAINT orders_pk primary key,
	custid NUMBER(5) CONSTRAINT custid_not_null NOT NULL, 
	bookid NUMBER(5) CONSTRAINT bookid_not_null NOT NULL,
	saleprice NUMBER(5),
	orderdate Date
);

alter table Orders add CONSTRAINT orders_fk FOREIGN KEY(custid) REFERENCES customer ON DELETE CASCADE;



insert into orders(orderid,custid,bookid,saleprice,orderdate)
values(10,1,22,1000,sysdate);

delete from customer where custid=1;

--제약조건 따로 밖에서 만들기
alter table book add CONSTRAINT book_bookno_pk primary key(bookno);

--제약조건 없애기
alter table book drop CONSTRAINT book_bookno_pk;

--테스트해보기
insert into book (bookno, title, author, price) 
values(1,'java3', null, 32000);

--book table의 제약조건 확인
select CONSTRAINT_name
from user_cons_columns
where table_name = 'BOOK';


################################################
emp dept

################################################
--dept2 지우기
drop table dept2;
select*from dept;

--emp2 지우기
drop table emp2;
select*from emp;

--dept table에 우리가 아까 넣은 50 EDU SEOUL 지우기
delete from dept where deptno=50;
commit;

--dept2, emp2 table 만들기
create table dept2 as select*from dept;
create table emp2 as select*from emp;

--제약조건 primary key 추가하기
alter table dept2 add CONSTRAINT dept2_deptno_pk primary key(deptno);
alter table emp2 add CONSTRAINT emp2_empno_pk primary key(empno);

--foreign key 추가하기
alter table emp2 add foreign key(deptno) references dept2;

alter table emp2 add CONSTRAINT emp2_fk1 foreign key(deptno) references dept2;
alter table emp2 add CONSTRAINT emp2_fk_mgr foreign key(mgr) references emp2;

### Primary key & Foreign key Test 하기

-- PK test
select*from dept2;
insert into dept2 values(10,'EDU', 'SEOUL');
-->unique constraint (SCOTT.DEPT2_DEPTNO_PK) violated 에러 남  => pk 동작 잘하고 있음

select*from emp2;
insert into emp2 (empno,ename,hiredate,sal,deptno) values(7839,'김주현',sysdate,0,40);
--> unique constraint (SCOTT.EMP2_EMPNO_PK) violated 에러남 => 여기 pk도 동작 잘하고 있음


-- FK test 1
insert into dept2 values(50,'EDU', 'SEOUL');
insert into emp2 (empno,ename,hiredate,sal,deptno) values(9999,'김주현',sysdate,0,50);

-- FK test 2   => foreign key에 null 허용 하는지 확인)
insert into emp2 (empno,ename,hiredate,sal,deptno) values(7777,'박주현',sysdate,0,null);
       --> foreign key는 null 값을 허용한다!

-- FK test 3  
insert into emp2 (empno,ename,hiredate,sal,deptno,mgr) values(8888,'이주현',sysdate,0,null,10);
       --> mgr에 대해 조건이 안걸려 있어서 mgr번호중에 10 없는데 insert 성공함  => self join 시 문제 말생 할 것임 

-- self join
### mgr foreign key 제약 조건 추가
alter table emp2 add foreign key(mgr) references emp2;
      --> foreign key는 무조건 pk를 reference 하기 때문에 table 이름만 지정해주면 됨
      
--dept2 table 지우기
drop table dept2;
     --> dept2를 referencing 하고 있는 emp2가 있어서 못지움
     --> emp2를 먼저 지우거나, cascade 해야함!

--방법1) emp2 먼저 지우기
drop table emp2;
drop table dept2;

--방법2) dept2를 먼저 지우려면 cascade CONSTRAINT 하기
drop table dept2 cascade CONSTRAINT;
drop table emp2 cascade CONSTRAINT;


===========================================
(8/21)
create table dept2 as select*from dept;
create table emp2 as select*from emp;

--제약조건 primary key 추가하기
alter table dept2 add CONSTRAINT dept2_deptno_pk primary key(deptno);
alter table emp2 add CONSTRAINT emp2_empno_pk primary key(empno);

--foreign key 추가하기
alter table emp2 add foreign key(deptno) references dept2;

alter table emp2 add CONSTRAINT emp2_fk1 foreign key(deptno) references dept2;
alter table emp2 add CONSTRAINT emp2_fk_mgr foreign key(mgr) references emp2;

--deptno = 20 지우기
delete from dept2 where deptno = 20;
      --> " integrity constraint (SCOTT.EMP2_FK1) violated - child record found" 라고 에러 뜸

--emp2_fk1 제약조건 지우기
alter table emp2 drop CONSTRAINT emp2_fk1;

--emp2_fk1 제약조건 다시 만들기  ver1)
--       => ON DELETE SET NULL; 조건 추가
--       => 삭제되고 자식은 NULL이 됨
alter table emp2 add CONSTRAINT emp2_fk1 
foreign key(deptno) references dept2 
ON DELETE SET NULL;

#####################
  [ ON DELETE ]

ON DELETE cascade: 해당하는 fk를 가진 참조행도 삭제 (연결 삭제)
ON DELETE set null: 해당하는 fk를 null로 바꿈

#####################

--다시 deptno=20 지우기
delete from dept2 where deptno = 20;
    --> 아까는 안되던게 제약조건 바꾸니까 됨
    --> dept2의 deptno = 20이 삭제되는 대신에 값이 없어서 referencing을 못하니까 emp2 table의 deptno=20인 애들은 NULL로 바뀌어 있음!

rollback;
--> rollback 하니 다시 deptno = 20 돌아와있음


--emp2_fk1 제약조건 지우기
alter table emp2 drop CONSTRAINT emp2_fk1;


--emp2_fk1 제약조건 다시 만들기  ver2) 연결 삭제
--	    => ON DELETE CASCADE; 조건 추가
--      => 삭제되고 자식도 삭제...동반...안녕...
alter table emp2 add CONSTRAINT emp2_fk1
foreign key(deptno) references dept2
ON DELETE CASCADE;

--다시 deptno=20 지우기
delete from dept2 where deptno = 20;
       --> emp2 table에 deptno=20 인 애들 다 사라짐...사요나라..

--emp2_fk1 제약조건 지우기
alter table emp2 drop CONSTRAINT emp2_fk1;


delete from dept where deptno=50;

