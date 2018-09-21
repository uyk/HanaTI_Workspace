-- 테이블 생성
create table new_table2(
  number_column number(5) Default 10,
  char_column varchar2(10)
);

-- 테이블에 컬럼 추가
ALTER TABLE NEW_TABLE2 ADD (
  char_column2 varchar2(20)
);

-- 제약사항 추가
ALTER TABLE NEW_TABLE2 
ADD CONSTRAINT nt2_uk_num UNIQUE(number_column);

ALTER TABLE new_table2
MODIFY (
  char_column not null
);

-- 제약사항 제거
Alter Table New_Table2
drop constraint nt2_uk_num;

-- 행 추가 
INSERT INTO NEW_TABLE2 (CHAR_COLUMN , CHAR_COLUMN2)
VALUES ('CHw', 'CHw');

-- 행 수정
UPDATE new_table2
SET CHAR_COLUMN = 'C'
WHERE ROWNUM = 1;

-- 디폴트 제약사항 변경
ALTER TABLE new_table2
modify (number_column default null);

-- 제약사항 출력
SELECT *
FROM SYS.USER_CONSTRAINTS
where TABLE_NAME = UPPER('new_table2');

-- NEW_TABLE2 출력
SELECT *
FROM NEW_TABLE2;

desc NEW_TABLE2;
COMMIT;

select *
from SYS.USER_TABLES
order by TABLE_NAME;