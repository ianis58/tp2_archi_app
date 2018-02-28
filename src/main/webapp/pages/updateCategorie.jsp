<%-- 
    Document   : updateCategorie
    Created on : 27 févr. 2018, 20:44:35
    Author     : almes
--%>

<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <%@ include file="template/head.jsp" %>
        <script type="text/javascript">  
             
            function goBack(){  
            <!--pour le bouton de retour !-->  
             window.open("categorieCRUD","_self"); 
            }  
            
        </script>  
    </head>
    <body>
        <%@ include file="template/nav.jsp" %>

        <div class="container body-content form-horizontal well">
            <h1>Modifier la Catégorie</h1>  
  
            <s:actionerror/>   
            <s:form action="updateCategorie" method="post"  style="align:center">  
                <s:textfield name="cat.nom" label="Nom" value="%{#parameters.nom}"/>
                <s:hidden name="cat.idCategorie" value="%{#parameters.id}" label="Primary Key" />
                <s:submit value="Modifier" align="center"/>  
                <input type="button" value="Retour" onclick="goBack()"/>
            </s:form> 
        </div>

        <%@ include file="template/footer.jsp" %>
    </body>
</html>
