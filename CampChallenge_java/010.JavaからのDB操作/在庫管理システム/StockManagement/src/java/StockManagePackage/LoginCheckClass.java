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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author fuzucoo
 */

//ログイン処理を行うクラス
public class LoginCheckClass extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
            //ログインフォームの入力情報を取得
            String n = request.getParameter("txtName").trim();
            String p = request.getParameter("PW").trim();
            
             HttpSession hs = request.getSession(true);

            // Connection データベースとの接続の時に使う
            Connection db_con = null;
            
            //preparedStatement　Sql文の型
            PreparedStatement db_st = null;
            //Resultset データベースの結果を表すResultset　インターフェース
            ResultSet db_data = null;
        try  {
            
            /* TODO output your page here. You may use following sample code. */
            
            
            //ここからMSQLへの接続、処理の記述
             Class.forName("com.mysql.jdbc.Driver").newInstance(); 
             db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db?useUnicode=true&"
                + "characterEncoding=utf8","fuzucoo","agetan00"); 
             
             db_st = db_con.prepareStatement("select * from userdata where name = ? and pass = ?");
             db_st.setString(1,n);
             db_st.setString(2,p);
             db_data = db_st.executeQuery(); 
             
             
          
             int i = 0; 
             while(db_data.next()){
                 //db_data内にデータが入って入れば認証可
                 //LoginOKの内容をセッションに登録
                 hs.setAttribute("login", "OK");      
                 //ServletContextオブジェクトを取得します。
                 ServletContext sc = getServletContext();
                 //RequestDispatcherオブジェクトを取得
                 RequestDispatcher rd = sc.getRequestDispatcher("/StockManage_Controll");
                 //forwardメソッド
                 rd.forward(request, response);
                 
                 
                i += 1;
             }
             if( i == 0){
                 //i==0 だと認証不可 再度エラーページへ
                response.sendRedirect("errorpage.html");
             }
            
            

             db_data.close();
             db_st.close();
             db_con.close();
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
