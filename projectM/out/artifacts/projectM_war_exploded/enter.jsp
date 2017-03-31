<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="reset.css">
    <link rel="stylesheet" type="text/css" href="enterToBlog.css">
    <link rel="stylesheet" type="text/css" href="form.css">
    <title>Enter to admin acc</title>
    <script src="jquery-3.1.1.min.js"></script>
</head>
<body>
<div class="form">
    <span class="closeForm">&times</span>
    <form class="login-form" method="post" action="loginAdminBlogServlet">
        <input id="name" type="text" placeholder="username"/>
        <input id="password" type="password" placeholder="password"/>
        <button>login</button>
    </form>
</div>
</body>
</html>
