/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_code;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author elcot
 */
public class login extends HttpServlet {

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
        /*try (PrintWriter out = response.getWriter()) {
             TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
                response.setContentType("text/html;charset=UTF-8");
                */
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            response.setContentType("text/html");
//PrintWriter out= response.getWriter();
*/
String n = request.getParameter("uname");
String p = request.getParameter("pwd");
//out.println(n);
//out.println(n);
 try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = null;
            conn =
       DriverManager.getConnection("jdbc:mysql://localhost/aspect_based_suggestion","root","shiva");
            out.print("done till driver manager");
  Statement stmt=conn.createStatement();  
  
ResultSet rs=stmt.executeQuery("select * from login");  
  int flag=0;
while(rs.next())  
{
    String s1=rs.getString(1);
    String s2=rs.getString(2);
    /*if(s1.equals("shiva"))
        out.println("helllllloooooo");*/
    out.println(rs.getString(1)+rs.getString(2));
    out.println("hai"+s1+s2);
    
    if((s1.equals(n))&&(s2.equals(p)))
    {
        flag=1;
        out.println(flag);
        break;
        
    }
}
//out.println(rs.getString(1)+"  "+rs.getString(2));  
  

/*request.setAttribute("message", "message"); // This will be available as ${message}
        request.getRequestDispatcher("").forward(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("http://localhost:8080/aspect/index_afterlog.html");
            dispatcher.forward( request, response );
*/
if(flag==1)
    response.sendRedirect("index_afterlog.html");
else
  response.sendRedirect("login.html");
conn.close();            
//out.println("logged in");
        } catch (Exception ex) {
            // handle the error
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
