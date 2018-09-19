select *
from employees
where salary = (select salary
                from    employees
                where Lower(last_name) = 'seo');
                
select *
from employees
where salary > (Select avg(salary) from employees);

select *
from employees
where job_id in (select job_id from employees where department_id = 30);

SELECT * 
FROM   employees 
WHERE  salary > (SELECT max(salary )
                            FROM   employees 
                            WHERE  department_id = 30);
                            
select rowid,
        rownum,
        employee_id,
        last_name
from employees;
