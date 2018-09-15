angular.module('projeto')
        .controller('providenciasNovaController',
                ['$scope',
                    'ServicoProvidencia',
                    '$state',
                    '$stateParams',
                    function ($scope, ServicoProvidencia, $state, $stateParams) {

                        var self = this;


                        this.inicializar = function () {

                            $scope.titulo = "Novo Providencia";
                            $scope.providencias = [];
                            $scope.providencia = {};
                            if ($stateParams.idProvidencia) {
                                self.carregarProvidencia($stateParams.idProvidencia);
                                $scope.titulo = "Editar Providencia";
                            }
                        };

                        this.carregarProvidencia = function (id) {

                            ServicoProvidencia.buscarProvidencia(id)
                                    .then(function (response) {
                                        $scope.providencia = response.data;
                                    }, function (erro) {
                                        alert('Não foi possível carregar a providencia');
                                    });

                        };

                        this.irParaLista = function () {
                            $state.go('providencias.lista');
                        };

                        this.mostrarMensagemErro = function () {
                            alert('Não foi possivel salvar a Providencia');
                        };


                        $scope.salvar = function (providencia) {
                            if (providencia.id) {
                                ServicoProvidencia.editar(providencia);
                            } else {
                                ServicoProvidencia.incluir(providencia);
                            }
                        };


                        $scope.$on('providenciaSelecionada', function (event, providencia) {
                            $scope.providencia.providencia = providencia;
                        });

                        $scope.$on('ServicoProvidenciaIncluirSucesso', function (event, providencia) {
                            self.irParaLista();
                        });

                        $scope.$on('ServicoProvidenciaIncluirFalha', function (event, providencia) {
                            self.mostrarMensagemErro();
                        });


                        $scope.$on('ServicoProvidenciaEditarSucesso', function (event, providencia) {
                            self.irParaLista();
                        });

                        $scope.$on('ServicoProvidenciaEditarFalha', function (event, providencia) {
                            self.mostrarMensagemErro();
                        });

                        $scope.$on('providenciaSelecionado', function (event, providencia) {
                            var exist = false;
                            angular.forEach($scope.providencias, function (cert, key) {
                                if (angular.equals(cert, providencia)) {
                                    $scope.providencias.splice(key, 1);
                                    $scope.providencias.chamados = $scope.providencias;
                                    exist = true;
                                }
                            });
                            if (!exist) {
                                $scope.providencias.push(providencia);
                                $scope.providencia.chamados = $scope.providencias;
                            }
                        });



                        this.inicializar();

                    }]);