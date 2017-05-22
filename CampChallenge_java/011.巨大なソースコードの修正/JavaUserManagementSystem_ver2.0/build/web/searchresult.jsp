<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="jums.UserDataBeans"
        import="java.util.ArrayList"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    ArrayList <UserDataDTO> udd = (ArrayList <UserDataDTO>)hs.getAttribute("resultData");
    
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        
        <%if(udd.size()==0){%>
        一致する情報ががありませんでした。
        <br> <a href="Search">検索画面へ戻る</a> <br>
        <%}else{%>       
 
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <%
            int i = 0;
            while(i< udd.size()){%>
            <form name="idpram<%=i%>" method="post" action="ResultDetail">
            <tr>
                <!--hrefでそのまま渡すとGetでURLに直接パラメータを渡してしまい、不正アクセス防止ができないので以下のように渡す -->
                <td><a href="#" onclick="document.idpram<%=i%>.submit();return false;"><%= udd.get(i).getName()%></a></td>
                <td><%= udd.get(i).getBirthday()%></td>
                <td><%= udd.get(i).getType()%></td>
                <td><%= udd.get(i).getNewDate()%></td>
            </tr>
            
                <input type="hidden" name="id"  value="<%= udd.get(i).getUserID()%>">
                <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            </form>
            <%  
                i+=1;
            }%>

        </table>
      
        <%}%>
        
        <%=jh.home()%>
        
    </body>
  
</html>
