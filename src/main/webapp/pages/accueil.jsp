<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <%@ include file="template/head.jsp" %>
    </head>
    <body>
        <%@ include file="template/nav.jsp" %>

        <div class="container body-content form-horizontal well">
            <b>Bienvenue, <s:property value="user.prenom"/> <s:property value="user.nom"/></b>
        </div>

        <%@ include file="template/footer.jsp" %>
    </body>
</html>
