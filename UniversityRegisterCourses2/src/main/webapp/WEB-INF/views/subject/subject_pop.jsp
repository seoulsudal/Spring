<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 등록 창</title>
<%-- jquery 사용시 선언 --%>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	<%-- ready는 대기하는것 --%>
	$(document).ready(function() {
		<%-- 버튼 눌리고 안눌리고 --%>
		var mode = "${mode}";
		if(mode == "insert"){
			$('#insertData').attr('disabled', false);
			$('#updateData').attr('disabled', true);
			$('#deleteData').attr('disabled', true);
		} else if(mode == "update"){
			$('#insertData').attr('disabled', true);
			$('#updateData').attr('disabled', false);
			$('#deleteData').attr('disabled', false);
		}
		<%-- action 주소를 여러개 줘야 해서 function을 이용해서 사용 --%>
		$("#insertData").click(function() {
			<%-- form에서 값을 안넣고 submit하는 방법 --%>
			if($("#no").val() == ""){
				<%-- 미리 0을 넣어놓는것 --%>
				$("#no").val(0);	
			}
			<%-- 데이터를 보내는 action, 데이터를 보내는 주소 --%>
			$("#subjectForm").attr("action", "/subject/insertSubject.do");
			$("#subjectForm").submit();
		});
		
		$("#updateData").click(function() {
			<%-- 데이터를 보내는 action, 데이터를 보내는 주소 --%>
			$("#subjectForm").attr("action", "/subject/updateSubject.do");
			$("#subjectForm").submit();
		});
		
		$("#deleteData").click(function() {
			<%-- 데이터를 보내는 action, 데이터를 보내는 주소 --%>
			$("#subjectForm").attr("action", "/subject/deleteSubject.do");
			$("#subjectForm").submit();
		});
		
		$("#closeWindow").click(function() {
			window.close();
		});
		
	});
</script>
</head>
<body>
<form id="subjectForm" name="subjectForm" method="post">
	<table>
		<caption>학과 테이블</caption>
		<tr>
			<td>일련 번호</td>
			<!-- id, name은 slq 컬럼명과 되도록 동일하게 작성 -->
			<td><input type="text" id="no" name="no" value="${svo.no}"/></td>
		</tr>
		<tr>
			<td>학과 번호</td>
			<td><input type="text" id="s_num" name="s_num" value="${svo.s_num}"/></td>
		</tr>
		<tr>
			<td>학과 이름</td>
			<td><input type="text" id="s_name" name="s_name" value="${svo.s_name}"/></td>
		</tr>
	</table>
</form>	
	<table>
		<tr>
			<!-- 학과등록 시 누를 수 있게 -->
			<td><input type="button" value="등록" id="insertData"/></td>
			<!-- 상세정보 시 누를 수 있게 -->
			<td><input type="button" value="수정" id="updateData"/></td>
			<!-- 상세정보 시 누를 수 있게 -->
			<td><input type="button" value="삭제" id="deleteData"/></td>
			<!-- 상시 누를 수 있게 -->
			<td><input type="button" value="닫기" id="closeWindow"/></td>
		</tr>
	</table>
</body>
</html>