<%-- 
    Document   : ファイルの書き出しと保存
    Created on : 2017/04/26, 14:03:15
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,java.text.*,java.io.*"%>
<%
   
File txt = new File("C:/Users/fuzucoo/Documents/NetBeansProjects/BasicClass/web/test.txt");

  FileWriter fw = new FileWriter(txt);
  fw.write("はじめまして、私の名前は藤野朋也です\r\n");
  fw.close();

%>
