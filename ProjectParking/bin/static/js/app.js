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
					}
					;

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
		[ '$scope', '$resource', function($scope, $resource) {

			$scope.login = function() {

				var login = {};

				User = $resource("http://localhost:8080/get-by-email/:mail", {}, {
					findByEmail : {
						method : 'GET',
						isArray : false,
						params : {
							mail : '@mail'
						}
					}
				});

				login.correo = $scope.logForm.correo;
				login.clave = $scope.logForm.clave;

				if (login.correo !== undefined) {
					if(login.clave !== undefined){
						
						$scope.Message = User.findByEmail({mail : login.correo});
						
					} else {
						$scope.Message = "El campo Contraseña es obligatorio";
					}
				} else {
					$scope.Message = "El campo Correo Electrónico es obligatorio";
				}

			};

		} ]);
