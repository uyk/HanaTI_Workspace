--팀 DB 연습할 계정 생성
create user my_dva identified by dva;

-- 시스템 연결 권한 부여
GRANT CREATE SESSION TO my_dva; 
-- my_dva에게 hr의 employee 테이블에 대한 권한 부여
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees
TO my_dva;

-- 권한 해제
REVOKE SELECT, INSERT, UPDATE, DELETE ON HR.EMPLOYEES
FROM my_dva;

-- role 부여 