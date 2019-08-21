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
        <h1>Hello  EDIT!</h1>
             Studento ID: ${studentas.id}
        <form method="POST" action="save">
            <input type="hidden" name="idx" value="${studentas.id}">
            <input name="vardas" value="${studentas.vardas}">
            <input name="pavarde" value="${studentas.pavarde}">
            <input name="elPastas" value="${studentas.elPastas}">
            <input type="submit" value="save">
        </form>
             <a href="back"><button>Back</button></a>
    </body>
</html>
