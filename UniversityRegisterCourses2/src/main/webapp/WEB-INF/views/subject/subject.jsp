<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- c를 쓰기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과</title>
</head>
<body>
	<table>
		<caption>학과</caption>
		<tr>
			<th>일련번호</th>
			<th>학과번호</th>
			<th>학과명</th>
			<th>상세정보</th>
		</tr>
		<!-- subjectList로 받은 값을 row로 출력 -->
		<c:forEach items="${subjectList}" var="row" >
		<tr>
			<td>${row.no}</td>
			<td>${row.s_num}</td>
			<td>${row.s_name}</td>
			<td><input type="button" value="상세정보"></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="3">학과정보등록</td>
			<td><input type="button" value="학과등록"></td>
		</tr>
		
		<tr>
		
		</tr>
	</table>
</body>
</html>