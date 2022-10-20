<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글목록</title>
</head>
<body>
	<h2>자유게시판 글 목록</h2>
	<hr>
	<table width="600" border="1" cellpadding="0" cellspacing="0">
		<tr bgcolor="#CEFBC9">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		
		<c:forEach items="${list}" var="dto"><!--jstl 반복분시작 items로  request 객체에 있는 리스트를 불러온다.-->
		<tr>
			<td>${dto.bid}</td>
			<td>${dto.btitle}</td>
			<td>${dto.bname}</td>
			<td>${dto.bdate}</td>
			<td>${dto.bhit}</td>
		</tr>
		</c:forEach>
	
	</table>
</body>
</html>