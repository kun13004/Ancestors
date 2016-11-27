/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elgalad
 */
@WebServlet(name = "ShowPeople", urlPatterns = {"/ShowPeople"})
public class ShowPeople extends HttpServlet {

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
        ResultSet rs = null;
        
        try {
            DBHelper db = new DBHelper();
        
            db.createPersonTable();
            db.createRelationsTable();
        
            db.insertIntoPersonTable("LaRell", "Kunz", "06/07/1937");
            db.insertIntoPersonTable("Kory", "Kunz", "07/26/1963");
            db.insertIntoPersonTable("Austin", "Kunz", "03/31/1992");
        
            rs = db.queryPersonTable();
        
            List<Person> list = new ArrayList();
            while (rs.next()) {
                System.out.println(rs.getString(2));
                String first = rs.getString(2);
                Person person = new Person();
                person.setFirst(first);
                person.setLast(rs.getString(3));
                person.setBirth(rs.getString(4));
                list.add(person);
            }
            
            
            System.out.println(list.size());
            
            request.setAttribute("people", list);
            request.getRequestDispatcher("SearchPeople.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ShowPeople.class.getName()).log(Level.SEVERE, null, ex);
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
