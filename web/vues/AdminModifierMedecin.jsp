<%-- 
    Document   : accueilAdmin
    Created on : 24 déc. 2015, 17:21:31
    Author     : soukaina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <title>Modification info secretaire</title>
    </head>
     <body>
        
       <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <a class="navbar-brand">Admin</a>
            </div>
            <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
            <li><a href="${pageContext.request.contextPath}/index">Deconnexion</a></li>
        
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
                            <a href="${pageContext.request.contextPath}/accueilAdmin">Accueil<span class="glyphicon glyphicon-book pull-right"></span></a>
                            <a href="${pageContext.request.contextPath}/AdminAjouterMedecin">Ajouter Medecin<span class="glyphicon glyphicon-book pull-right"></span></a>
                            <a href="${pageContext.request.contextPath}/AdminAjouterSpecialite">Ajouter specialité<span class="glyphicon glyphicon-book pull-right"></span></a>
                            <a href="${pageContext.request.contextPath}/AdminAjouterSecretaire">Ajouter secretaire <span class="glyphicon glyphicon-book pull-right"></span></a>
                        </li>
                    </ul>
                      </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        
        <div id="page-wrapper">
            <div class="col-lg-12">
               <h3 class="page-header" class="box-title"><FONT  size="5pt"><strong>Administration</strong></FONT> </h3>

                     <div class="row">
                        <div class="col-lg-2 text-center">
                            <div class="panel-body">
              
                            </div>
                         </div>
                        <div class="col-lg-8 text-center">
                            <div class="panel-body">
                          <form  action="modifierMed" role="form" method="post">
                                
                                    <fieldset>
                                                <div class="form-group">
                                                    <label for="disabledSelect">Numero</label>
                                                    <input class="form-control"  type="text" name="id_utilisateur" value="${mede.id_utilisateur}">
                                                </div>                     
                                                <div class="form-group">
                                                    <label>Nom</label>
                                                    <input class="form-control" name="nom" type="text" value="${mede.nom}">
                                                </div>
                                                <div class="form-group">
                                                    <label>Prenom</label>
                                                    <input class="form-control" name="prenom" type="text" value="${mede.prenom}">
                                                </div>
                                                  <div class="form-group">
                                                    <label>Date naissance</label>
                                                    <input class="form-control" name="date_naissance" type="text" value="${mede.date_naissance}">
                                                </div>                                          
                                                <div class="form-group">
                                                    <label>Adresse</label>
                                                    <input class="form-control" name="adresse" type="text" value="${mede.adresse}">
                                                </div>
                                                <div class="form-group">
                                                    <label>Numero telephone</label>
                                                    <input class="form-control" name="numero_telephone" type="text" value="${mede.numero_telephone}">
                                                </div>
                                                
                                                <div class="form-group">
                                                    <label>Login</label>
                                                    <input class="form-control" name="login" type="text" value="${mede.login}">
                                                </div>
                                                <div class="form-group">
                                                    <label>Password</label>
                                                    <input class="form-control" name="password" type="text" value="${mede.password}">
                                                </div>                      
                                          
                                            <!-- Change this to a button or input when using this as a form -->
                                            <input type="submit"  value="Modifier" class="btn btn-lg btn-warning"/>
                                        </fieldset>
                                    </form>

                            </div> 

                        </div>
                        <div class="col-lg-2 text-center">
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
