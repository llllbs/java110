<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
<h1>EL - Map 객체에서 값 꺼내기</h1>
<%
HashMap<String,Object> map = new HashMap<>();
map.put("s01","김구");
map.put("s02","안중근");
map.put("s03","윤봉길");

pageContext.setAttribute("map", map);
%>
${map["s01"]}<br>
${map["s02"]}<br>
${map["s03"]}<br>

${map.s01 }<br>
${map.s02 }<br>
${map.s03 }<br>

<%-- 아래가 더 직관적인 방법 --%>


</body>
</html>