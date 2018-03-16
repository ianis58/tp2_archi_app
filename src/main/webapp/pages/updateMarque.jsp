<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <%@ include file="template/head.jsp" %>
        <script type="text/javascript">  
             
            function goBack(){  
            <!--pour le bouton de retour !-->  
             window.open("marqueCRUD","_self"); 
            }  
            
        </script>  
    </head>
    <body>
        <%@ include file="template/nav.jsp" %>

        <div class="container body-content form-horizontal well">
            <h1>Modifier la Marque</h1>
                <div class="row">
                <div class="col-md-10 mx-auto">
                    <s:actionerror/>
                    <s:form action="updateMarque" method="post" class="form">
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label for="nom">Nom</label>
                                <s:textfield name="mar.libelleMarque" id="nom" value="%{#parameters.nom}" class="form-control form-control-sm rounded-0"/>
                            </div>
                            <s:hidden name="mar.idMarque" value="%{#parameters.id}" label="Primary Key" />
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

