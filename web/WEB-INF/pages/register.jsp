<%--
  Created by IntelliJ IDEA.
  User: Lumia
  Date: 2018/12/12
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@include file="/Path.jsp"%>>--%>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="doRegister" method="post">
    用户名：<input type="text" name="username" id="uname" class="ajaxCla"><span id="message"></span></br>
    密码：<input type="password" name="pwd" id="pwd" class="ajaxCla" placeholder="请输入8-16位字母或数字"><span id="pmes"></span></br>
    确认密码：<input type="password" name="pwds" id="pwds" placeholder="请输入8-16位字母或数字" class="ajaxCla"></br>
    电话：<input type="text" name="tele" id="tele" class="ajaxCla" placeholder="请输入手机号码"></br>
    <input type="button" value="确认注册" disabled="disabled" id="btn">
</form>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        /*使用Ajax*/
        var un;
        var pwd;
        var pwds;
        var tele;
        $(".ajaxCla").blur(function () {
            un = $("#uname").val();
            pwd = $("#pwd").val();
            pwds = $("#pwds").val();
            tele = $("#tele").val();
            $.ajax({
                url:"doRegister",
                type:"post",
                data:{"unames":un,"pwd":pwd,"pwds":pwds,"tele":tele},
                success:function (result) {
                    if (result=="4"){
                        $("#message").text("可以注册");
                    }
                    if (result=="43") {
                        $("#message").text("可以注册");
                        $("#pmes").text("√");
                        $("#btn").attr("disabled",false);
                    }
                    if (result=="1"){
                        $("#message").text("用户已存在");
                    }
                    if (result=="42"){
                        $("#message").text("可以注册");
                        $("#pmes").text("两次密码不一致");
                    }
                }
            })
        });

        $("#btn").click(function () {
            $.ajax({
                url:"doIt",
                type:"post",
                data:{"unames":un,"pwd":pwd,"pwds":pwds,"tele":tele},
                success:function (data) {
                    if (data>0){
                        window.location.href="http://localhost:8080/ajaxTest_war_exploded/login"
                    }
                }
            })
        });

    });
</script>
</body>
</html>
