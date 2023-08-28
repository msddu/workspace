--- *** DML(Data Manipulation Language) : 데이터 조작 언어

-- 테이블에 값을 삽입하거나(INSERT), 수정하거나(UPDATE), 삭제(DELETE)하는 구문

-- 주의 : 혼자서 COMMIT, ROLLBACK 하지 말것!

-- 테스트용 테이블 생성
CREATE TABLE EMPLOYEE2 AS SELECT * FROM EMPLOYEE;
CREATE TABLE DEPARTMENT2 AS SELECT * FROM DEPARTMENT;

SELECT * FROM EMPLOYEE2;
SELECT * FROM DEPARTMENT2;

--------------------------------------------------------------------------------------------------------------------

-- 1. INSERT

-- 테이블에 새로운 행을 추가하는 구문


-- 1)  INSERT INTO 테이블명 VALUES(데이터, 데이터, ...)
-- 테이블에 모든 컬럼에 대한 값을 INSERT할 때 사용
-- INSERT하고자 하는 컬럼이 모든 컬럼인 경우 컬럼명 생략 가능. 단, 컬럼의 순서를 지켜서 VALUES에 값을 기입해야 함

-- 900, '장채현', '901123-2345678', 'jang_ch@kh.or.kr', '01012341234','D1', 'J7', 'S3', 4300000, 0.2, 200, SYSDATE, NULL, 'N'
        
INSERT INTO EMPLOYEE2 
--VALUES (테이블 컬럼 순서대로 값 작성)

VALUES(900, '장채현', '901123-2345678', 'jang_ch@kh.or.kr', '01012341234','D1', 'J7', 'S3', 4300000, 0.2, 200, SYSDATE, NULL, 'N');


SELECT * FROM EMPLOYEE2 
ORDER BY EMP_ID DESC;

ROLLBACK;

SELECT * FROM DEPARTMENT2;
INSERT INTO DEPARTMENT2 VALUES ('D0', '개발부', 'L1');

ROLLBACK;
---------------------------------------

-- 2)  INSERT INTO 테이블명(컬럼명, 컬럼명, 컬럼명,...)
-- VALUES (데이터1, 데이터2, 데이터3, ...);
-- 테이블에 내가 선택한 컬럼에 대한 값만 INSERT할 때 사용
-- 선택안된 컬럼은 값이 NULL이 들어감

-- EMP_NAME, EMP_ID, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SAL_LEVEL, SALARY
-- '장채현', 900, '901123-2345678', 'jang_ch@kh.or.kr', '01012341234', 'D1', 'J7', 'S3', 4300000

INSERT INTO EMPLOYEE2 (EMP_NAME, EMP_ID, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SAL_LEVEL, SALARY) 
VALUES('장채현', 900, '901123-2345678', 'jang_ch@kh.or.kr', '01012341234', 'D1', 'J7', 'S3', 4300000);

SELECT * FROM EMPLOYEE2
WHERE EMP_ID = 900;

ROLLBACK;
ROLLBACK;

SELECT * FROM EMPLOYEE2;

DELETE FROM EMPLOYEE2 
WHERE EMP_ID  = 900;

COMMIT;

SELECT* FROM EMPLOYEE2;




INSERT INTO DEPARTMENT2(DEPT_ID, LOCATION_ID) VALUES ('D0', 'L1');

SELECT * FROM DEPARTMENT2;

ROLLBACK;





---------------------------------------

-- (참고) INSERT시 VALUES 대신 서브쿼리 사용 가능
CREATE TABLE EMP_01(
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(30),
    DEPT_TITLE VARCHAR2(20)
);


SELECT * FROM EMP_01;

INSERT INTO EMP_01
--VALUES--서브쿼리 INSERT시 VALUES 생략
(SELECT EMP_ID, EMP_NAME, DEPT_TITLE
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT2 ON (DEPT_CODE = DEPT_ID));

SELECT * FROM EMP_01;--23행을 삽입

COMMIT;


--------------------------------------------------------------------------------------------------------------------

-- 2. UPDATE

-- 테이블에 기록된 컬럼의 값을 수정하는 구문

-- [작성법]
-- UPDATE 테이블명 SET 컬럼명 = 바꿀값 [WHERE 컬럼명 비교연산자 비교값];

-- DEPARTMENT2 테이블에서 DEPT_ID가 'D9'인 부서 정보 조회

SELECT *
FROM DEPARTMENT2
WHERE DEPT_ID  = 'D9';


-- DEPARTMENT2 테이블에서 DEPT_ID가 'D9'인 행의 DEPT_TITLE을 '전략기획팀' 으로 수정

UPDATE DEPARTMENT2 SET DEPT_TITLE  = '전략기획팀'; 
-->모든 행 수정

SELECT * FROM DEPARTMENT2;
ROLLBACK;


