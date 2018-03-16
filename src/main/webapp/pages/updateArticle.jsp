<%-- 
    Document   : updateArticle
    Created on : 15.03
    Author     : nruj
--%>

<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <%@ include file="template/head.jsp" %>
        <script type="text/javascript">

            function goBack() {
            <!--pour le bouton de retour !-->  
                window.open("articleCRUD", "_self");
            }

        </script>  
    </head>
    <body>
        <%@ include file="template/nav.jsp" %>

        <div class="container body-content form-horizontal well">
            <h1>Modifier l'article</h1>
            <div class="row">
                <div class="col-md-10 mx-auto">
                    <s:actionerror/>
                    <s:form action="updateArticle" method="post" class="form">
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label for="nom">Nom</label>
                                <s:textfield name="art.nom" id="nom" class="form-control form-control-sm rounded-0"/>
                            </div>
                            <label for="marque">Marque</label>
                            <div class="form-group col-md-6">
                                <s:select class="custom-select"
                                          name="linkedMarqueIds"
                                          list="listMarques"
                                          listKey="idMarque"
                                          listValue="libelleMarque"
                                          multiple="false"
                                          size="3"
                                          value="art.marque.idMarque"
                                          required="true"
                                          /></div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label for="nom">Reference</label>
                                <s:textfield name="art.reference" id="reference"  class="form-control form-control-sm rounded-0"/>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="nom">Prix</label>
                                <s:textfield name="art.prix" id="prix"  class="form-control form-control-sm rounded-0"/>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="nom">Description</label>
                                <s:textfield name="art.description" id="description" class="form-control form-control-sm rounded-0"/>
                            </div>
                        </div>
                        <div class="row">
                            <label for="categorie">Categories</label>
                            <div class="form-group col-md-6">
                                <s:select class="custom-select"
                                          name="linkedSousCategoriesIds"
                                          list="listAllSousCategories"
                                          listKey="idSousCategorie"
                                          listValue="nom"
                                          multiple="true"
                                          size="3"
                                          value="linkedSousCategoriesIds"
                                          required="true"
                                          /></div>
                                 
                            <label for="vehicule">Vehicule</label>
                            <div class="form-group col-md-4">
                                <s:select class="custom-select"
                                          name="linkedVehIds"
                                          list="listVehicules"
                                          listKey="idVehicule"
                                          listValue="LibelleVehicule"
                                          multiple="true"
                                          size="3"
                                          value="linkedVehIds"
                                          required="true"
                                          /></div>
                        </div>
                        <div class="row">
                                <s:hidden name="art.idArticle" value="%{#parameters.id}" label="Primary Key" />
                            <div class="form-group col-md-4">
                                <s:submit value="Modifier" class="btn btn-success btn-lg float-right"/>
                            </div>
                            <div class="form-group col-md-4">
                                <input value="Retour" class="btn btn-default btn-lg float-right" type="button" onclick="goBack()"/>
                            </div> 
                        </div>
                    </s:form>
                </div>
            </div>
        </div>

        <%@ include file="template/footer.jsp" %>
    </body>
</html>
