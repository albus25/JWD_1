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
public class AddEmpServlet extends HttpServlet {

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
                ResultSet rs = AllMethods.ShowDepartment();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet AddEmpServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                String eid = request.getParameter("eid");
                
                if(eid!="" && eid!=null){
                    ResultSet rs1 = AllMethods.GetEmployee(Integer.parseInt(eid));
                    while(rs1.next())
                    {
                        out.println("<form method='post' action='UpdEmp'>");
                        out.println("<table>");
                        out.println("<tr>\n" + "<td>EmpID</td>\n" + "<td><input type=\"text\" name=\"empID\" value='"+rs1.getString(1)+"' readonly></td>\n" +
                        "</tr>");
                        out.println("<tr>\n" + "<td>EmpName</td>\n" + "<td><input type=\"text\" name=\"empName\" value='"+rs1.getString(2)+"'></td>\n" +
                        "</tr>");
                        out.println("<tr>\n" + "<td>Salary</td>\n" + "<td><input type=\"number\" name=\"salary\" value='"+rs1.getString(3)+"'></td>\n" +
                        "</tr>");
                        out.println("<tr>\n" + "<td>Department</td>\n" + "<td>"
                               + "<select name='deptID'>");
                        while(rs.next()){
                            if(rs.getInt(1) == rs1.getInt(4))
                            {
                                out.println("<option value='"+rs.getInt(1)+"' selected>"+rs.getString(2)+"</option>");
                            }
                            else
                            {
                                out.println("<option value='"+rs.getInt(1)+"'>"+rs.getString(2)+"</option>");                                
                            }
                        }
                        out.println("</select></td>");
                        out.println("</tr>");
                        out.println("<tr>\n" + "<td colspan='2'><input type=\"submit\" value='Update'></td>\n" +
                        "</tr>");
                        out.println("<table>");
                        out.println("<form>");                                            
                    }
                }
                else{
                    out.println("<form method='post' action='AddEmp'>");
                    out.println("<table>");
                    out.println("<tr>\n" + "<td>EmpID</td>\n" + "<td><input type=\"text\" name=\"empID\" readonly></td>\n" +
                    "</tr>");
                    out.println("<tr>\n" + "<td>EmpName</td>\n" + "<td><input type=\"text\" name=\"empName\"></td>\n" +
                    "</tr>");
                    out.println("<tr>\n" + "<td>Salary</td>\n" + "<td><input type=\"number\" name=\"salary\"></td>\n" +
                    "</tr>");
                    out.println("<tr>\n" + "<td>Department</td>\n" + "<td>"
                           + "<select name='deptID'>");
                    while(rs.next()){
                        out.println("<option value='"+rs.getInt(1)+"'>"+rs.getString(2)+"</option>");
                    }
                    out.println("</select></td>");
                    out.println("</tr>");
                    out.println("<tr>\n" + "<td colspan='2'><input type=\"submit\" value='Add'></td>\n" +
                    "</tr>");
                    out.println("<table>");
                    out.println("<form>");                    
                }
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
