<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="javax.servlet.http.HttpSession"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("currentdata");
    
    String url = request.getRequestURI();
    System.out.println(url);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        <h1>詳細情報</h1>
        名前:<%= udd.getName()%><br>
        生年月日:<%= udd.getBirthday()%><br>
        種別:<%= udd.getType()%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        登録日時:<%= udd.getNewDate()%><br>
        <form action="Update" method="POST">
        <input type="submit" name="update" value="変更"style="width:100px">
         <input type="hidden" name="ac"  value="<%=hs.getAttribute("ac")%>">
        </form>
        <form action="Delete" method="POST">
        <input type="submit" name="delete" value="削除"style="width:100px">
        <input type="hidden" name="ac"  value="<%=hs.getAttribute("ac")%>">
        </form>
        <br>
        <form action="SearchResult" method="POST">
        <input type="submit" name="delete" value="検索結果一覧へ戻る">
        <input type="hidden" name="ac"  value="<%=hs.getAttribute("ac")%>">
        <input type="hidden" name="url"  value="<%=url%>">
        </form>
    </body>
</html>

