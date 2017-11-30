<html ng-app="mymodule">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script src="resources/assets/jquery-3.2.1.min.js">
        </script>
        <script src="resources/assets/js/framework/jquery-1.12.0.min.js"></script>
        <script src="resources/assets/js/framework/angular.js"></script>
        <script src="resources/assets/js/addUser.js"></script>
       <script src="resources/assets/js/framework/alasql.min.js"></script>
 <script src="resources/assets/js/framework/excl.js"></script>
 <script src="resources/assets/js/framework/xlsx.core.min.js"></script>
 <script src="resources/assets/js/framework/Blob.js"></script>
      <!--  <script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.11.10/xlsx.js"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/alasql/0.4.3/alasql.min.js"></script> -->
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
  <button class="btn btn-warning" ng-click="search()">Search User</button>
  </div>
 <div ng-show="showsuccessmessage" style="
    position: absolute;
    left: 546px;
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
                
                
   <div ng-show="loadingshow">
  <img src="resources/assets/images/ajax-loader.gif" id="loadingImage"  style="display: block;margin: 0px auto;position: absolute;top: 189px;left: 596px;">
</div>       
  
 
</div>
</body>
</html>
