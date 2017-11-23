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
  <button class="btn btn-danger" ng-click="showallusers()">Show All Customer</button>
  <button class="btn btn-success" onclick="location.href='views/editUser.jsp';">Edit Customer</button>
  <button class="btn btn-warning" onclick="location.href='views/searchUser.jsp';">Search Customer</button>
  <button class="btn btn-danger" onclick="location.href='views/deleteUser.jsp';">Delete Customer</button>
  </div>
 <!--  <div form-directive ng-if="show"></div> -->
  <div total-user-table ng-if="totalusesrdirective"></div>
  
  <div ng-show="show" class="container" style=" position: absolute; top: 191px;left: 366px;">
                <form>
                    <div class="form-group">
                        <label for="usr">First name:</label>
                        <input type="text" class="form-control" style="width: 50%;" ng-model="fname">
                    </div>
                    <div class="form-group">
                        <label for="usr">Last Name:</label>
                        <input type="text" class="form-control" style="width: 50%;" ng-model="lname">
                    </div>
                    <div class="form-group">
                        <label for="usr">MobileNo:</label>
                        <input type="text" class="form-control" style="width: 50%;" ng-model="mobile">
                    </div>
                    <div class="form-group">
                        <label for="pwd">Email:</label>
                        <input type="text" style="width: 50%;" class="form-control" ng-model="email">
                    </div>
                     <div class="form-group">
                        <label for="pwd">Password:</label>
                        <input type="password" style="width: 50%;" class="form-control" ng-model="password">
                    </div>
                     <div class="form-group">
                        <label for="pwd">Zip:</label>
                        <input type="text" style="width: 50%;" class="form-control" ng-model="zip">
                    </div>
                    
                    <div ng-repeat="language in languages">

                        <div>
                            <label>
                                <input ng-model="$parent.selectedlang" value="{{language}}" name="languageradiobtn" type="radio"> <span> {{language}} </span>

                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-05">
                            <label for="sel1">Select State:</label>
                            <select name="singleSelect" id="singleSelect" style="width: 25%;" class="form-control" ng-model="selectestate">
                                <option value="">---Please select---</option>
                                <option ng-repeat="state in states" value="{{state}}">{{state}}</option>
                            </select>
                        </div>
                    </div>
                    <button class="btn btn-success" ng-click="submit()">Submit</button>
                </form>
                
            </div>
  
 
</div>
</body>
</html>
