-- 1번
select e.EMPLOYEE_ID "사원번호",
       e.LAST_NAME "이름",
       j.JOB_TITLE "업무",
       d.DEPARTMENT_NAME "부서이름",
       l.CITY "위치"
from employees e
      join jobs j
      using (job_id)
      join departments d
      using (department_id)
      join locations l
      using (location_id)
where l.CITY = 'London';

-- 2번
select e.last_name "이름" ,
       d.DEPARTMENT_NAME "부서"
from employees e
     join DEPARTMENTS d
     using (department_id)
where e.last_name like '%A%';

-- 3번
select e.EMPLOYEE_ID "사번" ,
       e.LAST_NAME "이름",
       e.SALARY "급여",
       d.DEPARTMENT_NAME "부서"
from employees e
     join DEPARTMENTS d
     using (department_id)
where e.SALARY between 3000 and 5000;

-- 4번
select e.LAST_NAME "이름",
       to_char(e.HIRE_DATE, 'yyyy/mm/dd (day)') "입사일"
from employees e
     join DEPARTMENTS d
     using (department_id)
where d.DEPARTMENT_NAME = 'Accounting';

-- 5번
select *
from employees 
where department_id = (select department_id
                       from employees
                       where last_name = 'Landry')
      and last_name != 'Landry';

-- 6번
select LAST_NAME "이름",
       HIRE_DATE "입사일"
from employees 
where HIRE_DATE  > (select hire_date
                      from employees
                      where Lower(last_name) = 'lee');

-- 7번
select LAST_NAME "이름",
       SALARY "급여"
from employees
where SALARY  > (select SALARY
                 from employees
                 where Lower(last_name) = 'lee');

-- 8번
select LAST_NAME "이름",
       SALARY "급여"
from employees
where SALARY in (select SALARY
                 from employees
                 where DEPARTMENT_ID = 50);
                 
-- 9번
select EMPLOYEE_ID "사번",
       LAST_NAME "이름",
       SALARY "급여"
from employees
where SALARY > (select avg(SALARY)
                 from employees);
                 
-- 10번
select PHONE_NUMBER "번호",
       LAST_NAME "이름"
--       DEPARTMENT_ID "부서"
from employees
where department_id in (select department_id
                       from employees
                       where last_name like '%T%');

-- 11번 
select PHONE_NUMBER "번호",
       LAST_NAME "이름",
       salary "급여"
from employees
where salary  =      (select max(salary)
                      from employees
                      where DEPARTMENT_ID = 10 );
                  
-- 12번 
select e.LAST_NAME "이름",
       d.DEPARTMENT_NAME "부서명"
from employees e
     join departments d
     using (department_id)
where department_id = 10;
                       
-- 13번
select DEPARTMENT_ID "부서 번호",
       employee_id "사원 번호",
       LAST_NAME "이름",
       salary "급여"
from employees
where salary > (select max(salary)
                from employees
                where job_id = 'IT_PROG');
                
-- 14번
select employee_id "사원 번호",
       LAST_NAME "이름",
       salary "급여"
from employees
where salary > (select avg(salary)
                from employees)
      and
      DEPARTMENT_ID in (select department_id
                       from employees
                       where last_name like '%u%');
                       
-- 15번
select job_id "업무번호",
       avg(salary) "평균급여"
from employees 
where job_id = (select job_id
                from employees
                where avg(salary) = min ((select avg(salary)
                                          from employees
                                          group by job_id ))
                group by job_id                        
                )
group by job_id;             

SELECT first_name, salary
FROM   employees
WHERE  ROWNUM <=5
ORDER  BY salary DESC;

-- FROM절에서 서브쿼리(Inline View)를 사용해야 한다
SELECT * 
FROM   (SELECT * 
           FROM   employees 
           ORDER  BY salary DESC) 
WHERE  ROWNUM <= 5;



