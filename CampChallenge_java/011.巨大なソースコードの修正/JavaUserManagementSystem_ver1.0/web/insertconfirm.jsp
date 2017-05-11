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
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        

        <%  //タスク3.UserDataBeansのクラスを利用する
        if(!userbeans.getName().equals("") 
        && !userbeans.getYear().equals("") 
        && !userbeans.getMonth().equals("") 
        && !userbeans.getDay().equals("") 
        && !userbeans.getType().equals("") 
        && !userbeans.getTell().equals("") 
        && !userbeans.getComment().equals("")){ %>
        
        <h1>登録確認</h1>
        
        名前:<%=userbeans.getName()%><br>
        生年月日:<%= userbeans.getYear()+"年"+ userbeans.getMonth()+"月"+userbeans.getDay()+"日"%><br>
        種別:<%= userbeans.getType()%><br>
        電話番号:<%= userbeans.getTell()%><br>
        自己紹介:<%= userbeans.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
        <% }
        //タスク4 未入力時の判定と表示の処理を記述
        if(userbeans.getName().equals("")){%>
        名前の入力が不完全です<br>
        <% }if(userbeans.getYear().equals("")||userbeans.getMonth().equals("")
            || userbeans.getDay().equals("")){%>
        生年月日が入力が不完全です<br>
        
        <%}
        //ラジオボタンの空の値はNullなので==で判定
        if(userbeans.getType() == null){ %>
        職業種別の入力が不完全です<br>
        <%}if(userbeans.getTell().equals("")){ %>
        電話番号の入力が不完全です<br>
        <%}if(userbeans.getComment().equals("")){%>
        自己紹介の入力が不完全です<br>
        <% }%>
        
        
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <!--タスク1　JumsHelperクラスを利用してトップページへのリンクを表示 -->
         <%=JumsHelper.getInstance().home()%>
    </body>
</html>
