--�� DB ������ ���� ����
create user my_dva identified by dva;

-- �ý��� ���� ���� �ο�
GRANT CREATE SESSION TO my_dva; 
-- my_dva���� hr�� employee ���̺� ���� ���� �ο�
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees
TO my_dva;

-- ���� ����
REVOKE SELECT, INSERT, UPDATE, DELETE ON HR.EMPLOYEES
FROM my_dva;

-- role �ο� 