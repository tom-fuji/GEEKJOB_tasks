/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagePackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fuzucoo
 */
//商品一覧を表示するクラス
public class StockBookList extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");request.setCharacterEncoding("UTF-8");
        
        //Sqlとの接続に使う変数の宣言
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        PrintWriter out = response.getWriter();
        
        try{ 
            /* TODO output your page here. You may use following sample code. */
           //mysqlとの接
            Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db?useUnicode=true&"
                 + "characterEncoding=utf8","fuzucoo","agetan00");  
            
            //Sql文を渡して実行            
            db_st = db_con.prepareStatement("select*from bookstockdata");
            db_data = db_st.executeQuery();
            
            int i = 0; 
            while(db_data.next()){
                out.print("ID:" + db_data.getInt("bookID") + ",");
                out.print("書籍名:" + db_data.getString("bookname") + ",");
                out.print("書籍価格:" + db_data.getString("bookprice") + ",");
                out.print("出版社名:" + db_data.getString("publisher") + "<br>");
                i +=1;
         }
         if( i == 0){
             out.print("該当データがありません");
         }
            out.print("<form action = StockManage_Controll method = post><br><br>");
            out.print("<button type= submit  name= pageid  value = 1>メインメニューへ</button><br>");
            out.print("<button type= submit  name= pageid  value = 2>続けて登録する</button><br>");
            
            
        }catch (SQLException e_sql){
            out.println("接続時にエラーが発生しました:"+e_sql.toString());
        } catch (Exception e){
            out.println("接続時にエラーが発生しました"+e.toString());
        } finally {
            if (db_con != null){
                try{
                    db_con.close();
                } catch (Exception e_con){
                     System.out.println(e_con.getMessage());
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
