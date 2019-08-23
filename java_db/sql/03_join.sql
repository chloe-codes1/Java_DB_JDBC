-- SCOTT/TIGER;

select*from EMP;

################
 [ Select 구문 ]
   select
   from
   where
   group by
   having
   order by
################

select ename,sal from EMP where deptno=10;

--Select절에 deptno가 없더라도 deptno순으로 order by(정렬) 가능하다
--why? projection은 가장 마지막에 수행되기 때문!
select ename,sal from EMP order by deptno;
select ename,sal,deptno from EMP order by deptno;

##########################################
Oracle join

##########################################
--이렇게 하면 두개의 서로 다른 table들이 곱해서 출력됨...12x4=48개의 row가 출력됨 ...노오우
select ename,dname
from emp, dept;

--Primary key와 Foreign key를 비교하는 조건문이 반드시 들어가야 함!
--table수 -1 개의 조건 (where절)이 필요함
-- (아래 방식은 Oracle 전용 조건 방식임)
select ename,dname
from emp, dept
where emp.deptno = dept.deptno;


--deptno가 양쪽 table에 있기 때문에 select구문에 사용 시 어느 table의 deptno를 말하는건지 명시해줘야함!
select ename,dname,dept.deptno
from emp, dept
where emp.deptno = dept.deptno;

select ename,dept.deptno "부서 번호",dname,loc
from emp, dept
where emp.deptno = dept.deptno;

--table이름 alias 시키기
select ename, d.deptno "부서 번호",dname,loc
from emp e, dept d
where e.deptno = d.deptno;

--완전히 두 table을 합해버려서 모든 내용 출력됨 (deptno는 두 번 출력됨)
select*
from emp e, dept d
where e.deptno = d.deptno;

--조건이 두 개라서 and로 이었음
select*
from emp e, dept d
where e.deptno = d.deptno and sal>2500;


########################################
ANCI join 표준

1)  ,  -> join
2) where -> on
########################################
select ename, d.deptno,dname,loc
from emp e, dept d
where e.deptno = d.deptno;

(Oracle join => ANCI join으로 변환)

select ename, d.deptno,dname,loc
from emp e join dept d
on e.deptno = d.deptno;

-- [ inner join ]
--양쪽에 모두 있는 내용만 출력 하는 것
--(여기서 inner는 위에처럼 생략 가능)
select ename, d.deptno,dname,loc
from emp e inner join dept d
on e.deptno = d.deptno
where sal>2500;


-- [ outer join ]

## Oracle 방식
select * from emp;
select * from dept;

select ename,sal,loc, e.deptno
from emp e, dept d
where e.deptno = d.deptno;
--> 이렇게 하면 양쪽에 둘다 있는 내용만 출력하기 때문에 사원이 없는 deptno 40은 출력되지 않음

*** (+) 마킹 하기   => '='를 기준으로 양쪽 중 한 쪽만 가능
*** + 는 null 쪽에 마킹한다
--> 이게 바로 Oracle 방식의 outer join

--null값이 있는 emp에 (+) 마킹함
select ename,sal,loc, d.deptno
from emp e, dept d
where e.deptno(+) = d.deptno;


## ANSI 방식 inner join
select ename,sal,loc, e.deptno
from emp e join dept d
on e.deptno = d.deptno;

## ANSI 방식 outer join
--오른쪽이 master(기준)면 right outer join
--왼쪽이 master면 left outer join

--right 쪽이 마스터, 즉 dept table이 master table이 되어 모두 출력
select ename,sal,loc, e.deptno
from emp e right outer join dept d
on e.deptno = d.deptno;

--left 쪽이 마스터 즉, emp table이 master table이 되어 모두 출력
select ename,sal,loc, e.deptno
from emp e left outer join dept d
on e.deptno = d.deptno;

##############################################
Non-Equi join (비등가 조인)
: 동일 column 없이 다른 조건을 사용하여 조인 할 때 사용


