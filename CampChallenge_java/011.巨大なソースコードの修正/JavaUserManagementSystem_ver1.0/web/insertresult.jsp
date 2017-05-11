<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper"%>
<%@page import="jums.UserDataBeans"%>

<%
    HttpSession hs = request.getSession();
    UserDataBeans userbeans = (UserDataBeans)hs.getAttribute("UDB");
    

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        名前:<%= userbeans.getName()%><br>
        生年月日:<%= userbeans.getYear()+"年"+userbeans.getMonth()+"月"+userbeans.getDay()+"日"%><br>
        種別:<%= userbeans.getType()%><br>
        電話番号:<%= userbeans.getTell()%><br>
        自己紹介:<%= userbeans.getComment()%><br>
        以上の内容で登録しました。<br>
        <!--タスク1　JumsHelperクラスを利用してトップページへのリンクを表示 -->
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
