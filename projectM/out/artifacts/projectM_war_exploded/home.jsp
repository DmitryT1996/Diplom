<%@ page import="com.projectm.db.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="reset.css">
    <link rel="stylesheet" type="text/css" href="home.css">
    <title>UserName</title>
    <script src="jquery-3.1.1.min.js"></script>
</head>
<body>
<div id="container">
    <div id="header">
			<span id="logo">
				<a href="welcome.html"><img src="icons/logo3.png"></a>
			</span>

        <ul id="main">
            <button id="enter-menu">
            </button>
            <li id="exit">Выйти</li>
        </ul>
    </div>

    <div id="userMenuWrap">
        <div id="userPhoto"></div>
        <%User user = (User) session.getAttribute("User");%>
        <h3><%=user.getName() %></h3>
        <button id="enter-obs">обсерватория</button>
    </div>

    <div id="galleryWrap">
        <div id="info">
            <h1>ГАЛЕРЕЯ</h1>
            <h2>Ваша галерея пока что пуста, вы можете добавить фотографии
                нажав на кнопку "добавить".
            </h2>
        </div>
        <button id="addPhoto">Добавить</button>
    </div>
</div>

<script>
    $("#addPhoto").on('click', function () {
       var file_data = $('')
    });
</script>
<script>
    window.addEventListener("keydown", function(e) {
        // space and arrow keys
        if([32, 37, 38, 39, 40].indexOf(e.keyCode) > -1) {
            e.preventDefault();
        }
    }, false);
</script>

</body>
</html>