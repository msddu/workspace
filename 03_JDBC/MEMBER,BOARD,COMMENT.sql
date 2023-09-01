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












