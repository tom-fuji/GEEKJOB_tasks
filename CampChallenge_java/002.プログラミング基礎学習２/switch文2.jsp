<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
char text = 'あ';
String result = " ";

switch(text){
       case 'あ':
         result = "日本語です";
         break;
       case 'A':
         result = "英語です";
         break;
}

out.print(result);

%>

     
       　　　
          
      
