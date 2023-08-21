--한줄 주석  ctrl + /
/*범위 주석 ctrl + shift + / */ 

--sql 한줄 실행 : ctrl + enter

--오라클 쌍따옴표 의미 : 대문자 / 소문자를 구분하겠다

ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER a230724_kms_su IDENTIFIED BY "kms0909";

GRANT CONNECT, RESOURCE, CREATE VIEW TO a230724_kms_su;

ALTER USER a230724_kms_su DEFAULT TABLESPACE "A230724"
QUOTA 20M ON "A230724";
