--Select 구문

--내가 보고싶은 column 이름들 ('*' 는 모든을 뜻함!) +  어디로부터 select 할꺼니     
--   select = 추출하다
--   from = 어느 table로 부터
--   select 뒤에는 꼭!!! from이 와야만 정보를 뽑을 수 있다!

select * from emp; 
select * from dept;
select ename,hiredate from emp;
select ENAME,HIREDATE from emp;
--대소문자 구분 없는 것 확인함 !

select ename,sal from emp;
select ename,comm from emp;

--연산도 된다! salary * 12 해서 연봉 알아내기
select ename,sal,sal*12,comm from emp;

--요약정보 보여줘  -> desc(=description)
desc dept;

--column name 바꾸기
select ename,sal,sal*12 as 연봉,comm from emp;

--column name blank 처리하기   => " " (유일하게 oracle에서 double quotation 쓰이는 곳!)
select ename,sal,sal*12 as "연 봉",comm from emp;

--as 없이도 column name 바꿀 수 있다!
select ename,sal,sal*12 as "연 봉",comm from emp;

select dname,loc from dept;

--hr 계정으로 로그인
conn hr/hr
select*from tab;
select*from employees;
select first_name,job_id,department_id from employees;

--다시 SCOTT/TIGER 로그인
conn SCOTT/TIGER
select empno,ename,sal,comm from emp;

--salary와 commision을 합친 월급여 출력하기
select empno,ename,sal,comm,sal+comm "월 급여" from emp;
--     => null을 포함한 산술식은 null로 출력됨..

--null 포함하면 계산 못하는 것 해결하기 위한 함수 사용  

-- [ nvl() method ]
-- => 특정 값으로 바궈줌! => 여기서는 null 값 0으로 바꿔줬음 -> 연산하기 위해!
-- => nvl()의 parameter (  , ) 두 개의 data type이 같아야 함!
select empno,ename,sal,comm,nvl(comm,0) from emp;

select empno,ename,sal,comm,nvl(comm,0),sal+nvl(comm,0) "월 급여" from emp;
select empno,ename,sal,comm,(sal+nvl(comm,0))*12 " 연 봉 " from emp;

select empno, ename,mgr,deptno from emp;

--아래와 같이 하면 타입 불일치로 에러 발생함! => 형변환 함수 필요!
select empno, ename,nvl(mgr,'CEO'),deptno from emp;

-- [ to_char() method ]
--문자로 형변환 
select empno,ename,nvl(to_char(mgr),'CEO') as mgr,deptno from emp;


## 문자열 연결 연산자   ||    => 결과값이 다 연결되게 하나로 출력됨
select empno,ename,deptno from emp;
select empno||ename||deptno from emp;

--연결 되지만 한칸씩 띄워서 출력하기
select empno||' '||ename||' '||deptno from emp;

--글자를 하나 붙일 수도 있음
select empno, ename,sal||'원' as "월급" from emp;

--연산 결과가 emp table의 row 수만큼 출력됨  =>12번 출력 되었음... 쓸데없이
select 10*24*24 from emp; 

--Dual table (가상의 테이블)을 사용하여 내가 원하는 값만 출력하기
select 10*24*24 from dual; 

--오늘 날짜 출력하기  => sysdate
select sysdate from dual;

## 중복제거 (distinct)
select job from emp;
select distinct job from emp;

select deptno from emp;
select distinct deptno from emp;

select*from emp;

## row에 제한을 걸어서 출력하기 (where 절 사용 / 별칭 사용 안됨)
select /*select 하겠습니다*/ 
from /*어떤 table로 부터*/
where /*이 조건에 맞는 애들만*/

select * from emp where deptno=20;
select * from emp where deptno=40; /*40번 부서에 근무하는 사람 없어서 now rows selected라고 뜸*/

select*from emp where deptno=10;

select*
from emp
where job='manager';

--대소문자 구분 함!!! => 구분 없이 검색 할 수 있도록 바꿔줘야함
select*
from emp
where job='MANAGER';

--UPPER() => 대문자로 변경
--LOWER() => 소문자로 변경
select*from emp where job=upper('manager');

--둗다 같이 upper로 가야 제대로 검색 기능 수행 가능
select*from emp where upper(job)=upper('manager');

--오늘 날짜 출력
select sysdate from dual;

--오늘 입사한 사람...없음
select*
from emp
where hiredate = sysdate;