[ EQUI JOIN과 NON-EQUI JOIN의 차이점 ]

EQUI JOIN : JOIN조건에 서로 다른 조건(=)을 가진 데이터를 JOIN해서 가져오는 방법
NON-EQUI JOIN : 같은 조건이 아닌 크거나 작거나 하는 경우 JOIN을 수행하는 방법
##############################################

select*from salgrade;

--Oracle non-equi join
select ename, sal, grade
from emp e , salgrade s
where sal between losal and hisal;

--ANSI non-equi join
select ename, sal, grade
from emp e join salgrade s
on sal between losal and hisal;


############################################
세개의 테이블 join

테이블 3개 = 조건 2개 필요
############################################

--Oracle join
select ename, sal, dname, loc, grade
from emp e, dept d, salgrade s
where e.deptno = d.deptno and sal between losal and hisal
order by e.deptno;

--deptno가 20번인 사람들만 출력하기
select ename, sal, dname, loc, grade
from emp e, dept d, salgrade s
where e.deptno = d.deptno 
      and sal between losal 
      and hisal and e.deptno = 20
order by sal;

--ANSI join
select ename, sal, dname, loc, grade
from emp e 
     join dept d 
     on e.deptno = d.deptno 
     join salgrade s
     on sal between losal and hisal
order by e.deptno, sal;

--deptno가 10번인 사람들만 출력하기
select ename, sal, dname, loc, grade
from emp e 
     join dept d 
     on e.deptno = d.deptno 
     join salgrade s
     on sal between losal and hisal
where d.deptno = 10
order by sal;


############################################
Self join

############################################
--사원이름과 그의 mgr 이름 출력하기

--emp table을 마치 table이 두 개 인 것으로 생각하고 그중에 하나를 사원, 다른 하나를 상사라고 가정하고,
--사원 테이블의 상사정보 (e.mgr)와 상사 table의 사원정보 (m.empno)를 조건으로 주기
select e.ename "사원", m.ename "상사"
from emp e, emp m
where e.mgr = m.empno(+);
  -->Oracle에서는 (+) 를 null이 있는 쪽에 한다
     =outer join
 
--empno까지 출력시켜서 확인하기
select e.empno, e.ename "사원", e.mgr, m.empno,m.ename "상사"
from emp e, emp m
where e.mgr = m.empno(+);

--ANSI join  (inner join)
select e.empno, e.ename "사원", e.mgr, m.empno,m.ename "상사"
from emp e join emp m
on e.mgr = m.empno;

--ANSI join  (outer join)
select e.empno, e.ename "사원", e.mgr, m.empno,m.ename "상사"
from emp e left outer join emp m
on e.mgr = m.empno;

--nvl() function 사용하여 mgr이 없는 사람은 CEO로 출력되게 하기
select e.empno, e.ename "사원", nvl(m.ename,'<CEO>') "상사"
from emp e left outer join emp m
on e.mgr = m.empno;

--상사보다 급여가 많은 사원 목록
select e.ename "사원", e.sal, m.ename "상사", m.sal
from emp e 
     join emp m
     on e.mgr = m.empno
where e.sal > m.sal;
    
--상사보다 급여가 많은 사원의 부서명, 근무지역 까지 출력하기
select e.ename "사원명", e.sal, dname, loc, m.ename "상사명", m.sal
from emp e 
     join emp m
     on e.mgr = m.empno
     join dept d
     on e.deptno = d.deptno
where e.sal > m.sal;


############################################
집계함수

- GROUP BY절을 이용하여 그룹 당 하나의 결과로 그룹화 할 수 있다.
- HAVING절을 사용하여 집계함수를 이용한 조건 비교를 할 수 있다.
- MIN, MAX 함수는 모든 자료형에 사용 할 수 있다.
- 일반적으로 가장 많이 사용하는 집계함수에는AVG(평균), COUNT(개수), MAX(최대값), MIN(최소값), SUM(합계) 등이 있다.
############################################

