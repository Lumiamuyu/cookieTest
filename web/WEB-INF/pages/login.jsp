<%--
  Created by IntelliJ IDEA.
  User: Lumia
  Date: 2018/12/12
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="doLogin" method="get" id="fm">
    用户名：<input type="text" name="uname" >
    密码：<input type="password" name="pwd" >
    <input type="submit" value="登录" id="btn">
<%--    <c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>--%>

    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

    <script type="text/javascript">
        $(function() {
            $("#btn").click(function () {
                var fm = $("#fm").serialize();
                $.ajax({
                    url:"doLogin",
                    type:"post",
                    data:fm,
                    success:function (data) {
                       /* alert(data);*/
                        if (data=="1"){
                            window.location.href="http://localhost:8080/ajaxTest_war_exploded/list";
                        }
                        if (data=="3"){
                            alert("请检查密码");
                        }
                      /*  if (data=="2"){
                            alert("用户名不存在");
                        }*/

                    }
                })

            })
        });
    </script>
</form>
</body>
</html>
