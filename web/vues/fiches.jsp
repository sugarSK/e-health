<%-- 
    Document   : fichesPatients
    Created on : 13 déc. 2015, 16:00:52
    Author     : soukaina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap Core CSS -->
        <link href="${pageContext.request.contextPath}/vues/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vues/css/style.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/vues/css/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/vues/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/vues/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
        <title>Authentification</title>
    </head>
     <body>
        
       <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                
                <a class="navbar-brand">Docteur:${medecin.nom}  </a>
            </div>
             <ul class="nav navbar-top-links navbar-right">
           
           
            <li class="dropdown">
          
            <li><a href="${pageContext.request.contextPath}/vues/index.jsp">Deconnexion</a></li>
        
            <!-- /.dropdown -->
        </ul>
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                               
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/accueilMedecin">Mes Rendez vous<span class="glyphicon glyphicon-book pull-right"></span></a>
                            <a href="${pageContext.request.contextPath}/fiches">Fiches des patients<span class="glyphicon glyphicon-book pull-right"></span></a>
                            <a href="${pageContext.request.contextPath}/ordonances.jsp">Ordonance<span class="glyphicon glyphicon-book pull-right"></span></a>
                            <a href="${pageContext.request.contextPath}/dossier.jsp">Dossier Medical<span class="glyphicon glyphicon-book pull-right"></span></a>
                        </li>  
                       
                    </ul>
                      </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        
        <div id="page-wrapper">
                <div class="col-lg-12">
                    <h3 class="page-header" class="box-title"><FONT  size="5pt"><strong>Fiches Patients</strong></FONT> </h3>
                    <div class="row">
                    <div class="col-lg-1 text-center">
                            <div class="panel-body">
                               
                             </div>
                    </div>
                    
                    <div class="col-lg-10 text-center">
                            <div class="panel-body">
                                       <table id="tableau2" class="table table-hover  dataTable" cellspacing="0" width="100%">
                                       <thead>
                                       <tr>
                                                <th>Numero Fiche</th>
                                                <th>Nom </th>
                                                <th>Prénom</th>
                                                <th>Datee naissance </th>
                                                <th>Maladie</th>
                                                <th>Comptes rendus </th>
                                               
                                        </tr>
                                        </thead>
                                        <tbody>
                                          <c:forEach var="listef" items="${listef}">
                                         <tr>
                                                <td> <c:out value="${listef.id_fiche}"/></td>                                    
                                                <td><c:out value="${listef.patient.nom}"/></td>
                                                <td><c:out value="${listef.patient.prenom}"/></td>
                                                <td><c:out value="${listef.patient.date_naissance}"/></td>
                                                <td><c:out value="${listef.patient.maladie}"/></td>
                                                <td>
                                                 
                                                    <a class="btn btn-warning" href="<c:url value="/seance/${listef.id_fiche}" />" >Consulter</a>
                                                </td>
                                               
                                               
                                            </tr>
      
                                         </c:forEach> 
                                    </tbody>
                                    </table>
                            </div>
                    </div>
                    <div class="col-lg-1 text-center">
                            <div class="panel-body">
                            </div>
                    </div>
                </div>

        

                </div>
        </div>
<!-- jQuery -->
    <script src="${pageContext.request.contextPath}/vues/js/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/vues/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/vues/js/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/vues/js/sb-admin-2.js"></script>
</body>
</html>