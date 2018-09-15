angular.module('curso')
        .controller('certificacoesFormularioController',
                ['$scope',
                    'ServicoCertificacao',
                    '$state',
                    '$stateParams',
                    function ($scope, ServicoCertificacao, $state, $stateParams) {

                        var self = this;
                        this.inicializar = function () {
                            $scope.certificacao = {};
                            $scope.titulo = "Nova Certificacao";
                            if ($stateParams.idCertificacao) {
                                self.carregarCertificacao($stateParams.idCertificacao);
                                $scope.titulo = "Editar Certificacao";
                            }
                        };
                        this.carregarCertificacao = function (id) {
                            ServicoCertificacao.buscarCurso(id)
                                    .then(function (response) {
                                        $scope.certificacao = response.data;
                                    }, function (erro) {
                                        alert('Não foi possível carregar o certificacao [:(]');
                                    });
                        };

                        this.irParaLista = function () {
                            $state.go('certificacoes.lista');
                        };
                        this.mostrarMensagemErro = function () {
                            alert('Não foi possível  Salvar o Curso [:(]');
                        };

                        $scope.salvar = function (certificacao) {
                            if (certificacao.id) {
                                ServicoCertificacao.editar(certificacao);
                            } else {
                                ServicoCertificacao.incluir(certificacao);
                            }
                        };

                        $scope.$on('professsorSelecionado', function (event, professor) {
                            $scope.certificacao.professor = professor;
                        });

                        $scope.$on('servicoCertificacaoIncluirSucesso', function (event, certificacao) {
                            self.irParaLista();
                        });
                        $scope.$on('servicoCertificacaoIncluirFalha', function (event, erro) {
                            self.mostrarMensagemErro();
                        });
                        $scope.$on('servicoCertificacaoEditarSucesso', function (event, certificacao) {
                            self.irParaLista();
                        });
                        $scope.$on('servicoCertificacaoEditarFalha', function (event, erro) {
                            self.mostrarMensagemErro();
                        });

                        $scope.$on('certificacaoSelecionado', function (event, certificacoes) {
                            $scope.professor.certificacoes = certificacoes;
                        });

                        this.inicializar();

                    }]);


