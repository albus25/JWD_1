/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Albus
 */
public class SessionServlet extends HttpServlet {

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
            out.println("<title>Servlet SessionServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            HttpSession session = request.getSession(true);
            Date createTime = new Date(session.getCreationTime());
            Date lastTime = new Date(session.getLastAccessedTime());
            String msg = "Hola Again User";
            int cnt = 0;
            String visitCnt = "Visited";
            String userIDKey = "UserId";
            String userID = "Albus";
            
            if(session.isNew())
            {
                msg = "Hola User";
                session.setAttribute(userIDKey, userID);
            }
            else
            {
                cnt = (Integer)session.getAttribute(visitCnt);
                cnt += 1;
                userID = (String)session.getAttribute(userIDKey);
            }
            
            session.setAttribute(visitCnt, cnt);
            out.println("<h2>"+msg+"</h2>");
            out.println("<h2>Session Creation Time : "+createTime+"</h2>");
            out.println("<h2>Session Last Access Time : "+lastTime+"</h2>");
            out.println("<h2>SessionId : "+session.getId()+"</h2>");
            out.println("<h2>By "+userID+" & Count is "+cnt+"</h2>");
            
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
