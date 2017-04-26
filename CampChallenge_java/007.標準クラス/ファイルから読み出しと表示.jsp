<%-- 
    Document   : ファイルから読み出しと表示
    Created on : 2017/04/26, 14:14:46
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,java.text.*,java.io.*"%>

<%
File txt = new File("C:/Users/fuzucoo/Documents/NetBeansProjects/BasicClass/web/test.txt");
FileReader fr = new FileReader(txt);
BufferedReader br = new BufferedReader(fr);
out.print(br.readLine());

br.close();



%>
