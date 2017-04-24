
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!

void test(int A){
    int num = 0; 
    num = A*5;
    System.out.println(num);
}

void test(int A,int B, boolean type){
      
      
      A = A*B;
      if(type == false){
          System.out.print(A);
      }else if(type == true){
          System.out.print((A*A));
      }
}
%>
<%
   System.out.print("test");
   test(5);
%>