/* ��ü ���̺� ���� => ������ �������� �����Ű�� �ȴ�*/
SELECT  'DROP TABLE ' || object_name || ' CASCADE CONSTRAINTS;'
  FROM    user_objects
WHERE   object_type = 'TABLE';

--DROP TABLE EVAL CASCADE CONSTRAINTS;
--DROP TABLE DEPT CASCADE CONSTRAINTS;
--DROP TABLE EMP CASCADE CONSTRAINTS;
--DROP TABLE REGION CASCADE CONSTRAINTS;
--DROP TABLE STOCK CASCADE CONSTRAINTS;
--DROP TABLE STORE CASCADE CONSTRAINTS;
--DROP TABLE ITEM CASCADE CONSTRAINTS;
--DROP TABLE TRANS CASCADE CONSTRAINTS;
--DROP TABLE PAYMENT CASCADE CONSTRAINTS;
--DROP TABLE PITEM CASCADE CONSTRAINTS;
--DROP TABLE PURCHASE CASCADE CONSTRAINTS;
--DROP TABLE OPINION CASCADE CONSTRAINTS;
--DROP TABLE CREDIT CASCADE CONSTRAINTS;
--DROP TABLE CLIENT CASCADE CONSTRAINTS;

/* �ſ��� */ 
CREATE TABLE credit 
  ( 
     credit_id      NUMBER(20) NOT NULL,/* �ſ���_��ȣ */ 
     client_id      NUMBER(20) NOT NULL,/* ��_��ȣ */ 
     credit_company VARCHAR2(20) NOT NULL,/* �ſ���_ȸ�� */ 
     credit_grade   VARCHAR2(20) NOT NULL /* �ſ���_���(�ſ�ȸ��) */ 
  ); 

CREATE UNIQUE INDEX pk_credit 
  ON credit ( credit_id ASC, client_id ASC ); 

ALTER TABLE credit 
  ADD CONSTRAINT pk_credit PRIMARY KEY ( credit_id, client_id ); 

CREATE SEQUENCE credit_seq 
  INCREMENT BY 1 
  START WITH 1000 
  NOMAXVALUE 
  NOCYCLE 
  CACHE 20; 

/* �� */ 
CREATE TABLE client 
  ( 
     client_id      NUMBER(20) NOT NULL,/* ��_��ȣ */ 
     personincharge NUMBER(20),/* ��_��翵����� */ 
     client_name    VARCHAR2(20) NOT NULL,/* ��_�̸� */ 
     client_phone   NUMBER(20) NOT NULL,/* ��_��ȭ��ȣ */ 
     client_address VARCHAR2(20) NOT NULL,/* ��_�ּ� */ 
     client_zipcode NUMBER(10) NOT NULL,/* ��_�����ȣ */ 
     client_region  VARCHAR2(20),/* ��_���� */ 
     client_city    VARCHAR2(20),/* ��_���ø� */ 
     client_state   VARCHAR2(20),/* ��_�ָ� */ 
     client_nation  VARCHAR2(20),/* ��_������ */ 
     creditgrade    VARCHAR2(20),/* ��_�ſ��� */ 
     client_userid  VARCHAR2(20),/* ��_���̵� */ 
     client_passwd  NUMBER(10),/* ��_��й�ȣ */ 
     client_remarks VARCHAR2(100)/* ��_��� */ 
  ); 

CREATE UNIQUE INDEX pk_client 
  ON client ( client_id ASC ); 

ALTER TABLE client 
  ADD CONSTRAINT pk_client PRIMARY KEY ( client_id ); 

CREATE SEQUENCE client_seq 
  INCREMENT BY 1 
  START WITH 1000 
  NOMAXVALUE 
  NOCYCLE 
  CACHE 20; 

/* ���ǰ� */ 
CREATE TABLE opinion 
  ( 
     opinion_id      NUMBER(20) NOT NULL,/* ���ǰ�_��ȣ */ 
     client_id       NUMBER(20) NOT NULL,/* ��_��ȣ */ 
     opinion_opinion VARCHAR2(100) NOT NULL /* ���ǰ�_�ǰ� */ 
  ); 

CREATE UNIQUE INDEX pk_opinion 
  ON opinion ( opinion_id ASC, client_id ASC ); 

