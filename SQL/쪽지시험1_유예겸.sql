-- 1��
select employee_id, last_name, salary, hire_date
from employees
where salary < 5000 or salary > 15000;

-- 2��
select employee_id, last_name, job_id, hire_date
from employees
where department_id = 50 and job_id = 'ST_MAN' and hire_date = '2004-07-18';

-- 3��
select *
FROM employees
WHERE TO_CHAR(hire_date, 'YYYY') >= '2002' and job_id in ('ST_MAN','ST_CLERK');

-- 4��
select *
FROM employees
WHERE manager_id is null;

-- 5��
select *
from employees
where salary < 10000 and job_id in ('SH_CLERK', 'PU_MAN', 'PU_CLERK');

-- 6��
select last_name "�̸�", length(last_name) "�̸� ����"
from employees
where last_name like 'J%' or last_name like 'A%' or last_name like 'M%';

-- 7��
select count(*)
from employees
group by to_char(hire_date,'yyyy');

-- 8��
select *
from employees
where mod(employee_id , 2) = 1;

-- 9��
SELECT to_char(NEXT_DAY(ADD_MONTHS(SYSDATE, 6), 6), 'YYYY-MM-DD HH24:MI:ss day') "6���� �� �ݿ���"
FROM dual;

-- 10��
SELECT  employee_id "���", 
        first_name "��", 
        DECODE(manager_id, null, '�뻧', 
                            manager_id) "���"
FROM   employees;

-- 11�� 
SELECT DECODE(mod(employee_id, 3), 
                  0, '��ȭ���', 
                  1, '���׸�', 
                  2, '����') "���̸�",
       employee_id "�����ȣ", 
       last_name "�����"
FROM   employees;

-- 12��
SELECT  RPAD(first_name || ' ' || last_name, 20, ' ') "�̸�", 
        LPAD('($'||salary||')',FLOOR(salary/1000)+LENGTH(salary)+3,'*') "�޿�"
FROM employees
order by salary desc;

-- 13 �� 
select department_id "�μ�", 
      count(*) "�ο���" 
from employees
where hire_date >= '2002-03-01' and hire_date < '2003-03-01'
group by department_id
order by count(*) desc;

-- 14 ��
select  avg(salary) 
from employees
group by job_id
having avg(salary) < 10000;

-- 15��
SELECT  TO_char(hire_date,'Q') "�б�", 
        count(*)"�����"
FROM employees
where to_char(hire_date, 'yy') = '04'
group by TO_char(hire_date,'Q');

??