/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagePackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


/**
 *
 * @author fuzucoo
 */
//在庫管理への登録を行うサーブレットクラス
public class StockRegist extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        //Sqlとの接続に使う変数の宣言
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        PrintWriter out = response.getWriter();
        
        try{
            //フォームから入力内容を取得
            String bn = request.getParameter("bookname").trim();
            String bpri = request.getParameter("price").trim();
            String bpub = request.getParameter("publisher").trim();
            
            int bpr = Integer.parseInt(bpri);
            
            //入力が空白の時にエラーを表示する
            if(bn.equals("") || bpri.equals("") || bpub.equals("") ){
                
                
            }
            
            //mysqlとの接続
            Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db?useUnicode=true&"
                 + "characterEncoding=utf8","fuzucoo","agetan00");  
            
            //Sql文を渡して実行            
            db_st = db_con.prepareStatement("insert into bookstockdata(bookname,bookprice,publisher)values(?,?,?)");
        
            db_st.setString(1,bn);
            db_st.setInt(2,bpr);
            db_st.setString(3,bpub);
            db_st.executeUpdate();
            
            //登録内容の表示
            out.print("登録が完了しました。<br><br>");
            out.print("登録内容<br>");
            out.print("書籍名:"+bn+"<br>");
            out.print("価格:"+bpri+"<br>");
            out.print("出版社名:"+bpub+"<br>");
            
            //メインメニュー画面か続けて登録画面に行くかのボタンを表示
            out.print("<form action = StockManage_Controll method = post><br><br>");
            out.print("<button type= submit  name= pageid  value = 1>メインメニューへ</button><br>");
            out.print("<button type= submit  name= pageid  value = 2>続けて登録する</button><br>");
            out.print("<button type= submit  name= pageid  value = 3>書籍データ一覧を表示</button><br>");
        
        
        
        } catch (SQLException e_sql){
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
