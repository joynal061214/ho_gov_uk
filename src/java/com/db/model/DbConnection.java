/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joynal Abedin
 */
public class DbConnection {

    //create a conneciton
    public static PreparedStatement getDbConnection(String sql) throws InstantiationException, IllegalAccessException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");//passing jdbc driver
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        }

        String dburl = "jdbc:mysql://localhost:3306/gov_dev";// to connect
        String user = "root";
        String pass = "";

        try { //getting connection
            con = DriverManager.getConnection(dburl, user, pass);
            //   creating a query to the db
            ps = con.prepareStatement(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           //  con.close(); 
        }
        return ps;

    }
    
    
}
