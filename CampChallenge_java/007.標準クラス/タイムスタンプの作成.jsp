<%-- 
    Document   : タイムスタンプの作成
    Created on : 2017/04/26, 10:35:38
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*;"%>

<%
  Date date = new Date();

  Calendar cal = Calendar.getInstance();
  cal.set(2016, 0,1,0,0,0);
  date = cal.getTime();
  
  out.print(date.getTime());
%>