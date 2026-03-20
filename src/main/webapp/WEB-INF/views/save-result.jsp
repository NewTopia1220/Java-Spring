<%@ page import="hello.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: kingh
  Date: 2026-03-15
  Time: 오후 7:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
  <meta charset="UTF-8">
</head>
<body>
성공
<ul>
    <li>id=${mwd}</li>
  <li>username=<%=((Member)request.getAttribute("member")).getUsername()%></li>
  <li>age=<%=((Member)request.getAttribute("member")).getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>