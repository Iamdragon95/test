<%--
  Created by IntelliJ IDEA.
  User: Dragon
  Date: 22/04/11
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<div id="frame_">
    <div id="inner_">
        账号:<input type="text" id="username"><br>
        密码:<input type="password" id="pwd"><br>
        <button id="submit">提交</button>
        <span id="error" style="color: #ff0000">${error}</span>
        <script>
            let btn001 = document.getElementById("submit");
            btn001.onclick = function () {
                let username = document.getElementById("username").value;
                if (username == "") {
                    document.getElementById("error").innerHTML = "账号不能为空!";
                    return;
                }
                let pwd = document.getElementById("pwd").value;
                if (pwd == "") {
                    document.getElementById("error").innerHTML = "密码不能为空!";
                    return;
                }

                document.getElementById("error").innerHTML = "";
                window.location.href = "LoginServlet?username=" + username + "&pwd=" + pwd;
            }

        </script>
    </div>
</div>


</body>
</html>
