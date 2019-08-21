<%-- 
    Document   : test
    Created on : Jul 28, 2019, 3:43:50 PM
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
        <h1>Test World!</h1>
        <c:forEach items="${pazymiai}" var="pz">
            user id: ${pz.studentasId}
            ${pz.data}
            pazymys: ${pz.pazymys}
            <br>
        </c:forEach>
            
        <a href="back"><button>Back</button></a>
    </body>
</html>
