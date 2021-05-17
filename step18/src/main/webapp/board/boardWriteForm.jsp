<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<script type="text/javascript" src="../script/boardScript.js?v=5"></script>
<style type="text/css">
table {
	border: 2px solid;
	border-collapse: collapse;
}
th, td {border: 2px solid;}
</style>
</head>
<body>
	<form action="boardWrite.do" name="writeForm" method="post">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" size="50"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="50" name="content"></textarea></td>
			</tr>
			<tr>				
				<td colspan="2" align="center">
					<input type="button" value="글쓰기" onclick="checkWrite()">
					<input type="reset" value="다시 작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>