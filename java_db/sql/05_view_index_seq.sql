######################################
p231 VIEW

- 권한 체크
######################################

뷰란?
- 뷰는 하나의 가상 테이블이라 생각하면 된다.
- 뷰는 실제 데이터가 저장 되는 것은 아니지만 뷰를 통해 데이터를 관리 할 수 있다.
- 뷰는 복잡한 Query를 통해 얻을 수 있는 결과를 간단한 Query로 얻을 수 있게 한다.
- 한 개의 뷰로 여러 테이블에 대한 데이터를 검색 할 수 있다.
- 특정 평가 기준에 따른 사용자 별로 다른 데이터를 access 할 수 있도록 한다.
- select의 결과값을 table로 다루겠다

select ename, sal, d.deptno,dname,loc
from emp e, dept d
where e.deptno = d.deptno;

--SCOTT/TIGER에게 dba급 권한 주기 by system/1234
conn system/1234;
grant dba to SCOTT;
conn SCOTT/TIGER;


## VIEW 만들기

--중복 허용하지 않아서 create or replace 로 함
-- : 없다면 만들어주고 있다면 replace 해줘어~
create or replace view emp_dept     --> create는 auto-commit!
as
select ename, sal, d.deptno,dname,loc
from emp e, dept d
where e.deptno = d.deptno;

select*from emp_dept;
   --> select문으로 emp, dept table 모두 볼 수 있음
   --> view로 만듬으로써 sql구문이 간단해짐!

--view 삭제
drop view emp_dept;

--새로운 view 생성
create or replace view emp_dept     
as
select*
from emp e, dept d
where e.deptno = d.deptno;
      -->  "duplicate column name" 이라고 뜸
      --> emp table의 deptno와 dept의 deptno가 중복되기 때문

--제대로 다시 만들기
create or replace view emp_dept     
as
select ename, sal, hiredate, d.deptno, dname, loc
from emp e, dept d
where e.deptno = d.deptno;

select*from emp_dept;
select*from tab;

select user from dual;



 [ 상관관계 SUB QUERY ]
--자기가 속한 부서의 평균 급여보다 적게 받는 사람들의 명단을 view로 만드세요.
--     view이름 = lowsalavg

create or replace view lowsalavg
as
select ename, sal, deptno 
from emp outer
where sal < ( select avg (sal) from emp where deptno=outer.deptno)
order by sal;

select*from lowsalavg;

--(다시해보기)
--자기가 속한 부서의 평균 급여보다 많이 받는 사람들의 명단을 view로 만드세요.
select*from emp;
select avg(sal) from emp;
select avg(sal) from emp where deptno=10;

create or replace view highsalavg
as
select*
from emp e
where sal > (select avg(sal) from emp where deptno=e.deptno)
order by sal;

select*from highsalavg;


######################################
SEQUENCE

######################################

시퀀스란?
- 유일(UNIQUE)한 값을 생성해주는 오라클 객체   -> vendor사에 의존적인 code
- 시퀀스를 생성하면 기본키와 같이 순차적으로 증가하는 컬럼을 자동적으로 생성 할 수 있다.
- 보통 PRIMARY KEY 값을 생성하기 위해 사용한다
- 메모리에 Cache 되었을 때 시퀀스 값의 엑세스 효율이 증가한다.
- 시퀀스는 테이블과는 독립적으로 저장되고 생성된다.

delete from dept2;
select*from dept2;
select*from emp2;
  --> 제약조건(on delete cascade) 있어서 연결삭제 되어서 둘다 no rows selected
  
commit;

--deptno가 중복되지 않게 관리하는 sequence를 만들겠어
create sequence deptno_seq;
    --> 기본 sequence (1부터 1씩 증가함)
insert into dept2 (deptno, dname,loc) values(deptno_seq.nextval,'인사부','비트');
  
[ .nextval ]  --> 새로운 시퀀스 값을 반환
:1부터 시작해서 순차적으로 deptno를 생성해줌!    
==> sequence가 관리해줘서 계속 같은 내용 insert 해도 들어감

[ .currval ]  --> 마지막 사용값을 반환
: 현재 value 상태 확인해줌                   
select deptno_seq.currval from dual;

drop sequence deptno_seq;

--deptno가 10부터 10씩 증가하는 sequence 생성
create sequence deptno_seq start with 10 increment by 10;

insert into dept2 (deptno, dname,loc) values(deptno_seq.nextval,'인사부','비트');

select*from dept2;

delete from dept2;
commit;

------시험-------
create sequence seq_stid
increment by 1
start with 100 maxvalue 10000;

--새로운 시퀀스 값을 반환
select seq_stid.nextval from dual;
--마지막 사용값을 반환
select seq_stid.currval from dual;
-----------------


--sequence 사용하지 않고도 순차적으로 deptno 늘어나게 하기
insert into dept2 (deptno, dname, loc)
values ((select nvl(max(deptno),0)+10 from dept2), '주현이팀', '주현회사');


######################################
index

primary key들은 다 index가 있다
검색 column에 자주 쓰이는 애는 index로 만들어 주는것이 좋다.

######################################

select*from emp;
select*from dept;

[ autotrace ]
--추적하겠다...  => 실행 계획이 표시됨
set autotrace on;

--Index Unique Scan
select*from emp where empno=7698;		--> index 기반 select 동작    => empno는 pk라서

--Table Access Full
select*from emp where ename='FORD';		--> full scan

    --> set autotrace on으로 어떻게 동작하는지 보니까 둘이 다름..확인해봐 다시..
	--> index 기반으로 동작하면 성능이 좋음!   
	--> but, index가 많아지면 overhead가 발생하므로 이점 참고!

[ Index와 Full scan의 차이점 ]
: index는 목차가 있어서 목차 보고 찾으면 되고, full scan은 목차 없어서 다~ 봐야함

--index 생성하기   => create은 auto-commit
create index emp_ename_idx on emp(ename);

--index를 만들었기 때문에 full scan 아니고 Index Range Scan이 되었음!
select*from emp where ename='FORD';

--index 삭제하기
drop index emp_ename_idx;

--다시 autotrace 끄기
set autotrace off;

--Table 별로 Index 확인 가능
select index_name, table_name from user_indexes;
 

--백업 해보기 p515
sqlplus "/as sysdba"

create or replace directory scott_backup as 'c:\lib\backup';

grant read, write on directory scott_backup TO SCOTT;

--SCOTT Schema의 모든 자료 백업 (export)하기
[ EXPDP ]
: Data Pump Export Utility의 약자로, 데이터를 백업(Export)하는 명령
EXPDP SCOTT/TIGER DIRECTORY=scott_backup DUMPFILE=scott_20190821.dmp

--SCOTT Schema의 자료 import 하기
[ IMPDP ]
: Data Pump Import Utility의 약자로, 백업된 자료를 복원(Import)할 때 사용하는 명령
IMPDP SCOTT/TIGER DIRECTORY=scott_backup DUMPFILE=scott_20190821.dmp

