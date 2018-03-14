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
            <h1>Gestion des sous catégories</h1>

            <div class="row">
                <div class="col-md-10 mx-auto">
                    <s:actionerror/>
                    <s:form action="addSouscategorie" method="post" class="form">
                        <div class="row">
                            <div class="form-group col-md-3">
                                <label for="nom">Nom de la sous catégorie</label>
                                <s:textfield name="souscategorie.nom" id="nom" class="form-control form-control-sm rounded-0"/>
                            </div>
                            <div class="form-group col-md-6">
                                <s:select class="custom-select"
                                    name="linkedCategoriesIds"
                                    list="listAllCategories"
                                    listKey="idCategorie"
                                    listValue="nom"
                                    multiple="true"
                                    size="10"
                                    required="true"
                                />
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <s:submit value="Ajouter sous catégorie" class="btn btn-success btn-lg float-right"/>
                            </div>
                        </div>
                    </s:form>
                </div>
            </div>

            <table class="table table-sm table-hover table-bordered">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Nom de la sous catégorie</th>
                        <th scope="col">Modifier</th>
                        <th scope="col">Supprimer</th>
                    </tr>
                </thead>
                <s:iterator value="listSouscategories" var="souscategorie">
                    <tr>
                        <th scope="row"><s:property value="#souscategorie.idSousCategorie" /></td>
                        <td><s:property value="#souscategorie.nom" /></td>
                        <td>
                            <s:url var="editURL" action="editSouscategorieLink">
                                <s:param name="id" value="#souscategorie.idSousCategorie"></s:param>
                            </s:url>
                            <s:a href="%{editURL}"><i class="material-icons">mode_edit</i></s:a>
                        </td>
                        <td>
                            <s:url var="deleteURL" action="deleteSouscategorie">
                                <s:param name="id" value="#souscategorie.idSousCategorie"></s:param>
                            </s:url>
                            <s:a href="%{deleteURL}" onclick="return confirm('Etes-vous sûr de vouloir supprimer cette sous catégorie ?')"><i class="material-icons">delete_forever</i></s:a>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </div>

        <%@ include file="template/footer.jsp" %>
    </body>
</html>
