
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.db.model.DbConnection"%>
<%@page import="com.model.apps.Cv" %>
<%@page import="com.dao.controller.DaoClass" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : CV
    Created on : 16-Aug-2016, 14:31:34
    Author     : Joynal Abedin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
         <link rel="stylesheet" type="text/css"  href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <title>Cv view</title>
    </head>
    <body class="bg-info">
        
<%@page language="java" import="java.sql.*"%>
<%@ page session="true" %>

<input type="file" name="fileSelecter" value="" width="200" />
                    

<%
   String hId=  request.getParameter("id"); 
    int id = Integer.parseInt(hId);
   // out.println(id);
  
  Cv cv = new Cv();
  String filename="";
      String filepath = "";
      String sql = "select CvDocs from Cv where applicantId="+id;
       String sql1 = "select DocType from Cv where applicantId="+id;
      ResultSet rs3 = DbConnection.getDbConnection(sql).executeQuery();
       ResultSet rs2 = DbConnection.getDbConnection(sql1).executeQuery();
      while (rs3.next()&& rs2.next()) {

          cv.setCvDocs(rs3.getString("CvDocs").toString());
          cv.setDocType(rs2.getString("DocType"));
          filepath = cv.getCvDocs();
          filename = cv.getDocType();
      }
     response.setContentType("APPLICATION/OCTET-STREAM");
     response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   

      java.io.FileInputStream fileInputStream = new java.io.FileInputStream(filepath+filename);

      int i;
      while ((i = fileInputStream.read()) != -1) {
          out.write(i);
        
      }
      fileInputStream.close(); 
    
%>   
    
        
  
        
        
    </body>
</html>
