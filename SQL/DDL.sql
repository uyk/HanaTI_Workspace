-- ���̺� ����
DROP TABLE person;

DESC PERSON;

/* #1. ���̺� ���� �� �÷� ���� �������� �߰� */
CREATE TABLE person(
  name     VARCHAR2(10) NOT NULL,
  age      NUMBER(10)   NOT NULL,
  birthday DATE         NOT NULL
);


/* ������ ��ųʸ��κ��� �������� ��ȸ */
SELECT *
FROM   user_constraints
WHERE  table_name = 'PERSON';

-- 1.NOT NULL ��������
CREATE TABLE person(
    name    VARCHAR2(10) CONSTRAINT person_name_nn NOT NULL,
    age      NUMBER(3)       NOT NULL,
    birthday DATE
);

-- 2.UNIQUE ��������
CREATE TABLE person(
    name    VARCHAR2(10) CONSTRAINT person_name_uk UNIQUE,
    age      NUMBER(3)       NOT NULL,
    birthday DATE
);

-- 3.PRIMARY KEY(UNIQUE + NOT NULL) ��������
CREATE TABLE person(
    name    VARCHAR2(10) CONSTRAINT person_name_pk PRIMARY KEY,
    age      NUMBER(3)         NOT NULL,
   birthday DATE
);

-- 4.FOREIGN KEY ��������
CREATE TABLE person(
	name       VARCHAR2(10) CONSTRAINT person_name_pk PRIMARY KEY,
  age        NUMBER(3)    NOT NULL,
  manager_id NUMBER(6)    CONSTRAINT person_id_fk REFERENCES employees(employee_id),
  birthday   DATE
);
-- 5.CHECK ��������
CREATE TABLE person(
	name     VARCHAR2(10)   CONSTRAINT person_name_pk PRIMARY KEY,
  age        NUMBER(3)    CONSTRAINT person_age_ck  CHECK (age BETWEEN 20 AND 100),
  manager_id NUMBER(6)    CONSTRAINT person_id_fk   REFERENCES employees(employee_id),
  birthday date DEFAULT SYSDATE
);



/* #1. ���̺� ���� �� �÷� ���� �������� �߰� */
CREATE TABLE sawon(
    ssn         NUMBER(20)      CONSTRAINT sawon_ssn_pk PRIMARY KEY,
    name        VARCHAR2(10)    NOT NULL,
    hiredate    DATE            DEFAULT SYSDATE NOT NULL,
    manager_ssn NUMBER(20)      CONSTRAINT sawon_ssn_fk REFERENCES sawon(ssn),
    sex         VARCHAR2(1)     CONSTRAINT sawon_sex_ck CHECK (sex IN('M', 'F') )
);

SELECT *
FROM   user_constraints
WHERE  table_name = 'SAWON';


/* #2. ���̺� ���� �� �������� �и� */
CREATE TABLE person (
  name       VARCHAR2(10),
  age        NUMBER(3)  NOT NULL,
  manager_id NUMBER(6)  NOT NULL,
  birthday   DATE DEFAULT sysdate,
  CONSTRAINT person_name_pk PRIMARY KEY(name),
  CONSTRAINT person_age_ck CHECK (age BETWEEN 20 AND 30),
  CONSTRAINT person_id_fk FOREIGN KEY(manager_id) REFERENCES EMPLOYEES(employee_id)
);

/* #3. ���̺� ���� �� ���̺� ������ ���� �������� �߰�(����) - ������ �������� �и� */
CREATE TABLE person(
  name       VARCHAR2(10),
  age        NUMBER(3)  NOT NULL,
  manager_id NUMBER(6)  NOT NULL,
  birthday   DATE DEFAULT sysdate
);

-- ������  ���̺� �������� �߰�
ALTER TABLE person
	ADD ( CONSTRAINT person_name_pk PRIMARY KEY(name),
        CONSTRAINT person_age_ck  CHECK (age BETWEEN 20 AND 30),
        CONSTRAINT person_id_fk   FOREIGN KEY(manager_id) REFERENCES EMPLOYEES(employee_id));

-- ������ ���Ǹ� ���� �������� ��Ȱ��ȭ/Ȱ��ȭ
ALTER TABLE person
  DISABLE CONSTRAINT person_name_pk CASCADE
  DISABLE CONSTRAINT person_age_ck
  DISABLE CONSTRAINT person_id_fk;

ALTER TABLE person
  ENABLE CONSTRAINT person_name_pk
  ENABLE CONSTRAINT person_age_ck
  ENABLE CONSTRAINT person_id_fk;


-- �׽�Ʈ�� ���� �μ�Ʈ
INSERT INTO person 
            (name, 
             age, 
             manager_id) 
VALUES      ('�����', 
             25, 
             100); 

INSERT INTO person 
            (name, 
             age, 
             manager_id, 
             birthday) 
VALUES      ('����� ', 
             30, 
             103, 
             To_date('1968-03-13', 'YYYY-MM-DD')); 

COMMIT;

SELECT *
FROM person;

--�������� ����
ALTER TABLE person
	DROP CONSTRAINT person_age_ck CASCADE;
  
  
  
-- �ǽ� : employees ���̺� �������� ��ȸ �� ���� ������� �Է��ϱ�

/* ���̺� ���� ���� */
--1.�÷� �߰�
ALTER TABLE person
	ADD (address VARCHAR2(100));
--2.�÷� ����
ALTER TABLE person
	MODIFY (address VARCHAR2(200));
--3.�÷� ����
ALTER TABLE person
	drop COLUMN address;


-- ���������� �̿��� ���̺� ����(����)
CREATE TABLE emp_info AS
    SELECT department_id "�μ���ȣ", COUNT(*) "�����", SUM(salary) "�޿�����", ROUND(AVG(salary)) "�޿����", MIN(salary) "�ּұ޿�", MAX(salary) "�ִ�޿�"
    FROM EMPLOYEES
    GROUP BY department_id
    ORDER BY department_id;

SELECT * FROM emp_info;




/* RENAME : ���̺� �̸� ���� */
RENAME sometable TO sometable2;

/* TRUNCATE */
-- ������� ����
-- DML�� DELETE�� �޸� ������ ���� ���� �Ҽ� ����(Auto Commit)
-- INDEX�� ���� ��� �ٽ� �����ؾ� �Ѵ�.
TRUNCATE table person ;

/* DROP : ���̺� ���� */
-- ���̺��� ��� ������ �ڷ�, ��������� �����Ǹ�
-- �׿� ������ INDEX �� �����ȴ�.
DROP table person;

-- ���̺�� ���õ�  ������׵� ����
DROP table person CASCADE CONSTRAINTS;

