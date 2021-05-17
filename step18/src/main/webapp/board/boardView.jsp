<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
<style type="text/css">
table {
	border: 2px solid;
	border-collapse: collapse;
}
th, td {border: 2px solid;}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="3">${dto.subject }</td>
		</tr>
		<tr align="center">
			<td width="120">글번호 : ${dto.seq }</td>
			<td width="120">작성자 : ${dto.name }</td>
			<td width="120">조회수 : ${dto.hit }</td>
		</tr>		
		<tr>
			<td colspan="3" height="300" valign="top">
				<pre>${dto.content }</pre>
			</td>
		</tr>		 
	</table>
	
	<input type="button" value="목록" onclick="location.href='boardList.do?pg=${pg }'">
	<input type="button" value="글수정">
	<input type="button" value="글삭제" onclick="location.href='boardDelete.do?seq=${seq }&pg=${pg }'">
</body>
</html>