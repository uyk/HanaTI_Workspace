/* #1. DBA ����(sys or system)���� ���� �� User ���� */
CREATE USER bangry identified BY bangry;

/* #2. ������ User�� �ý��� ���� / ��ü(���̺�, �䡦) ���� �ο� */
-- �ý��� ���� ���� �ο�
GRANT CREATE SESSION TO bangry;
-- ��ü ���� �ο�(sys�� bangry���� hr ��Ű���� employee ��ü�� ���� CRUD ������ �ο�)
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees
TO bangry;

/* #3. �ʿ信 ���� User���� �ο��� ���� ȸ�� */
REVOKE SELECT, INSERT, UPDATE, DELETE ON hr.employees
FROM bangry;


/* ��(ROLE) : ���� ���ѵ��� ����(���� �� / ����� ���� ��) */
/* #1. User�� ���� �� �ο� */
GRANT CONNECT, RESOURCE, dba TO bangry;

/* #2. ����� ���� �� ���� */
CREATE ROLE my_role;
--DROP ROLE my_role;

/* #3. �ý��� ���Ѱ� ��ü ������ �ѿ� ��� */
GRANT CREATE SESSION TO my_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees TO  my_role;
