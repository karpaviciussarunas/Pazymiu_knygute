<%-- 
    Document   : studentas
    Created on : Jul 29, 2019, 7:27:51 PM
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
        <h1>Hello Studentas World!</h1>
        ${studentas.vardas}
        ${studentas.pavarde}
        <br>
    <c:forEach items="${pazymiai}" var="pz">
 
        pazymio id: ${pz.id}
        ${pz.data}
        pazymys: ${pz.pazymys}
        <a href="pazymysedit?idp=${pz.id}"> <button>edit</button></a> 
        <a href="pazymysdelete?idp=${pz.id}"><button>delete</button></a>
        <br>
    </c:forEach>
    <a href="pazymysedit?(idp=${idp}, idx=${idx})"><button>Naujas pažymys</button></a>
    <a href="back"><button>Back</button></a>
</body>
</html>
