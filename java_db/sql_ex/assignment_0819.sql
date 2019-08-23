/*
문제1. Query 문장을 작성하십시오. 

각 사원(employee)에 대해서 사번(employee_id), 이름(first_name), 부서명(department_name), 매니저(manager)의 이름(first_name)을 조회하시오.
*/

select e.employee_id, e.first_name, department_name, m.first_name
from employees e 
	 join departments d
     on e.department_id = d.department_id
     join employees m
     on e.manager_id = m.employee_id;

/*     
문제2. 자신의 매니저보다 연봉(salary)을 많이 받는 직원들의 성(last_name)과 연봉(salary)을 출력하시오
*/
     
select e.last_name, e.salary
from employees e
	 left outer join employees m
	 on e.manager_id = m.employee_id
where e.salary> m.salary;

/*
문제3. 업무명(job_title)이 ‘Sales Representative’인 직원 중에서 연봉(salary)이 9,000 이상, 10,000 이하인 직원들의 이름(first_name), 성(last_name)과 연봉(salary)을 출력하시오.
*/

select first_name, last_name, salary
from employees e
     join jobs j
     on e.job_id = j.job_id
 where salary between 9000 and 10000 and lower(job_title) = lower('Sales Representative');
 										--> 검색 할 때에는 lower/lower or upper/upper로 맞춰주기! 꼭!
 
 
/*
 문제4. Query 문장을 작성하십시오. 
 자신의 매니저보다 채용일(hire_date)이 빠른 사원의 사번(employee_id), 성(last_name)과 채용일(hire_date)을 조회하라.
*/

select e.employee_id, e.last_name, e.hire_date
from employees e
	 join employees m
	 on e.manager_id = m.employee_id
where e.hire_date < m.hire_date
order by 1;

/*
문제5. Query 문장을 작성하십시오. 

각 업무(job_title)가 어느 부서(department_name)에서 수행되는지 조회하는 SQL 쿼리문을 작성하세요. (단, 수행하지 않는 업무는 표시하지 않고 중복되는 정보는 하나만 표시합니다.)
출력: JOB_TITLE | DEPARTMENT_NAME
*/

select distinct j.job_title, d.department_name
from employees e 
     join jobs j
     on e.job_id = j.job_id
     join departments d
     on e.department_id = d.department_id
order by 1;


/*
문제6. 월 별 입사자 수를 조회하는 SQL 쿼리문을 작성하세요. 월 순으로 정렬하세요. 
출력: 월 | 입사자수
*/

select to_char(hire_date,'mm') 월, count(*) 입사자수
from EMPLOYEES
group by to_char(hire_date,'mm')
order by 1;
    --> 월별, 부서별, 분기별 등이 나오면 무조건 집계함수 & Group by!
    --> select문에 count(to_char(hire_date,'mm'))이라고 써도 됨! 근데 어쩌피 group by로 출력되어서 상관없음 (선생님은 이렇게 했더라~~)

/*
문제7. 08년도에 입사한 직원의 이름(first_name), 입사일(hire_date), 관리자사번(employee_id), 관리자 이름(first_name)을 조회합니다. 
단, 관리자가 없는 사원정보도 출력결과에 포함되어야 합니다
*/

select e.first_name, e.hire_date, nvl(to_char(m.employee_id), null), nvl(m.first_name, null)
from employees e
     left outer join employees m
     on e.manager_id = m.employee_id
where to_char(e.hire_date,'yy') = '08';
      

/*
문제8. ‘Sales’부서에 속한 직원의 이름(first_name), 급여(salary), 부서이름(department_name)을 조회하시오. 
*/

select first_name, salary, department_name
from employees e
     join departments d
     on e.department_id = d.department_id
where lower(department_name) = lower('Sales')
order by 2;
      --> where절에 like 연산자 사용 가능! 이걸 더 자주 사용~



/*
문제9. 2004년 입사한(hire_date) 직원들의 사번(employee_id), 이름(first_name), 성(last_name), 부서명(department_name)을 조회합니다.
이때, 부서에 배치되지 않은 직원의 경우, ‘<NOT ASSIGNED>’로 보여줍니다.
*/

select employee_id, first_name, last_name, nvl(department_name,'<NOT ASSIGNED>') "DEPARTMENT_NAME"
from employees e
	 left outer join departments d
	 on e.department_id = d.department_id
where to_char(e.hire_date,'yy') = '04';

/*
문제10. 2003년에 입사한 직원의 이름(first_name), 입사일(hire_date), 관리자사번(employee_id), 관리자 이름(first_name)을 조회합니다. 
단, 관리자가 없는 사원정보도 출력결과에 포함되어야 합니다.. 
*/

select e.first_name, e.hire_date, nvl(to_char(e.employee_id), '(null)') as "EMPLOYEE_ID", nvl(m.first_name, '(null)') as "FIRST_NAME_1"
from employees e
	 left outer join employees m
	 on e.manager_id = m.employee_id
where to_char(e.hire_date,'yy') = '03'
order by m.last_name;


