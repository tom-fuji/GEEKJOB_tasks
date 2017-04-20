<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
String text = "A";

for(int i = 0; i < 30 ; i++){
    
    out.println(text);
    
    text += "A";
    
}

%>