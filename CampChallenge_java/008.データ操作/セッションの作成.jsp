<%-- 
    Document   : セッションの作成
    Created on : 2017/04/27, 13:14:27
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.Cookie;"%>
<%@page import="java.util.*;"%>

<%
HttpSession hs = request.getSession(false);

if(hs != null){
  hs = request.getSession(true);   
  long  i = hs.getLastAccessedTime();
  Date accessdate = new Date(i);
  out.print("前回アクセスしたのは、"+ accessdate+"です");
}

%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
    </body>
</html>
