select employee_id , last_name, salary, hire_date
from EMPLOYEES
where HIRE_DATE like '02%';

-- 정렬
select employee_id , last_name, salary, hire_date
from EMPLOYEES
--order by employee_id desc;
order by last_name asc, salary desc;

-- group by
select department_id, count(department_id)
from employees
group by department_id
order by count(department_id);

-- having
select department_id, count(department_id)
from employees
group by department_id
having department_id is not null
order by count(department_id);

select *
from employees
order by department_id;

-- 서브쿼리(내부쿼리)를 이용한 테이블 복사
CREATE TABLE emp as 
  select * 
  from employees;

-- union
select *
from employees 
--union all
union
select *
from emp;
  
-- intersect
select *
from employees 
intersect
select *
from emp;

select *
from employees
minus
select *
from emp;
