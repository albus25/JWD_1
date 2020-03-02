/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FiltersPack;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Albus
 */
public class TestFilter implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public TestFilter() {
    }    
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("TestFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("TestFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
            
        System.out.println("Filter");
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        res.setContentType("text/html");
        PrintWriter out = response.getWriter();
        boolean flag = false;
        
        String sid = req.getParameter("txtSID");
        String sname = req.getParameter("txtName");
        String age = req.getParameter("txtAge");
        String email = req.getParameter("txtEmail");
        String mno = req.getParameter("txtMNo");
        
        if(sid.equals(""))
        {
            flag = false;
            req.setAttribute("ErrorMsgID", "ID is required");
            RequestDispatcher rd = req.getRequestDispatcher("FormServlet");
            rd.include(request, response);
        }
        else if(Pattern.matches("^S[0-9]{2,3}$", sid))
        {
            flag = true;
            req.setAttribute("StudentID", sid);
        }
        else
        {
            req.setAttribute("ErrorMsgID", "ID should be start with 'S' and contains 2-3 characters");
            req.setAttribute("StudentID", sid);
            RequestDispatcher rd = req.getRequestDispatcher("FormServlet");
            rd.include(request, response);
            flag = false;
        }
        
        if(sname.equals(""))
        {
            flag = false;
            req.setAttribute("ErrorMsgName", "Name is required");
            RequestDispatcher rd = req.getRequestDispatcher("FormServlet");
            rd.include(request, response);
        }
        else if(Pattern.matches("^[a-zA-Z]+$", sname))
        {
            flag = true;
            req.setAttribute("StudentName", sname);
        }
        else
        {
            req.setAttribute("ErrorMsgName", "Invalid StudentName");
            req.setAttribute("StudentName", sname);
            RequestDispatcher rd = req.getRequestDispatcher("FormServlet");
            rd.include(request, response);
            flag = false;
        }
        
        if(age.equals(""))
        {
            flag = false;
            req.setAttribute("ErrorMsgAge", "Age is required");
            RequestDispatcher rd = req.getRequestDispatcher("FormServlet");
            rd.include(request, response);
        }
        else if(Integer.parseInt(age)>=25 && Integer.parseInt(age)<=40)
        {
            flag = true;
            req.setAttribute("StudentAge", age);
        }
        else
        {
            req.setAttribute("ErrorMsgAge", "Age should be 25 to 40");
            req.setAttribute("StudentAge", age);
            RequestDispatcher rd = req.getRequestDispatcher("FormServlet");
            rd.include(request, response);
            flag = false;
        }
        
        if(email.equals(""))
        {
            flag = false;
            req.setAttribute("ErrorMsgEmail", "Email is required");
            RequestDispatcher rd = req.getRequestDispatcher("FormServlet");
            rd.include(request, response);
        }
        else if(Pattern.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$", email))
        {
            flag = true;
            req.setAttribute("StudentEmail", email);
        }
        else
        {
            req.setAttribute("ErrorMsgEmail", "Email is invalid");
            req.setAttribute("StudentEmail", email);
            RequestDispatcher rd = req.getRequestDispatcher("FormServlet");
            rd.include(request, response);
            flag = false;
        }

        if(mno.equals(""))
        {
            flag = false;
            req.setAttribute("ErrorMsgMno", "Mobile No is required");
            RequestDispatcher rd = req.getRequestDispatcher("FormServlet");
            rd.include(request, response);
        }
        else if(Pattern.matches("^91[6-9]{1}[0-9]{9}$", mno))
        {
            flag = true;
            req.setAttribute("StudentMobileNo", mno);
        }
        else
        {
            req.setAttribute("ErrorMsgMno", "Mobile no is only valid to indian telecom(+91) with 10 digit");
            req.setAttribute("StudentMobileNo", mno);
            RequestDispatcher rd = req.getRequestDispatcher("FormServlet");
            rd.include(request, response);
            flag = false;
        }

        if(flag)
        {
            chain.doFilter(request, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("TestFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("TestFilter()");
        }
        StringBuffer sb = new StringBuffer("TestFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);                
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");                
                pw.print(stackTrace);                
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
