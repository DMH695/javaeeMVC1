<%--
  Created by IntelliJ IDEA.
  User: 23139
  Date: 2021/10/19
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
编号：<input type="text" value="" id="pno"/><br>
姓名：<input type="text" value="" id="name"/><br>
性别：男：<input type="radio" name="sex" value="男">女：<input type="radio" name="sex" value="女"><br>
年龄：<select id="age">
  <option value="15">15</option>
  <option value="16">16</option>
  <option value="17">17</option>
  <option value="18">18</option>
  <option value="19">19</option>
  <option value="20">20</option>
  <option value="21">21</option>
  <option value="22">22</option>
  <option value="23">23</option>
  <option value="24">24</option>
  <option value="25">25</option>
</select><br>
身高：<input type="text" value="" id="height"/><br>
体重：<input type="text" value="" id="weight"/><br>
<input type="button" value="插入" id="btn_1" onclick="submit()"/>
<br>
<br>
<br>

编号：<input type="text" value="" id="pno_query"/>
<input type="button" value="查询" id="btn_2" onclick="query()"/>
<table id="queryResult">
  <tr>
    <td>编号</td>
    <td>姓名</td>
    <td>性别</td>
    <td>年龄</td>
    <td>身高</td>
    <td>体重</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
</table>


<br>
<br>
<br>
编号：<input type="text" value="" id="pno_del"/>
<input type="button" value="删除" id="btn_3" onclick="del()"/>

<br>
<br>
<br>
编号：<input type="text" value="" id="pno_up"/><br>
姓名：<input type="text" value="" id="name_up"/><br>
性别：男：<input type="radio" name="sex_up" value="男">女：<input type="radio" name="sex_up" value="女"><br>
年龄：<select id="age_up">
  <option value="15">15</option>
  <option value="16">16</option>
  <option value="17">17</option>
  <option value="18">18</option>
  <option value="19">19</option>
  <option value="20">20</option>
  <option value="21">21</option>
  <option value="22">22</option>
  <option value="23">23</option>
  <option value="24">24</option>
  <option value="25">25</option>
</select><br>
身高：<input type="text" value="" id="height_up"/><br>
体重：<input type="text" value="" id="weight_up"/><br>
<input type="button" value="更新" id="btn_4" onclick="update()"/>

</body>

<script type="text/javascript">
  /*
      var x = $("#queryResult").html();

      for(var i=0; i < 20 ; i++) {
          x += '<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
      }
      $("#queryResult").html(x);*/
  function submit() {
    var pno = $("#pno").val();
    var name = $("#name").val();
    var sex = $('input[name="sex"]:checked').val();
    var age = $("#age").val();
    var height = $("#height").val();
    var weight = $("#weight").val();

    var data={

      "pno":pno,
      "name":name,
      "sex":sex,
      "age":age,
      "height":height,
      "weight" : weight
    }


    $.ajax({
      type : "post",
      url : "Hello",
      data : data,
      cache : true,
      async : true,
      success: function (data ,textStatus, jqXHR){
        if(data.code == 200){
          alert("插入成功了");
        }else{
          alert(data.message);
        }
      },
      error:function (XMLHttpRequest, textStatus, errorThrown) {

        alert(typeof(errorThrown));
      }

    });
  }


  function query() {

    var pno = $("#pno_query").val();
    var str = ["编号","姓名","性别","年龄","身高","体重"];
    $.ajax({
      type : "post",
      url : "HelloQuery",
      data : {
        "pno": pno
      },
      cache : true,
      async : true,
      success: function (data ,textStatus, jqXHR){
        //data = $.parseJSON(data);
        var j = 0;
        var x = 1;
        //for(var i=1; i <20; i++) {
        for(var p in data){//遍历json对象的每个key/value对,p为key
          console.log(data[p]);
          if(j == 6) {
            j = 0;
            x++;
          }
          $("#queryResult tr:eq("+x+") td:eq("+j+")").html(data[p]);
          console.log(data[p]);
          j++;
        }
        //}




      },
      error:function (XMLHttpRequest, textStatus, errorThrown) {

        alert(typeof(errorThrown));
      }

    });
  }

  function del() {
    var pno = $("#pno_del").val();

    $.ajax({
      type : "post",
      url : "HelloDelete",
      data : {
        "pno": pno
      },
      cache : true,
      async : true,
      success: function (data ,textStatus, jqXHR){
        if(data.code == 200){
          alert("删除成功了");
        }else{
          alert(data.message);
        }
      },
      error:function (XMLHttpRequest, textStatus, errorThrown) {

        alert(typeof(errorThrown));
      }

    });
  }

  function update() {
    var pno = $("#pno_up").val();
    var name = $("#name_up").val();
    var sex = $('input[name="sex_up"]:checked').val();
    var age = $("#age_up").val();
    var height = $("#height_up").val();
    var weight = $("#weight_up").val();

    var data={

      "pno":pno,
      "name":name,
      "sex":sex,
      "age":age,
      "height":height,
      "weight" : weight
    }


    $.ajax({
      type : "post",
      url : "HelloUpdate",
      data : data,
      cache : true,
      async : true,
      success: function (data ,textStatus, jqXHR){
        if(data.code == 200){
          alert("更新成功了");
        }else{
          alert(data.message);
        }
      },
      error:function (XMLHttpRequest, textStatus, errorThrown) {

        alert(typeof(errorThrown));
      }

    });
  }



</script>

</html>
