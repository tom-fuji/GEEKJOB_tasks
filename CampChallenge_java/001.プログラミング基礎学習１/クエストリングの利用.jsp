<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    
String sougaku = request.getParameter("param1");
String kosuu = request.getParameter("param2");
String syubetu = request.getParameter("param3");

if(syubetu.equals("1")){
  out.println("１：雑貨");
}else if(syubetu == "2"){
    out.println("２：生鮮食品");
}else if(syubetu == "3"){
    out.println("３：その他");
}

out.println("総額は" + sougaku + "円です");


int a = Integer.parseInt(sougaku);
int b = Integer.parseInt(kosuu);
int kakaku =  a / b;

out.println("一個当たりの値段は" + kakaku + "円です" );

double p = 0;

if( a > 5000 ){
   p = a * 0.05;
}else if( a >3000){
   p = a * 0.04;
}

out.print("今回付与されるポイントは"+ p +"ポイントです");

%>
