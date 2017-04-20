<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.Arrays"%>

<%
  String nArr[] = {"10","100","soeda","hayashi","-20","118","END"};
  nArr[2] = "33";
  out.println(Arrays.toString(nArr));
%>

