<%-- 
    Document   : 文字の入れ替え
    Created on : 2017/04/26, 11:53:49
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
 
String str = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";

str = str.replace("I","い");
str = str.replace("U","う");

out.print(str);
%>
