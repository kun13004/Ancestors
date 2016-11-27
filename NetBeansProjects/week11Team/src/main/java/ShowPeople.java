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

/**
 *
 * @author Elgalad
 */
@WebServlet(urlPatterns = {"/ShowPeople"})
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
        
        try {
            DBHelper db = new DBHelper();
        
            db.createPersonTable();
            db.createRelationsTable();
        
            db.insertIntoPersonTable("LaRell", "Kunz", "06/07/1937");
            db.insertIntoPersonTable("Dean", "Whiting", "10/21/1938");
            db.insertIntoPersonTable("Deanna", "Daw", "01/13/1942");
            db.insertIntoPersonTable("Douglas", "Andrus", "04/29/1941");
        
            ResultSet rs = db.queryPersonTable();
        
            List<Person> list = new ArrayList();

            while (rs.next()) {
                Person person = new Person();
                person.setFirstName(rs.getString(1));
                person.setLastName(rs.getString(2));
                person.setBirthDate(rs.getString(3));
                list.add(person);
            }
        
            request.setAttribute("person", list);
            request.getRequestDispatcher("SearchPeople.jsp").forward(request, response);
        } catch(SQLException se) {
            se.printStackTrace();
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