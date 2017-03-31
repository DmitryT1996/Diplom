<%@ page import="java.util.ArrayList" %>
<%@ page import="com.projectm.blog.BlogBean" %>
<%@ page import="java.sql.Array" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="reset.css">
    <link rel="stylesheet" type="text/css" href="blog.css">
    <title>Gallery</title>
    <script src="jquery-3.1.1.min.js"></script>
</head>
<body>
<div id="container">
    <span id="logo">
        <a href="/home/max/projectM/new/welcome.html"><img src="/home/max/projectM/newIcon/logo_invert.png"></a>
    </span>

    <div id="content-wrap">
        <%
            ArrayList<BlogBean> arr = (ArrayList<BlogBean>) request.getAttribute("arr");
            for(BlogBean list : arr) {
        %>
        <span class="post-date"><%=list.getDate()%></span>
        <div class="info">
            <h1><%=list.getHeader()%></h1>
            <p><%=list.getText()%></p>
        </div>
        <%
            }
        %>
    </div>
</div>
</body>
</html>
