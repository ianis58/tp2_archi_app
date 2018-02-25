<%-- 
    Document   : footer
    Created on : 24 févr. 2018, 18:22:38
    Author     : almes
--%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<%!Calendar calendar = new GregorianCalendar();%>
<%! int Annee = calendar.get(Calendar.YEAR); %>
<hr />
<div id="footer" style="background-color:#0B5AA1">
    <div class="container" >
        <p class="footer-block" style="color:white">&copy; <%= Annee%> - Atelier Mécanique</p>
    </div>
</div>

