-- 1번
select employee_id, last_name, salary, hire_date
from employees
where salary < 5000 or salary > 15000;

-- 2번
select employee_id, last_name, job_id, hire_date
from employees
where department_id = 50 and job_id = 'ST_MAN' and hire_date = '2004-07-18';

-- 3번
select *
FROM employees
WHERE TO_CHAR(hire_date, 'YYYY') >= '2002' and job_id in ('ST_MAN','ST_CLERK');

-- 4번
select *
FROM employees
WHERE manager_id is null;

-- 5번
select *
from employees
where salary < 10000 and job_id in ('SH_CLERK', 'PU_MAN', 'PU_CLERK');

-- 6번
select last_name "이름", length(last_name) "이름 길이"
from employees
where last_name like 'J%' or last_name like 'A%' or last_name like 'M%';

-- 7번
select count(*)
from employees
group by to_char(hire_date,'yyyy');

-- 8번
select *
from employees
where mod(employee_id , 2) = 1;

-- 9번
SELECT to_char(NEXT_DAY(ADD_MONTHS(SYSDATE, 6), 6), 'YYYY-MM-DD HH24:MI:ss day') "6개월 후 금요일"
FROM dual;

-- 10번
SELECT  employee_id "사번", 
        first_name "성", 
        DECODE(manager_id, null, '대빵', 
                            manager_id) "상사"
FROM   employees;

-- 11번 
SELECT DECODE(mod(employee_id, 3), 
                  0, '영화배우', 
                  1, '개그맨', 
                  2, '가수') "팀이름",
       employee_id "사원번호", 
       last_name "사원명"
FROM   employees;

-- 12번
SELECT  RPAD(first_name || ' ' || last_name, 20, ' ') "이름", 
        LPAD('($'||salary||')',FLOOR(salary/1000)+LENGTH(salary)+3,'*') "급여"
FROM employees
order by salary desc;

-- 13 번 
select department_id "부서", 
      count(*) "인원수" 
from employees
where hire_date >= '2002-03-01' and hire_date < '2003-03-01'
group by department_id
order by count(*) desc;

-- 14 번
select  avg(salary) 
from employees
group by job_id
having avg(salary) < 10000;

-- 15번
SELECT  TO_char(hire_date,'Q') "분기", 
        count(*)"사원수"
FROM employees
where to_char(hire_date, 'yy') = '04'
group by TO_char(hire_date,'Q');

??