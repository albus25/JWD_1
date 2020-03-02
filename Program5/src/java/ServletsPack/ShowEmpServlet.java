/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletsPack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Albus
 */
public class ShowEmpServlet extends HttpServlet {

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
            try {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ShowEmpServlet</title>");            
                out.println("</head>");
                out.println("<body>");

                ResultSet rs = AllMethods.ShowEmployee();
                ResultSet rs1 = AllMethods.ShowDepartment();
                out.println("<form method='post' action='SearchServlet'>");                
                out.println("<select name='deptID'>");
                while(rs1.next()){
                    out.println("<option value='"+rs1.getInt(1)+"'>"+rs1.getString(2)+"</option>");                    
                }
                out.println("</select>");
                out.println("<input type='submit' value='Search'>");                
                out.println("</form>");                
                out.println("<a href='DeptSalary'>TotalSalary</a>");
                out.println("<a href='AddEmpServlet'>Add</a>");
                out.println("<table>");
                out.println("<tr><td>ID</td><td>EmpName</td><td>Salary</td><td>DeptName</td><td>Delete</td><td>Edit</td></tr>");
                if(request.getAttribute("deptList")!=null){
                    ResultSet rs2 = (ResultSet)request.getAttribute("deptList");
                    while(rs2.next()){
                    out.println("<tr><td>"+rs2.getString(1)+"</td><td>"+rs2.getString(2)+"</td><td>"+rs2.getString(3)+"</td><td>"+rs2.getString(5)+"</td><td><a href='DelEmp?eid="+rs2.getInt(1)+"'>Delete</a></td><td><a href='AddEmpServlet?eid="+rs2.getInt(1)+"'>Edit</a></td></tr>");
                }
                }
                else{
                    while(rs.next()){
                        out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(5)+"</td><td><a href='DelEmp?eid="+rs.getInt(1)+"'>Delete</a></td><td><a href='AddEmpServlet?eid="+rs.getInt(1)+"'>Edit</a></td></tr>");
                    }
                }
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            } catch (Exception e) {
                e.printStackTrace();
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
