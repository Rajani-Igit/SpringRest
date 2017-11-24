var app = angular.module("mymodule", []);
app.controller("myctrl", [ "$scope", "$http", "$log", "customerService", function(scope, http, customerservice, log) {
	

	scope.fname="";
	scope.lname="";
	scope.mobile="";
	scope.password="";
	scope.selectestate="";
	scope.zip="";
	scope.email="";
	
	scope.show = false;
	scope.editshowhide = false;
	scope.languages = [ "Hindi", "English", "Odia" ];
	scope.states = [ "Odisha", "Telengana", "AndhraPradesh", "Banglore" ];

	http.get("selectlist.do")
		.then(function(response) {
			//First function handles success
			scope.states = response.data;
			alert(scope.states);
		}, function(response) {
			//Second function handles error
			// $scope.content = "Something went wrong";
			alert("Content not loaded properly");
		});

	scope.showallusers = function() {
		alert("Allusers");
		http.get("getallusers.do")
			.then(function(response) {
				//First function handles success
				scope.users = response.data;
				console.log(scope.users);
				console.log(response);
				scope.show = false;
				scope.editshowhide = false;
				scope.totalusesrdirective = true;

			}, function(response) {
				//Second function handles error
				// $scope.content = "Something went wrong";
				alert("Content not loaded properly");
			});

	}


	scope.submit = function() {
		alert("Submit");
		alert(scope.selectedlang);
		alert(scope.fname);
		alert(scope.lname);
		alert(scope.mobile);
		alert(scope.password);
		alert(scope.selectestate);
		alert(scope.zip);
		alert(scope.email);
		
		 var data={
					"email":scope.email,
					"fName":scope.fname,
					"gender":scope.selectedlang,
					"lName":scope.lname,
					"mobile":scope.mobile,
					"password":scope.password,
					 "state":scope.selectestate,
					 "zip":scope.zip,

					}

					http.post("add.do", data)
						.then(function(success) {
							alert("data......");
							scope.show = false;
							console.log(success);
							
						}, function(error) {
							
						});




	
	}

	scope.adduserdata = function() {
		alert("inside userdatasssss");
		scope.totalusesrdirective = false;
		scope.show = true;

	}


} ])

app.service("customerService", [ "$http", function(http) {
	alert("Save customer");
	this.saveCustomer = function(cb, lang, fname, lname, mobile, password, selectestate,email,zip) {
		alert("first name" + fname);
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

} ])




app.directive("formDirective", function() {

	return {
		templateUrl : "resources/assets/formDirective.html"
	}
})


app.directive("totalUserTable", function() {

	return {
		templateUrl : "resources/assets/totalUserTable.html"
	}
})