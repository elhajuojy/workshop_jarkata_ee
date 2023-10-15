
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String error = (String) request.getAttribute("error")== null ? "" : (String) request.getAttribute("error");
%>
<html>
<head>

    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<!-- Responsive navbar-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <a class="navbar-brand" href="#"> YOUCODE - JAVA VENTURES </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#">LOGIN</a></li>
        <li class="nav-item"><a class="nav-link" href="#">REGISTER </a></li>
      </ul>
    </div>
  </div>
</nav>
<!-- Page content-->
<div class="container">
  <div class="text-center mt-5">
    <h1>Workshop Jakrta ee and hibernate </h1>
  </div>
</div>
<div>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-4">
        <form action="user-servlet" method="post">
          <h2 class="mb-3">Login</h2>
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" required>
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="Enter your password" required>
          </div>
          <button type="submit" class="btn btn-primary mt-3 btn-block">Login</button>
        </form>
        <div>
            <p class="text-danger mt-3">
                <%= error %>
            </p>
        </div>
      </div>
    </div>
  </div>

</div>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</body>
</html>
