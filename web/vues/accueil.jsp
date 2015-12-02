<%-- 
    Document   : accueil
    Created on : 30 nov. 2015, 17:20:48
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${medecin.nom}</h1>
        <h3>${medecin.prenom} </h3>
        <h4>${fiche_patient}</h4>
        
        <c:forEach var="fiche" items="${listFiches}">
            Nom : <c:out value="${fiche.patient.nom}"/>
            Prenom : <c:out value="${fiche.patient.prenom}"/><br>
            <c:forEach var="seance" items="${fiche.seances}">
                <c:out value="${seance.date}"/>
            </c:forEach>
        </c:forEach>
    </body>
</html>
