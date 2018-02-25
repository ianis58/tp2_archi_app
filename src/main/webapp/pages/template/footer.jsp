<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>

<%!Calendar calendar = new GregorianCalendar();%>
<%! int Annee = calendar.get(Calendar.YEAR); %>

<footer class="footer">
    <div class="container">
        <span class="text-muted">&copy; <%= Annee%> - Atelier Mécanique</span>
    </div>
</footer>
