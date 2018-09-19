/* #1. DBA 계정(sys or system)으로 연결 후 User 생성 */
CREATE USER bangry identified BY bangry;

/* #2. 생성된 User에 시스템 권한 / 객체(테이블, 뷰…) 권한 부여 */
-- 시스템 연결 권한 부여
GRANT CREATE SESSION TO bangry;
-- 객체 권한 부여(sys가 bangry에게 hr 스키마의 employee 객체에 대한 CRUD 권한을 부여)
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees
TO bangry;

/* #3. 필요에 따라 User에게 부여된 권한 회수 */
REVOKE SELECT, INSERT, UPDATE, DELETE ON hr.employees
FROM bangry;


/* 롤(ROLE) : 여러 권한들의 묶음(내장 롤 / 사용자 정의 롤) */
/* #1. User에 내장 롤 부여 */
GRANT CONNECT, RESOURCE, dba TO bangry;

/* #2. 사용자 정의 롤 생성 */
CREATE ROLE my_role;
--DROP ROLE my_role;

/* #3. 시스템 권한과 객체 권한을 롤에 등록 */
GRANT CREATE SESSION TO my_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees TO  my_role;
