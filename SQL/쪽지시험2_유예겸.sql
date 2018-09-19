-- 1��
select e.EMPLOYEE_ID "�����ȣ",
       e.LAST_NAME "�̸�",
       j.JOB_TITLE "����",
       d.DEPARTMENT_NAME "�μ��̸�",
       l.CITY "��ġ"
from employees e
      join jobs j
      using (job_id)
      join departments d
      using (department_id)
      join locations l
      using (location_id)
where l.CITY = 'London';

-- 2��
select e.last_name "�̸�" ,
       d.DEPARTMENT_NAME "�μ�"
from employees e
     join DEPARTMENTS d
     using (department_id)
where e.last_name like '%A%';

-- 3��
select e.EMPLOYEE_ID "���" ,
       e.LAST_NAME "�̸�",
       e.SALARY "�޿�",
       d.DEPARTMENT_NAME "�μ�"
from employees e
     join DEPARTMENTS d
     using (department_id)
where e.SALARY between 3000 and 5000;

-- 4��
select e.LAST_NAME "�̸�",
       to_char(e.HIRE_DATE, 'yyyy/mm/dd (day)') "�Ի���"
from employees e
     join DEPARTMENTS d
     using (department_id)
where d.DEPARTMENT_NAME = 'Accounting';

-- 5��
select *
from employees 
where department_id = (select department_id
                       from employees
                       where last_name = 'Landry')
      and last_name != 'Landry';

-- 6��
select LAST_NAME "�̸�",
       HIRE_DATE "�Ի���"
from employees 
where HIRE_DATE  > (select hire_date
                      from employees
                      where Lower(last_name) = 'lee');

-- 7��
select LAST_NAME "�̸�",
       SALARY "�޿�"
from employees
where SALARY  > (select SALARY
                 from employees
                 where Lower(last_name) = 'lee');

-- 8��
select LAST_NAME "�̸�",
       SALARY "�޿�"
from employees
where SALARY in (select SALARY
                 from employees
                 where DEPARTMENT_ID = 50);
                 
-- 9��
select EMPLOYEE_ID "���",
       LAST_NAME "�̸�",
       SALARY "�޿�"
from employees
where SALARY > (select avg(SALARY)
                 from employees);
                 
-- 10��
select PHONE_NUMBER "��ȣ",
       LAST_NAME "�̸�"
--       DEPARTMENT_ID "�μ�"
from employees
where department_id in (select department_id
                       from employees
                       where last_name like '%T%');

-- 11�� 
select PHONE_NUMBER "��ȣ",
       LAST_NAME "�̸�",
       salary "�޿�"
from employees
where salary  =      (select max(salary)
                      from employees
                      where DEPARTMENT_ID = 10 );
                  
-- 12�� 
select e.LAST_NAME "�̸�",
       d.DEPARTMENT_NAME "�μ���"
from employees e
     join departments d
     using (department_id)
where department_id = 10;
                       
-- 13��
select DEPARTMENT_ID "�μ� ��ȣ",
       employee_id "��� ��ȣ",
       LAST_NAME "�̸�",
       salary "�޿�"
from employees
where salary > (select max(salary)
                from employees
                where job_id = 'IT_PROG');
                
-- 14��
select employee_id "��� ��ȣ",
       LAST_NAME "�̸�",
       salary "�޿�"
from employees
where salary > (select avg(salary)
                from employees)
      and
      DEPARTMENT_ID in (select department_id
                       from employees
                       where last_name like '%u%');
                       
-- 15��
select job_id "������ȣ",
       avg(salary) "��ձ޿�"
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

-- FROM������ ��������(Inline View)�� ����ؾ� �Ѵ�
SELECT * 
FROM   (SELECT * 
           FROM   employees 
           ORDER  BY salary DESC) 
WHERE  ROWNUM <= 5;