ALTER TABLE opinion 
  ADD CONSTRAINT pk_opinion PRIMARY KEY ( opinion_id, client_id ); 

CREATE SEQUENCE opinion_seq 
  INCREMENT BY 1 
  START WITH 1000 
  NOMAXVALUE 
  NOCYCLE 
  CACHE 20; 

/* ���� */ 
CREATE TABLE purchase 
  ( 
     purchase_id         NUMBER(20) NOT NULL,/* ����_��ȣ */ 
     client_id           NUMBER(20) NOT NULL,/* ��_��ȣ */ 
     personincharege     NUMBER(20),/* ����_��翵�������ȣ */ 
     purchase_outid      NUMBER(10) NOT NULL,/* ����_�ܺα��Ź�ȣ */ 
     purchase_date       DATE,/* ����_��¥ */ 
     purchase_isship     VARCHAR2(4),/* ����_�������� */ 
     purchase_shipdate   DATE,/* ����_������¥ */ 
     persionincharge     NUMBER(10),/* ����_��翵�������ȣ */ 
     purchase_price      NUMBER(20, 2),/* ����_�ݾ� */ 
     purchase_payby      VARCHAR2(10),/* ����_���� ��� */ 
     purchase_purchaseby VARCHAR2(10),/* ���� ���� */ 
     purchase_isarrived  VARCHAR2(100),/* ����_�������� */ 
     purchase_remakrs    VARCHAR2(400)/* ����_��� */ 
  ); 

CREATE UNIQUE INDEX pk_purchase 
  ON purchase ( purchase_id ASC, client_id ASC ); 

ALTER TABLE purchase 
  ADD CONSTRAINT pk_purchase PRIMARY KEY ( purchase_id, client_id ); 

CREATE SEQUENCE purchase_seq 
  INCREMENT BY 1 
  START WITH 1000 
  NOMAXVALUE 
  NOCYCLE 
  CACHE 20; 

/* �����׸� */ 
CREATE TABLE pitem 
  ( 
     pitem_id            NUMBER(20) NOT NULL,/* �����׸�_��ȣ */ 
     purchase_id         NUMBER(20) NOT NULL,/* ����_��ȣ */ 
     client_id           NUMBER(20) NOT NULL,/* ��_��ȣ */ 
     item_id             NUMBER(20) NOT NULL,/* ��ǰ_��ȣ */ 
     pitem_unitp         NUMBER(20, 2),/* �����׸�_�ܰ� */ 
     pitem_quantity      NUMBER(10),/* �����׸�_���� */ 
     pitem_shipquantity  NUMBER(10),/* �����׸�_�������� */ 
     pitem_ispurchaseall VARCHAR2(20)/* �����׸�_��� */ 
  ); 

CREATE UNIQUE INDEX pk_pitem 
  ON pitem ( pitem_id ASC, purchase_id ASC, client_id ASC, item_id ASC ); 

ALTER TABLE pitem 
  ADD CONSTRAINT pk_pitem PRIMARY KEY ( pitem_id, purchase_id, client_id, 
  item_id ); 

CREATE SEQUENCE pitem_seq 
  INCREMENT BY 1 
  START WITH 1000 
  NOMAXVALUE 
  NOCYCLE 
  CACHE 20; 

/* ������� */ 
CREATE TABLE payment 
  ( 
     payment_id      NUMBER(20) NOT NULL,/* ���_��ȣ */ 
     purchase_id     NUMBER(20) NOT NULL,/* ����_��ȣ */ 
     client_id       NUMBER(20) NOT NULL,/* ��_��ȣ */ 
     payment_state   VARCHAR2(10),/* ���_���� */ 
     payment_balance NUMBER(20, 2)/* ���_�ܾ� */ 
  ); 

CREATE UNIQUE INDEX pk_payment 
  ON payment ( payment_id ASC, purchase_id ASC, client_id ASC ); 

ALTER TABLE payment 
  ADD CONSTRAINT pk_payment PRIMARY KEY ( payment_id, purchase_id, client_id ); 

CREATE SEQUENCE payment_seq 
  INCREMENT BY 1 
  START WITH 1000 
  NOMAXVALUE 
  NOCYCLE 
  CACHE 20; 

