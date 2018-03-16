<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <%@ include file="template/head.jsp" %>
        <script type="text/javascript">  
             
            function goBack(){  
            <!--pour le bouton de retour !-->  
             window.open("vehiculeCRUD","_self"); 
            }  
            
        </script>  
    </head>
    <body>
        <%@ include file="template/nav.jsp" %>

        <div class="container body-content form-horizontal well">
            <h1>Modifier le Véhicule</h1>
            <div class="row">
                <div class="col-md-10 mx-auto">
                    <s:actionerror/>
                    <s:form action="updateVehicule" method="post" class="form">
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label for="libelleVehicule">Nom du véhicule</label>
                                <s:textfield name="vehicule.libelleVehicule" id="libelleVehicule" class="form-control form-control-sm rounded-0"/>
                            </div>
                        </div>
 
                        <div class="form-group col-md-6">
                            <s:select class="custom-select"
                                name="marqueId"
                                list="listAllMarques"
                                listKey="idMarque"
                                listValue="libelleMarque"
                                size="10"
                                value="marqueId"
                                required="true"
                            />
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
