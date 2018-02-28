<nav class="navbar navbar-expand-lg navbar-dark bg-primary navbar-atelier-meca">
    <a class="navbar-brand" href="index">Atelier Mécanique</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <!--add class "active" to make this item selected: <li class="nav-item active">-->
            <li class='nav-item <s:if test="action == \"managearticles\"">active</s:if>'>
                <a class="nav-link" href="#">Articles</a>
            </li>
            <li class='nav-item <s:if test="action == \"categorieCRUD\"">active</s:if>'>
                <a class="nav-link" href="categorieCRUD">Catégories</a>
            </li>
            <li class='nav-item <s:if test="action == \"managesouscategories\"">active</s:if>'>
                <a class="nav-link" href="managesouscategories">Sous catégories</a>
            </li>
            <li class='nav-item <s:if test="action == \"manageusers\"">active</s:if>'>
                <a class="nav-link" href="manageusers">Utilisateurs</a>
            </li>
            <li class='nav-item <s:if test="action == \"search\"">active</s:if>'>
                <a class="nav-link" href="#">Recherches</a>
            </li>
        </ul>
        <s:if test="!user.mail.isEmpty()">
            <span class="navbar-text">
                Bonjour,  <s:property value="user.prenom"/> <s:property value="user.nom"/>!
            </span>
        </s:if>
    </div>
</nav>
