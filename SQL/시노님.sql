-- sys or system���� �����ؼ� �ó�� ����
CREATE SYNONYM emp_synonym
FOR HR.EMPLOYEES;

SELECT * FROM emp_synonym;

-- �ó�� ����
DROP SYNONYM emp_synonym;
