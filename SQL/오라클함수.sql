-- 문자열 관련 단일행 함수

SELECT CONCAT('Oracle', 'Java Developer')
FROM dual;

SELECT INITCAP('kim ki jung')
FROM dual;

SELECT first_name, last_name
FROM employees
--WHERE first_name = 'james';
WHERE LOWER(first_name) = 'james';

SELECT UPPER('bangry')
FROM dual;

SELECT RPAD('DataBase', 10, '*')
FROM dual;

SELECT SUBSTR('Java Developer', 6, 9)
FROM dual;

SELECT SUBSTR('서울시가산동', 4)
FROM dual;

SELECT first_name, LENGTH(first_name)
FROM employees;

SELECT REPLACE('기정바보', '바보', '최고')
FROM dual;

SELECT REPLACE('서울 시', ' ', '')
FROM dual;

--SELECT INSTR('DataBase', 'B')
SELECT INSTR('DataBase', 'a', 1, 2)
FROM dual;

--SELECT LTRIM('    JavaDeveloper')
--SELECT LTRIM('    JavaDeveloper', ' ')
SELECT LTRIM('JavaDeveloper', 'Java')
FROM dual;

--SELECT RTRIM('JavaDeveloper      ')
--SELECT RTRIM('JavaDeveloper      ', ' ')
SELECT RTRIM('JavaDeveloper', 'loper')
FROM dual;

SELECT TRIM('      Java  Developer      ')
FROM dual;

------------------- 숫자 단일행 함수
SELECT  ROUND(45.923), ROUND(45.923, 0), ROUND(45.923, 2), ROUND(45.923, -1)
FROM dual;

SELECT  TRUNC(45.923), TRUNC(45.923, 0), TRUNC(45.923, 2), TRUNC(45.923, -1) 
FROM dual;

SELECT  MOD(123456, 2)
FROM dual;

SELECT  CEIL(123.123)
FROM dual;

SELECT  FLOOR(123.123)
FROM dual;

SELECT  ABS(-500)
FROM dual;

SELECT  LN(10)
FROM dual;

SELECT  POWER(5, 2), SQRT(5), SIN(30), COS(30), TAN(30)
FROM dual;

-- 전달인자중 최소값 반환
SELECT  LEAST(10, 20, 30, 40)
FROM dual;

-- 전달인자중 최대값 반환
SELECT  GREATEST(10, 20, 30, 40)
FROM dual;


SELECT SYSDATE
FROM dual;

-- DATE 타입에 연산 가능
SELECT SYSDATE - 1 "어제" , SYSDATE "오늘", SYSDATE + 1 "내일"
FROM dual;

-- 사원별 근무 일수 검색
SELECT first_name,  hire_date, SYSDATE, CEIL(SYSDATE - hire_date) "근무일수"
FROM employees;

-- 사원별 근무 개월수 검색
SELECT first_name, TRUNC(MONTHS_BETWEEN(SYSDATE, hire_date))  "근무개월수"
FROM employees;

-- 특정개월수를 더한 날짜 반환
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 2) "오늘부터 2개월 후"
FROM dual;

-- 이번주 토요일 날짜
SELECT SYSDATE "오늘", NEXT_DAY(SYSDATE, '토요일') "이번주 토요일"
FROM dual;

-- 이번달 마지막 날짜
SELECT SYSDATE, LAST_DAY(SYSDATE) "이번달 마지막날"
FROM dual;


SELECT TO_DATE('2011/12/31 18:45:23', 'YYYY/MM/DD HH24:MI:SS')
FROM dual;

SELECT first_name, hire_date
FROM employees
--WHERE hire_date = TO_DATE('2003-06-17', 'YYYY-MM-DD');
WHERE hire_date = TO_DATE(20030617, 'YYYY-MM-DD');
--WHERE hire_date = '2003-06-17 18:45:23';
--WHERE hire_date = 20030617;

SELECT first_name, hire_date
FROM employees
--WHERE hire_date = TO_DATE('2013', 'YYYY');
WHERE hire_date = tO_DATE('2003-07-14', 'YYYY/MM/DD');
--WHERE HIRE_DATE < '2003-12-31' and Hire_Date > '2003-01-01';


-------------숫자
SELECT TO_NUMBER('12345') + 1
FROM dual;

