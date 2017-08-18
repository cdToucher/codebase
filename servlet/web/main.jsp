<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/28
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>test</title>
</head>
<body>
<h1>使用 POST 方法读取数据</h1>
<ul>
    <li><p><b>测试:</b>
        <%=request.getParameter("name")%>
    </p></li>
    <li><p><b>提交:</b>
        <%= request.getParameter("url")%>
    </p></li>
</ul>
</body>
</html>