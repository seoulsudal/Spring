<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- c를 쓰기 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과</title>
<%-- jquery 사용시 선언 --%>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<%-- insertPopup을 위한 자바스크립트 --%>
<script type="text/javascript">
	function insertPopup() {
		$("#no").val(0);
		<%-- 팝업 명령어 window.open --%>
		window.open("", "pop", "width=700, height=400");
		$("#popupForm").attr("action", "/subject/selectSubject.do");
		<%-- window.open의 2번째와 같은 이름으로 작성 --%>
		$("#popupForm").attr("target", "pop");
		$("#popupForm").submit();
	}
	function updatePopup(no) {
		$("#no").val(no);
		<%-- 팝업 명령어 window.open --%>
		window.open("", "pop", "width=700, height=400");
		$("#popupForm").attr("action", "/subject/selectSubject.do");
		<%-- window.open의 2번째와 같은 이름으로 작성 --%>
		$("#popupForm").attr("target", "pop");
		$("#popupForm").submit();
	}
	function listSearch() {
		$("#popupForm").attr("action", "/subject/listSubject.do");
		$("#popupForm").submit();
	}
</script>
</head>
<body>
	<form id="popupForm" name="popupForm" method="post">
		<input type="hidden" name="no" id="no"> 
	</form>
	<table>
		<caption >학과</caption>
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
			<td><input type="button" value="상세정보" onclick="updatePopup('${row.no}')"></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="3">학과정보등록</td>
			<td><input type="button" value="학과등록" onclick="insertPopup()"></td>
		</tr>
	</table>
</body>
</html>