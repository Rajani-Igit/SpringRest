<html ng-app="mymodule">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script src="resources/assets/jquery-3.2.1.min.js">
        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="resources/assets/angular.js"></script>
        <script src="resources/assets/addUser.js"></script>
        <script>
            $(document).ready(function() {
                alert("Jquery worked");
            });
        </script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Add Usesr</title>
    </head>
<body ng-controller="myctrl">
<div class="container">
<div class="row">
  <h1 style="font-style: oblique;
    margin-left: 351px;">Welcome to Curd operation</h1>
    
  </div>
  <div style="
    margin-top: 54px;
    margin-left: 305px;">
  <button class="btn btn-primary" ng-click="adduserdata()">Add Customer</button>
  <button class="btn btn-success" onclick="location.href='views/editUser.jsp';">Edit Customer</button>
  <button class="btn btn-warning" onclick="location.href='views/searchUser.jsp';">Search Customer</button>
  <button class="btn btn-danger" onclick="location.href='views/deleteUser.jsp';">Delete Customer</button>
  </div>
  <div form-directive ng-if="show"></div>
 
</div>
</body>
</html>
