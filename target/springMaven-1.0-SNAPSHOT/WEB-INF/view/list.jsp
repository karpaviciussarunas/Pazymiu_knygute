<%-- 
    Document   : list
    Created on : Jul 28, 2019, 12:19:44 PM
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
        <h1>Studentų sąrašas!</h1>
        <ul>

            <c:forEach items="${studentai}" var="st">
                <li>

                    Id: ${st.id}
                    ${st.pavarde}
                    ${st.vardas}
                    ${st.elPastas} 
                    <a href="edit?idx=${st.id}"> <button>edit</button></a> 
                    <a href="delete?idx=${st.id}"><button>delete</button></a>
                    <a href="studentas?idx=${st.id}"><button>Pažymiai</button></a>
                </li>
            </c:forEach>

        </ul>
        <br>
        Įtraukti naują studentą
        <a href="edit"><button>Naujas studentas</button></a><br>
        <a href="back"><button>Back</button></a>
    </body>
</html>
