<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글삭제</title>
<script type="text/javascript">
	if(${result } > 0) {
		alert("삭제했습니다.");
		location.href="boardList.do?pg=${pg }";
	} else {
		alert("삭제 실패");
		location.href="history.back()";
	}
</script>
</head>
<body>

</body>
</html>