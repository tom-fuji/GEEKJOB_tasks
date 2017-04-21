
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    String hantei(int i){
      
      String r =" ";
      if((i % 2) == 0){
        r = "偶数です";  
      }else{
        r = "奇数です";
    }
      return r;
    
    }

%>


<%
   out.print(hantei(8));
%>
