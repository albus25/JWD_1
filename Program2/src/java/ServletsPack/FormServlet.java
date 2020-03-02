/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletsPack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Albus
 */
public class FormServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormServlet</title>");            
            out.println("</head>");
            out.println("<body>");
//            out.println("Hola");

            String id,name,age,email,mno=null;
            String sid,sname,sage,semail,smno=null;

            id = (String)request.getAttribute("ErrorMsgID");
            name = (String)request.getAttribute("ErrorMsgName");
            age = (String)request.getAttribute("ErrorMsgAge");
            email = (String)request.getAttribute("ErrorMsgEmail");
            mno = (String)request.getAttribute("ErrorMsgMno");
            
            sid = (String)request.getAttribute("StudentID");
            sname = (String)request.getAttribute("StudentName");
            sage = (String)request.getAttribute("StudentAge");
            semail = (String)request.getAttribute("StudentEmail");
            smno = (String)request.getAttribute("StudentMobileNo");

            out.println("<form method='post' action='HolaServlet'>");
            out.println("<table border='2'>");
            
            out.println("<tr>");
            out.println("<td>StudentID</td>");
            if(sid==null){
                out.println("<td><input type='text' name='txtSID'></td>");
            }
            else{
                out.println("<td><input type='text' name='txtSID' value='"+sid+"'></td>");                
            }
            if(id!=null){
                out.println("<td><font color='red'>"+id+"</font></td>");                
            }
            out.println("</tr>");            
            
            out.println("<tr>");
            out.println("<td>StudentName</td>");
            if(sname==null){
                out.println("<td><input type='text' name='txtName'></td>");
            }
            else{
                out.println("<td><input type='text' name='txtName' value='"+sname+"'></td>");                
            }
            if(name!=null){
                out.println("<td><font color='red'>"+name+"</font></td>");                
            }
            out.println("</tr>");            
            
            out.println("<tr>");
            out.println("<td>Age</td>");
            if(sage==null){
                out.println("<td><input type='number' name='txtAge'></td>");
            }
            else{
                out.println("<td><input type='number' name='txtAge' value='"+sage+"'></td>");
            }
            if(age!=null){
                out.println("<td><font color='red'>"+age+"</font></td>");                                
            }
            out.println("</tr>");            
            
            out.println("<tr>");
            out.println("<td>Email</td>");
            if(semail==null){
                out.println("<td><input type='email' name='txtEmail'></td>");
            }
            else{
                out.println("<td><input type='email' name='txtEmail' value='"+semail+"'></td>");                
            }
            if(email!=null){
                out.println("<td><font color='red'>"+email+"</font></td>");                                                
            }
            out.println("</tr>");            
            
            out.println("<tr>");
            out.println("<td>MobileNo</td>");
            if(smno==null){
                out.println("<td><input type='number' name='txtMNo'></td>");
            }
            else{
                out.println("<td><input type='number' name='txtMNo' value='"+smno+"'></td>");                
            }
            if(mno!=null){
                out.println("<td><font color='red'>"+mno+"</font></td>");                                                                
            }
            out.println("</tr>");            
            
            out.println("<tr>");
            out.println("<td colspan='2'><center><input type='submit' value='Register' name='Submit'></center></td>");
            out.println("</tr>");            
            out.println("</table>");
            out.println("</form>");
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
