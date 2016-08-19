/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.controller;

import com.model.apps.Applicants;
import com.db.model.DbConnection;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.apps.Cv;

/**
 *
 * @author Joynal Abedin
 */
public class DaoClass { // this is a dao controller class 

    /*
    Method to view the list of applicants
     */
    public static List<Applicants> getAll() throws SQLException, InstantiationException, IllegalAccessException {
        List<Applicants> list = new ArrayList<Applicants>(); //using list with generics
        ResultSet rs = DbConnection.getDbConnection("select * from applicants").executeQuery();
        // while loop through the list
        while (rs.next()) {
            Applicants a = new Applicants();
            a.setId(rs.getInt("id"));
            a.setFname(rs.getString("fname"));
            a.setLname(rs.getString("lname"));
            list.add(a); // adding all to the list
        }

        return list;
    }

    /*
    method to find an applicant by id
     */
    public static Applicants FindById(int Id) throws InstantiationException, IllegalAccessException, SQLException {
        //    List<Applicants> list = new ArrayList<Applicants>();
        Applicants a = null;
        String sql = "select * from applicants where id=" + Id;
        ResultSet rs = DbConnection.getDbConnection(sql).executeQuery();
        while (rs.next()) {// while loop through the resultSet
            a = new Applicants();
            a.setId(rs.getInt("id"));
            a.setFname(rs.getString("fname"));
            a.setLname(rs.getString("lname"));
        }
        return a;
    }

    /*
    method to view candidate cv using applicant id
     */
    public void readFileByPath(int applicantId, String filename) throws IOException, InstantiationException, IllegalAccessException, SQLException {

        Cv cv = new Cv();
        String filepath = "";

        // while loop through the resultSet
        String sql = "select CvDocs from Cv where applicantId=" + applicantId;
        String sql1 = "select DocType from Cv where applicantId=" + applicantId;
        ResultSet rs = DbConnection.getDbConnection(sql).executeQuery();
        ResultSet rs1 = DbConnection.getDbConnection(sql1).executeQuery();
        while (rs.next() && rs1.next()) {

            cv.setCvDocs(rs.getString("CvDocs").toString());
            cv.setDocType(rs1.getString("DocType"));
            filepath = cv.getCvDocs();
            filename = cv.getDocType();
        }
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(filepath + filename);
        int i;
        while ((i = fileInputStream.read()) != -1) {
            System.out.write(i);
        }
        fileInputStream.close();
    }

}
