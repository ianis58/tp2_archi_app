<%-- 
    Document   : categorieCRUD
    Created on : 12/03
    Author     : nruj
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
            <h1>Gestion des Articles</h1>     
            <div class="row">
                <div class="col-md-10 mx-auto">
                    <s:actionerror/>
                    <s:form action="addArticle" method="post" class="form">
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="nom">Nom</label>
                                <s:textfield name="art.nom" id="nom" class="form-control form-control-sm rounded-0"/>
                                <label for="marque">Marque</label>
                                <s:textfield name="art.marque" id="marque" class="form-control form-control-sm rounded-0"/>
                                <label for="ref">Reference</label>
                                <s:textfield name="art.ref" id="ref" class="form-control form-control-sm rounded-0"/>
                                <label for="prix">Prix</label>
                                <s:textfield name="art.prix" id="prix" class="form-control form-control-sm rounded-0"/>
                                <label for="description">Description</label>
                                <s:textfield name="art.description" id="description" class="form-control form-control-sm rounded-0"/>
                                <label for="sousCat">Categorie</label>
                                <s:textfield name="listSousCat" id="listSousCat" class="form-control form-control-sm rounded-0"/>
                            </div>
                            <div class="form-group col-md-6">
                                <s:submit value="Ajouter Article" class="btn btn-success btn-lg float-right"/>
                            </div>
                        </div>
                    </s:form>
                </div>
            </div>

            <s:if test="listArticles.size() > 0">
                <div>
                    <table class="table table-sm table-hover table-bordered">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Nom</th>
                                <th scope="col">Reference</th>
                                <th scope="col">Prix</th>
                                <th scope="col">Description</th>
                                <th scope="col">Stocks</th>
                                <th scope="col">Modifier</th>
                                <th scope="col">Supprimer</th>
                            </tr>   
                        </thead>     
                        <s:iterator value="listArticles" var="article">
                        <tr>
                            <th scope="row"><s:property value="#article.idArticle" /></td>
                            <td><s:property value="#article.nom" /></td>
                            <td>
                                <s:url var="editURL" action="editCategorieLink">
                                    <s:param name="id" value="%{#article.idArticle}"></s:param>
                                    <s:param name="nom" value="%{#article.nom}"></s:param>
                                    <s:param name="nom" value="%{#article.marque}"></s:param>
                                    <s:param name="nom" value="%{#article.reference}"></s:param>
                                    <s:param name="nom" value="%{#article.prix}"></s:param>
                                    <s:param name="nom" value="%{#article.description}"></s:param> 
                                    <s:param name="nom" value="%{#article.souscategories}"></s:param>
				</s:url>
                                <s:a href="%{editURL}"><i class="material-icons">mode_edit</i></s:a>
                            </td>
                            <td>
                                <s:url var="deleteURL" action="deleteArticle">
                                    <s:param name="id" value="%{#article.idArticle}"></s:param>
                                    <s:param name="nom" value="%{#article.nom}"></s:param>
                                    <s:param name="nom" value="%{#article.marque}"></s:param>
                                    <s:param name="nom" value="%{#article.reference}"></s:param>
                                    <s:param name="nom" value="%{#article.prix}"></s:param>
                                    <s:param name="nom" value="%{#article.description}"></s:param>
                                    <s:param name="nom" value="%{#article.souscategories}"></s:param>
				</s:url>
                                <s:a href="%{deleteURL}" onclick="return confirm('Etes-vous sûr de vouloir supprimer cet article ?')"><i class="material-icons">delete_forever</i></s:a>
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
