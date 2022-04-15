<%--
  Created by IntelliJ IDEA.
  User: Dragon
  Date: 22/04/14
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>房屋信息增加界面</title>
    <style>
        #a {
            width: 70%;
            height: 600px;
            background-color: lemonchiffon;
            margin-left: 240px;
            margin-top: 50px;
            position: absolute;
        }

        #b {
            margin-left: 300px;
            margin-top: 100px;
        }

        input {
            margin-top: 15px;
            margin-left: 70px;
            font-size: 30px;
            color: red;
            font-family: 华文新魏;
        }

        button {
            background-color: azure;
            width: 100px;
            height: 25px;
            font-size: 20px;
            font-family: 华文新魏;
            margin-left: 110px;
        }
    </style>
    <script>
        function addconfirm() {

            let roomname = document.getElementById("roomname").value;
            let rent_price = document.getElementById("rent_price").value;
            let used_water = document.getElementById("used_water").value;
            let used_electronic = document.getElementById("used_electronic").value;
            let net_price = document.getElementById("net_price").value;
            window.location.href = "AddServlet?username=${user.getUsername()}&roomname=" + roomname + "&rent_price=" + rent_price + "&used_water=" + used_water + "&used_electronic=" + used_electronic + "&net_price=" + net_price;
        }

        function backtomainpage() {
            window.location.href = "MainServlet?username=${user.getUsername()}";
        }

    </script>
</head>

<body>
<div id="a">
    <div style="font-size: 40px;margin-top: 40px;margin-left: 70px">房屋信息增加界面</div>
    <div id="b">
        <span>管理员:${user.getUsername()}</span><br>
        房屋名称：<input type="text" id="roomname"><br>
        <br>
        房租:&nbsp;&nbsp;<input type="text" id="rent_price"><br>
        <br>
        水量:&nbsp;&nbsp;<input type="text" id="used_water"><br>
        <br>
        电量:&nbsp;&nbsp;<input type="text" id="used_electronic"><br>
        <br>
        网费:&nbsp;&nbsp;<input type="text" id="net_price"><br>
        <br>
        <button onclick="backtomainpage()">回主界面</button>
        <button onclick="addconfirm()">确认增加</button>
        <span>${error}</span>
    </div>
</div>


</body>
</html>
