<html>
<!-- index.jsp  -->
<head>
        <title>Feed Administration</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <!-- Font-Awesome -->
        <link href="css/bootstrap-theme.min.css" rel="stylesheet">
        <!-- My style -->
        <link href="css/style.css" rel="stylesheet" media="screen">
    </head>
<body>
<% final String URL="getinfo.html"; %>
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Feed Administration</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="<%=URL%>">GetInfo</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">

      <div class="starter-template">
        <h1>Accueil</h1>
        <p class="lead">Cliquer <a href="<%=URL%>">Tester l'environnement Spring MVC</a></p>
      </div>

    </div><!-- /.container -->
</body>
<footer>
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </footer>
</html>