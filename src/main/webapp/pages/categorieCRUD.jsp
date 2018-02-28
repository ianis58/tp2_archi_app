<%-- 
    Document   : categorieCRUD
    Created on : 27 févr. 2018, 17:11:01
    Author     : almes
--%>

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
            <h1>Gestion des Catégories</h1>

            <s:actionerror/>
            <s:form action="addCategorie" method="post" style="align: center">
                <s:textfield name="cat.nom" label="Nom"/>
                <s:submit value="Add Categorie" align="center"/>
            </s:form>

            <s:if test="listCategories.size() > 0">
                <div>
                    <table class="table table-sm table-hover table-bordered">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Nom</th>
                                <th scope="col">Modifier</th>
                                <th scope="col">Supprimer</th>
                            </tr>
                        </thead>
                        <s:iterator value="listCategories" var="categorie">
                        <tr>
                            <th scope="row"><s:property value="#categorie.idCategorie" /></td>
                            <td><s:property value="#categorie.nom" /></td>
                            <td>
                                <s:url var="editURL" action="editCategorieLink">
                                    <s:param name="id" value="%{#categorie.idCategorie}"></s:param>
                                    <s:param name="nom" value="%{#categorie.nom}"></s:param>
				</s:url>
                                <s:a href="%{editURL}">Modifier</s:a>
                            </td>
                            <td>
                                <s:url var="deleteURL" action="deleteCategorie">
                                    <s:param name="id" value="%{#categorie.idCategorie}"></s:param>
				</s:url>
                                <s:a href="%{deleteURL}" onclick="return confirm('Etes-vous sûr de vouloir supprimer cette catégorie ?')">Supprimer</s:a>
                            </td>
                        </tr>
                        </s:iterator>
                    </table>
                </div>
            </s:if>
            
        </div>

        <%@ include file="template/footer.jsp" %>
    </body>
</html>
