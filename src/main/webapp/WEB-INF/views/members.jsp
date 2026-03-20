
<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: kingh
  Date: 2026-03-15
  Time: 오후 6:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  List<Member> members=(List<Member>)request.getAttribute("members1");
  if (members == null) {
    out.write("회원 목록이 없습니다.");
    return; // 더 이상 아래 코드를 실행하지 않음
  }
%>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
  <thead>
  <th>id</th>
  <th>username</th>
  <th>age</th>
  </thead>
  <tbody>
  <%
  for (Member member : members) {
  out.write("    <tr>");
    out.write("        <td>" + member.getId() + "</td>");
    out.write("        <td>" + member.getUsername() + "</td>");
    out.write("        <td>" + member.getAge() + "</td>");
    out.write("    </tr>");
  }
  %>
  </tbody>
</table>
</body>
</html>