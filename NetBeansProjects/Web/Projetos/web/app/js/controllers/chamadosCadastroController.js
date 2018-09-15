angular.module("projetos")
        .controller("chamadosCadastroController", ["$scope", "ChamadosService", "ProjetosService", "$state", "$stateParams",
            function ($scope, ChamadosService, ProjetosService, $state, $stateParams) {
                var self = this;

                this.inicializar = function () {
                    $scope.chamado = {};
                    ChamadosService.buscarStatuses();
                    if ($stateParams.id) {
                        self.carregarItem($stateParams.id);
                        if ($state.includes("chamados.detalhes")) {
                            $scope.$emit("mudarTituloSubtitulo", "Chamados", "Detalhes");
                        } else {
                            $scope.$emit("mudarTituloSubtitulo", "Chamados", "Edição");
                            $scope.edicao = true;
                        }
                    } else {
                        $scope.$emit("mudarTituloSubtitulo", "Chamados", "Novo");
                    }
                    ProjetosService.buscarTodos();
                };

                this.carregarItem = function (id) {
                    ChamadosService.buscar(id).then(
                            function (response) {
                                $scope.chamado = response.data;
                            },
                            function (error) {
                                alert("Não foi possível carregar o chamado!");
                            });
                };

                this.irParaLista = function () {
                    $state.go("chamados.lista");
                };

                this.irParaNovo = function () {
                    $state.go("chamados.novo");
                };

                this.mostrarMensagemErro = function () {
                    alert("Não foi possível salvar o chamado!");
                };

                $scope.salvar = function (item) {
                    if (item.id) {
                        ChamadosService.editar(item);
                    } else {
                        ChamadosService.incluir(item);
                    }
                };

                $scope.$on("projetosServiceBuscarTodosSucesso", function (event, projetos) {
                    $scope.projetos = projetos;
                });

                $scope.$on("projetosServiceBuscarTodosFalha", function (event, erro) {
                    alert("Não foi possível carregar os projetos!");
                });

                $scope.$on("chamadosServiceIncluirSucesso", function (event, chamado) {
                    self.irParaLista();
                });

                $scope.$on("chamadosServiceIncluirFalha", function (event, erro) {
                    self.mostrarMensagemErro();
                });

                $scope.$on("chamadosServiceEditarSucesso", function (event, chamado) {
                    self.irParaLista();
                });

                $scope.$on("chamadosServiceEditarFalha", function (event, erro) {
                    self.mostrarMensagemErro();
                });

                $scope.$on("navegacaoLista", function (event) {
                    self.irParaLista();
                });

                $scope.$on("navegacaoNovo", function (event) {
                    self.irParaNovo();
                });

                $scope.$on("chamadosServiceBuscarStatusesSucesso", function (event, statuses) {
                    $scope.statuses = statuses;
                });

                $scope.$on("chamadosServiceBuscarStatusesFalha", function (event, erro) {
                    alert("Não foi possível carregar os status do chamado!");
                });

                this.inicializar();
            }]);