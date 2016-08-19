<%@page import="com.model.apps.Cv"%>
<%@page import="java.util.List"%>
<%@page import="com.model.apps.Applicants"%>
<%@page import="com.dao.controller.DaoClass"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : 12-Aug-2016, 16:22:45
    Author     : Joynal Abedin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
        <script src="js/jquery/jquery.js"></script>
        <script src="js/bootstrap.js"></script>
        <link rel="stylesheet" type="text/css"  href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">

        <!--      javascript for validation of input text-->
        <script>
            function validateForm() {
                var x = document.forms["searchBox"]["Id"].value;
                if (x == null || x == "") {
                    alert("A number must be filled out");
                    return false;
                }
            }
        </script>

        <title>Home Page</title>

    </head>
    <body class="bg-info">

        <!-- Header menu navigation
   ***********************************************************
        -->
        <header>
            <div class="header">
                <div class="row">
                    <div class="col-md-12">
                        <p><a href="index.html">Login</a> |<a href="index.html">Register</a></p>
                    </div>
                </div>
            </div>
        </header>

        <nav id="tf-menu" class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="home.jsp"><h1 class="header_logo bounceInRight"></h1> </a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="home.jsp" >Home</a></li>
                        <li><a href="#" >Services</a></li>
                        <li><a href="#" >Current jobs</a></li>
                        <li><a href="#" >Employer</a></li>
                        <li><a href="#">Employee</a></li>
                        <li><a href="#">About</a></li>
                       
                        <li><a href="#">Contact</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>  


        <div class="space-container" ><h2> Applicants list</h2></div>  

        <%
            List<Applicants> list = DaoClass.getAll();
            DaoClass dc = new DaoClass();
            request.setAttribute("list", list);

        %>
        <!--        applicants list view table div starts here-->
        <div class="listView-container" >

            <table class="table"  >
                <tr>
                    <th>Applicant Id</th>
                    <th>First name</th>
                    <th>Last name</th>
                </tr>
                <div class="container" style="margin-bottom: 5px"><h3>To view an applicant CV please click on the first name</h3></div> 

                <c:forEach items="${list}" var="em">
                    <tr>
                        <td>${em.id}</td>
                        <td><a href="CV.jsp?id=${em.id}">${em.fname}</a></td>
                        <td>${em.lname}</td>
                    </tr>

                </c:forEach>    

            </table>
        </div>
        <!--        applicatns search box div starts here-->
        <div class="search-container" >

            <form class="service" onsubmit="return validateForm()" name="searchBox" action="ApplicantServlet" method="post">
                To search an applicant:   <input type="text" style="color: black"  onfocus="this.value = '';"  name="Id" value="Enter an id number only" size="20">
                <!--                <input type="submit" class="btn-success" name="searh" value=" Searh "> -->

                <button class='button' style="position: relative">Search</button> 
            </form>

        </div>    
    </body>
</html>
