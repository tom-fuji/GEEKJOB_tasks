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

/**
 *
 * @author fuzucoo
 */
public class datagetServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
                        request.setCharacterEncoding("UTF-8");
            
            //名前部分取得
            String n = request.getParameter("txtName").trim();
            if(n.equals("")){
                n = "名前が入力されていません<br>";
                }
            
            //性別部分取得
            String s1 = request.getParameter("rdo_man");
            String s2 = request.getParameter("rdo_woman");
            
            String s = "";
            if(s1 != null){
                s = "男性";
            }else if(s2 != null){
                s = "女性";
            }else{
                s = "性別が選択されていません<br>";
            }
            
            //趣味欄取得
            String p = request.getParameter("txtprof").trim();
         
            if(p.equals("")){
                p = "趣味の欄が入力されていません";
                
            }
          
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet datagetServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            out.print("<font size=5>");
            out.println("名前:"+ n +"<br>");
            out.println("性別:"+ s + "<br>");
            out.println("趣味:"+ p + "<br>");
            out.print("</font>");
            
            out.println("</body>");
            out.println("</html>");
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
