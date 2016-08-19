<%-- 
    Document   : ViewSerachResult
    Created on : 15-Aug-2016, 18:15:10
    Author     : Joynal Abedin
--%>

<%@page import="com.model.apps.Applicants"%>
<%@page import="com.dao.controller.DaoClass"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="home.jsp" flush="true"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery/jquery.js"></script>
        <script src="js/bootstrap.js"></script>
        <link rel="stylesheet" type="text/css"  href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
         <!-- Bootstrap -->
        <link rel="stylesheet" type="text/css"  href="css/bootstrap.css">
     
        
        
        
        <title>Search result</title>
    </head>
    <body class="bg-info">


        <!--        JSP scriplet to execute dao class findById method -->
        <%
            Applicants a = new Applicants();
            String Id = request.getParameter("Id");
            int id = Integer.parseInt(Id);
            a = DaoClass.FindById(id);
            request.getAttribute("Id");
        %>

        <div class="result-container" > 
            <h3>Here is your search result: </h3>
            <p class="" style="margin-left: 260px"> To search again please enter another id number</p>
            <table class="table1" >
                <tr>
                    <th>Applicant Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                </tr>

                <tr> <!--        JSP scriplet to display the search result-->
                    <td><%=id%></td>
                    <td><%=DaoClass.FindById(id).getFname()%></td>
                    <td><%=DaoClass.FindById(id).getLname()%></td>
                </tr>
               
                    <a href='home.jsp' class='button' style="position: absolute; margin-left: 600px; margin-bottom: 10px" >Clear result</a>
                       </table>


        </div>

    </body>
</html>
