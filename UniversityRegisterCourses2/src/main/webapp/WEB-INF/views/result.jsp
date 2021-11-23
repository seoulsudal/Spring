<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 화면</title>
<script type="text/javascript">
	alert("${result}")
		<%-- 문제가 있을 경우 뒤로가기(history.go) --%>
	if("${result}".indexOf("실패") > -1){
		history.go(-1);
	} else {
		<%-- 열려 있는 팝업창에서 값을 가지고 가는것, 창을 닫고 기존 창을 새로고침 --%>
		opener.location.reload();
		window.close();
	}
</script>
</head>
<body>

</body>
</html>