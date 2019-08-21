<%-- 
    Document   : index
    Created on : Jul 16, 2019, 6:15:21 PM
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
        <ul>
            <c:forEach items="${studentai}" var="st">
                <li>
                    ${st.vardas}
                    ${st.pavarde}
                    ${st.elPastas}
                    
                </li>
            </c:forEach>
        </ul>
    </body>
</html>