var app=angular.module("mymodule",[]);
app.controller("myctrl",["$scope","$http","customerService",function(scope,http,customerservice) {
	alert("hiiiii");
	scope.fname;
	scope.lname;
	scope.mobile;
	scope.password;
	scope.languages=["Hindi","English","Odia"];
	scope.states=["Odisha","Telengana","AndhraPradesh","Banglore"];
	scope.submit=function(){
		alert(scope.selectedlang);
		alert(scope.fname);
		alert(scope.lname);
		alert(scope.mobile);
		alert(scope.password);
		alert(scope.selectestate);
		customerservice.saveCustomer(function(r){
			scope.message=r;
		},scope.selectedlang,scope.fname,scope.lname,scope.mobile,scope.password,scope.selectestate);
	}
	
	
}])

app.service("customerService",["$http",function($http) {
	alert("Save customer");
this.saveCustomer=function(cb,lang,fname,lname,mobile,password,selectestate){
	alert("first name"+fname);
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
	var req = {
			 method: 'GET',
			 url: 'addUser.htm',
			 params:{fname: fname}
			}

			$http(req).then(function(response){cb(response.data)}, function(){alert("Eror occured")});
	
	
	//return emparry;
	
}	
	
}])




app.directive("formDirective",function(){
	
	return{
		templateUrl:"resources/assets/formDirective.html"
	}
})
