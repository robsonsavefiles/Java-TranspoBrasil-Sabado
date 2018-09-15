angular.module("projetos")
        .controller("projetosCadastroController", ["$scope", "ProjetosService", "$state", "$stateParams",
            function ($scope, ProjetosService, $state, $stateParams) {
                var self = this;

                this.inicializar = function () {
                    $scope.projeto = {};
                    if ($stateParams.id) {
                        self.carregarItem($stateParams.id);
                        if ($state.includes("projetos.detalhes")) {
                            $scope.$emit("mudarTituloSubtitulo", "Projetos", "Detalhes");
                        } else {
                            $scope.$emit("mudarTituloSubtitulo", "Projetos", "Edição");
                            $scope.edicao = true;
                        }
                    } else {
                        $scope.$emit("mudarTituloSubtitulo", "Projetos", "Novo");
                    }
                };

                this.carregarItem = function (id) {
                    ProjetosService.buscar(id).then(
                            function (response) {
                                $scope.projeto = response.data;
                            },
                            function (error) {
                                alert("Não foi possível carregar o projeto!");
                            });
                };

                this.irParaLista = function () {
                    $state.go("projetos.lista");
                };

                this.mostrarMensagemErro = function () {
                    alert("Não foi possível salvar o projeto!");
                };

                $scope.salvar = function (item) {
                    if (item.id) {
                        ProjetosService.editar(item);
                    } else {
                        ProjetosService.incluir(item);
                    }
                };

                $scope.$on("projetosServiceIncluirSucesso", function (event, projeto) {
                    self.irParaLista();
                });

                $scope.$on("projetosServiceIncluirFalha", function (event, erro) {
                    self.mostrarMensagemErro();
                });

                $scope.$on("projetosServiceEditarSucesso", function (event, projeto) {
                    self.irParaLista();
                });

                $scope.$on("projetosServiceEditarFalha", function (event, erro) {
                    self.mostrarMensagemErro();
                });

                $scope.$on("navegacaoLista", function (event) {
                    self.irParaLista();
                });


                this.inicializar();
            }]);