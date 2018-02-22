var app = angular.module('myApp', [ 'ngResource' ]);

app.controller('UserController', ['$scope', '$resource', function($scope, $resource) {
	
					function fetchAllUser() {
						$scope.users = $resource('/user')
								.query(function(data) {
									return data;
								});
					};

					fetchAllUser();

					$scope.refresh = function() {
						fetchAllUser();
					};

					$scope.create = function() {
						User = $resource("/create", {}, {
							save : {
								method : 'PUT',
								isArray : false
							}
						});

						var user = {};

						user.id = $scope.userForm.id;
						user.name = $scope.userForm.name;
						user.lastname = $scope.userForm.lastname;
						user.document = $scope.userForm.document;
						user.user = $scope.userForm.user;

						$scope.Message = User.save(user);

						$scope.userForm.id = "";
						$scope.userForm.name = "";
						$scope.userForm.lastname = "";
						$scope.userForm.document = "";
						$scope.userForm.user = "";
					};
					
					$scope.deleteRec = function(){
				    	User = $resource(
				    		    "/delete/:id",
				    		    {},
				    		    {save: {method:'DELETE', params: {id: '@id'}}}
				    	);
				    	
							
						User.delete({id: $scope.personForm.id}).then(function successCallback(response) {
							$scope.Message = response;
						}, function errorCallback(response) {
						    
						});
								
						$scope.userForm.id = "";
						$scope.userForm.nombre = "";
						$scope.userForm.apellido = "";
						$scope.userForm.documento = "";
						$scope.userForm.user = "";
				    };

					$scope.update = function() {

						User = $resource("/update/:id",
								{}, {
									save : {
										method : 'PUT',
										params : {
											id : '@id'
										}
									}
								});

						var user = {};

						user.id = $scope.userForm.id;
						user.nombre = $scope.userForm.nombre;
						user.apellido = $scope.userForm.apellido;
						user.documento = $scope.userForm.documento;
						user.user = $scope.userForm.user;

						$scope.Message = User.save({id : $scope.userForm.Id}, user);

						$scope.userForm.id = "";
						$scope.userForm.nombre = "";
						$scope.userForm.apellido = "";
						$scope.userForm.documento = "";
						$scope.userForm.user = "";
					};

				} ])

.controller('LoginController',
		[ '$scope', '$resource', '$http', function($scope, $resource, $http) {

			$scope.login = function() {

				var login = {};

				login.correo = $scope.logForm.correo;
				console.log('prueba');
				if (login.correo !== undefined) {						
						$scope.Message = $http.get("/get-by-email/" + login.correo)
					    .then(function(response) {
					    	console.log('prueba');
					        $scope.response = response.data;
					        console.log($scope.response);
					        if($scope.response.user !== undefined){
					        	window.location.href = "./views/main/main.html";
					        } else {
					        	console.log('prueba');
					        	$scope.Message = "El campo Correo Electrónico es incorrecto sdkhfgskdhfg";
					        }
					    });						
				} else {
					$scope.Message = "El campo Correo Electrónico es obligatorio";
				}

			};

		} ])
		
.controller('MainController',['$scope', '$resource', function($scope, $resource) {
	
			function fetchAllVehicle() {
				$scope.vehicles = $resource('/vehicle')
						.query(function(data) {
							return data;
						});
			};
		
			fetchAllVehicle();
		
			$scope.refresh = function() {
				fetchAllVehicle();
			};
	

			$scope.create = function() {
				Vehicle = $resource("/createvehicle", {}, {
					save : {
						method : 'PUT',
						isArray : false
					}
				});

				var vehicle = {};
				
				vehicle.id = $scope.mainForm.id;
				vehicle.type = $scope.mainForm.type;
				vehicle.plaque = $scope.mainForm.plaque;
				vehicle.cylinder = $scope.mainForm.cylinder;
				vehicle.document = $scope.mainForm.document;

				$scope.Message = Vehicle.save(vehicle);

				$scope.mainForm.id = "";
				$scope.mainForm.type = "";
				$scope.mainForm.plaque = "";
				$scope.mainForm.cylinder = "";
				$scope.mainForm.document = "";
			};

		} ]);
