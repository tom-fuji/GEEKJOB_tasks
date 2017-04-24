<%-- 
    Document   : 引数、戻り値
    Created on : 2017/04/24, 11:22:30
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.HashMap;"%>

<%!
  HashMap profiles(int id){
    HashMap<String,String> prof = new HashMap<String,String>(); 
    
    switch(id){
    
    case 185:
    prof.put("id","185");
    prof.put("name","tomoyafujino");
    prof.put("birth", "1987/7/15");
    prof.put("adress","yokohama,kanagawa");
    
    break;
    
    case 165:
    prof.put("id","165");
    prof.put("name","nobunagaoda");
    prof.put("birth", "1542/??/??");
    prof.put("adress","nagoya,aichi");
    
    break;
    
    case 862:
    prof.put("id","862");
    prof.put("name","sousekinatsume");
    prof.put("birth", "1867/2/9");
    prof.put("adress","shinjuku,tokyo");
    
    }
    
    return prof;
}   

%>

<%
out.println(profiles(185).get("name"));
out.println(profiles(185).get("birth"));
out.println(profiles(185).get("adress"));

%>
