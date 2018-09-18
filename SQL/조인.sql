-- 크로스 조인
-- 오라클 조인
select e.LAST_NAME, d.DEPARTMENT_NAME
from EMPLOYEES e, DEPARTMENTS d;

-- ANSI 조인
select e.last_Name, d.DEPARTMENT_NAME
from employee e
     cross join DEPARTMENTS d;
     
select sysdate from dual;

-- Inner Join
-- 조인하고자 하는 두 테이블에서 공통적으로 존재하는 컬럼(department_id)의 값을 동등 비교하여 일치하는 행과 행을 조인
-- 오라클 EQUI JOIN 구문
SELECT  e.employee_id, 
        e.last_name, 
        d.department_name 
FROM    employees e, 
        departments d 
WHERE  e.department_id = d.department_id 
       AND e.salary >= 3000;

-- ANSI 표준 EQUI JOIN 구문
SELECT  e.employee_id, 
        e.last_name, 
        d.department_name 
FROM    employees e 
        JOIN departments d 
--        on e.department_id = d.department_id 
        using(department_id) 
WHERE   e.salary >= 3000; 


---- 3개이상 테이블 조인
-- 딕셔너리 테이블로부터 테이블 종류 조회
SELECT *
FROM user_tables;

SELECT e.employee_id, 
          e.last_name, 
          d.department_name, 
          l.city, 
          l.state_province, 
          c.country_name 
FROM   employees e 
         JOIN departments d 
            ON e.department_id = d.department_id 
         JOIN locations l 
            ON d.location_id = l.location_id 
         JOIN countries c 
            ON l.country_id = c.country_id; 
            
-- 공통 컬럼이 없는 테이블과 테이블간 조인
-- 조인 조건에서 ‘=’ 연산자를 이용한 동등비교가 아닌 다른 비교연산자를 사용하여 특정범위로 행과 행을 연결하여 조인
-- 사원 급여에 따른 급여등급 출력

-- 오라클 NON-EQUI JOIN
-- Enterprise 버전에 있는 salgrade 테이블
SELECT e.ename, 
          e.sal, 
          s.grade 
FROM   emp e, 
          salgrade s 
WHERE  e.sal BETWEEN s.losal AND s.hisal;

SELECT e.employee_id, 
          e.last_name, 
          e.salary, 
          j.job_title 
FROM   employees e, 
          jobs j 
WHERE  e.salary BETWEEN j.min_salary AND j.max_salary 
ORDER  BY e.employee_id; 

-- ANSI 표준 NON-EQUI JOIN
SELECT e.ename, 
          e.sal, 
          s.grade 
FROM   emp e 
         JOIN salgrade s 
           ON e.sal BETWEEN s.losal AND s.hisal; 

desc jobs;

SELECT e.employee_id, 
          e.last_name, 
          e.salary, 
          j.job_title 
FROM   employees e 
         JOIN jobs j 
           ON e.salary BETWEEN j.min_salary AND j.max_salary 
ORDER  BY e.employee_id; 


-- employees 테이블에에서 부서번호가 NULL 인 Kimberely는 
-- EQUI Join만으로는 검색되지 않음
SELECT e.first_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- 소속부서가 없는 사원도 출력!
-- 오라클 OUTER JOIN
SELECT e.employee_id, 
          e.first_name, 
          e.last_name, 
          decode (d.department_name, null, '없음',
                      D.department_name)
FROM   employees e, 
          departments d 
WHERE  e.department_id = d.department_id(+); 

-- ANSI 표준 OUTER JOIN(LEFT, RIGHT, FULL 예약어 사용)
--  LEFT OUTER JOIN
SELECT  e.employee_id, 
          e.first_name, 
          e.last_name, 
          decode (d.department_name, null, '없음',
                      D.department_name)
FROM   employees e 
          LEFT OUTER JOIN departments d 
             ON e.department_id = d.department_id; 

-- ANSI 표준 OUTER JOIN(LEFT, RIGHT, FULL 예약어 사용)
--  LEFT OUTER JOIN
SELECT e.first_name, 
          d.department_name 
FROM   employees e 
          LEFT OUTER JOIN departments d 
             ON e.department_id = d.department_id; 

-- RIGHT OUTER JOIN
SELECT e.first_name, 
          d.department_name 
FROM   employees e 
          RIGHT OUTER JOIN departments d 
             ON e.department_id = d.department_id; 

-- FULL OUTER JOIN
SELECT e.first_name, 
          d.department_name 
FROM   employees e 
          FULL OUTER JOIN departments d 
             ON e.department_id = d.department_id; 
             
             
             -- 사원별 상사 검색
SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee, EMPLOYEES manager
WHERE employee.manager_id = manager.employee_id;

-- 상사가 없는 사원도 검색 시 OUTER JOIN 필요
SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee, EMPLOYEES manager
WHERE employee.manager_id = manager.employee_id(+);

SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee LEFT OUTER JOIN EMPLOYEES manager
ON employee.manager_id = manager.employee_id;


