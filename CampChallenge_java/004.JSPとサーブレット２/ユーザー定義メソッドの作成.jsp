<%-- 
    Document   : profile
    Created on : 2017/04/20, 15:38:23
    Author     : kurikura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%!   
            void getmyProf(){
            
            System.out.println("藤野朋也"+"<br>");
            System.out.print("1987/7/15"+"<br>");
            System.out.print("横浜出身です"+"<br>");
            
            }

        %>
        <%
        
            for(int i = 0 ;i < 10 ; i++){
            
            getmyProf();
        }
        %>
