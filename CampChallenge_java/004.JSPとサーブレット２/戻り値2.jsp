<%-- 
    Document   : 戻り値2
    Created on : 2017/04/24, 10:59:03
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.HashMap;"%>
<%!
   HashMap profiles(){
    HashMap<String,String> prof = new HashMap<String,String>(); 
    
    prof.put("id","15258");
    prof.put("name","tomoyafujino");
    prof.put("birth", "1987/7/15");
    prof.put("adress","yokohama,kanagawa");
    
    return prof;
    
}   

%>

<%
out.println(profiles().get("name"));
out.println(profiles().get("birth"));
out.println(profiles().get("adress"));
   


%>


