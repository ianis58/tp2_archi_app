<%-- 
    Document   : categorieCRUD
    Created on : 27 févr. 2018, 17:11:01
    Author     : almes
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
            <h1>Categorie Manager</h1>  
  
            <s:actionerror/>   
            <s:form action="addCategorie" method="post"  style="align:  
                    center">  
                <s:textfield name="cat.nom" label="Nom"/>  
                <s:submit value="Add Categorie" align="center"/>  
            </s:form>  

             <%  
            int count = 0;   


            %>  
            
        </div>

        <%@ include file="template/footer.jsp" %>
    </body>
</html>