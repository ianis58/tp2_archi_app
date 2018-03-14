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

            <div class="row">
                <div class="col-md-10 mx-auto">
                    <s:actionerror/>
                    <s:form action="addEmploye" method="post" class="form">
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label for="mail">Mail</label>
                                <s:textfield name="employe.mail" id="mail" class="form-control form-control-sm rounded-0"/>
                            </div>

                            <div class="form-group col-md-4">
                                <label for="prenom">Prénom</label>
                                <s:textfield name="employe.prenom" id="prenom" class="form-control form-control-sm rounded-0"/>
                            </div>

                            <div class="form-group col-md-4">
                                <label for="password">Mot de passe</label>
                                <s:password name="employe.password" id="password" class="form-control form-control-sm rounded-0"/>
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
                            <div class="form-group col-md-6">
                                <label class="custom-control custom-checkbox">
                                  <s:checkbox name="employe.isAdmin" id="isadmin" class="custom-control-input"/>
                                  <span class="custom-control-indicator"></span>
                                  <span class="custom-control-description small text-dark">Faire de cet utilisateur un administrateur</span>
                                </label>
                            </div>

                            <div class="form-group col-md-6">
                                <s:submit value="Ajouter utilisateur" class="btn btn-success btn-lg float-right"/>
                            </div>
                        </div>
                    </s:form>
                </div>
            </div>

            <table class="table table-sm table-hover table-bordered">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Mail</th>
                        <th scope="col">Admin</th>
                        <th scope="col">Prénom</th>
                        <th scope="col">Nom</th>
                        <th scope="col">Adresse</th>
                        <th scope="col">Téléphone</th>
                        <th scope="col">Modifier</th>
                        <th scope="col">Supprimer</th>
                    </tr>
                </thead>
                <s:iterator value="listEmployees" var="employe">
                    <tr>
                        <th scope="row"><s:property value="#employe.idPersonne" /></td>
                        <td><s:property value="#employe.mail" /></td>
                        <td><s:if test="#employe.isAdmin == 1">Oui</s:if>
                            <s:if test="#employe.isAdmin == 0">Non</s:if></td>
                        <td><s:property value="#employe.prenom" /></td>
                        <td><s:property value="#employe.nom" /></td>
                        <td><s:property value="#employe.adresse" /></td>
                        <td><s:property value="#employe.telephone" /></td>
                        <td>
                            <s:url var="editURL" action="editEmployeLink">
                                <s:param name="id" value="#employe.idPersonne"></s:param>
                            </s:url>
                            <s:a href="%{editURL}"><i class="material-icons">mode_edit</i></s:a>
                        </td>
                        <td>
                            <s:url var="deleteURL" action="deleteEmploye">
                                <s:param name="id" value="#employe.idPersonne"></s:param>
                            </s:url>
                            <s:a href="%{deleteURL}" onclick="return confirm('Etes-vous sûr de vouloir supprimer cet utilisateur ?')"><i class="material-icons">delete_forever</i></s:a>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </div>

        <%@ include file="template/footer.jsp" %>
    </body>
</html>
