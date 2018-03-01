<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <%@ include file="template/head.jsp" %>
    </head>

    <s:if test="user == null">
        <body class="bg-dark">
            <div class="container py-5">
                <div class="row">
                    <div class="col-md-12">
                        <h2 class="text-center text-white mb-4">Atelier mécanique</h2>
                        <div class="row">
                            <div class="col-md-6 mx-auto">

                                <!-- form card login -->
                                <div class="card rounded-0">
                                    <div class="card-header">
                                        <h3 class="mb-0">Connexion</h3>
                                    </div>
                                    <div class="card-body">
                                        <s:actionerror />
                                        <s:fielderror />
                                        <s:form action="login" class="form">
                                            <div class="form-group">
                                                <label for="uname1">Identifiant (email)</label>
                                                <s:textfield class="form-control form-control-lg rounded-0" name="user.mail" id="uname1" required=""/>
                                                <div class="invalid-feedback">Oops, you missed this one.</div>
                                            </div>
                                            <div class="form-group">
                                                <label for="pwd1">Mot de passe</label>
                                                <s:password class="form-control form-control-lg rounded-0" name="user.password" id="pwd1" required=""/>
                                                <div class="invalid-feedback">Enter your password too!</div>
                                            </div>
                                            <s:submit class="btn btn-success btn-lg float-right" value="Connexion"/>
                                        </s:form>
                                    </div>
                                    <!--/card-block-->
                                </div>
                                <!-- /form card login -->

                            </div>


                        </div>
                        <!--/row-->

                    </div>
                    <!--/col-->
                </div>
                <!--/row-->
            </div>
            <!--/container-->
        </body>
    </s:if>
    <s:else>
        <body>
            <%@ include file="template/nav.jsp" %>
            
            <div class="container body-content form-horizontal well">
                <b>Bienvenue, <s:property value="%{#attr['prenom']}"/> <s:property value="%{#attr['nom']}"/></b>
            </div>
            
            <%@ include file="template/footer.jsp" %>
        </body>
    </s:else>
</html>
