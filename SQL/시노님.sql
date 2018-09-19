-- sys or system으로 접속해서 시노님 생성
CREATE SYNONYM emp_synonym
FOR HR.EMPLOYEES;

SELECT * FROM emp_synonym;

-- 시노님 삭제
DROP SYNONYM emp_synonym;
