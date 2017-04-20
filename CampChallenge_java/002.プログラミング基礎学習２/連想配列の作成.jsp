<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>

<%
    HashMap<String,String>nMap = new HashMap<String,String>();
  
    nMap.put("1","AAA");
    nMap.put("hello", "world");
    nMap.put("soeda","33");
    nMap.put("20","20");
    
    out.println(nMap.toString());
%>