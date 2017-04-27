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
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 *
 * @author fuzucoo
 */
public class dataget extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            request.setCharacterEncoding("UTF-8");
            
             String n = request.getParameter("txtName").trim();
             String s1 = request.getParameter("rdo_man");
             String s2 = request.getParameter("rdo_woman");
             String p = request.getParameter("txtprof").trim();
            
            int s = 0;
            if(s1 != null){
                s = 1;
            }else if(s2 != null){
                s = 2;
            }else{
                s = 3;
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet dataget</title>");            
            out.println("</head>");
            
               
            HttpSession hs = request.getSession();
            hs.setAttribute("Name",n);
            hs.setAttribute("Sex",s);
            hs.setAttribute("Prof",p); 
            
            out.println("<body>");
            out.println("<div><i>あなたの情報を入力してください</i></div><br>");
            out.println("<form action=dataget method=post>");
            out.println("名前<input type= text  name= txtName value ="+ hs.getAttribute("Name")+">");
            out.println("<br><br>");
            
            if(hs.getAttribute("Sex").equals(1)){
                out.println("男<input type=radio name= rdo_man  checked >");
                out.println("女<input type=radio  name= rdo_woman>");
            }else if(hs.getAttribute("Sex").equals(2)){
                out.println("男<input type=radio name= rdo_man>");
                out.println("女<input type=radio  name= rdo_woman checked >");
            }else{
                out.println("男<input type=radio name= rdo_man>");
                out.println("女<input type=radio  name= rdo_woman>");
            }
            
            out.println("<br><br>");
            out.println(" 趣味<textarea name=txtprof>" + hs.getAttribute("Prof") + " </textarea>");
            out.println("<input type=submit name=submitbtn>");
            out.println();
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
