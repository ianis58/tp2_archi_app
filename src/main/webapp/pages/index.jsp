<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
  <%@ include file="template/header.jsp"%>
  <body>
    <%@ include file="template/menu.jsp"%>
    
    <div class="container body-content form-horizontal well">
        <s:actionerror/>
        <s:form action="login">
            <s:textfield name="user.mail" label="Name"/>
            <s:password name="user.password" label="Password"/>
            <s:submit value="Login"/>
        </s:form>
    </div>
    
    <%@ include file="template/footer.jsp"%>
  </body>
</html>
