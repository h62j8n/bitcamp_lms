<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 한페이지에 게시글이 5개씩있는 페이지의 페이징 -->
<c:url value="/lms/curriculum_list.html" var="root"/>
<c:if test="${param.prev }">
<a href="${root }?page=1">맨앞으로</a>
<a href="${root }?page=${param.begin-1}">prev</a>
</c:if>
<c:forEach begin="${param.begin }" end="${param.end }" step="1" var="index">
	<c:choose>
		<c:when test="${param.page==index }">
			${index }
		</c:when>
		<c:otherwise>
			<a href="${root }?page=${index}">${index }</a>
		</c:otherwise>
	</c:choose>
</c:forEach>
<c:if test="${param.next }">
<a href="${root }?page=${param.end+1}">next</a>
<a href="${root }?page=${param.total}">맨뒤로</a>
</c:if>
</body>
</html>