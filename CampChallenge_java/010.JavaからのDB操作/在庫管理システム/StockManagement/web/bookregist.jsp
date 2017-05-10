<%-- 
    Document   : bookregist
    Created on : 2017/05/08, 16:47:55
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>書籍情報登録ページ　在庫管理システム</title>
    </head>
    <body>
         <form action="StockRegist" method="post">
            情報を入力して登録ボタンを押してください
            <br>
            <br>
            書籍名<input type="text" name="bookname">
            <br>
            価格      <input type="text" name="price">円(半角数字で入力してください)
            <br>
            出版社<input type="text" name="publisher">
            <br><br> 
                     
            <button type="submit" name="submitbtn">登録</button>
            
         </form>
    </body>
</html>