SELECT TO_NUMBER('12,345', '00,000') + 1
FROM dual;  

SELECT TO_NUMBER('1000') + TO_NUMBER('2,000', '0,000') + 1
FROM dual;

---------------- 문자
SELECT TO_CHAR(12345), TO_CHAR(12345.67)
FROM dual;

SELECT TO_CHAR(12345, '999,999'), TO_CHAR(12345.677, '999,999.99')
FROM dual;

SELECT TO_CHAR(12345, '000,000'), TO_CHAR(12345.677, '000,000.00')
FROM dual;

SELECT TO_CHAR(150, '$9999'), TO_CHAR(150, '$0000')
FROM dual;

SELECT TO_CHAR(150, 'S9999'), TO_CHAR(150, 'S0000')
FROM dual;

SELECT TO_CHAR(150, '9999MI'), TO_CHAR(-150, '9999MI')
FROM dual;

SELECT TO_CHAR(150, '9999EEEE'), TO_CHAR(150, '99999B')
FROM dual;

SELECT TO_CHAR(150, 'RN'), TO_CHAR(150, 'rn')
FROM dual;

SELECT TO_CHAR(10, 'X'), TO_CHAR(10, 'x'), TO_CHAR(15, 'X')
FROM dual;

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD AM HH:MI:SS DAY')
FROM dual;

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD AM HH:MI:SS DAY', 'NLS_DATE_LANGUAGE=FRencH')
--SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD AM HH:MI:SS DAY', 'NLS_DATE_LANGUAGE=ENGLISH')
FROM dual;

-- 초기 파라메터(환경설정) 목록 검색
SELECT * FROM  NLS_SESSION_PARAMETERS;

SELECT first_name, hire_date, TO_CHAR(hire_date, 'YYYY-MM-DD HH24:MI') "ch"
FROM employees;

-- 입사년도가 2002년도인 사원들
SELECT first_name, hire_date
FROM employees
WHERE TO_CHAR(hire_date, 'YYYY') = '2002';

-----------------------------------------------------일반함수 NVL
SELECT 10 * NULL, 10 * NVL(NULL, 1)
FROM dual;

SELECT first_name, 
          salary, 
          commission_pct, 
          ( salary + ( salary * commission_pct ) ) * 12 "연봉"
FROM   employees;

SELECT first_name, 
          salary, 
          commission_pct, 
          ( salary + ( salary * NVL(commission_pct, 0) ) ) * 12 "연봉" 
FROM   employees;
--order by ( salary + ( salary * NVL(commission_pct, 0) )                      ) * 12;

SELECT first_name, 
          job_id, 
          salary, 
          DECODE(job_id, 'IT_PROG', salary * 1.5, 
                              'AC_MRG', salary * 1.3, 
                              'AC_ASST', salary * 1.1, 
                              salary) "인상된급여" 
FROM   employees;

------------------------------------------- 그룹함수
select count(commission_pct) "커미션사원수"
from employees;

select count(*) "전체사원수", count(commission_pct) "커미션사원수"
from employees;

select sum(salary), SUM(commission_pct)
from employees;

select avg(salary)
from employees;

select avg(commission_pct), avg(NVL(commission_pct,0))
from employees;

select MAX(salary), MAX(commission_pct)
from employees;

SELECT MAX(hire_date), MIN(hire_date), MAX(hire_date) - MIN(hire_date) "짬밥차" 
FROM employees;

-- GROUP BY 절(특정 컬럼을 기준으로 그룹핑)
SELECT department_id
FROM employees
GROUP BY department_id;

-- 부서별 급여총액, 평균
SELECT department_id, SUM(salary), AVG(salary)
FROM employees
GROUP BY department_id
order by avg(salary);

-- HAVING 절(그룹에 대한 조건)
SELECT department_id, SUM(salary), AVG(salary)
FROM employees
GROUP BY department_id
HAVING department_id = 10;

SELECT department_id, SUM(salary), AVG(salary)
FROM employees
GROUP BY department_id
HAVING AVG(salary) >= 9000;

SELECT department_id, MAX(salary), MIN(salary)
FROM employees
GROUP BY department_id
HAVING MAX(salary) > 20000; 

SELECT  hire_date, COUNT(*)
FROM employees
GROUP BY hire_date
ORDER BY hire_date;  
--ORDER BY COUNT(*);