--81/09/28 입사자
select*
from emp
where hiredate = '81/09/28';

--81/09/28 이후 입사자
select*
from emp
where hiredate > '81/09/28';

--81/09/28 이전 입사자
select*
from emp
where hiredate < '81/09/28';

--81/09/28 이전 & 이후 입사자 -> 이날 입사한 사람만 빼고 출력해라
select*
from emp
where hiredate <> '81/09/28';

--이렇게 해도 같은 효과
select*
from emp
where hiredate != '81/09/28';

--월급 3000이상인 사람
select*
from emp
where sal >3000;

--월급 3000이상 5000이하인 사람
select*
from emp
where sal >= 3000 and sal<=5000;

--월급 3000이상 5000이하인 사람
select*
from emp
where sal between 3000 and 5000;

--between 쓸 때에는 작은 수 먼저 써야함!
select*
from emp
where sal between 5000 and 3000;

select*
from emp
where sal not between 3000 and 5000;

select*
from emp
where deptno = 10 or deptno=20;

##집합연산자 in  -> or 같은 것
select*
from emp 
where deptno IN(10,20);

select*
from emp 
where deptno not IN(10,20);

--10과 dallas는 and, () () 는 or 관계
select*
from dept
where (deptno,loc) IN((10,'DALLAS'),(30,'CHICAGO'));

## like 연산자  => java에서 contains 같은것!
select*from emp;
select*from emp where ename='ALLEN'; /* =은 완전히 같아야함*/

select*
from emp
where ename like 'ALLEN';

--ename이 S로 시작하는 모든 사람 출력해라
select*
from emp
where ename like 'S%';

--ename에 S가 들어가는 애
select*
from emp
where ename like '%S%';

--이름 중간에 m있고 t있는사람 -> m과 t사이에 한글자 있는데 몰라
select*
from emp
where ename like '%M_T%';

--입사년도가 81년인 사람 출력
select*
from emp
where hiredate like '81%';

--이름이 A B C D 로 시작되는 사원의 목록
select*
from emp
where ename like 'A%' or ename like 'B%' or ename like 'C%' or ename like 'D%'; /*코드 넘나 김*/

##정규식 사용
--REGEXP_LIKE() method
--like 함수처럼 특정 패턴과 매칭되는 결과를 검색하는 함수

--이렇게 했더니 이름에 A B C D 를 포함하는 애들 다 나옴
select *
from emp
where regexp_like(ename,'A|B|C|D');

--이렇게 해야 이름 A,B,C,D로 시작하는 애들
select *
from emp
where regexp_like(ename,'^[A-D]');

--이름이 A,B,C,D로 끝나는 애들
select *
from emp
where regexp_like(ename,'[A-D]$');

##null값 처리
-- is null / is not null
select*
from emp
where comm = null; /*골라내지 못함! null 비교는 is null 연산자 사용*/

--commision이 null인 애들
select*
from emp
where comm is null;

--commision이 null이 아닌 애들
select*
from emp
where comm is not null;


## row에 제한을 걸어서 출력하기 (where 절 사용 / 별칭 사용 안됨) 여기 밑에서는 total이 별칭!
select ename, sal, comm, sal + nvl(comm,0) as total
from emp
where sal + nvl(comm,0) >3000;

--select에 보이지 않는 column을 where절에 쓸 수 있다!
select ename, sal, comm, sal + nvl(comm,0) as total
from emp
where deptno=20;

##정렬 order by    -> 기본적으로 오름차순으로 정렬됨! (asending)  => 별칭 쓸 수 있다!

select ename,sal,comm,sal+nvl(comm,0) total, deptno
from emp
order by deptno;

--내림차순으로 정렬하기 => desc (descending)
select ename,sal,comm,sal+nvl(comm,0) total, deptno
from emp
order by deptno desc;

--order by 절에서도 별칭 쓸 수 있다
select ename,sal,comm,sal+nvl(comm,0) total, deptno
from emp
order by total;

--두번째 column (여기서는 sal)을 기준으로 정렬하기
select ename,sal,comm,sal+nvl(comm,0) total, deptno
from emp
order by 2;

--1차기준은 deptno (내림차순), 2차 기준은 total (오름차순)으로 정렬하기
select ename,sal,comm,sal+nvl(comm,0) total, deptno
from emp
order by deptno desc, total;

-- 순서 --
select
from
where
order by
-------

