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
import java.text.SimpleDateFormat;


/**
 *
 * @author fuzucoo
 */


public class dbaccess12 extends HttpServlet {

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
        //ResultSet db_data = null;
        
        try {
            
            
        
        String n = request.getParameter("Name").trim();
        
        String ae = request.getParameter("Age").trim();
        String yy = request.getParameter("year").trim();
        String mm = request.getParameter("month").trim();
        String dd = request.getParameter("day").trim();
        
        //IDとAgeを""の場合の処理を回避しながらStringからIntへ変更。
        int a = 0;
        
        if(ae != ""){
          a = Integer.parseInt(ae);
        }
         //生年月日の処理　StringをDate型へ
        String birth = yy + "-" + mm + "-" + dd;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date bi = format.parse(birth);  
        
        
        
         Class.forName("com.mysql.jdbc.Driver").newInstance(); 
         db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db?useUnicode=true&"
                 + "characterEncoding=utf8","fuzucoo","agetan00");  
         
         db_st = db_con.prepareStatement("select * from profiles where name = ? and age = ? and birthday = ?");
         db_st.setString(1,n);;
         db_st.setInt(2,a);
         db_st.setDate(3,new java.sql.Date(bi.getTime()));
         db_data = db_st.executeQuery(); 
        
         
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
            
         
         
         //executeUpdateの戻り値で削除が行われたか判定
         switch(db_st.executeUpdate()){
             case 0:
                 out.print("入力されたID番号のデータは存在しません。");
                 break;
             default:
                 out.print("データの追加が完了しました");
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
