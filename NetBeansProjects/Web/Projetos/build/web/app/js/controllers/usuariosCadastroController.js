angular.module("projetos")
        .controller("usuariosCadastroController", ["$scope", "UsuariosService", "$state", "$stateParams",
            function ($scope, UsuariosService, $state, $stateParams) {
                var self = this;

                this.inicializar = function () {
                    $scope.usuario = {};
                    UsuariosService.buscarPermissoes();
                    if ($stateParams.id) {
                        self.carregarItem($stateParams.id);
                        if ($state.includes("usuarios.detalhes")) {
                            $scope.$emit("mudarTituloSubtitulo", "Usuarios", "Detalhes");
                        } else {
                            $scope.$emit("mudarTituloSubtitulo", "Usuarios", "Edição");
                        }
                    } else {
                        $scope.$emit("mudarTituloSubtitulo", "Usuarios", "Novo");
                    }
                };

                this.carregarItem = function (id) {
                    UsuariosService.buscar(id).then(
                            function (response) {
                                $scope.usuario = response.data;
                            },
                            function (error) {
                                alert("Não foi possível carregar o usuario!");
                            });
                };

                this.irParaLista = function () {
                    $state.go("usuarios.lista");
                };

                this.mostrarMensagemErro = function () {
                    alert("Não foi possível salvar o usuario!");
                };

                $scope.salvar = function (item) {
                    if (item.id) {
                        UsuariosService.editar(item);
                    } else {
                        UsuariosService.incluir(item);
                    }
                };

                $scope.$on("usuariosServiceBuscarPermissoesSucesso", function (event, permissoes) {
                    $scope.permissoes = permissoes;
                });

                $scope.$on("usuariosServiceBuscarPermissoesFalha", function (event, erro) {
                    alert("Não foi possível carregar as permissões!");
                });

                $scope.$on("usuariosServiceIncluirSucesso", function (event, usuario) {
                    self.irParaLista();
                });

                $scope.$on("usuariosServiceIncluirFalha", function (event, erro) {
                    self.mostrarMensagemErro();
                });

                $scope.$on("usuariosServiceEditarSucesso", function (event, usuario) {
                    self.irParaLista();
                });

                $scope.$on("usuariosServiceEditarFalha", function (event, erro) {
                    self.mostrarMensagemErro();
                });

                $scope.$on("navegacaoLista", function (event) {
                    self.irParaLista();
                });


                this.inicializar();
            }]);