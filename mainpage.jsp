<%--
  Created by IntelliJ IDEA.
  User: Dragon
  Date: 22/04/12
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主界面</title>
    <style>
        #head_ {
            height: 100px;
            width: 100%;
            background-color: slategray;
        }

        #personFile {
            width: 120px;
            height: 50px;
            padding-top: 25px;
            margin-left: 90%;
        }

        #search {
            height: 70px;
            width: 100%;
            background-color: cornflowerblue;
        }

        #inner_s {
            /*width: 200px;
            height: 40px;
            padding-right: 70%;
            padding-top: 50%;*/
            width: 30%;
            padding-top: 25px;
            padding-left: 45%;
        }

        #table {
            margin-left: 30%;
            margin-top: 30px;
        }

        td {
            text-align: center;
            height: 20px;
            width: 150px;
            border: black 1px solid;
            padding: 1px;

        }
    </style>
    <script>
        function search() {
            let roomname = document.getElementById("searchinput").value;
            window.location.href="MainServlet?roomname="+roomname+"&username=${user.getUsername()}";
        }
        function updateinfo(roomname){
            window.location.href="UpdateServlet?roomname="+roomname+"&username=${user.getUsername()}";
        }
        function deleteinfo(roomname){
            let isdelete = confirm("是否删除"+roomname+"号房信息");
            if (isdelete){
                window.location.href="DeleteServlet?roomname="+roomname+"&username=${user.getUsername()}";
            }else{
                return ;
            }

        }
        function addinfo(){
            window.location.href="AddServlet?username=${user.getUsername()}";
        }
    </script>
</head>
<body>

<div id="head_">
    <div id="personFile">
        用户名:<span style="color: black">${user.getUsername()}</span><br>
        <span style="color: yellow">欢迎来到房屋管理系统！</span>
    </div>
</div>


<div id="search">
    <div id="inner_s">
        <input type="text" style="font-size: 20px; height: 26px;width: 190px" id="searchinput">&nbsp;&nbsp;
        <button style="font-size: 18px; height: 28px;" onclick="search()">查询</button>
    </div>
</div>

<div>
    <table id="table" style="height: 30px;width: 700px;border: black 1px solid;border-collapse:collapse;">
        <tr>
            <td>房间名</td>
            <td>租金</td>
            <td>使用的水量</td>
            <td>使用的电量</td>
            <td>是否上网</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list}" var="item">
            <tr>
                <td>${item.getRoomname()}</td>
                <td>${item.getRent_price()}</td>
                <td>${item.getUsed_water()}</td>
                <td>${item.getUsed_electronic()}</td>
                <td>${item.getNet_price()}</td>
                <td>
                    <button style="color: chocolate" onclick="updateinfo('${item.getRoomname()}')">修改</button>
                    <button style="color: chocolate" onclick="deleteinfo('${item.getRoomname()}')">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <button style="color: chocolate" onclick="addinfo()">增加</button>
</div>
</body>
</html>

