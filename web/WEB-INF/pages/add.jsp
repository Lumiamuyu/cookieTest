<%--
  Created by IntelliJ IDEA.
  User: Lumia
  Date: 2018/12/13
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<form action="doAdd" method="post" enctype="multipart/form-data">
    商品名称：<input type="text" name="name"></br>
    商品价格：<input type="text" name="price"></br>
    商品图片：<input name="url" type="file" onchange="imgChange(this)"><img id="img" width="100" height="100"></br>

    商品描述：<input type="text" name="des"></br>
    <input type="submit" value="确认添加">
</form>
<script type="text/javascript">
    function imgChange(obj){
        var les = (obj.files[0].name).substr((obj.files[0].name).indexOf(".")+1);
        if (les=="jpg"||les=="png"||les=="jpeg"||les=="gif"){
            var reader = new FileReader();
            reader.onload=function (e) {
                var img = document.getElementById("img");
                img.src=e.target.result;
            }
            reader.readAsDataURL(obj.files[0]);
        }else {
            img.src="";
        }
        /*document.getElementById('file').onchange = function() {
            var imgFile = this.files[0];
            var fr = new FileReader();
            fr.onload = function() {
                document.getElementById('img')[0].src = fr.result;
            };
            fr.readAsDataURL(imgFile);
        };*/
    }
</script>
</body>
</html>
