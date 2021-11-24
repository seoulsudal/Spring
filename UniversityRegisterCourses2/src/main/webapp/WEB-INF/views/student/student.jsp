<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 테이블</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	function passwordCheck(row_no) {
		
	}
	function insertPopup() {
		$("#no").val(0);
		window.open("", "pop", "width=900, height = 700");
		$("#popupForm").attr("action", "/student/selectStudent.do");
		$("#popupForm").attr("target", "pop");
		$("#popupForm").submit();
	}
	function updatePopup() {
		var passwd = "#passwd" + no;
		var btnPw = "#btnPw" + no;
		var update = "#update" + no;
		
		$(update).attr("disabled", true);
		$(passwd).attr("disabled", false);
		$(btnPw).attr("disabled", false);
		
		$("#no").val(no);
		window.open("", "pop", "width=900, height = 700");
		$("#popupForm").attr("action", "/student/selectStudent.do");
		$("#popupForm").attr("target", "pop");
		$("#popupForm").submit();
	}
	function listSearch() {
		$("#searchForm").attr("action", "/student/listStudent.do");
		$("#searchForm").submit();
	}
</script>
<style type="text/css">
table {
	width:700px;
}
td{
	text-align: center;
}
#searchForm table th{
	width: 114px;
}
#searchForm table td{
	width: 104px;
	text-align: center;
}
#sd_name{
	widows: 310px;
}
</style>
</head>
<body>
	<div>
		<a href="../">메인</a>
	</div>
	<form id="popupForm" name="popupForm" method="post">
		<input type="hidden" id="no" name="no"/>
	</form>
	<div>
		<table border="1">
			<caption><h3>학생[Student]</h3></caption>
			<colgroup>
				<col width="120px"/>
				<col width="110px"/>
				<col width="110px"/>
				<col width="360px"/>
			</colgroup>
			<thead>
				<tr>
					<th>일련 번호</th>
					<th>학생 번호</th>
					<th>학생 이름</th>
					<th>상세 보기</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty studentList}">
					<tr>
						<td colspan="5">등록된 학생 정보가 존재하지 않습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${studentList}" var="row">
					<tr>
						<td>${row.no}</td>
						<td>${row.sd_num}</td>
						<td>${row.sd_name}</td>
						<td>
							<input type="button" id="update${row.no}" value="[ 수정/삭제 ]" disabled="disabled" onclick="updatePopup('${row.no}')"/>
							<input type="password" id="passwd${row.no}" placeholder="비밀번호를 입력하세요."/>
							<input type="button" id="btnPw${row.no}" value="확인" onclick="passwordCheck('${row.no}')"/>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3">학생 정보 수정/삭제는 비밀번호 확인 후 가능</td>
					<td><input type="button" onclick="insertPopup()" value="[ 학생 정보 등록 ]"/></td>
				</tr>
			</tbody>
		</table>
	</div>
	<p></p>
	<div>
		<form id="searchForm" name="searchForm" method="post">
			<table border="1" cellpadding="1" cellspacing="1">
				<tr>
					<th>학생 이름</th>
					<td><input type="text" id="sd_name" name="sd_name"/></td>
					<td><input type="button" onclick="listSearch()" value="검색"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>