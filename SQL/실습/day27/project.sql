/* 전체 테이블 삭제 => 생성된 쿼리문을 실행시키면 된다*/
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

/* 신용등급 */ 
CREATE TABLE credit 
  ( 
     credit_id      NUMBER(20) NOT NULL,/* 신용등급_번호 */ 
     client_id      NUMBER(20) NOT NULL,/* 고객_번호 */ 
     credit_company VARCHAR2(20) NOT NULL,/* 신용등급_회사 */ 
     credit_grade   VARCHAR2(20) NOT NULL /* 신용등급_등급(신용회사) */ 
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

/* 고객 */ 
CREATE TABLE client 
  ( 
     client_id      NUMBER(20) NOT NULL,/* 고객_번호 */ 
     personincharge NUMBER(20),/* 고객_담당영업사원 */ 
     client_name    VARCHAR2(20) NOT NULL,/* 고객_이름 */ 
     client_phone   NUMBER(20) NOT NULL,/* 고객_전화번호 */ 
     client_address VARCHAR2(20) NOT NULL,/* 고객_주소 */ 
     client_zipcode NUMBER(10) NOT NULL,/* 고객_우편번호 */ 
     client_region  VARCHAR2(20),/* 고객_지역 */ 
     client_city    VARCHAR2(20),/* 고객_도시명 */ 
     client_state   VARCHAR2(20),/* 고객_주명 */ 
     client_nation  VARCHAR2(20),/* 고객_국가명 */ 
     creditgrade    VARCHAR2(20),/* 고객_신용등급 */ 
     client_userid  VARCHAR2(20),/* 고객_아이디 */ 
     client_passwd  NUMBER(10),/* 고객_비밀번호 */ 
     client_remarks VARCHAR2(100)/* 고객_비고 */ 
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

/* 고객의견 */ 
CREATE TABLE opinion 
  ( 
     opinion_id      NUMBER(20) NOT NULL,/* 고객의견_번호 */ 
     client_id       NUMBER(20) NOT NULL,/* 고객_번호 */ 
     opinion_opinion VARCHAR2(100) NOT NULL /* 고객의견_의견 */ 
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

/* 구매 */ 
CREATE TABLE purchase 
  ( 
     purchase_id         NUMBER(20) NOT NULL,/* 구매_번호 */ 
     client_id           NUMBER(20) NOT NULL,/* 고객_번호 */ 
     personincharege     NUMBER(20),/* 구매_담당영업사원번호 */ 
     purchase_outid      NUMBER(10) NOT NULL,/* 구매_외부구매번호 */ 
     purchase_date       DATE,/* 구매_날짜 */ 
     purchase_isship     VARCHAR2(4),/* 구매_선적여부 */ 
     purchase_shipdate   DATE,/* 구매_선적날짜 */ 
     persionincharge     NUMBER(10),/* 구매_담당영업사원번호 */ 
     purchase_price      NUMBER(20, 2),/* 구매_금액 */ 
     purchase_payby      VARCHAR2(10),/* 구매_지불 방법 */ 
     purchase_purchaseby VARCHAR2(10),/* 구매 수단 */ 
     purchase_isarrived  VARCHAR2(100),/* 구매_도착정보 */ 
     purchase_remakrs    VARCHAR2(400)/* 구매_비고 */ 
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

/* 구매항목 */ 
CREATE TABLE pitem 
  ( 
     pitem_id            NUMBER(20) NOT NULL,/* 구매항목_번호 */ 
     purchase_id         NUMBER(20) NOT NULL,/* 구매_번호 */ 
     client_id           NUMBER(20) NOT NULL,/* 고객_번호 */ 
     item_id             NUMBER(20) NOT NULL,/* 제품_번호 */ 
     pitem_unitp         NUMBER(20, 2),/* 구매항목_단가 */ 
     pitem_quantity      NUMBER(10),/* 구매항목_수량 */ 
     pitem_shipquantity  NUMBER(10),/* 구매항목_선적수량 */ 
     pitem_ispurchaseall VARCHAR2(20)/* 구매항목_방법 */ 
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

/* 대금정보 */ 
CREATE TABLE payment 
  ( 
     payment_id      NUMBER(20) NOT NULL,/* 대금_번호 */ 
     purchase_id     NUMBER(20) NOT NULL,/* 구매_번호 */ 
     client_id       NUMBER(20) NOT NULL,/* 고객_번호 */ 
     payment_state   VARCHAR2(10),/* 대금_상태 */ 
     payment_balance NUMBER(20, 2)/* 대금_잔액 */ 
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

/* 운송 */ 
CREATE TABLE trans 
  ( 
     trans_id      NUMBER(20) NOT NULL,/* 운송_번호 */ 
     purchase_id   NUMBER(20) NOT NULL,/* 구매_번호 */ 
     client_id     NUMBER(20) NOT NULL,/* 고객_번호 */ 
     trans_state   VARCHAR2(20),/* 운송_상태 */ 
     trans_remarks VARCHAR2(400) /* 운송_비고 */ 
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

/* 제품 */ 
CREATE TABLE item 
  ( 
     item_id        NUMBER(20) NOT NULL,/* 제품_번호 */ 
     item_name      VARCHAR2(30) NOT NULL,/* 제품_이름 */ 
     item_summary   VARCHAR2(100),/* 제품_요약설명 */ 
     item_details   VARCHAR2(200),/* 제품_상세설명 */ 
     item_picture   VARCHAR2(50),/* 제품_사진 */ 
     item_price     NUMBER(20),/* 제품_공장가격 */ 
     item_salesunit VARCHAR2(10),/* 제품_판매단위 */ 
     item_remarks   VARCHAR2(100)/* 제품_비고 */ 
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

/* 창고 */ 
CREATE TABLE store 
  ( 
     store_id       NUMBER(20) NOT NULL,/* 창고_번호 */ 
     region_id      NUMBER(20) NOT NULL,/* 지역_번호 */ 
     personincharge NUMBER(20) NOT NULL,/* 창고_담당사원 */ 
     store_name     VARCHAR2(30) NOT NULL,/* 창고_이름 */ 
     store_phone    VARCHAR2(20),/* 창고_전화번호 */ 
     store_address  VARCHAR2(50),/* 창고_주소 */ 
     store_city     VARCHAR2(20),/* 창고_도시명 */ 
     store_state    VARCHAR2(20),/* 창고_주명 */ 
     store_nation   VARCHAR2(20),/* 창고_국가명 */ 
     store_zipcode  VARCHAR2(30),/* 창고_우편번호 */ 
     store_remarks  VARCHAR2(100)/* 창고_비고 */ 
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

/* 재고 */ 
CREATE TABLE stock 
  ( 
     stock_id               NUMBER(20) NOT NULL,/* 재고_번호 */ 
     item_id                NUMBER(20) NOT NULL,/* 제품_번호 */ 
     store_id               NUMBER(20) NOT NULL,/* 창고_번호 */ 
     stock_max              NUMBER(10) NOT NULL,/* 재고_최대재고량 */ 
     stock_reasonforexhaust VARCHAR2(30),/* 재고_재고소진이유 */ 
     stock_dateofreceipt    DATE,/* 재고_제품수령일 */ 
     stock_dateofreorder    DATE,/* 재고_재주문시점 */ 
     stock_quantity         NUMBER(10),/* 재고_재고량 */ 
     stock_remarks          VARCHAR2(100),/* 재고_비고 */ 
     region_id              NUMBER(20),/* 지역_번호 */ 
     personincharge         NUMBER(20)/* 창고_담당사원 */ 
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

/* 지역 */ 
CREATE TABLE region 
  ( 
     region_id   NUMBER(20) NOT NULL,/* 지역_번호 */ 
     region_name VARCHAR2(30) NOT NULL /* 지역_이름 */ 
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

/* 전체사원 */ 
CREATE TABLE emp 
  ( 
     emp_id         NUMBER(20) NOT NULL,/* 사원_사원번호 */ 
     dept_id        NUMBER(20),/* 부서_부서번호 */ 
     emp_managerid  NUMBER(20),/* 사원_상사 */ 
     emp_lastname   VARCHAR2(20) NOT NULL,/* 사원_성 */ 
     emp_firstname  VARCHAR2(20) NOT NULL,/* 사원_이름 */ 
     emp_hiredate   DATE,/* 사원_입사일 */ 
     emp_rank       VARCHAR2(20),/* 사원_직급 */ 
     emp_salary     NUMBER(10) NOT NULL,/* 사원_월급 */ 
     emp_userid     VARCHAR2(20),/* 사원_아이디 */ 
     emp_passwd     VARCHAR2(20),/* 사원_비밀번호 */ 
     emp_commission NUMBER(5, 5),/* 사원_커미션 */ 
     emp_remarks    VARCHAR2(50)/* 사원_비고 */ 
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

/* 부서 */ 
CREATE TABLE dept 
  ( 
     dept_id       NUMBER(20) NOT NULL,/* 부서_부서번호 */ 
     emp_id        NUMBER(20) NOT NULL,/* 사원_부서장 */ 
     dept_name     VARCHAR2(20) NOT NULL,/* 부서_부서이름 */ 
     dept_location VARCHAR2(20) NOT NULL,/* 부서_부서위치 */ 
     dept_remarks  VARCHAR2(50)/* 부서_비고 */ 
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

/* 평가 */ 
CREATE TABLE eval 
  ( 
     eval_id         NUMBER(20) NOT NULL,/* 평가_평가번호 */ 
     emp_subjectid   NUMBER(20) NOT NULL,/* 사원_대상자 */ 
     emp_writerid    NUMBER(20) NOT NULL,/* 사원_작성자 */ 
     eval_evaluation VARCHAR2(50) NOT NULL /* 평가_내용 */ 
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