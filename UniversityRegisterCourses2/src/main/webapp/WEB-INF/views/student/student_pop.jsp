<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 테이블 팝업</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

</script>
<style type="text/css">
.required{
	color: red;
}
table{
	width: 550px;
}
table th{
	width: 200px;
	text-align: left;
}
</style>
</head>
<body>
	<div>
		<form id="studentForm" name="studentForm" method="post">
			<table border="1">
				<thead>
					<tr>
						<td colspan="2" align="center"><h4>학생 테이블 팝업창</h4></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th><span class="required">*</span>일련번호</th>
						<td><input type="text" id="no" name="no" value="${StudentVO.no}"></td>
					</tr>
					<tr>
						<th><span class="required">*</span>학과번호</th>
						<td>
							<c:choose>
								<c:when test="${StudentVO.s_num == null}">
									<select id="s_num" name="s_num">
										<option>학과를 선택하세요.</option>
										<c:forEach items="${subjectNum}" var="row">
										<option value="${row.s_num}">${row.s_num}:${row.s_name}</option>
										</c:forEach>
									</select>
								</c:when>
								<c:when test="${StudentVO.s_num != null}">
									<input type="text" id="s_num" name="s_num" value="${StudentVO.s_num}"/>
								</c:when>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th><span class="required">*</span>학생번호</th>
						<td><input type="text" id="sd_num" name="sd_num" value="${StudentVO.sd_num}"></td>
					</tr>
					<tr>
						<th><span class="required">*</span>학생이름</th>
						<td><input type="text" id="sd_name" name="sd_name" value="${StudentVO.sd_name}"></td>
					</tr>
					<tr>
						<th><span class="required">*</span>아이디</th>
						<td><input type="text" id="sd_id" name="sd_id" value="${StudentVO.sd_id}"></td>
						<td><input type="button" value="중복체크" id="idCheck">
					</tr>
					<tr>
						<th><span class="required">*</span>비밀번호</th>
						<td><input type="password" id="sd_passwd" name="sd_passwd" value="${StudentVO.sd_passwd}"></td>
					</tr>
					<tr>
						<th><span class="required">*</span>생년월일</th>
						<td><input type="date" id="sd_birthday" name="sd_birthday" value="${StudentVO.sd_birthday}"></td>
					</tr>
					<tr>
						<th><span class="required">*</span>핸드폰번호(- 제외)</th>
						<td><input type="tel" id="sd_phone" name="sd_phone" maxlength="11" value="${StudentVO.sd_phone}"></td>
					</tr>
					<tr>
						<th><span class="required">*</span>주소</th>
						<td><input type="text" id="sd_address" name="sd_address" value="${StudentVO.sd_address}"></td>
					</tr>
					<tr>
						<th><span class="required">*</span>이메일</th>
						<td><input type="email" id="sd_email" name="sd_email" value="${StudentVO.sd_email}"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div>
		<p></p>
		<table border="0">
			<tr align="center">
				<td><input type="button" id="insertData" value="등록"></td>
				<td><input type="button" id="updateData" value="수정"></td>
				<td><input type="button" id="deleteData" value="삭제"></td>
				<td><input type="button" id="closeWindow" value="닫기"></td>
			</tr>
		</table>
	</div>
</body>
</html>