/* ��� */ 
CREATE TABLE trans 
  ( 
     trans_id      NUMBER(20) NOT NULL,/* ���_��ȣ */ 
     purchase_id   NUMBER(20) NOT NULL,/* ����_��ȣ */ 
     client_id     NUMBER(20) NOT NULL,/* ��_��ȣ */ 
     trans_state   VARCHAR2(20),/* ���_���� */ 
     trans_remarks VARCHAR2(400) /* ���_��� */ 
  ); 

CREATE UNIQUE INDEX pk_trans 
  ON trans ( trans_id ASC, purchase_id ASC, client_id ASC ); 

ALTER TABLE trans 
  ADD CONSTRAINT pk_trans PRIMARY KEY ( trans_id, purchase_id, client_id ); 

CREATE SEQUENCE trans_seq 
  INCREMENT BY 1 
  START WITH 1000 
  NOMAXVALUE 
  NOCYCLE 
  CACHE 20; 

/* ��ǰ */ 
CREATE TABLE item 
  ( 
     item_id        NUMBER(20) NOT NULL,/* ��ǰ_��ȣ */ 
     item_name      VARCHAR2(30) NOT NULL,/* ��ǰ_�̸� */ 
     item_summary   VARCHAR2(100),/* ��ǰ_��༳�� */ 
     item_details   VARCHAR2(200),/* ��ǰ_�󼼼��� */ 
     item_picture   VARCHAR2(50),/* ��ǰ_���� */ 
     item_price     NUMBER(20),/* ��ǰ_���尡�� */ 
     item_salesunit VARCHAR2(10),/* ��ǰ_�ǸŴ��� */ 
     item_remarks   VARCHAR2(100)/* ��ǰ_��� */ 
  ); 

CREATE UNIQUE INDEX pk_item 
  ON item ( item_id ASC ); 

ALTER TABLE item 
  ADD CONSTRAINT pk_item PRIMARY KEY ( item_id ); 

CREATE SEQUENCE item_seq 
  INCREMENT BY 1 
  START WITH 1000 
  NOMAXVALUE 
  NOCYCLE 
  CACHE 20; 

/* â�� */ 
CREATE TABLE store 
  ( 
     store_id       NUMBER(20) NOT NULL,/* â��_��ȣ */ 
     region_id      NUMBER(20) NOT NULL,/* ����_��ȣ */ 
     personincharge NUMBER(20) NOT NULL,/* â��_����� */ 
     store_name     VARCHAR2(30) NOT NULL,/* â��_�̸� */ 
     store_phone    VARCHAR2(20),/* â��_��ȭ��ȣ */ 
     store_address  VARCHAR2(50),/* â��_�ּ� */ 
     store_city     VARCHAR2(20),/* â��_���ø� */ 
     store_state    VARCHAR2(20),/* â��_�ָ� */ 
     store_nation   VARCHAR2(20),/* â��_������ */ 
     store_zipcode  VARCHAR2(30),/* â��_�����ȣ */ 
     store_remarks  VARCHAR2(100)/* â��_��� */ 
  ); 

CREATE UNIQUE INDEX pk_store 
  ON store ( store_id ASC, region_id ASC, personincharge ASC ); 

ALTER TABLE store 
  ADD CONSTRAINT pk_store PRIMARY KEY ( store_id, region_id, personincharge ); 

CREATE SEQUENCE store_seq 
  INCREMENT BY 1 
  START WITH 1000 
  NOMAXVALUE 
  NOCYCLE 
  CACHE 20; 

/* ��� */ 
CREATE TABLE stock 
  ( 
     stock_id               NUMBER(20) NOT NULL,/* ���_��ȣ */ 
     item_id                NUMBER(20) NOT NULL,/* ��ǰ_��ȣ */ 
     store_id               NUMBER(20) NOT NULL,/* â��_��ȣ */ 
     stock_max              NUMBER(10) NOT NULL,/* ���_�ִ���� */ 
     stock_reasonforexhaust VARCHAR2(30),/* ���_���������� */ 
     stock_dateofreceipt    DATE,/* ���_��ǰ������ */ 
     stock_dateofreorder    DATE,/* ���_���ֹ����� */ 
     stock_quantity         NUMBER(10),/* ���_��� */ 
     stock_remarks          VARCHAR2(100),/* ���_��� */ 
     region_id              NUMBER(20),/* ����_��ȣ */ 
     personincharge         NUMBER(20)/* â��_����� */ 
  ); 

