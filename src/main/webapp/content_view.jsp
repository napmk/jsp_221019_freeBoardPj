<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글보기</title>
</head>
<body>
	<h2>자유게시판 글내용</h2>
	<hr>
	<table width="600" border="1" cellspacing="0" cellpadding="0">
		<tr>
			<th>제목</th>
			<td>${content.btitle }</td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td>${content.bname }</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${content.bdate }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${content.bhit }</td>
		</tr>
		<tr>
			<th valign="top">내용</th>
			<td height="200" valign="top">${content.bcontent }</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="글수정" onclick="javascript:window.location='content_modify.do?bid=${content.bid }'">
				<input type="button" value="글삭제" onclick="javascript:window.location='delete.do?bid=${content.bid }'">
				<input type="button" value="글목록" onclick="javascript:window.location='list.do'">
			</td>
		</tr>
		
	</table>
</body>
</html>