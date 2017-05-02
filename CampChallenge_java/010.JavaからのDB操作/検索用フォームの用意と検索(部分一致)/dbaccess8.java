/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

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


public class dbaccess8 extends HttpServlet {

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
        
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        try {
            
            
        String name = request.getParameter("txtName").trim();
        
         Class.forName("com.mysql.jdbc.Driver").newInstance(); 
         db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db?useUnicode=true&"
                 + "characterEncoding=utf8","fuzucoo","agetan00");
         
         
         db_st = db_con.prepareStatement("select * from profiles where name like ?");
         db_st.setString(1,"%"+name+"%");
         db_data = db_st.executeQuery();    
         
         
         //要チェック　 今のままだと正しいとき無表示になる
         //検索結果が空の時と正常な時で表示を変えたいがうまくいかない　getRow? == 0, getnext == false
        //実行結果がないかgetRow()でチェック
        
                
        int i = 0; 
            while(db_data.next()){
                out.print("ID:" + db_data.getInt("profilesID") + "<br>");
                out.print("名前:" + db_data.getString("name") + "<br>");
                out.print("電話番号:" + db_data.getString("tell") + "<br>");
                out.print("年齢:" + db_data.getInt("age") + "<br>");
                out.print("生年月日:" + db_data.getString("birthday") + "<br><br>");
         }
         if( i == 0){
             out.print("該当データがありません");
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
