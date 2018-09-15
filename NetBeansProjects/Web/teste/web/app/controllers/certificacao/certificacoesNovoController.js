angular.module('curso').controller('certificacoesNovoController', ['$scope',
                    'ServicoCertificacoes',
                    '$state',
                    '$stateParams',
                    function ($scope, ServicoCertificacoes, $state, $stateParams) {

                        var self = this;


                        this.inicializar = function () {

                            $scope.titulo = "Nova Certificação";
                            $scope.certificacao = {};
                            if ($stateParams.idCertificacao) {
                                self.carregarCertificacao($stateParams.idCertificacao);
                                $scope.titulo = "Editar Certificação";
                            }
                        };

                        this.carregarCertificacao = function (id) {

                            ServicoCertificacoes.buscarCertificacao(id)
                                    .then(function (response) {
                                        $scope.certificacao = response.data;
                                    }, function (erro) {
                                        alert('Não foi possível carregar o curso');
                                    });

                        };

                        this.irParaLista = function () {
                            $state.go('certificacoes.lista');
                        };

                        this.mostrarMensagemErro = function () {
                            alert('Não foi possivel salvar a Certificação');
                        };


                        $scope.salvar = function (certificacao) {
                            if (certificacao.id) {
                                ServicoCertificacoes.editar(certificacao);
                            } else {
                                ServicoCertificacoes.incluir(certificacao);
                            }
                        };


                        $scope.$on('certificacaoSelecionado', function (event, certificacao) {
                            $scope.certificacao = certificacao;
                        });

                        $scope.$on('servicoCertificacaoIncluirSucesso', function (event, certificacao) {
                            self.irParaLista();
                        });

                        $scope.$on('servicoCertificacaoIncluirFalha', function (event, certificacao) {
                            self.mostrarMensagemErro();
                        });


                        $scope.$on('ServicoCertificacaoEditarSucesso', function (event, certificacao) {
                            self.irParaLista();
                        });

                        $scope.$on('ServicoCertificacaoEditarFalha', function (event, certificacao) {
                            self.mostrarMensagemErro();
                        });
                        




                        this.inicializar();

                    }]);