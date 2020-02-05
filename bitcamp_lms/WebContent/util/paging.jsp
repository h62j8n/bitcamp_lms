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
<c:url value="/home/educurriculum.html" var="root"/>
<c:if test="${param.prev }">
<li><a href="${root }?page=1" class="pg_start"><span class="hidden">맨 앞으로</span></a>
<li><a href="${root }?page=${param.begin-1}" class="pg_prev"><span class="hidden">이전 페이지</span></a></li>
</c:if>
<c:forEach begin="${param.begin }" end="${param.end }" step="1" var="index">
	<c:choose>
		<c:when test="${param.page==index }">
			<li><b>${index }</b></li>
		</c:when>
		<c:otherwise>
			<li><a href="${root }?page=${index}">${index }</a></li>
		</c:otherwise>
	</c:choose>
</c:forEach>
<c:if test="${param.next }">
<li><a href="${root }?page=${param.end+1}" class="pg_next"><span class="hidden">다음 페이지</span></a></li>
<li><a href="${root }?page=${param.total}" class="pg_end"><span class="hidden">맨 뒤로</span></a></li>
</c:if>
</body>
</html>