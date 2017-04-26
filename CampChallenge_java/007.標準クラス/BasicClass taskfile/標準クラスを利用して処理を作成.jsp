<%-- 
    Document   : 標準クラスを利用して処理を作成
    Created on : 2017/04/26, 14:54:13
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,java.text.*,java.io.*"%>




<%!
  String Nowtime(){
    Date ds = new Date();
   Calendar cal = Calendar.getInstance();
   cal.setTime(ds);
   int yy = cal.get(Calendar.YEAR);
   int mm = cal.get(Calendar.MONTH)+1;
   int dd = cal.get(Calendar.DATE);
   int hh = cal.get(Calendar.HOUR_OF_DAY);
   int min = cal.get(Calendar.MINUTE);
   int ss = cal.get(Calendar.SECOND);
   
   String now = new String(yy + "-" + mm + "-" + dd + " " + hh + ":" + min + ":" +ss);
   
   return now;
   }
  

   void Filewrite(BufferedWriter b,String x){
     try{
     b.write(x);
     b.newLine();
    }catch(IOException e){
    }
}
%>

<%
File txt = new File(application.getRealPath("classlog.txt"));

 FileWriter fw = new FileWriter(txt);
 BufferedWriter bw = new BufferedWriter(fw); 
  
 //Localeクラスの処理を行う 国や言語などを扱うためのクラス
  Filewrite(bw,Nowtime()+ "Locale クラスの処理を記録　開始"+"<br>");
  Filewrite(bw,Locale.JAPAN.getCountry()+"<br>");
  Filewrite(bw,Locale.US.getCountry()+"<br>");
  Filewrite(bw,Locale.JAPAN.getDisplayCountry()+"<br>");
  Filewrite(bw,Locale.US.getDisplayCountry()+"<br>");
  Filewrite(bw,Locale.US.getDisplayLanguage()+"<br>");
  Filewrite(bw,Nowtime()+ "Locale クラスの処理を記録　終了"+"<br>");
  
  bw.close();
 
  //読み込みして表示 
  File logs = new File(application.getRealPath("classlog.txt"));
  FileReader fr = new FileReader(logs);
  BufferedReader br = new BufferedReader(fr); 
  
  String str;
  while((str = br.readLine()) != null){
      out.print(str);
      
  }
%>
