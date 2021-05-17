<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.paging{color: blue; text-decoration: none;}
.currentPaging { color: red; text-decoration: underline;}
#subjectA:link {color:black; text-decoration: none;}
#subjectA:visited {color:black; text-decoration: none;}
#subjectA:hover {color:green; text-decoration: underline;}
#subjectA:active {color:black; text-decoration: none;}
</style>
<script type="text/javascript">
	function isLogin(seq) {
		if(${memId == null}) {
			alert("먼저 로그인 하세요");
		} else {
			location.href = "boardView.do?seq=" + seq + "&pg=" + ${pg};
		}
	}
</script>
</head>
<body>
      <table border="1" width="500">
         <tr align="center" bgcolor="#ffff00">
            <td width="70">글번호</td>
            <td>제목</td>
            <td width="70">작성자</td>
            <td width="100">작성일</td>
            <td width="70">조회수</td>
         </tr>
         
         <c:forEach var="dto" items="${list}">
			<tr bgcolor="ffffcc" align="center">
				<td>${dto.seq }</td>				
				<td><a id="subjectA" href="#" onclick="isLogin(${dto.seq})">
               		${dto.subject }</a> </td>     	
				<td>${dto.name }</td>
				<td>${dto.logtime }</td>
				<td>${dto.hit }</td>
			</tr>
		 </c:forEach>        
         
         <tr>
			<td colspan="5" align="center">
				<c:if test="${startPage > 3 }">			
					[<a class="paging" href="boardList.do?pg=${startPage - 1 }">이전</a>]
				</c:if>		
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<c:if test="${pg == i }">
					[<a class="currentPaging" href="boardList.do?pg=${i }">${i }</a>]
				</c:if>
		
				<c:if test="${pg != i }">
					[<a class="paging" href="boardList.do?pg=${i }">${i }</a>]
				</c:if>
			</c:forEach>				
	
				<c:if test="${endPage < totalP }">						
					[<a class="paging" href="boardList.do?pg=${endPage + 1 }">다음</a>]
				</c:if>
			</td>
		</tr>               
      </table>
          
      <c:if test="${memId == null }">
      	<a href="../member/loginForm.jsp">로그인</a>
      </c:if>        
      <c:if test="${memId != null }">
      	<a href="boardWriteForm.do">새글쓰기</a>
      </c:if>
</body>
</html>


