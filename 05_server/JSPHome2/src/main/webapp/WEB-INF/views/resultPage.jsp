<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 페이지</title>
</head>
<body>

    <h1>${param.name}님의 구매 목록</h1>
    
	
	<h3>검정 펜 ${param.blackPen} 개 : ${param.blackPen * 500}원 </h3>
	<h3>빨간 펜 ${param.redPen} 개 : ${param.redPen * 700}원</h3>
	<h3>파란 펜 ${param.bluePen} 개 : ${param.bluePen * 700}원</h3>
	<h3>화이트 ${param.whitePen} 개 : ${param.whitePen * 1000}원</h3>
	<hr>
	<h3>총합 ${total}원을 결제하셨습니다.</h3>


</body>
</html> 