UPDATE DEPARTMENT2 
SET DEPT_TITLE  = '전략기획팀' 
WHERE DEPT_ID = 'D9';


SELECT * FROM DEPARTMENT2;
ROLLBACK; --DML실행취소

-- UPDATE 확인




-- EMPLOYEE2 테이블에서 BONUS를 받지 않는 사원의 
-- BONUS를 0.1로 변경
UPDATE EMPLOYEE2 
SET BONUS  = '0.1'
WHERE BONUS IS NULL;

SELECT * FROM EMPLOYEE2;

ROLLBACK;

SELECT * FROM EMPLOYEE2;





---------------------------------------

-- * 조건절을 설정하지 않고 UPDATE 구문 실행 시 모든 행의 컬럼 값 변경.

SELECT * FROM DEPARTMENT2;

UPDATE DEPARTMENT2 
SET DEPT_TITLE  = '인사팀'
WHERE DEPT_ID  = 'D1';

SELECT * FROM DEPARTMENT2;

ROLLBACK;


---------------------------------------



-- * 여러 컬럼을 한번에 수정할 시 콤마(,)로 컬럼을 구분하면됨.
-- D9 / 전략기획팀  -> D0 / 전략기획2팀으로 수정
UPDATE DEPARTMENT2 
SET DEPT_ID  = 'D0' , DEPT_TITLE  = '전략기획2팀'
WHERE DEPT_ID  = 'D9';


SELECT * FROM DEPARTMENT2;

ROLLBACK;

---------------------------------------

-- * UPDATE시에도 서브쿼리를 사용 가능

-- [작성법]
-- UPDATE 테이블명
-- SET 컬럼명 = (서브쿼리)

-- EMPLOYEE2 테이블에서
-- 평상시 유재식 사원을 부러워하던 방명수 사원의
-- 급여와 보너스율을 유재식 사원과 동일하게 변경해 주기로 했다.
-- 이를 반영하는 UPDATE문을 작성하시오.

SELECT	EMP_NAME, SALARY 
FROM EMPLOYEE2
WHERE EMP_NAME IN ('유재식', '방명수');


UPDATE EMPLOYEE2 
SET SALARY = (SELECT SALARY 
				FROM EMPLOYEE2
				WHERE EMP_NAME  = '유재식'),
	BONUS = (SELECT BONUS
			FROM EMPLOYEE2 
			WHERE EMP_NAME = '유재식')
WHERE EMP_NAME = '방명수';

SELECT * FROM EMPLOYEE2  WHERE EMP_NAME IN ('방명수' , '유재식');

ROLLBACK;


 
---------------------------------------


-- *다중열 서브쿼리를 이용한 UPDATE문

-- EMPLOYEE2 테이블에서
-- 방명수 사원의 급여 인상 소식을 전해들은 다른 멤버들이
-- 단체로 파업을 진행했다.
-- 노옹철, 전형돈, 정중하, 하동운 사원의 급여와 보너스를
-- 유재식 사원의 급여와 보너스와 같게 변경하는 UPDATE문을 작성하시오.

SELECT EMP_NAME, SALARY , BONUS
FROM EMPLOYEE2
WHERE EMP_NAME IN('유재식', '노옹철', '전형돈', '정중하', '하동윤');

UPDATE EMPLOYEE2 
SET (SALARY,BONUS) 
	= (SELECT SALARY, BONUS FROM EMPLOYEE2 WHERE EMP_NAME ='유재식')
WHERE EMP_NAME IN('노옹철', '전형돈', '정중하', '하동윤');

ROLLBACK;


-- EMP_SALARY테이블에서 아시아지역에 근무하는 직원의 보너스를 0.3으로 변경
-- EMPLOYEE2 , DEPARTMENT2, LOCATION 테이블


-- 1) 아시아 지역에 근무하는 직원

SELECT EMP_ID 
FROM EMPLOYEE2 
JOIN DEPARTMENT2 ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
WHERE LOCAL_NAME LIKE 'ASIA%';
 


-- 2) 아시아 지역 근무 직원 보너스 0.3으로 변경

UPDATE EMPLOYEE2 
SET BONUS = '0.3'
WHERE EMP_ID IN (SELECT EMP_ID 
				FROM EMPLOYEE2 
				JOIN DEPARTMENT2 ON (DEPT_CODE = DEPT_ID)
				JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
				WHERE LOCAL_NAME LIKE 'ASIA%');
			

SELECT EMP_ID , EMP_NAME, BONUS
FROM EMPLOYEE2 
JOIN DEPARTMENT2 ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
WHERE LOCAL_NAME LIKE 'ASIA%';		

ROLLBACK;



--------------------------------------------------------------------------------------------------------------------

-- 3. MERGE(병합) (참고만 하세요!)

-- 구조가 같은 두 개의 테이블을 하나로 합치는 기능.
-- 테이블에서 지정하는 조건의 값이 존재하면 UPDATE
-- 조건의 값이 없으면 INSERT됨

