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
  <button class="btn btn-primary" ng-click="adduserdata()">Add User</button>
  <button class="btn btn-danger" ng-click="showallusers()">Show All Users</button>
  <button class="btn btn-success" ng-click="fetchNextPage()">Next Page</button>
  <button class="btn btn-warning" ng-click="search()">Search User</button>
  <button class="btn btn-danger" ng-click="dummy()">Delete User</button>
  </div>
 <div ng-show="showsuccessmessage" style="
    position: absolute;
    left: 625px;
    top: 74px;
    font-size: large;
    font-family: sans-serif;
    font-style: italic;
    color: red;
">{{successmessage}}</div> 
  <div total-user-table ng-if="totalusesrdirective"></div>
  
  <div ng-show="searchshow" class="container" style=" position: absolute; top: 191px;left: 366px;">
               <form>
                    <div class="form-group">
                        <label for="usr">Search:</label>
                        <input type="text"  placeholder="Search By Email id" class="form-control" style="width: 50%;" ng-model="searchattribute">
                    </div>
                     <button class="btn btn-success" ng-click="searchuser(searchattribute)">Submit</button>
                    </form>
                    </div>
  <div  form-directive  ng-show="show">
                
                
          
  
 
</div>
</body>
</html>
