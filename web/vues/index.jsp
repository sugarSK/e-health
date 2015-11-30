<%-- 
    Document   : index
    Created on : 30 nov. 2015, 15:46:38
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentification</title>
    </head>
    
        <h1>Hello index</h1>
        <form method="POST" action="doLogin">
            <label>login</label>
            <input type="text" name="login" /><br>
            <label>password</label>
            <input type="password" name="password" />
                <input type="submit" value="LogIn">
        </form>
    