select *
from emp
where deptno =30
order by sal;

select *
from emp
where deptno in (20,30)  /*20이거나 30이거나 (or)*/
order by sal;

--any option 사용하기  => in이랑 똑같음! '= any()' 이런식으로 쓴다
select *
from emp
where deptno = any(20,30) 
order by sal;

--all option 사용하기   =>' != all ' => 이 아이들을 제외한 나머지를 뽑아내라
select *
from emp
where deptno != all(20,30) 
order by sal;


----------------
## 내장함수 p204 Single Row Function

select * from dept;
select dname,loc from dept;

--lower 함수 (Function) => return 되는 값이 있음
select dname,lower(dname),loc,lower(loc) from dept;

--round 함수  => 반올림 처리하는 함수
--trunc 함수 => 소수점 이하 값을 절삭 하는 함수
select 45.5678, 45.5678 from dual;
select round(45.5678), trunc(45.5678) from dual;

--소수점 두자리까지 반올림, 두자리 이하 절삭
select round(45.5678,2), trunc(45.5678,2) from dual;

--날짜 하루 증가시키기
select sysdate, sysdate +1 from dual;
--30일 증가시키기
select sysdate, sysdate +30 from dual;

--substr() method     => substr(시작위치, 끝 위치)
-- : 문자열 중 특정 위치에서 시작하여 지정한 길이만큼의 문자열을 반환하는 함수
--oracle은 index 무조건 1부터 시작한다!!!!! JAVA처럼 0부터 시작하지 않아....
select ename, hiredate from emp;
select ename, hiredate, substr(hiredate,1,2) "입사 연도" from emp;

--to_char
-- : 문자 type (char type)으로 바꿔줌
--오늘 날짜에서 연도만 빼오기
select sysdate, to_char(sysdate,'YYYY') from dual;
--연도 두자리만 뽑기 (19년)
select sysdate, to_char(sysdate,'YY') from dual;
--오늘 날짜 뽑기 (18일)
select sysdate, to_char(sysdate,'dd') from dual;
--오늘 무슨 요일인지 뽑기 (
select sysdate, to_char(sysdate,'day') from dual;

##emp table에서 사원들의 입사월 뽑기
--month, mon   -> 1월
select ename,hiredate,to_char(hiredate,'month') 입사월 from emp;
--mm   -> 01
select ename, hiredate, to_char(hiredate,'mm') 입사월 from emp;

--to_date
-- : 날짜라는 것을 알려주기
select sysdate, '2019/08/14' from dual;
select sysdate, to_date('2019/08/14') from dual;

--년도를 뒤에 쓰는 형식으로 쓰면 에러남.... 고쳐야함!
select sysdate, to_date('08/14/2019') from dual;
--월/일/년 순인걸 알려주기
select sysdate, to_date('08/14/2019', 'mm/dd/yy') from dual;

## nvl() 함수  => 매개변수 (a,b) : a가 null인경우 b로 바꿔 
select ename, mgr, comm from emp;
--comm은 숫자인데 '_'는 문자라서 type에러가 뜸
select ename, mgr, nvl(comm,'_') from emp;
--문자를 숫자로 바꿀수는 없으므로 숫자를 문자로 type casting 하기  -> 근데 문자는 왼쪽 정렬을 하므로 정렬 순서 이상함 -> 나중에 정렬순서 바꿔봐
select ename, mgr, nvl(to_char(comm),'_') from emp;
--아니면 그냥 null 값을 숫자로..ㅎ
select ename, mgr, nvl(comm,0) from emp;

## nvl2() 함수 => 매개변수가 (a,b,c) 세개가 옴 : a가 null이면 b, null이 아니면 c로 바꿔
select ename, mgr, nvl2(comm,comm,0) from emp;

--mgr이 있으면 yes 없으면 no   => mgr이 int지만 지금 yes no 모든 데이터가 문자이기 때문에 에러 안남
select ename, nvl2(mgr,'yes','no') from emp;

## decode 함수  => if else 구문 같은거~~~ (데이터를 일률적으로 계산할 때 사용)
-- DECODE(VALUE, IF1, THEN1, IF2, THEN2...) 형태로 사용

--deptno가 10이라면 sal에 10을 곱해라
select ename, sal, deptno, decode(deptno, 10, sal*1,
										20, sal*2,
										30, sal*3,
										sal) 계산 from emp order by deptno;

