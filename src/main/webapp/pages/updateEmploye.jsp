<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <%@ include file="template/head.jsp" %>
        <script type="text/javascript">  
             
            function goBack(){  
            <!--pour le bouton de retour !-->  
             window.open("manageusers","_self"); 
            }  
            
        </script>  
    </head>
    <body>
        <%@ include file="template/nav.jsp" %>

        <div class="container body-content form-horizontal well">
            <h1>Modifier l'utilisateur</h1>  

            <div class="row">
                <div class="col-md-10 mx-auto">
                    <s:actionerror/>
                    <s:form action="updateEmploye" method="post" class="form">
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label for="mail">Mail</label>
                                <s:textfield name="employe.mail" id="mail" class="form-control form-control-sm rounded-0"/>
                            </div>

                            <div class="form-group col-md-4">
                                <label for="prenom">Prénom</label>
                                <s:textfield name="employe.prenom" id="prenom" class="form-control form-control-sm rounded-0"/>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-4">
                                <label for="nom">Nom</label>
                                <s:textfield name="employe.nom" id="nom" class="form-control form-control-sm rounded-0"/>
                            </div>

                            <div class="form-group col-md-4">
                                <label for="adresse">Adresse</label>
                                <s:textfield name="employe.adresse" id="adresse" class="form-control form-control-sm rounded-0"/>
                            </div>

                            <div class="form-group col-md-4">
                                <label for="telephone">Téléphone</label>
                                <s:textfield name="employe.telephone" id="telephone" class="form-control form-control-sm rounded-0"/>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-8">
                                <label class="custom-control custom-checkbox">
                                  <s:checkbox name="employe.isAdmin" id="isadmin" class="custom-control-input"/>
                                  <span class="custom-control-indicator"></span>
                                  <span class="custom-control-description small text-dark">Faire de cet utilisateur un administrateur</span>
                                </label>
                            </div>

                            <div class="form-group col-md-2">
                                <input type="button" value="Retour" onclick="goBack()" class="btn btn-outline-secondary btn-lg float-left"/>
                            </div>

                            <div class="form-group col-md-2">
                                <s:hidden name="employe.idPersonne" value="%{#parameters.id}" label="Primary Key" />
                                <s:hidden name="employe.password" />
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
