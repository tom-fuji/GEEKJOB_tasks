
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
 
int num = 1; String result = "";

switch(num){
    case 1:
        result = "one";
        break;
    case 2:
        result = "two";
        break;
    default:
        result = "想定外";
        break;
}

out.println(result);
%>