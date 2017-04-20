<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
int num1 = 0;

for(int i = 1; i <= 100; i++){
    
    out.println(num1);
    num1 += i; 
}
%>
