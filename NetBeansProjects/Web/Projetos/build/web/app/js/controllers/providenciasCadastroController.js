angular.module("projetos")
        .controller("providenciasCadastroController", ["$scope", "AutenticacaoService", "ProvidenciasService", "ChamadosService", "ProjetosService", "$state", "$stateParams",
            function ($scope, AutenticacaoService, ProvidenciasService, ChamadosService, ProjetosService, $state, $stateParams) {
                var self = this;

                this.inicializar = function () {
                    $scope.providencia = {};
                    $scope.projetos = [];
                    $scope.chamados = [];
                    $scope.projeto = {};
                    $scope.chamado = {};
                    ProvidenciasService.buscarEstagios();
                    ProjetosService.buscarTodos();

                    if ($stateParams.chamadoId && $stateParams.id) {
                        self.carregarItem($stateParams.chamadoId, $stateParams.id);
                        if ($state.includes("providencias.detalhes")) {
                            $scope.$emit("mudarTituloSubtitulo", "Providências", "Detalhes");
                        } else {
                            $scope.$emit("mudarTituloSubtitulo", "Providências", "Edição");
                            $scope.edicao = true;
                        }
                    } else {
                        $scope.$emit("mudarTituloSubtitulo", "Providências", "Novo");
                        $scope.providencia.autor = AutenticacaoService.getUsuario();
                    }
                };

                this.carregarItem = function (chamadoId, id) {
                    ChamadosService.buscar($stateParams.chamadoId).then(
                            function (response) {
                                $scope.chamado = response.data;
                                $scope.projeto = response.data.projeto;
                                $scope.atualizarChamados();
                            },
                            function (error) {
                                alert("Não foi possível carregar o chamado!");
                            });

                    ProvidenciasService.buscar(chamadoId, id).then(
                            function (response) {
                                $scope.providencia = response.data.providencia;
                            },
                            function (error) {
                                alert("Não foi possível carregar a providencia!");
                            });
                };

                this.irParaLista = function () {
                    $state.go("providencias.lista");
                };

                this.mostrarMensagemErro = function () {
                    alert("Não foi possível salvar a providencia!");
                };

                $scope.salvar = function (item) {
                    if (item.id) {
                        ProvidenciasService.editar($scope.chamado, item);
                    } else {
                        ProvidenciasService.incluir($scope.chamado, item);
                    }
                };

                $scope.atualizarChamados = function () {
                    ChamadosService.buscarPorProjeto($scope.projeto.id);
                };

                $scope.$on("chamadosServiceBuscarPorProjetoSucesso", function (event, chamados) {
                    $scope.chamados = chamados;
                });

                $scope.$on("chamadosServiceBuscarPorProjetoFalha", function (event, erro) {
                    alert("Não foi possível carregar os chamados!");
                });

                $scope.$on("projetosServiceBuscarTodosSucesso", function (event, projetos) {
                    $scope.projetos = projetos;
                });

                $scope.$on("projetosServiceBuscarTodosFalha", function (event, erro) {
                    alert("Não foi possível carregar os projetos!");
                });

                $scope.$on("providenciasServiceIncluirSucesso", function (event, providencia) {
                    self.irParaLista();
                });

                $scope.$on("providenciasServiceIncluirFalha", function (event, erro) {
                    self.mostrarMensagemErro();
                });

                $scope.$on("providenciasServiceEditarSucesso", function (event, providencia) {
                    self.irParaLista();
                });

                $scope.$on("providenciasServiceEditarFalha", function (event, erro) {
                    self.mostrarMensagemErro();
                });

                $scope.$on("navegacaoLista", function (event) {
                    self.irParaLista();
                });

                $scope.$on("providenciasServiceBuscarEstagiosSucesso", function (event, estagios) {
                    $scope.estagios = estagios;
                });

                $scope.$on("providenciasServiceBuscarEstagiosFalha", function (event, erro) {
                    alert("Não foi possível carregar os status da providencia!");
                });

                $scope.$on("usuarioSelecionado", function (event, usuario) {
                    $scope.providencia.autor = usuario;
                });

                this.inicializar();
            }]);