select ename, round(sal) from emp;

--집계 함수 => 데이터가 12개가 들어가서 하나의 결과값이 나옴
select avg(sal) from emp;

--평균급여 소수점 2자리까지 구하기
select round(avg(sal),2) "평균 급여" from emp;

--아래처럼 하면 "not a single-group group function" 이라고 에러뜸 => 집계함수에 해당되지 않는 내용이 왔기 때문 - group by 써야만 가능
select ename,avg(sal) from emp;

--count(*)는 직원 수가 나옴
select count(empno), count(comm), count(*), count(mgr), round(avg(sal)) "평균 급여"
from emp;

--중복제거 해서 이 회사의 job의 개수 구하기
select count(distinct job) from emp;

--
select sum(sal), count(*), round(avg(sal)) "평균 급여 반올림", sum(sal)/count(*) "평균 급여" from emp;

--회사 전체의 평균 급여
select round(avg(sal)) "평균 급여" from emp;

--10번 부서의 평균 급여
select round(avg(sal)) "평균 급여"
from emp
where deptno=10;

--20번 부서의 평균 급여
select round(avg(sal)) "평균 급여"
from emp
where deptno=20;

--30번 부서의 평균 급여
select round(avg(sal)) "평균 급여"
from emp
where deptno=30;

select*from emp order by deptno;

--group by
--집계 함수를 쓰겠다~ 는 얘기
select round(avg(sal)) "부서 별 평균 급여" 
from emp 
group by deptno;

--몇 번 부서인지 알기 위해 deptno 넣음  => 에러가 안남!
--why? group by에 참여한 절은 select절에 올 수 있어서!
select deptno, round(avg(sal)) "평균 급여" 
from emp 
group by deptno;

--부서 이름별 평균 급여 구하기
select dname, nvl(round(avg(sal)),0) "평균 급여" 
from emp e right outer join dept d
on e.deptno = d.deptno
group by dname;

--deptno도 포함해서 출력시키기
select d.deptno,dname, nvl(round(avg(sal)),0) "평균 급여" 
from emp e right outer join dept d
on e.deptno = d.deptno
group by d.deptno,dname
order by 1;

--집계함수
select max(sal), min(sal), count(*), avg(sal)
from emp;

--부서별로 출력
select deptno, max(sal), min(sal), count(*), avg(sal)
from emp
group by deptno
order by 1;

--[ having 절 사용 ]
--group by 이후에 나오는 조건을 달 때

--부서별 평균 급여가 2000이상인 부서 리스트
select d.deptno,dname, nvl(round(avg(sal)),0) "평균 급여" 
from emp e 
     right outer join dept d
     on e.deptno = d.deptno
group by d.deptno,dname
having avg(sal) >2000
order by 1;

--급여가 1000이하인 애들은 집계 (avg구하는 것) 에서 아예 제외가 되게 하기
select d.deptno,dname, nvl(round(avg(sal)),0) "평균 급여" 
from emp e 
     right outer join dept d
     on e.deptno = d.deptno
where sal>1000
group by d.deptno,dname
having avg(sal) >2000
order by 1;
   --> group by 에 참여한 애들과 집계함수만 select문에 올 수 있음


--FORD 보다 급여를 많이 받는 사원 리스트
select sal from emp where ename = 'FORD';
select*from emp where sal>3000;
  --> 그런데 이렇게 하면 FORD의 sal에 변동이 생기면 문제가 생김  => Sub Query 사용!

### Sub Query ###
: select문 안에는 select문이 들어갈 수 있다
select*from emp where sal>(select sal from emp where ename = 'FORD');

--평균 급여보다 적게 받는 사원 리스트
select*from emp where sal<(select avg(sal) from emp) order by sal;

--가장 적은 급여 받는 사람...맴찢...
select*from emp where sal=(select min(sal) from emp);

--각 부서에서 급여가 가장 적은 사람
select*from emp where sal = (select min(sal) from emp group by deptno);
    --> 이렇게 하면 "single-row subquery returns more than one row" 라고 에러 뜸

