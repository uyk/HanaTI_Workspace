/* 시퀀스(sequence) 생성 */
-- 테스트를 위한 테이블 생성
CREATE TABLE list(
    no   NUMBER CONSTRAINT list_no_pk PRIMARY KEY,
    name VARCHAR2(10) NOT NULL
);


CREATE SEQUENCE list_seq;
    --START WITH 1
    --INCREMENT BY 1
    --NOMAXVALUE
    --NOCYCLE
    --CACHE 20;

SELECT list_seq.CURRVAL,  list_seq.NEXTVAL
FROM dual;

INSERT INTO list
VALUES((select max(no) +1  from list), '김기정');

rollback;
COMMIT;

SELECT * FROM list;

-- 시퀀스 수정
ALTER SEQUENCE list_seq
	INCREMENT  BY 2;
	

-- 시퀀스 삭제
DROP SEQUENCE  list_seq;

select * from departments;

-- 딕셔너리 시퀀스 조회
SELECT *  FROM user_sequences;

-- 직급별 뷰 생성
CREATE OR REPLACE VIEW employees_sajang_view
	AS SELECT *
       FROM EMPLOYEES;

CREATE OR REPLACE VIEW employees_bujang_view
	AS SELECT employee_id, first_name, salary
       FROM EMPLOYEES;


SELECT *
FROM employees_sajang_view;

SELECT *
FROM employees_bujang_view;


-- 복잡한 SQL 저장을 위한 뷰 생성
CREATE OR REPLACE VIEW employees_by_departments
AS
SELECT e.first_name, d.department_name
FROM employees e JOIN (SELECT department_id, department_name
                                 FROM departments
                                 WHERE department_id = 30) d
ON e.department_id = d.department_id;

select * from employees_by_departments;


-- 딕셔너리로부터 뷰 조회
SELECT * FROM user_views;

SELECT * FROM EMP_DETAILS_VIEW;


---------인덱스

-- 인덱스에서 사용하는 가상컬럼 조회
SELECT rowid, rownum, employee_id, first_name
FROM employees;

-- 사용자 정의 인덱스 생성
CREATE INDEX emp_salary_idx
ON employees(salary);

SELECT *
FROM employees
WHERE salary >= 12000;

-- 딕셔너리로부터 인덱스 조회
SELECT *
FROM user_indexes
WHERE table_name = 'EMPLOYEES';

SELECT *
FROM user_ind_columns
WHERE table_name = 'EMPLOYEES';

-- 자동 인덱스 사용
select *
from employees
where last_name = 'James';

CREATE TABLE EMP1
AS
SELECT *
FROM EMPLOYEES;

INSERT INTO EMP1 
SELECT *
FROM EMP1;

COMMIT;

SELECT *
FROM EMP1
WHERE EMPLOYEE_ID = 100;

CREATE INDEX emp_id_idx
on emp1(employee_id);