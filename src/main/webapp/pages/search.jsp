<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <%@ include file="template/head.jsp" %>
    </head>
    <body>
        <%@ include file="template/nav.jsp" %>
        
        <div class="container body-content form-horizontal well">
            <h1>Recherche</h1>
            <br>
            <h4>Entrez le nom d'un article</h4>
            <s:actionerror/>
            <s:form action="processrecherche" method="post" style="form-inline">
                    <s:textfield name="art.nom" label="Nom" />
                    <s:submit value="Recherche" align="center" class="btn btn-success"/>
            </s:form>
            <br>
            <h4>Ou effectuez une recherche par catégorie</h4>
            <s:form action="advancesearch" method="post" style="align: center">
                <s:select class="custom-select"
                          headerValue="Select"
                                    name="searchCategorieId"
                                    list="listAllCategories"
                                    listKey="idCategorie"
                                    listValue="nom"
                                    required="true"
                                />
                <s:submit value="Recherche" align="center" class="btn btn-success"/>
            </s:form>
            <br>
            <table class="table table-striped table-sm">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Marque</th>
                        <th scope="col">Nom</th>
                        <th scope="col">Reference</th>
                        <th scope="col">Prix</th>
                        <th scope="col">Description</th>
                    </tr>
                </thead>
                
                         <s:iterator value="listRecherche" var="article">
                             
                            <tr>
                                <td scope="row"><s:property value="#article.idArticle" /></td>
                                <td><s:property value="#article.marque.libelleMarque" /></td>
                                <td><s:property value="#article.nom" /></td>
                                <td><s:property value="#article.reference" /></td>
                                <td><s:property value="#article.prix" /></td>
                                <td><s:property value="#article.description" /></td>
                            </tr>
                           
                        </s:iterator>
                   
            </table>
            
        </div>
        <%@ include file="template/footer.jsp" %>
    </body>
</html>
