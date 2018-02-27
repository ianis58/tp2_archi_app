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
            <table>
                <tr>
                    <th>id</th>
                    <th>Mail</th>
                    <th>Mot de passe</th>
                    <th>Admin</th>
                    <th>Prénom</th>
                    <th>Nom</th>
                    <th>Adresse</th>
                    <th>Téléphone</th>
                </tr>
                <s:iterator value="listEmployees" var="employe">
                    <tr>
                        <td><s:property value="#employe.idPersonne" /></td>
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
