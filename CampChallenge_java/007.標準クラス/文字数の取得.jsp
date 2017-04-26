<%-- 
    Document   : 文字数の取得
    Created on : 2017/04/26, 11:50:16
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
 
String myad = "jojowasaman00@gmail.com";

out.print(myad.substring(myad.indexOf("@")));
%>