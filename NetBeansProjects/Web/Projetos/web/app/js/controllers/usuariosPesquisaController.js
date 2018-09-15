angular.module("projetos")
        .controller("usuariosPesquisaController", ["$scope", "UsuariosService", function ($scope, UsuariosService) {
                this.inicializar = function () {
                    $scope.usuarios = [];
                    UsuariosService.buscarTodos();
                };

                $scope.selecionar = function (usuario) {
                    $scope.$emit("usuarioSelecionado", usuario);
                };

                $scope.$on("usuariosServiceBuscarTodosSucesso", function (event, usuarios) {
                    $scope.usuarios = usuarios;
                });

                $scope.$on("usuariosServiceBuscarTodosFalha", function (event, erro) {
                    alert("Não foi possível carregar os usuarios!");
                });

                this.inicializar();
            }]);