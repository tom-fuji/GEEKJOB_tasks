<%-- 
    Document   : タイムスタンプの表示
    Created on : 2017/04/26, 11:11:02
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*;"%>
<%@page import = "java.text.*;"%>

<%
  Date date = new Date();

  Calendar cal = Calendar.getInstance();
  cal.set(2016,10,4,10,0,0);
  Date datepast = cal.getTime();
  
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  String sdate = sdf.format(datepast.getTime());
  out.print(sdate);
%>