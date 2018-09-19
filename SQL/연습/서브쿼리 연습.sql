-- cross join
select e.FIRST_NAME, d.department_name
from EMPLOYEES e, departments d;

select e.first_name,
       d.department_name
from employees e
     cross join departments d;
     
-- inner join
-- equi join
select e.EMPLOYEE_ID,
       e.LAST_NAME,
       d.DEPARTMENT_NAME
from employees e,
     departments d
where e.department_id = d.department_id;

select e.EMPLOYEE_ID,
       e.LAST_NAME,
       d.DEPARTMENT_NAME
from employees e
     join departments d
--     on e.department_id = d.department_id;
     using (department_id)
where salary >= 3000;

-- outer join
SELECT *
FROM user_tables;

select e.EMPLOYEE_ID,
       e.LAST_NAME,
       d.DEPARTMENT_NAME,
       l.CITY
from employees e
      join departments d
      using (department_id)
      join locations l
      using (location_id);
      
      
-- non equi join
select e.LAST_NAME,
       e.SALARY,
       e.employee_id,
       j.JOB_TITLE
from employees e
      join jobs j
      on   e.salary Between j.min_salary and j.max_salary
order by e.employee_id;

-- outer join
SELECT    e.employee_id, 
          e.first_name, 
          e.last_name, 
--          d.department_name
          decode (d.department_name, null, '없음',
                      D.department_name)
from employees e,
     departments d
where e.department_id = d.department_id(+);

SELECT    e.employee_id, 
          e.first_name, 
          e.last_name, 
--          d.department_name
          decode (d.department_name, null, '없음',
                      D.department_name)
from employees e
     left outer join departments d
     using (deparmtnet_id);
     
-- self 조인
-- 상사가 없는 사원도 검색 시 OUTER JOIN 필요
SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee, EMPLOYEES manager
WHERE employee.manager_id = manager.employee_id(+);

-- 상사가 없는 사원도 검색 시 OUTER JOIN 필요
SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee, EMPLOYEES manager
WHERE employee.manager_id = manager.employee_id(+);

