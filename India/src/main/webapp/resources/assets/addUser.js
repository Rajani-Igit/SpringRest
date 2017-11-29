var app = angular.module("mymodule", []);
app.config(['$httpProvider',
    function($httpProvider) {
        $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8';
    }
]);
app.controller("myctrl", ["$scope", "$http", "$log", "customerService", "$timeout",
    function(scope, http, customerservice, log, $timeout) {
	 var count=1;
	scope.attribute="";
        scope.searchshow = false;
        scope.fname = "";
        scope.lname = "";
        scope.mobile = "";
        scope.password = "";
        scope.selectestate = "";
        scope.zip = "";
        scope.email = "";
        scope.showsuccessmessage = false;
        scope.show = false;
        scope.editshowhide = false;
        scope.genders = ["Male", "Female"];
        //scope.states = [ "Odisha", "Telengana", "AndhraPradesh", "Banglore" ];

        
        http.get("selectlist.do")
            .then(function(response) {
                //First function handles success
                scope.states = response.data;
            }, function(response) {
                //Second function handles error
                // $scope.content = "Something went wrong";
                alert("Content not loaded properly");
            });


//By clicking Search button this function will call
        scope.search = function() {
            scope.searchattribute="";
            scope.searchshow = true;
            scope.show = false;
            scope.totalusesrdirective=false;
            count=1;
        }

 // By clicking addUser button this function will called
        scope.adduserdata = function() {
        	count=1;
            scope.fname = "";
            scope.lname = "";
            scope.mobile = "";
            scope.password = "";
            scope.selectestate = "";
            scope.zip = "";
            scope.email = "";
            scope.totalusesrdirective = false;
            scope.show = true;
            scope.searchshow = false;
            

        }

        
        
        //Submitting Search user this function will be called
        scope.searchuser = function(searchattribute) {
            http.get('finduser.do', {
                params: {
                    email: searchattribute
                }
            }).then(function(success) {
                scope.show = true;
                console.log(success.data);
                scope.fname = success.data.fName;
                scope.lname = success.data.lName;
                scope.mobile = success.data.mobile;
                scope.selectestate = success.data.state;
                //scope.selectestate="Odisha";
                scope.selectedlang = success.data.gender;
                scope.zip = success.data.zip;
                scope.email = success.data.email;
                scope.show = true;
                scope.searchshow = false;

            }, function(error) {
            	 scope.show = false;
            	  scope.showsuccessmessage = true;
            	  console.log(error);
            	 scope.successmessage = error.data.message;
                 $timeout(function() {
                     scope.showsuccessmessage = false;
                 }, 9000);
            	console.log(error);
            });
        }


//By clicking show alluser this function will be called
        scope.showallusers = function() {
            scope.searchshow = false;
            alert("Allusers");
            http.get("getallusers.do",{ params:{pageno:count,pageSize:2}}).then(function(response) {
                    scope.users = response.data;
                    console.log(scope.users);
                    console.log(response);
                    scope.show = false;
                    scope.editshowhide = false;
                    scope.totalusesrdirective = true;
                }, function(response) {
                    alert("Content not loaded properly");
                });

        }

//By clicking delete usesr this function will be called
        scope.remove = function(emailid) {
            var data = 'email=' + emailid;
            http.post('deleterecordbyemail.do', data)
                .then(function(success) {
                    scope.show = false;
                    scope.showsuccessmessage = true;
                    scope.successmessage = success.data;
                    scope.showallusers();
                    $timeout(function() {
                        scope.showsuccessmessage = false;
                    }, 9000);

                    console.log(success);

                }, function(error) {

                });
        }

//By submiting addUser form this function will be called
        scope.submit = function() {
            scope.searchshow = false;
            alert(scope.selectedlang);
            var data = {
                "email": scope.email,
                "fName": scope.fname,
                "gender": scope.selectedlang,
                "lName": scope.lname,
                "mobile": scope.mobile,
                "password": scope.password,
                "state": scope.selectestate,
                "zip": scope.zip,

            }

            http.post("add.do", data, {
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(function(success) {
                    alert("data......");
                    scope.show = false;
                    scope.showsuccessmessage = true;
                    scope.successmessage = success.data;
                    $timeout(function() {
                        scope.showsuccessmessage = false;
                    }, 9000);
                    console.log(success);

                }, function(error) {
                	alert("inside error");
                	console.log(error);
                	scope.successmessage = error.data.message;
                	scope.showsuccessmessage = true;
                	 $timeout(function() {
                         scope.showsuccessmessage = false;
                     }, 9000);
                });
        }

        scope.dummy=function(){
        	 var data = {
                     "email": "jajani769",
                     "fName": "Rajani",
                     "gender":"Male",
                     "lName": "Pradhan",
                     "mobile": "8895247580",
                     "password": "1234",
                     "state": "Odisha",
                     "zip": "761126",

                 }
        	alert(" This is the dummy function For Testing");
        	http({
   			 method: 'POST',
   			 url: 'dummy.do',
   			 params:{fname: "Rajanikant"},
   			 headers: {
                 'Content-Type': 'application/x-www-form-urlencoded'
             }
   			}).then(function(response){alert("Success")}, function(){alert("Eror occured")});
        }
        
        scope.fetchNextPage=function(){
        	count++;
        	alert(count);
        	scope.showallusers();
        }
        
    }
])

//Custom service  i have not implemented
app.service("customerService", ["$http",
    function(http) {
        this.saveCustomer = function(cb, lang, fname, lname, mobile, password, selectestate, email, zip) {
           // alert("first name" + fname);
            /*var emparry=[];
	var emp={};
	emp["name"]="Rajanikanta";
	emp["age"]=25;
	emp["organization"]="IBM";
	emp["salary"]=56000;
	
	var emp1={};
	
	emp1["name"]="SaiRam";
	emp1["age"]=25;
	emp1["organization"]="TCS";
	emp1["salary"]=36000;
	
var emp2={};
	
	emp2["name"]="Akshya Nalmwar";
	emp2["age"]=26;
	emp2["organization"]="Appstek";
	emp2["salary"]=6000;
	
	
var emp3={};
	
	emp3["name"]="Akshya Nalmwar";
	emp3["age"]=26;
	emp3["organization"]="Appstek";
	emp3["salary"]=6000;
	

	emparry.push(emp);
	emparry.push(emp1);
	emparry.push(emp2);
	emparry.push(emp3);
*/
            /*var req = {
			 method: 'GET',
			 url: 'addUser.htm',
			 params:{fname: fname}
			}

			$http(req).then(function(response){cb(response.data)}, function(){alert("Eror occured")});
	
	
	//return emparry;
*/
        }

    }
])




app.directive("formDirective", function() {

    return {
        templateUrl: "resources/assets/formDirective.html"

    }
})


app.directive("totalUserTable", function() {

    return {
        templateUrl: "resources/assets/totalUserTable.html",
        link: function(scope) {
            scope.clickFunc = function(email) {
                scope.remove(email);
            };
        }
    }
})