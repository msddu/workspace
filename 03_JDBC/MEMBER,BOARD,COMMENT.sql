--시퀀스 생성
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE;  --회원번호
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE; 	--게시글번호
CREATE SEQUENCE SEQ_COMMENT_NO NOCACHE; --댓글번호





--MEMBER테이블에 INSERT
INSERT INTO MEMBER 
VALUES(SEQ_MEMBER_NO.NEXTVAL,
'mem01@gmail.com', 
'mem123' , 
'멤버회원', 
'0101112222', 
'서울시 중구' , 
DEFAULT, 
DEFAULT);


COMMIT;



SELECT * FROM MEMBER;




--MEMBER테이블에 이메일, 비밀번호가 일치하는 회원의 
--닉네임, 전화번호, 주소 수정

UPDATE MEMBER 
SET MEMBER_NICKNAME = '변경된 닉네임',MEMBER_TEL  = '01011112222', MEMBER_ADDRESS = '경기도 수원'
WHERE MEMBER_EMAIL  =  'mem01@gmail.com'
AND MEMBER_PW = 'mem123';

ROLLBACK;

SELECT * FROM MEMBER;



DELETE FROM MEMBER
WHERE MEMBER_EMAIL  =  'mem01@gmail.com'
AND MEMBER_PW = 'mem123';




UPDATE MEMBER 
SET MEMBER_PW  = 'DD123'
WHERE MEMBER_EMAIL = 'alstn25000@naver.com' AND MEMBER_PW = 'SDFDSAF';






--	            // ------------------ 게시글 상세 조회(selectBoard) ------------------
--	            // 게시글 번호를 입력 받아 일치하는 게시글의
--	            // 제목, 내용, 작성일, 조회수, 작성자번호, 작성자 닉네임 조회
--	            // 단, 삭제되지 않은 게시글만 조회 가능(BOARD_DEL_FL = 'N')
--	            
--	            // view 메서드 1개 - service 메서드 1개 -  dao 메서드 2개
--	            // service에서 dao의 메서드를 연달아 호출
--	            // 1) 게시글 상세조회(selectBoard(게시글번호)) 를 먼저 수행
--	            // 2) 게시글 상세 조회 결과가 있을 경우 -> 조회수 증가(incrementReadCount(게시글 번호)) 수행


SELECT BOARD_TITLE, BOARD_CONTENT, 
   TO_CHAR(B_CREATE_DATE, 'YYYY-MM-DD HH24:MI:SS') B_CREATE_DATE,
   READ_COUNT, MEMBER_NO, MEMBER_NICKNAME
FROM BOARD
JOIN MEMBER USING(MEMBER_NO)
WHERE BOARD_DEL_FL = 'N'
AND BOARD_NO = 1;





UPDATE BOARD SET 
READ_COUNT = READ_COUNT+1
WHERE BOARD_NO  = 1	;

ROLLBACK;



SELECT * FROM BOARD;




SELECT COUNT(*) CHK FROM BOARD
WHERE BOARD_NO = 2
AND MEMBER_NO = 5;



UPDATE BOARD SET 
BOARD_DEL_FL  = 'Y';


SELECT * FROM BOARD;




SELECT BOARD_NO , BOARD_TITLE,  B_CREATE_DATE , READ_COUNT , MEMBER_NO , MEMBER_NICKNAME
FROM BOARD 
JOIN MEMBER USING (MEMBER_NO)
WHERE BOARD_DEL_FL = 'N'
ORDER BY BOARD_NO DESC;










