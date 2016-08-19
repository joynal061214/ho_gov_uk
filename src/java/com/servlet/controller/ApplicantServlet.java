/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.controller;

import com.dao.controller.DaoClass;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import javax.servlet.ServletOutputStream;

/**
 *
 * @author Joynal Abedin
 */
public class ApplicantServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, SQLException, InstantiationException, IllegalAccessException {
//        
////        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/home.jsp");
////        rd.forward(request, response);
//       
//       
//
//}
    /*
    post method to find an applicant by passing an id
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Id = request.getParameter("Id").trim();
        if (Id.equals("")) {
            Id = "Applicant id cannot be empty ";
        } else {

            int id = Integer.parseInt(Id);

            try {
                DaoClass.FindById(id);
            } catch (InstantiationException ex) {
                Logger.getLogger(ApplicantServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ApplicantServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ApplicantServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/ViewSerachResult.jsp");
            rd.forward(request, response);

        }
    }

protected void OpenFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String filename = (String) request.getAttribute("fileName");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition",
                "attachment;filename="+filename);

        File file = new File(filename);
        FileInputStream fileInputStream = new FileInputStream(file);
        ServletOutputStream out = response.getOutputStream();

        byte[] outputByte = new byte[(int)file.length()];
        //copy binary contect to output stream
        while(fileInputStream.read(outputByte, 0, (int)file.length()) != -1)
        {
        out.write(outputByte, 0, (int)file.length());
        } 
        
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/CV.jsp");
            rd.forward(request, response);
            request.setAttribute("OpenFile", file );
            

     }

}
