-- 명시적 NULL 입력 
INSERT INTO departments 
                  (department_id,     -- PK 
                   department_name,   -- NN
                   manager_id,        -- FK
                   location_id)       -- FK
VALUES        (900, 
                   'KOSTA', 
                   NULL,              -- 명시적 NULL 입력
                   NULL); 
                   
SELECT *
FROM DEPARTMENTS;

SELECT *
FROM USER_TABLES;

-- 묵시적 NULL 입력 
INSERT INTO departments (department_id, department_name) 
VALUES     (510,  'KOSTA1'); 

-- 시퀀스를 이용한 부서번호 입력 
INSERT INTO departments (department_id,  department_name, manager_id, location_id) 
VALUES       (departments_seq.NEXTVAL, 'KOSTA', NULL, NULL); 




-- 
SELECT * 
FROM   user_sequences;  --데이터 딕셔너리 (시스템 테이블)


-- 데이터 딕셔너리 조회
SELECT *
FROM USER_CONSTRAINTS;




-- 데이터 구조 복사
CREATE TABLE dept
AS SELECT *
FROM DEPARTMENTS      
WHERE(0=1);

INSERT INTO DEPT
SELECT *
FROM DEPARTMENTS;

SELECT *
FROM DEPT;

-- UPDATE
UPDATE employees 
SET    salary = salary * 1.1 
WHERE  department_id = 30;

SELECT *
FROM EMP;

DELETE FROM departments 
WHERE  department_name LIKE '%KOSTA%'; 

DELETE FROM EMP
WHERE  salary > (SELECT AVG(salary) 
                       FROM   EMP); 
rollback;






-- 모든 값 넣고, 부서번호 fk, 시퀀스
select *
from SYS.USER_CONSTRAINTS;

select *
from EMPLOYEES;

insert into EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT,
                       MANAGER_ID, DEPARTMENT_ID)
VALUES (EMPLOYEES_SEQ.NEXTVAL, 
        '예겸', 
        '유', 
        'meopulior', 
        '010.9650.1261', 
        to_date('2018.08.26'),
        (select job_id
         from jobs
         where rownum = 1),
         5000,
         0.5,
         (select EMPLOYEE_ID
         from EMPLOYEES
         where rownum = 1),
         (select DEPARTMENTS.DEPARTMENT_ID
         from DEPARTMENTS
         where rownum = 1)
        );
commit;
select  EMPLOYEE_ID ,
        FIRST_NAME ,
        LAST_NAME ,
        EMAIL ,
        PHONE_NUMBER ,
        HIRE_DATE ,
        JOB_ID ,
        SALARY ,
        COMMISSION_PCT ,
        MANAGER_ID ,
        DEPARTMENT_ID 
from employees;
