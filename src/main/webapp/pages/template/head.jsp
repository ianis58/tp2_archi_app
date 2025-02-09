<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<link rel="icon" href="images/favicon.ico">

<title>Atelier M�canique</title>

<!--bootstrap 4 stylesheet-->
<!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">

<!--material icons, see https://material.io/icons/ to find an icon-->
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

<!--bootstrap 4 js dependencies (jquery.slim.min.js, popper.min.js, bootstrap.min.js)-->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<!--our stylesheets-->
<link rel="stylesheet" href="css/style.css">

<!--our scripts-->
<script src="js/script.js"></script>

<% 
    if(session.getAttribute("nom") == null && 
            !request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1).equals("")
            && !request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1).equals("index.jsp")){
        //System.out.println(request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1));
        response.sendRedirect("login");
        
    } %>
