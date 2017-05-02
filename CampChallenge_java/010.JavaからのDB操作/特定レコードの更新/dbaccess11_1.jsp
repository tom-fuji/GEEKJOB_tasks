<%-- 
    Document   : dbaccess10_1
    Created on : 2017/05/02, 13:36:08
    Author     : fuzucoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
      <form action="dbaccess11" method="post">
    <body>　上書きしたいprofilesIDを指定してください<br>
            profilesID<input type="text" name="ID"><br><br>
            
            情報を入力<br>
          
          
            名前<input type="text" name="Name"><br>
            電話番号<input type="text" name="Tell"><br>
            年齢<input type="text" name="Age"><br> 
            <br>
            生年月日を入力<br>
            年<input type="text" name="year"><br>
            月<input type="text" name="month"><br>
            日<input type="text" name="day"><br>
            <input type="submit" name="submitbtn">
            </form>
    </body>
</html>
