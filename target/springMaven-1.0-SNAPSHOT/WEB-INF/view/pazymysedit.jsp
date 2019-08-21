<%-- 
    Document   : pazimysedit
    Created on : Aug 2, 2019, 2:07:29 PM
    Author     : Sars
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <h1>pažymių redagavimas!</h1>
            
            pažymio ID: ${pazymiai.id}<br>
            ${pazymiai.getStudentasId().getVardas()}
            ${pazymiai.getStudentasId().getPavarde()}
        <form method="POST" action="savepazymys">
            <input type="hidden" name="idp" value="${pazymiai.id}">
            <input name="pažymys" value="${pazymiai.pazymys}">
            <input name="pažymio Data" value="${pazymiai.data}">
            <input type="submit" value="save">
        </form>
            ${studentas.vardas}
        ${studentas.pavarde}
             <a href="back"><button>Back</button></a>
    </body>
</html>
