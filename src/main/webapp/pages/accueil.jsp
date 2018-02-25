<%-- 
    Document   : accueil
    Created on : 25 févr. 2018, 15:02:04
    Author     : almes
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
  <%@ include file="template/header.jsp"%>
  <body>
    <%@ include file="template/menu.jsp"%>
    
    <div class="container body-content form-horizontal well">
        <b>Welcome,<s:property value="user.nom"/></b>
    </div>
    
    <%@ include file="template/footer.jsp"%>
  </body>
</html>