CREATE UNIQUE INDEX pk_stock 
  ON stock ( stock_id ASC, item_id ASC ); 

ALTER TABLE stock 
  ADD CONSTRAINT pk_stock PRIMARY KEY ( stock_id, item_id ); 

CREATE SEQUENCE stock_seq 
  INCREMENT BY 1 
  START WITH 1000 
  NOMAXVALUE 
  NOCYCLE 
  CACHE 20; 

/* ���� */ 
CREATE TABLE region 
  ( 
     region_id   NUMBER(20) NOT NULL,/* ����_��ȣ */ 
     region_name VARCHAR2(30) NOT NULL /* ����_�̸� */ 
  ); 

CREATE UNIQUE INDEX pk_region 
  ON region ( region_id ASC ); 

ALTER TABLE region 
  ADD CONSTRAINT pk_region PRIMARY KEY ( region_id ); 

CREATE SEQUENCE region_seq 
  INCREMENT BY 1 
  START WITH 1000 
  NOMAXVALUE 
  NOCYCLE 
  CACHE 20; 

/* ��ü��� */ 
CREATE TABLE emp 
  ( 
     emp_id         NUMBER(20) NOT NULL,/* ���_�����ȣ */ 
     dept_id        NUMBER(20),/* �μ�_�μ���ȣ */ 
     emp_managerid  NUMBER(20),/* ���_��� */ 
     emp_lastname   VARCHAR2(20) NOT NULL,/* ���_�� */ 
     emp_firstname  VARCHAR2(20) NOT NULL,/* ���_�̸� */ 
     emp_hiredate   DATE,/* ���_�Ի��� */ 
     emp_rank       VARCHAR2(20),/* ���_���� */ 
     emp_salary     NUMBER(10) NOT NULL,/* ���_���� */ 
     emp_userid     VARCHAR2(20),/* ���_���̵� */ 
     emp_passwd     VARCHAR2(20),/* ���_��й�ȣ */ 
     emp_commission NUMBER(5, 5),/* ���_Ŀ�̼� */ 
     emp_remarks    VARCHAR2(50)/* ���_��� */ 
  ); 

CREATE UNIQUE INDEX pk_emp 
  ON emp ( emp_id ASC ); 

ALTER TABLE emp 
  ADD CONSTRAINT pk_emp PRIMARY KEY ( emp_id ); 

CREATE SEQUENCE emp_seq 
  INCREMENT BY 1 
  START WITH 1000 
  NOMAXVALUE 
  NOCYCLE 
  CACHE 20; 

/* �μ� */ 
CREATE TABLE dept 
  ( 
     dept_id       NUMBER(20) NOT NULL,/* �μ�_�μ���ȣ */ 
     emp_id        NUMBER(20) NOT NULL,/* ���_�μ��� */ 
     dept_name     VARCHAR2(20) NOT NULL,/* �μ�_�μ��̸� */ 
     dept_location VARCHAR2(20) NOT NULL,/* �μ�_�μ���ġ */ 
     dept_remarks  VARCHAR2(50)/* �μ�_��� */ 
  ); 

CREATE UNIQUE INDEX pk_dept 
  ON dept ( dept_id ASC ); 

ALTER TABLE dept 
  ADD CONSTRAINT pk_dept PRIMARY KEY ( dept_id ); 

CREATE SEQUENCE dept_seq 
  INCREMENT BY 1 
  START WITH 1000 
  NOMAXVALUE 
  NOCYCLE 
  CACHE 20; 

/* �� */ 
CREATE TABLE eval 
  ( 
     eval_id         NUMBER(20) NOT NULL,/* ��_�򰡹�ȣ */ 
     emp_subjectid   NUMBER(20) NOT NULL,/* ���_����� */ 
     emp_writerid    NUMBER(20) NOT NULL,/* ���_�ۼ��� */ 
     eval_evaluation VARCHAR2(50) NOT NULL /* ��_���� */ 
  ); 

CREATE UNIQUE INDEX pk_eval 
  ON eval ( eval_id ASC, emp_subjectid ASC, emp_writerid ASC ); 

ALTER TABLE eval 
  ADD CONSTRAINT pk_eval PRIMARY KEY ( eval_id, emp_subjectid, emp_writerid ); 

