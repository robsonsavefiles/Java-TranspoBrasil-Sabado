angular.module("projetos")
        .controller("usuariosListaController", ["$scope", "UsuariosService", "$state",
            function ($scope, UsuariosService, $state) {
                this.inicializar = function () {
                    $scope.$emit("mudarTituloSubtitulo", "Usuarios", "Lista");
                    UsuariosService.buscarTodos();
                };

                $scope.irParaNovo = function () {
                    $state.go("usuarios.novo");
                };

                $scope.irParaDetalhes = function (usuario) {
                    $state.go("usuarios.detalhes", {"id": usuario.id});
                };

                $scope.irParaEditar = function (usuario) {
                    $state.go("usuarios.editar", {"id": usuario.id});
                };

                $scope.remover = function (usuario) {
                    UsuariosService.remover(usuario);
                };

                $scope.$on("usuariosServiceBuscarTodosSucesso", function (event, usuarios) {
                    $scope.usuarios = usuarios;
                });

                $scope.$on("usuariosServiceBuscarTodosFalha", function (event, erro) {
                    alert("Falha ao carregar os usuarios!");
                });

                $scope.$on("usuariosServiceRemoverSucesso", function (event, usuarioRemovido) {
                    var item = null;
                    angular.forEach($scope.usuarios, function (usuario) {
                        if (usuario.id === usuarioRemovido.id) {
                            item = usuario;
                        }
                    });
                    var index = $scope.usuarios.indexOf(item);
                    if (index > -1) {
                        $scope.usuarios.splice(index, 1);
                    }
                });

                $scope.$on("usuariosServiceRemoverFalha", function (event, erro) {
                    alert("Falha ao remover o usuario!");
                });

                $scope.$on("navegacaoNovo", function (event) {
                    $scope.irParaNovo();
                });

                this.inicializar();
            }]);