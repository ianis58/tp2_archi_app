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
            <h1>Gestion des utilisateurs</h1>
            <table class="table table-sm table-hover table-bordered">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Mail</th>
                        <th scope="col">Mot de passe</th>
                        <th scope="col">Admin</th>
                        <th scope="col">Prénom</th>
                        <th scope="col">Nom</th>
                        <th scope="col">Adresse</th>
                        <th scope="col">Téléphone</th>
                    </tr>
                </thead>
                <s:iterator value="listEmployees" var="employe">
                    <tr>
                        <th scope="row"><s:property value="#employe.idPersonne" /></td>
                        <td><s:property value="#employe.mail" /></td>
                        <td><s:property value="#employe.password" /></td>
                        <td><s:if test="#employe.isAdmin == 1">Oui</s:if>
                            <s:if test="#employe.isAdmin == 0">Non</s:if></td>
                        <td><s:property value="#employe.prenom" /></td>
                        <td><s:property value="#employe.nom" /></td>
                        <td><s:property value="#employe.adresse" /></td>
                        <td><s:property value="#employe.telephone" /></td>
                    </tr>
                </s:iterator>
            </table>
        </div>

        <%@ include file="template/footer.jsp" %>
    </body>
</html>
