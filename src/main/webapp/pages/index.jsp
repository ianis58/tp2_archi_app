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
            <s:actionerror />
            <s:form action="login">
                <s:textfield name="user.mail" label="Identifiant (mail)"/>
                <s:password name="user.password" label="Mot de passe"/>
                <s:submit value="Connexion"/>
            </s:form>
        </div>

        <%@ include file="template/footer.jsp" %>
    </body>
</html>
