<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>KH 온라인 문방구</hh><br>
	<hr>
	
    <form action="/orderProduct.do" method="POST">
        <table border="1" width = "300px">
        <tr>
            <th colspan="3" >주문자명</th>
    
        </tr>
        <tr>
            <td colspan="3"><input type="text" name = "name" style="width: 99%;"></td>
            
        </tr>
        <tr>
            <th>품목</th>
            <th>가격</th>
            <th>수량</th>
        </tr>
        <tr>
            <td>검정펜</td>
            <td>500원</td>
            <td><input type="number" name = "blackPen" value="0" min = "0" max = "100" style="width: 99%;"></td>
        </tr>
        <tr>
            <td>빨간펜</td>
            <td>700원</td>
            <td><input type="number"  name = "redPen" value="0" min = "0" max = "100" style="width: 99%;"></td>
        </tr>
        <tr>
            <td >파란펜</td>
            <td>700원</td>
            <td><input type="number" name = "bluePen" value="0" min = "0" max = "100" style="width: 99%;"></td>
        </tr>
        <tr>
            <td>화이트</td>
            <td>1000원</td>
            <td><input type="number"  name = "white" value="0" min = "0" max = "100" style="width: 99%;"></td>
        </tr> 
        <tr>
            <th colspan="3">
            <button type = "Submit">구매</button>
            <button>초기화</button>
            </th>
        
        </tr> 
        
        </table>
    </form>



</body>
</html>