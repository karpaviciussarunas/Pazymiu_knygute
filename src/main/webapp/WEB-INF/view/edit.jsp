<%-- 
    Document   : edit
    Created on : Jul 28, 2019, 3:37:23 PM
    Author     : Sars
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>EDIT!</h1>
             Studento ID: ${studentas.id}
        <form method="POST" action="save">
            <input type="hidden" name="idp" value="${pazymys.id}">
            <input name="pažymys" value="${pazymys.pazymys}">
            <input name="data" value="${pazymys.data}">
            <input name="studentasId" value="${pazymys.studentasId}">
            <input type="submit" value="save">
        </form>
             <a href="back"><button>Back</button></a>
    </body>
</html>
