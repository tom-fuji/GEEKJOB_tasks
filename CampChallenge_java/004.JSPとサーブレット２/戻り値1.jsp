<%-- 
    Document   : 戻り値1
    Created on : 2017/04/24, 10:22:23
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%!   
            boolean getmyProf(){
            
            System.out.println("藤野朋也"+"<br>");
            System.out.println("1987/7/15"+"<br>");
            System.out.println("横浜出身です"+"<br>");
            
            boolean type = true;
            
            return type;
            
            }

        %>

        
<%
    if(getmyProf() == true){
        out.println("この処理は正しく実行できました");
    }else {
        out.println("この処理は正しく実行できませんでした");
    }
  

%>