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
            <h1>Gestion des Marques</h1>
            
            <div class="row">
                <div class="col-md-10 mx-auto">
                    <s:actionerror/>
                    <s:form action="addMarque" method="post" class="form">
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="nom">Nom</label>
                                <s:textfield name="mar.libelleMarque" id="nom" class="form-control form-control-sm rounded-0"/>
                            </div>

                            <div class="form-group col-md-6">
                                <s:submit value="Ajouter marque" class="btn btn-success btn-lg float-right"/>
                            </div>
                        </div>
                    </s:form>
                </div>
            </div>

            <s:if test="listMarques.size() > 0">
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
                        <s:iterator value="listMarques" var="marque">
                        <tr>
                            <th scope="row"><s:property value="#marque.idMarque" /></td>
                            <td><s:property value="#marque.libelleMarque" /></td>
                            <td>
                                <s:url var="editURL" action="editMarqueLink">
                                    <s:param name="id" value="%{#marque.idMarque}"></s:param>
                                    <s:param name="nom" value="%{#marque.libelleMarque}"></s:param>
				</s:url>
                                <s:a href="%{editURL}"><i class="material-icons">mode_edit</i></s:a>
                            </td>
                            <td>
                                <s:url var="deleteURL" action="deleteMarque">
                                    <s:param name="id" value="%{#marque.idMarque}"></s:param>
				</s:url>
                                <s:a href="%{deleteURL}" onclick="return confirm('Etes-vous sûr de vouloir supprimer cette marque ?')"><i class="material-icons">delete_forever</i></s:a>
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
