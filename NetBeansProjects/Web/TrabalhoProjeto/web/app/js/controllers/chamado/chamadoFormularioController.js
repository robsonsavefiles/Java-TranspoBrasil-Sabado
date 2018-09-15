angular.module('projeto')
        .controller('chamadosFormularioController',
                ['$scope',
                    'ServicoChamado',
                    'ServicoProjeto',
                    '$state',
                    '$stateParams',
                    function ($scope, ServicoChamado, ServicoProjeto, $state, $stateParams) {

                        var self = this;

                        this.inicializar = function () {
                            $scope.chamado = {};
                            $scope.status = {};
                            $scope.projeto = {};
                            $scope.titulo = "Novo Chamado";
                            ServicoChamado.buscarStatos();
                            if ($stateParams.idChamado) {
                                self.carregarChamado($stateParams.idChamado);
                                $scope.titulo = "Editar Chamado";
                            }
                            ServicoProjeto.buscarProjetos();

                        };
                        this.carregarChamado = function (id) {
                            ServicoChamado.buscarChamado(id)
                                    .then(function (response) {
                                        $scope.chamado = response.data;
                                    }, function (erro) {
                                        alert('Não foi possível carregar o chamado');
                                    });

                        };
                        this.carregarProjeto = function (id) {
                            ServicoChamado.buscarChamado(id)
                                    .then(function (response) {
                                        $scope.chamado = response.data;
                                    }, function (erro) {
                                        alert('Não foi possível carregar o chamado');
                                    });

                        };
                        this.irParaLista = function () {
                            $state.go('chamados.lista');
                        };
                        $scope.irParaDetalhes = function (chamado) {
                            $state.go("chamados.detalhes", {"id": chamado.id});
                        };
                        $scope.remover = function (chamado) {
                            ServicoChamado.remover(chamado);
                        };

                        this.irParaNovo = function () {
                            $state.go("chamados.novo");
                        };
                        $scope.atualizarChamados = function () {
                            ServicoChamado.buscarPorProjeto($scope.projeto.id);
                        };
                        this.mostrarMensagemErro = function (mensagem) {
                            if (mensagem) {
                                alert();
                            } else {
                                alert('Não foi possivel salvar o Chamado');
                            }
                            ;



                            $scope.salvar = function (chamado) {
                                if (chamado.id) {
                                    ServicoChamado.editar(chamado);
                                } else {
                                    ServicoChamado.incluir(chamado);
                                }
                            };

                            $scope.$on('ServicoProjetoBuscarTodos', function (event, projetos) {
                                $scope.projetos = projetos;
                            });

                            $scope.$on('chamadoSelecionado', function (event, chamado) {
                                $scope.chamado.providencia = chamado;
                            });

                            $scope.$on('ServicoChamadoIncluirSucesso', function (event, chamado) {
                                self.irParaLista();
                            });

                            $scope.$on('ServicoChamadoIncluirFalha', function (event, chamado) {
                                self.mostrarMensagemErro();
                            });


                            $scope.$on('ServicoChamadoEditarSucesso', function (event, chamado) {
                                self.irParaLista();
                            });

                            $scope.$on('ServicoChamadoEditarFalha', function (event, chamado) {
                                self.mostrarMensagemErro();
                            });
                            $scope.$on('chamadoSelecionado', function (event, chamado) {
                                $scope.chamado.chamado = chamado;
                            });


                            this.inicializar();
                        };
                    }]);