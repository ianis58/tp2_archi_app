<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <%@ include file="template/head.jsp" %>
        <script type="text/javascript">  
             
            function goBack(){  
            <!--pour le bouton de retour !-->  
             window.open("managesouscategories","_self"); 
            }  
            
        </script>  
    </head>
    <body>
        <%@ include file="template/nav.jsp" %>

        <div class="container body-content form-horizontal well">
            <h1>Modifier la sous catégorie</h1>  

            <div class="row">
                <div class="col-md-10 mx-auto">
                    <s:actionerror/>
                    <s:form action="updateSouscategorie" method="post" class="form">
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label for="nom">Nom de la sous catégorie</label>
                                <s:textfield name="souscategorie.nom" id="nom" class="form-control form-control-sm rounded-0"/>
                            </div>
                        </div>
 
                        <div class="form-group col-md-6">
                            <s:select class="custom-select"
                                name="linkedCategoriesIds"
                                list="listAllCategories"
                                listKey="idCategorie"
                                listValue="nom"
                                multiple="true"
                                size="10"
                                value="linkedCategoriesIds"
                                required="true"
                            />
                            <!--
                                name: nom de la variable qui sera envoyée vers l'action du form
                                list: liste de toutes les Categorie
                                listKey: attribut de la classe Categorie pour accéder aux ids de catégories possibles depuis listAllCategories
                                listValue: attribut de la classe Categorie pour accéder aux noms de catégories possibles depuis listAllCategories
                                multiple: permet de selectionner plusieurs catégories
                                size: nombre de lignes pour définir la hauteur du select
                                value: permet de re-sélectionner les catégories qui sont associées à cette sous catégorie en bdd
                                required: pas sûr que ce soit utile puisque ça passe avec 0 catégories sélectionnées...
                            -->
                        </div>

                        <div class="row">
                            <div class="form-group col-md-2">
                                <input type="button" value="Retour" onclick="goBack()" class="btn btn-outline-secondary btn-lg float-left"/>
                            </div>

                            <div class="form-group col-md-2">
                                <s:hidden name="souscategorie.idSousCategorie" value="%{#parameters.id}" label="Primary Key" />
                                <s:submit value="Modifier" class="btn btn-success btn-lg float-right"/>
                            </div>
                        </div>
                    </s:form>
                </div>
            </div>
        </div>

        <%@ include file="template/footer.jsp" %>
    </body>
</html>
