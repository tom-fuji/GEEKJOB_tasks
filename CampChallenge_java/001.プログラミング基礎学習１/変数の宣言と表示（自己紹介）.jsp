
<%@page pageEncoding="UTF-8"%>
<%@page contentType="text/html;charset=UTF-8"%>

<%
    String my_profile = "はじめまして、藤野朋也です";
    int height = 175;  
    
    
    out.println(my_profile);
    
    out.println("身長は"+ height +"cmです");
    
%>