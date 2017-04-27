<%-- 
    Document   : coockie
    Created on : 2017/04/27, 12:57:15
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.Cookie;"%>
<%@page import="java.util.*;"%>

<%
  //1回目
  Date time = new Date();
  Cookie c = new Cookie("LastLogin",time.toString());
  response.addCookie(c);
  
  //2回目の訪問時
  Cookie cs[] = request.getCookies();
  if(cs != null){
      for (int i = 0; i < cs.length; i++){
         if(cs[i].getName().equals("LastLogin")){
           out.print("前回のアクセス日時は、"+cs[i].getValue()+"です。");
           break;
         }
      }
   }
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
