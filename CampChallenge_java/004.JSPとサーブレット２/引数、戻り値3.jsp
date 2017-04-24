<%-- 
    Document   : 引数、戻り値
    Created on : 2017/04/24, 11:22:30
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.HashMap;"%>
<%@page import = "java.util.*;"%>

<%!
  HashMap profiles(int id){
    HashMap<String,String> prof = new HashMap<String,String>(); 
    
    switch(id){
    
    case 185:
    prof.put("id","185");
    prof.put("name","tomoyafujino");
    prof.put("birth", "1987/7/15");
    prof.put("adress","yokohama,kanagawa");
    
    break;
    
    case 165:
    prof.put("id","165");
    prof.put("name","nobunagaoda");
    prof.put("birth", "1542/??/??");
    prof.put("adress",null);
    
    break;
    
    case 862:
    prof.put("id","862");
    prof.put("name","sousekinatsume");
    prof.put("birth", "1867/2/9");
    prof.put("adress","shinjuku,tokyo");
    
    }
    return prof;
}   
%>

<%
    
Integer limit = 2;
int[] idset = {185,165,862};
String[] keyset = {"name","birth","adress"};

    for (int i =0; i < idset.length; i++){
        for(int j = 0; j < keyset.length;j++){
           //nullの要素を除外 
           if(profiles(idset[i]).get(keyset[j]) == null){
               continue;
           }else
               out.println(profiles(idset[i]).get(keyset[j]));
           
           
        }
        if(i == limit-1){
            break;
        }
    }
    

%>
