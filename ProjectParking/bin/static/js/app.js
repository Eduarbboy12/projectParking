var app = angular.module('myApp', [ 'ngResource' ]);

app.controller(
		'UserController',
		[
				'$scope',
				'$resource',
				function($scope, $resource) {

					function fetchAllUser() {
						$scope.users = $resource('http://localhost:8080/user')
								.query(function(data) {
									return data;
								});
					};

					fetchAllUser();

					$scope.refresh = function() {
						fetchAllUser();
					};

					$scope.create = function() {
						User = $resource("http://localhost:8080/create", {}, {
							save : {
								method : 'PUT',
								isArray : false
							}
						});

						var user = {};

						user.id = $scope.userForm.id;
						user.nombre = $scope.userForm.nombre;
						user.apellido = $scope.userForm.apellido;
						user.documento = $scope.userForm.documento;
						user.telefono = $scope.userForm.telefono;
						user.direccion = $scope.userForm.direccion;
						user.mail = $scope.userForm.mail;
						user.clave = $scope.userForm.clave;
						user.confirmPassword = "";

						$scope.Message = User.save(user);

						$scope.userForm.Id = "";
						$scope.userForm.Nombre = "";
						$scope.userForm.Apellido = "";
						$scope.userForm.Documento = "";
						$scope.userForm.Telefono = "";
						$scope.userForm.Direccion = "";
						$scope.userForm.Mail = "";
						$scope.userForm.Clave = "";
					};
					
					$scope.deleteRec = function(){
				    	User = $resource(
				    		    "http://localhost:8080/delete/:id",
				    		    {},
				    		    {save: {method:'DELETE', params: {id: '@id'}}}
				    	);
				    	
							
						User.delete({id: $scope.personForm.id}).then(function successCallback(response) {
							$scope.Message = response;
						}, function errorCallback(response) {
						    
						});
								
						$scope.personForm.id = "";
						$scope.personForm.name="";
						$scope.personForm.mobile="";
						$scope.personForm.password="";
						$scope.personForm.email="";
				    };

					$scope.update = function() {

						User = $resource("http://localhost:8080/update/:id",
								{}, {
									save : {
										method : 'PUT',
										params : {
											id : '@id'
										}
									}
								});

						var user = {};

						user.Id = $scope.userForm.Id;
						user.Nombre = $scope.userForm.Nombre;
						user.Apellido = $scope.userForm.Apellido;
						user.Documento = $scope.userForm.Documento;
						user.Telefono = $scope.userForm.Telefono;
						user.Direccion = $scope.userForm.Direccion;
						user.Mail = $scope.userForm.Mail;
						user.Clave = $scope.userForm.Clave;
						user.confirmPassword = "";

						$scope.Message = User.save({id : $scope.userForm.Id}, user);

						$scope.userForm.Id = "";
						$scope.userForm.Nombre = "";
						$scope.userForm.Apellido = "";
						$scope.userForm.Telefono = "";
						$scope.userForm.Direccion = "";
						$scope.userForm.Mail = "";
						$scope.userForm.Clave = "";
					};

				} ])

.controller('LoginController',
		[ '$scope', '$resource', '$http', function($scope, $resource, $http) {

			$scope.login = function() {

				var login = {};

				login.correo = $scope.logForm.correo;

				if (login.correo !== undefined) {						
						$scope.Message = $http.get("http://localhost:8080/get-by-email/" + login.correo)
					    .then(function(response) {
					        $scope.response = response.data;
					        if($scope.response.mail !== undefined){
					        	window.location.href = "./views/main/main.html";
					        } else {
					        	$scope.Message = "El campo Correo Electrónico incorrecto";
					        }
					    });						
				} else {
					$scope.Message = "El campo Correo Electrónico es obligatorio";
				}

			};

		} ]);