CREATE SEQUENCE eval_seq 
  INCREMENT BY 1 
  START WITH 1000 
  NOMAXVALUE 
  NOCYCLE 
  CACHE 20; 

ALTER TABLE credit 
  ADD CONSTRAINT fk_client_to_credit FOREIGN KEY ( client_id ) REFERENCES client 
  ( client_id ); 

ALTER TABLE client 
  ADD CONSTRAINT fk_emp_to_client FOREIGN KEY ( personincharge ) REFERENCES emp 
  ( emp_id );
  
ALTER TABLE client
  ADD CONSTRAINT client_ck_creditgrade
  CHECK (creditgrade IN ('EXCELLENT', 'GOOD', 'POOR'));   
  
ALTER TABLE opinion 
  ADD CONSTRAINT fk_client_to_opinion FOREIGN KEY ( client_id ) REFERENCES 
  client ( client_id ); 

ALTER TABLE purchase 
  ADD CONSTRAINT fk_client_to_purchase FOREIGN KEY ( client_id ) REFERENCES 
  client ( client_id ); 

ALTER TABLE purchase 
ADD CONSTRAINT purchase_ck_purchase_payby
  CHECK (purchase_payby IN ('Credit', 'Card'));
  
ALTER TABLE purchase 
  ADD CONSTRAINT purchase_ck_purchase_isship
  CHECK (purchase_isship IN ('Y', 'N'));

ALTER TABLE purchase 
  ADD CONSTRAINT fk_emp_to_purchase FOREIGN KEY ( personincharege ) REFERENCES 
  emp ( emp_id ); 

ALTER TABLE pitem 
  ADD CONSTRAINT fk_purchase_to_pitem FOREIGN KEY ( purchase_id, client_id ) 
  REFERENCES purchase ( purchase_id, client_id ); 

ALTER TABLE pitem 
  ADD CONSTRAINT fk_item_to_pitem FOREIGN KEY ( item_id ) REFERENCES item ( 
  item_id ); 

ALTER TABLE payment 
  ADD CONSTRAINT fk_purchase_to_payment FOREIGN KEY ( purchase_id, client_id ) 
  REFERENCES purchase ( purchase_id, client_id ); 

ALTER TABLE trans 
  ADD CONSTRAINT fk_purchase_to_trans FOREIGN KEY ( purchase_id, client_id ) 
  REFERENCES purchase ( purchase_id, client_id ); 

ALTER TABLE store 
  ADD CONSTRAINT fk_region_to_store FOREIGN KEY ( region_id ) REFERENCES region 
  ( region_id ); 

ALTER TABLE store 
  ADD CONSTRAINT fk_emp_to_store FOREIGN KEY ( personincharge ) REFERENCES emp ( 
  emp_id ); 

ALTER TABLE stock 
  ADD CONSTRAINT fk_item_to_stock FOREIGN KEY ( item_id ) REFERENCES item ( 
  item_id ); 

ALTER TABLE stock 
  ADD CONSTRAINT fk_store_to_stock FOREIGN KEY ( store_id, region_id, 
  personincharge ) REFERENCES store ( store_id, region_id, personincharge ); 

ALTER TABLE emp 
  ADD CONSTRAINT fk_emp_to_emp FOREIGN KEY ( emp_managerid ) REFERENCES emp ( 
  emp_id ); 

ALTER TABLE emp 
  ADD CONSTRAINT fk_dept_to_emp FOREIGN KEY ( dept_id ) REFERENCES dept ( 
  dept_id ); 

ALTER TABLE dept 
  ADD CONSTRAINT fk_emp_to_dept FOREIGN KEY ( emp_id ) REFERENCES emp ( emp_id ) 
; 

ALTER TABLE eval 
  ADD CONSTRAINT fk_emp_to_eval FOREIGN KEY ( emp_subjectid ) REFERENCES emp ( 
  emp_id ); 

ALTER TABLE eval 
  ADD CONSTRAINT fk_emp_to_eval2 FOREIGN KEY ( emp_writerid ) REFERENCES emp ( 
  emp_id ); 

ALTER TABLE region
  ADD CONSTRAINT region_ck_region_name
  CHECK (region_name IN ('NA', 'SA', 'AF', 'ME', 'AS', 'EU'));