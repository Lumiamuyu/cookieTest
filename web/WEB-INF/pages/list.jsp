<%@ page import="java.util.List" %>
<%@ page import="Lumiamuyu.pojo.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Lumia
  Date: 2018/12/12
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            background-color: #777777;
            border: solid 1px #ffffff;
            border-collapse: collapse;
            color: white;
        }
        table thead tr th,table tbody tr td{
            border: solid 1px #ffffff;
            padding: 5px 10px;
        }
        table tbody tr:nth-child(odd){
            background-color: #555555;
            color: white;
        }
    </style>
</head>
<body>



    <h2>欢迎${user.username}</h2>
    <a href="exit">退出</a>
    <table>
        <thead>
            <tr>
                <th>商品编号</th>
                <th>商品名称</th>
                <th>商品价格</th>
                <th>商品图片</th>
                <th>商品描述</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>

        <c:forEach items="${lists}" var="pro">
            <tr>
                <td>${pro.productId}</td>
                <td>${pro.productName}</td>
                <td>${pro.price}</td>
                <td><img src="${pro.url}" alt="pic"></td>
                <td>${pro.productDes}</td>
                <td><a href="delete?productId=${pro.productId}"><input type="button" value="删除"></a>&nbsp;<a href="update?productId=${pro.productId}"><input type="button" value="修改"></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add"><input type="button" value="添加"></a>

<%--<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        alert(woqu);
    });

</script>--%>
</body>
</html>
