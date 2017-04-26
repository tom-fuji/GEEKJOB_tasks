<%-- 
    Document   : バイト数と文字数の取得
    Created on : 2017/04/26, 11:44:28
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
   String name = new String("藤野朋也" );
   out.println(name.length());
   out.println(name.getBytes().length);
   

%>
