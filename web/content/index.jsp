<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
        http://www.w3.org/TR/html4/strict.dtd>
<html xmlns:margin-bottom="http://www.w3.org/1999/xhtml" xmlns:bottom="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8">
    <title>IAD - lab</title>
    <style type="text/css">
        .header, .footer {
            background: lightcyan;
            border-top: 1px solid;
            border-bottom: 1px solid;
        }
        h2 {
            color: grey;
            font-size: 150%;
            font-family: "Garamond", monospace;
        }
        .layout {
            overflow: hidden;
        }
        .layout DIV{
            float: left;
        }
        .InputLogic DIV {
            float: none;
            display: inline-block;
        }
        .InputLogic {
            padding-left: 40px;
            width: auto;
        }

        #input DIV{
            display: block;
        }

        #ad-unit-l {
            width: auto;
            max-width: 20%;
        }
        #ad-unit-r {
            float: right;
            max-width: 40%;
        }

        .ad-img {
            height: auto;
            width: 80%;
        }
        A[href="https://www.youtube.com/watch?v=dQw4w9WgXcQ"]:hover {
            font-size: 115%;
            color: red;
        }
        #left-footer {
            float: left;
            width: 50%;
        }

        .Stallman {
            width: auto;
            height: 78px;
            float: left;
        }
        #no-adblock-img{
            width: auto;
            height: 78px;
            float: left;
        }

        #right-footer {
            display: inline-block;
            width: 50%;
        }
        #right-footer P {
            padding-left: 10px;
        }

        .footer {
            position: absolute;
            bottom: 0px;
            width: 99%;
        }

        .coordinate_plate {
            width: 400px;
            height: 400px;
            border: 1px solid black;
            margin-top: 20px;
            margin-left: 20px;
            vertical-align: top;
            background-image: url(pics/plate.png);
            horiz-align: right;
        }
    </style>
</head>

<body>

<a name="begin"></a>

<div class="header">
    <img src="./gifs/cats_01.gif" align=left hspace=0 class="head-cat">
    <img src="./gifs/cats_04.gif" align=right hspace=0 class="head-cat">
    <h2 align="center"> gr.P3211 var.355</h2>
    <h2 align="center"> Made by Roman Efremov & Danil Sinitskiy </h2>
</div>



<div class="layout" >
    <div id="ad-unit-l" class="ad-unit" style="display: none">
        <table width = 165px>
            <tr align = "center">
                <td>
                    <img src="gifs/rek/ad1.gif" class="ad-img">
                    <br>
                    <a class="ad-link" href="https://www.youtube.com/watch?v=dQw4w9WgXcQ">
                        Борода будет расти как на дрожжах, если пользоваться этим средством. Всего 66,6 рублей...</a>
                </td>
            </tr>
            <tr align = "center">
                <td>
                    <p class="ad-paragraph">
                        <img src="gifs/rek/ad2.gif" class="ad-img">
                        <br>
                        <a class="ad-link" href="https://www.youtube.com/watch?v=dQw4w9WgXcQ">
                            Мужчина был ШОКИРОВАН, увидев это...</a>
                </td>
            </tr>
        </table>
    </div>


    <div class="InputLogic">
        <div id="input">
            <form method="POST" action="controller">
                <div id="X">
                    <p>Input coordinate X:</p>
                    <p>
                        <select id="Xcor" name="Xcor" requied placeholder=0>
                            <option value="-3">-3</option>
                            <option value="-2">-2</option>
                            <option value="-1">-1</option>
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </p>
                </div>
                <div id = "Y">
					<p>Input coordinate Y:</p>
					<input type = "text" id = "Ycor" name = "Ycor"
						placeholder = "0" value="0" required/>
					<script src = "validator.js"></script>
				</div>
                <div id = "R">
                    <p>Input radius R:</p>
                    <p>
                        <select id="Rrad" name="Rrad" requied placeholder=1>
                            <option value="1">1</option>
                            <option value="1.5">1.5</option>
                            <option value="2">2</option>
                            <option value="2.5">2.5</option>
                            <option value="3">3</option>
                        </select>
                    </p>
                </div>
				<div id = "Submit">
					<p><input id="sub" name="sub" type="submit" value="Submit"></p>
				</div>
			</form>
		</div>

        <div class = "coordinate_plate">
            <canvas id = "plate"/>
        </div>
    </div>


    <div id="ad-unit-r" class="ad-unit" style="display: none">
        <table align = "center">
            <col width=165px>
            <tr align = "center" valign="top">
                <td>
                    <img src="gifs/rek/ad4.gif" class="ad-img">
                    <br>
                    <a class="ad-link" href="https://www.youtube.com/watch?v=dQw4w9WgXcQ">
                        Сервер будет стоять неделю!!!</a>
                </td>

                <td>
                    <img src="gifs/rek/ad5.gif" class="ad-img">
                    <br>
                    <a class="ad-link" href="https://www.youtube.com/watch?v=dQw4w9WgXcQ">
                        Преподаватели годами скрывали секрет успешной сдачи работ! Надо просто...</a>
                </td>
            </tr>
            <col width="165px">
            <tr align = "center">
                <td>
                    <img src="gifs/rek/ad6.gif" class="ad-img">
                    <br>
                    <a class="ad-link" href="https://www.youtube.com/watch?v=dQw4w9WgXcQ">
                        Каждый студент мечтает об этом!!! Пассивный доход 2 балла за лабу, надо только добавить это.</a>
                </td>
                <td>
                    <img src="gifs/rek/ad3.gif" class="ad-img">
                    <br>
                    <a class="ad-link" href="https://www.youtube.com/watch?v=dQw4w9WgXcQ">
                        Археологи ужаснулись, откопав это! Возраст находки поразил всех!!!</a>
                </td>
            </tr>
        </table>
    </div>
</div>

<div class="footer">
    <div id="left-footer">
    <img class="Stallman" src="./pics/Stoll.png">

    <p left=1 5px>It's a full free project

        <span style="-webkit-transform: scaleX(-1);
					  -moz-transform: scaleX(-1);
						-o-transform: scaleX(-1);
					-khtml-transform: scaleX(-1);
					   -ms-transform: scaleX(-1);
						   transform: scaleX(-1);
				   display: inline-block;
				">
					&copy;
				</span>
        <br>
    <a href="https://github.com/merfemor/iad-lab">https://github.com/merfemor/iad-lab</a>
        <br>
        You can help developers by
        <a href="https://docs.google.com/spreadsheets/d/12L0BR27avnnyiePcc0Af_1zE-U9VVqdj8YMRvxmbJAM/edit#gid=445358099">donating</a>
        in cells <b>Q9</b> and <b>Q	19</b> <br>
    </p>
    </div>
    <div id="right-footer" style="display: none">
        <img id="no-adblock-img" src="pics/noadblock.png"/>
        <p>
            Please turn off your Adblock, we <ins>earn scores</ins> on advertising. <br>
            If you have already donated, you can
            <a id="turn-off-ads" href="#begin"> <ins>turn off advertising <ins/> </a> .
            <script src="adblocking.js" type="text/javascript"> </script>
            <script type="text/javascript">
                window.onload = function () {
					is_donated(function(status) {
						console.log("onload status: " + status);
						if(status !== true) {
							show_ads();
						}
					});
                };
            </script>
        </p>

    </div>
</div>

</body>

</html>