CREATE TABLE EMP_M01
AS SELECT * FROM EMPLOYEE;

CREATE TABLE EMP_M02
AS SELECT * FROM EMPLOYEE
   WHERE JOB_CODE = 'J4';
   
INSERT INTO EMP_M02
VALUES (999, '곽두원', '561016-1234567', 'kwack_dw@kh.or.kr',
        '01011112222', 'D9', 'J4', 'S1', 9000000, 0.5, NULL,
        SYSDATE, NULL, DEFAULT);
       
SELECT * FROM EMP_M01; 
SELECT * FROM EMP_M02; --EMP_01과 겹치는 행 4행, 겹치지 않는 행 1행

UPDATE EMP_M02 SET SALARY = 0; --EMP_02 SALARY를 모두 0으로 수정

SELECT * FROM EMP_M02;

MERGE INTO EMP_M01 USING EMP_M02 ON(EMP_M01.EMP_ID = EMP_M02.EMP_ID)
WHEN MATCHED THEN --같은 사번이 존재하면
UPDATE SET        --UPDATE 실행
EMP_M01.EMP_NAME = EMP_M02.EMP_NAME,
EMP_M01.EMP_NO = EMP_M02.EMP_NO,
EMP_M01.EMAIL = EMP_M02.EMAIL,
EMP_M01.PHONE = EMP_M02.PHONE,
EMP_M01.DEPT_CODE = EMP_M02.DEPT_CODE,
EMP_M01.JOB_CODE = EMP_M02.JOB_CODE,
EMP_M01.SAL_LEVEL = EMP_M02.SAL_LEVEL,
EMP_M01.SALARY = EMP_M02.SALARY,
EMP_M01.BONUS = EMP_M02.BONUS,
EMP_M01.MANAGER_ID = EMP_M02.MANAGER_ID,
EMP_M01.HIRE_DATE = EMP_M02.HIRE_DATE,
EMP_M01.ENT_DATE = EMP_M02.ENT_DATE,
EMP_M01.ENT_YN = EMP_M02.ENT_YN
WHEN NOT MATCHED THEN --같은 사번이 존재하지 않으면 INSERT 실행 (곽두원)
INSERT VALUES (EMP_M02.EMP_ID, EMP_M02.EMP_NAME, EMP_M02.EMP_NO,
               EMP_M02.EMAIL, EMP_M02.PHONE, EMP_M02.DEPT_CODE,
               EMP_M02.JOB_CODE, EMP_M02.SAL_LEVEL, EMP_M02.SALARY,
               EMP_M02.BONUS, EMP_M02.MANAGER_ID, EMP_M02.HIRE_DATE,
               EMP_M02.ENT_DATE, EMP_M02.ENT_YN);

SELECT * FROM EMP_M01; 


--------------------------------------------------------------------------------------------------------------------

-- 4. DELETE
-- 테이블의 행을 삭제하는 구문

-- [작성법]
-- DELTE FROM 테이블명 WHERE 조건설정
-- 만약 WHERE 조건을 설정하지 않으면 모든 행이 다 삭제됨


COMMIT;

-- EMPLOYEE2 테이블에서 '장채현'사원 정보 조회
SELECT * FROM EMPLOYEE2 WHERE EMP_NAME  = '장채현';

-- EMPLOYEE2 테이블에서 이름이 '장채현'인 사원 정보 삭제
DELETE FROM EMPLOYEE2 WHERE EMP_NAME  = '장채현';
-- 삭제 확인
SELECT * FROM EMPLOYEE2; 

ROLLBACK;
-- EMPLOYEE2 테이블 전체 삭제
DELETE FROM EMPLOYEE2;

ROLLBACK;
---------------------------------------------------------------------------------------------

-- 5. TRUNCATE (DDL 입니다! DML 아닙니다!)
-- 테이블의 전체 행을 삭제하는 DDL
-- DELETE보다 수행속도가 더 빠르다.
-- ROLLBACK을 통해 복구할 수 없다.

-- TRUNCATE 테스트용 테이블 생성
CREATE TABLE EMPLOYEE3
AS SELECT * FROM EMPLOYEE2;

-- 생성 확인
SELECT * FROM EMPLOYEE3;

-- DELETE로 모든 데이터 삭제
DELETE FROM EMPLOYEE3;

-- 삭제 확인
SELECT * FROM EMPLOYEE3;

ROLLBACK;

-- 롤백 후 복구 확인
SELECT * FROM EMPLOYEE3;

-- TRUNCATE로 삭제
TRUNCATE TABLE EMPLOYEE3;

-- 삭제 확인
SELECT * FROM EMPLOYEE3;

ROLLBACK;
-- 롤백 후 복구 확인 -> 복구 안됨을 확인!
SELECT * FROM EMPLOYEE3; 






