<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
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
        <title>JUMS登録画面</title>
    </head>
    <body>
    
    <form action="insertconfirm" method="POST">
    <!--タスク5 再入力の際にフォームに前回入力した値を保持する-->
        名前:
        <%if(userbeans != null){%>
        <input type="text" name="name" value="<%=userbeans.getName() %>">
        <%}else{%>
        <input type="text" name="name" value="">
        <%}%>
        <br><br>
        生年月日:
        <select name="year">
            <%if(userbeans != null){%>
            <option value=""></option>
            <%
            for(int i=1950; i<=2010; i++){ 
            if(userbeans.getYear() != "" &&  i == Integer.parseInt(userbeans.getYear())){%>
            <option value="<%=i%>" selected><%=i%> </option>
            <%}else{%>
            <option value="<%=i%>" > <%=i%> </option>
            <% }}}else{%>
            <option value=""></option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"> <%=i%> </option>
            <% }}%>
        </select>年
        <select name="month">
            <%if(userbeans != null){%>
            <option value=""></option>
            <%
            for(int i=1; i<=12; i++){ 
            if(userbeans.getMonth() != "" && i == Integer.parseInt(userbeans.getMonth())){%>
            <option value="<%=i%>" selected><%=i%> </option>
            <%}else{%>
            <option value="<%=i%>" > <%=i%> </option>
            <% }}}else{%>
            <option value=""></option>
            <%
            for(int i=1; i<=12; i++){ %>
            <option value="<%=i%>"> <%=i%> </option>
            <% }}%>
        </select>月
        <select name="day">
            <%if(userbeans != null){%>
            <option value=""></option>
            <%
            for(int i=1; i<=31; i++){ 
            if(userbeans.getDay() != "" && i == Integer.parseInt(userbeans.getDay())){%>
            <option value="<%=i%>" selected><%=i%> </option>
            <%}else{%>
            <option value="<%=i%>" > <%=i%> </option>
            <% }}}else{%>
            <option value=""></option>
            <%
            for(int i=1; i<=31; i++){ %>
            <option value="<%=i%>"> <%=i%> </option>
            <% }}%>
        </select>日
        <br><br>

        種別:
        <br>
        <%if(userbeans != null && userbeans.getType()!= null ){
        switch(Integer.parseInt(userbeans.getType())){
            case 1:%>
                 <input type="radio" name="type" value="1" checked >エンジニア<br>
                 <input type="radio" name="type" value="2">営業<br>
                 <input type="radio" name="type" value="3">その他<br>
          <%  break;
            case 2:%>
                 <input type="radio" name="type" value="1">エンジニア<br>
                 <input type="radio" name="type" value="2" checked>営業<br>
                 <input type="radio" name="type" value="3">その他<br>
          <%  break;
            case 3:%>
                 <input type="radio" name="type" value="1">エンジニア<br>
                 <input type="radio" name="type" value="2">営業<br>
                 <input type="radio" name="type" value="3" checked>その他<br>
          <%  break;}%>
        
        
        <%}else{%>
        <input type="radio" name="type" value="1" >エンジニア<br>
        <input type="radio" name="type" value="2">営業<br>
        <input type="radio" name="type" value="3">その他<br>
        <br>
        <%}%>
        
        
        
        電話番号:
        <%if(userbeans != null){%>
        <input type="text" name="tell" value="<%=userbeans.getTell()%>">
        <%}else{%>
        <input type="text" name="tell" value="">
        <%}%>
        <br><br>

        自己紹介文
        <br>
        <%if(userbeans != null){%>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=userbeans.getComment()%>
        </textarea><br><br>
        <%}else{%>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"></textarea><br><br>
        <%}%>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <!--タスク1　JumsHelperクラスを利用してトップページへのリンクを表示 -->
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
