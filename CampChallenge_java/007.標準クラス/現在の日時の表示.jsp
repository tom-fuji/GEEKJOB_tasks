<%-- 
    Document   : 現在日時の取得
    Created on : 2017/04/26, 10:54:12
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*;"%>

<%
  Date date = new Date();

  Calendar cal = Calendar.getInstance();
  cal.setTime(date);
  int yy = cal.get(Calendar.YEAR);
  int mm = cal.get(Calendar.MONTH)+1;
  int dd = cal.get(Calendar.DATE);
  int hh = cal.get(Calendar.HOUR_OF_DAY);
  int min = cal.get(Calendar.MINUTE);
  int ss = cal.get(Calendar.SECOND);
  
  out.print(yy+"-"+mm+"-"+dd+"　"+hh+":"+min+":"+ss);


%>
