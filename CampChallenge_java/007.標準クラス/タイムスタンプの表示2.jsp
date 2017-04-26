<%-- 
    Document   : タイムスタンプの表示2
    Created on : 2017/04/26, 11:11:02
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*;"%>
<%@page import = "java.text.*;"%>

<%

  Calendar cal1 = Calendar.getInstance();
  cal1.set(2015,0,1,0,0,0);
  Date datepast1 = cal1.getTime();

  Calendar cal2 = Calendar.getInstance();
  cal2.set(2015,11,31,23,59,59);
  Date datepast2 = cal2.getTime();
  
 out.print(datepast2.getTime() - datepast1.getTime());

%>
