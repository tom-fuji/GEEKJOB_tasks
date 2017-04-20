<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*"%>
<%
   //素因数をkeyにして割った回数を値の部分に格納する目的で連想配列を作成
   HashMap<Integer,Integer>sMap = new HashMap<Integer,Integer>();
   sMap.put(2, 0);sMap.put(3, 0);sMap.put(5, 0);sMap.put(7, 0);

   String num = request.getParameter("param1");
   int i = Integer.parseInt(num);

   out.println("元の値"+num);
  
   //割った回数をkeyに格納
   for(Map.Entry<Integer,Integer>x:sMap.entrySet()){
       while((i % x.getKey())==0){
        i = i / x.getKey();
        x.setValue((x.getValue())+1);
        }
   }
 
   out.println("1ケタの素因数");
  
   //keyが0でない要素を「素因数*回数」の形式で表示
   for(Map.Entry<Integer,Integer>x:sMap.entrySet()){
      if(x.getValue() != 0){
          out.println(x.getKey() + "*" + x.getValue());              
      }
    }

if(i != 1){
out.println("その他 "+ i );
}
%>