############################################
스칼라 = 단일값			벡터 = 다중값

where  ___ = (스칼라 - 단일값)   -> single-row subquery
where  ___ in (벡터 - 다중값)    -> multi-row subquery
############################################
--(tmi) -> big data 분석할 때 쓰는 언어 R은 스칼라가 아닌 벡터 기반인다


--in 연산자 사용해야 함!
select*from emp where sal in (select min(sal) from emp group by deptno);

select*from emp where sal in (select max(sal) from emp group by deptno);


## 각 부서에서 급여가 가장 많은 사원 리스트
-- 밑에 둘의 차이점 생각하기

--ver1)
select deptno, ename, sal
from emp
where sal in (select max(sal) from emp group by deptno);

--ver2)
select deptno, ename, sal
from emp
where (deptno,sal)
in (select deptno, max(sal) from emp group by deptno);
   --> where 절에서 deptno 와 sal은 and조건, 나머지는 or 조건이다!


############################################
상관관계 Sub Query 
: outer query의 column 중 하나가 inner query문에서 사용되는 query문
############################################

--자신이 속한 부서의 평균 급여보다 적은 사원 리스트
select*
from emp out
where sal < (select avg(sal) from emp where deptno=out.deptno)
order by deptno,sal;
     --> out에 있는 아이의 부서의 평균 급여를 뽑아와서 그아이의 급여와 비교시킴
     --> emp table 충돌나서 하나를 emp "out" 으로 alias 시킴

############################################
rownum
: row마다 number가 매겨진다
############################################

select rownum, ename, sal, hiredate
from emp;

--급여 Top3 뽑기
select rownum, ename, sal, hiredate
from emp
order by sal desc;
 --> 이렇게 order by절을 이용해 sort를 하면 rownum이 정렬한 순으로 나오지 않음

--Sub Query 사용항 정렬 후 select구문 수행 시키기
select rownum, ename, sal, hiredate
from (select * from emp order by sal desc);
      --> from절에도 sub query문이 올 수 있다!
      --> sub query의 select문의 결과값이 마치 table이 된것 처럼 되어서 여기에서 rownum, ename, sal, hiredate을 뽑아냄
      --> sort가 되어있는 table 구조를 만들고 내가 원하는 column들을 뽑아내기 때문에 rownum에 일련의 번호들이 매겨짐   

--Top 3만 뽑기
select rownum, ename, sal, hiredate
from (select * from emp order by sal desc)
where rownum<4;


## 주의  => 이거 실행 안됨!
select rownum, ename, sal, hiredate
from (select * from emp order by sal desc)
where rownum>4;
    --> rownum은 실행되면서 1부터 만들어지는 형식이라서 1도 안 만들어졌는데 4이상인 것을 비교하는게 불가!

--between도 사용 가능
select rownum, ename, sal, hiredate
from (select * from emp order by sal desc)
where rownum between 1 and 3;
      --> 일련의 rownum을 뽑아내는 구조
      


## 다시 주의!  => 실행 안된다구~
select rownum, ename, sal, hiredate
from (select * from emp order by sal desc)
where rownum between 4 and 7;
     --> rownum은 무조건 1부터 실행 시켜야 한다!!!! 중간 위치부터 접근 불가!!


######################################
Page 처리

######################################

--rownum은 의미가 있는 column이니까 row#으로 alias 해서 사용하기
select*from(
select rownum as row#, ename, sal, hiredate
from (select * from emp order by sal desc)
)
where row# between 1 and 4;

--page 처리 하고 나니까 5에서 9도 출력 가능!
select*from(
select rownum as row#, ename, sal, hiredate
from (select * from emp order by sal desc)
)
where row# between 5 and 9;

### Page 처리 공식 만들기 ###
				start		end
1page 1~5		5*0+1		+4
2page 6~10		5*1+1		+4
3page 11~15		5*2+1		+4


