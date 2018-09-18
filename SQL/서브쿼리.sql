select *
from employees
where salary = (select salary
                from employees
                where lower(last_name) = 'seo')
                and lower(last_name) != 'seo';
                
-- 전체사원 평균급여보다 더 많은 급여를 받는 사원 목록 조회
SELECT * 
FROM   employees 
WHERE  salary > (SELECT AVG(salary) 
                      FROM    employees);
                      
-- IN 연산자 활용
-- 30번 부서에 소속된 사원들과 동일한 업무를 가지는 전체 사원목록 조회
SELECT last_name, 
          job_id, 
          department_id 
FROM   employees 
WHERE  job_id IN (SELECT job_id 
                       FROM   employees 
                       WHERE  department_id = 30);



-- ANY 연산자 활용
-- 30번 부서의 최소급여자 보다  더 많은 급여를 받는 전체 사원목록 조회
SELECT * 
FROM   employees 
WHERE  salary > ANY (SELECT salary 
                             FROM   employees 
                             WHERE  department_id = 30);
                             
-- ALL 연산자 활용
-- 30번 부서의 최대급여자 보다 더 많은 급여를 받는 전체 사원목록 조회
SELECT * 
FROM   employees 
WHERE  salary > ALL (SELECT salary 
                            FROM   employees 
                            WHERE  department_id = 30);

-- EXISTS 연산자 활용
-- 서브쿼리의 결과 유무에 따른 조회
SELECT * 
FROM   employees 
WHERE  EXISTS(SELECT * 
                     FROM   departments 
                     WHERE  department_id = 30)
           AND department_id = 30;
           
-- 부서별 최소급여자 정보
SELECT * 
FROM   employees 
WHERE  ( department_id, salary ) IN(SELECT department_id, 
                                                         MIN(salary) 
                                              FROM   employees 
                                              GROUP  BY department_id) 
ORDER  BY department_id;

-- 가상컬럼(ROWID, ROWNUM)
SELECT ROWID, 
       ROWNUM, 
       employee_id,
       last_name
FROM   employees;

-- 테이블의 같은 행이라도 서로 다른 ROWNUM을 가질 수 있다
SELECT ROWNUM, employee_id
FROM   employees;

SELECT ROWNUM, employee_id
FROM   employees
ORDER BY employee_id DESC;

SELECT *
FROM   employees
WHERE  ROWNUM > 0;

-- 첫번째 행의 rownum이 1이므로
-- 1 > 1은 false가 되어 rownum은 더이상 증가하지 않으며, 하나의 행도 반환되지 않음
SELECT *
FROM   employees
WHERE  ROWNUM > 1;


-- 첫번째 10개행(범위)만을 조회할 경우
-- 첫번째 행의 rownum이 1이므로
-- 1 <= 10은 true가 되어 첫번째 행에 1이 할당되고 rownum은 2로 증가
SELECT *
FROM   employees
WHERE  ROWNUM <= 10;
 

/* 특정 컬럼을 기준으로 정렬하여 상위 5개(범위)를 조회하고자 한다면 */
-- 예)전체 사원의 급여순으로 5명 가져오기
-- 전체 급여 순위가 아닌 처음 5명안에서의 급여순위가 됨
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


-- 급여순으로 10 ~ 20 사이
SELECT page, 
      employee_id, 
      first_name, 
      salary 
FROM   (SELECT CEIL(ROWNUM / 10) page, 
               employee_id, 
               first_name, 
               salary 
        FROM   (SELECT ROWNUM,                    
                        employee_id, 
                        first_name, 
                        salary 
                FROM   employees 
                ORDER  BY salary DESC)) -- 급여 순 내린차순
WHERE  page = 2; 



