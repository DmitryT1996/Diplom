<!doctype HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%! String pageName = "index"; %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="reset.css">
    <link rel="stylesheet" type="text/css" href="welcomestyle.css">
    <link rel="stylesheet" type="text/css" href="aboutpstyle2.css">
    <title>
        projectM | добро пожаловать
    </title>
    <script src="jquery-3.1.1.min.js"></script>
</head>
<body>
<div id="container">
    <span id="logo">
        <a href="/home/max/projectM/new/welcome.html"><img src="icons/logo3.png"></a>
    </span>

    <%@ include file = "navigation.jspf"%>

    <div id="titleWrap">
        <div id="title">
            <h1>Откройте новый взгляд на звездное небо</h1>
        </div>
        <div id="button">
            <button>УЗНАТЬ БОЛЬШЕ</button>
        </div>
    </div>

    <div id="other">
        <div id="social">
            <p>Язык</p>
            <p>Пожертвовать</p>
        </div>
        <ul>
            <li><img src="icons/twitter.png"></li>
            <li><img src="icons/facebook.png"></li>
            <li><img src="icons/vk3.png"></li>
        </ul>
    </div>

    <div id="myModal" class="modal">
        <div class=modal-content>
            <div class="modal-body">
                <div class="circle">
                    <span class="close">&times</span>
                </div>
                <div class="about-us">
                    <div class="header1">
                        <h1>О projectm</h1>
                    </div>
                    <div class="about_info">
                        <p>
                            <span id="hello">ПРИВЕТ!</span><br>
                            Мы - маленькая, независимая команда, цель которой создать удобный инструмент<br>
                            для наблюдения и фотографирования небесных объектов. <br>
                            <br>
                            C 2015 года, мы развивали нашу идею до апогея, набирались опыта на других
                            наших незначительно важных проектах и решили взяться за кое-что иное,<br>
                            кое-что, чем вдохновляются большинство людей. <br>
                            Звёздное небо.
                        </p>
                    </div>
                </div>

                <div class="about_dev">
                    <div class="header2">
                        <h1>НАША КОМАНДА</h1>
                    </div>
                    <ul class="contacts">
                        <li class="first">
                            <img src="aut/2A.png">
								<span id="aut1-head">
									<h1>Дмитрий Терещенко</h1>
								</span>
                        </li>
                        <li class="second">
                            <img src="aut/1A-2.png">
								<span id="aut2-head">
									<h1>Максим Грек</h1>
								</span>
                        </li>
                    </ul>
                </div>

                <div class="about_contact">
                    <div class="header3">
                        <h1>МЫ ХОТИМ БЫТЬ ЛУЧШЕ</h1>
                    </div>
                    <div class="about_info2">
                        <p>
                            Несомненно, вы можете связаться с нами, оставить свои пожелания и<br>
                            предложения, либо наоборот, ткнуть нас носом в наши ошибки. В любом случае<br>
                            кажое замечание будет учтено, чтобы мы смогли улучшить наш сервис еще лучше.
                            <br>
                            <br>
                            Но для этого, нам нужно будет связаться с вами в ответ, чтобы уточнить нюансы.<br>
                            Поэтому проверяйте свою почту, как можно чаще. Мы будем отвечать по мере возможностей.
                        </p>
                    </div>
                    <div id="button2">
                        <a href="/home/max/projectM/new/contacts.html"><button>СВЯЗАТЬСЯ С НАМИ</button></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    (function() {
        "use strict";
        var toggles = document.querySelectorAll(".close_menu");

        for (var i = toggles.length - 1; i >= 0; i--) {
            var toggle = toggles[i];
            toggleHandler(toggle);
        };

        function toggleHandler(toggle) {
            toggle.addEventListener( "click", function(e) {
                e.preventDefault();
                (this.classList.contains("is-active") === true) ? this.classList.remove("is-active") : this.classList.add("is-active");
            });
        }
    })();
</script>

<script>
    $(document).ready(function() {
        //modal
        $('#button').click(function() {
            $('#myModal').animate({
                top: 0
            }, 'easeInOut');

            $('.circle').animate({
                top: '1em',
                left: '1em'
            }, 'easeInOut');
        });
        $('.circle').click(function() {
            $('#myModal').animate({
                top: "100%"
            }, 'easeInOut');

            $('.circle').animate({
                top: "100%"
            }, 'easeInOut');
        });
    });
</script>

<script>
    //menu
    var clicked = true;
    $(".close_menu").on("click", function() {
        if(clicked) {
            clicked = false;
            $("#menu").animate({
                "left": 0
            });
        }
        else {
            clicked = true;
            $("#menu").animate({
                "left": "-13em"
            });
        }
    });
</script>
</body>
</html>