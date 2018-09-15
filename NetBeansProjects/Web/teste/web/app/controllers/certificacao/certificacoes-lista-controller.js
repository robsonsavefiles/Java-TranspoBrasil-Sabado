angular.module('curso')
        .controller('certificacoesListaController',
                ['$scope', 'ServicoCertificacoes', '$state', function ($scope, ServicoCertificacoes, $state) {

                        $scope.certificacoes = [];

                        $scope.editar = function (certificacao) {
                            $state.go('certificacoes.editar', {idCertificacao: certificacao.id});
                        };

                        $scope.remover = function (certificacao) {
                            ServicoCertificacoes.deleteCertificacao(certificacao);
                        };

                        ServicoCertificacoes.buscarCertificacoes();

                        $scope.$on('servicoCertificacaoBuscarTodosSucesso',
                                function (event, certificacoes) {
                                    $scope.certificacoes = certificacoes;
                                });

                        $scope.$on('ServicoCertificacaoBuscarTodosFalha',
                                function (event, erro) {
                                    alert('Falha ao carregar as certificações');
                                });


                        $scope.$on('ServicoCertificacaoExcluirSucesso',
                                function (event, certificacaoRemovido) {
                                    var item = null;
                                    angular.forEach($scope.certificacoes, function (certificacao) {
                                        if (angular.equals(certificacao.id, certificacaoRemovido.id)) {
                                            item = certificacao;
                                            console.log(certificacao.id);
                                        }
                                    });
                                    var index = $scope.certificacoes.indexOf(item);
                                    if (index > -1) {
                                        $scope.certificacoes.splice(index, 1);
                                    }
                                });

                        $scope.$on('ServicoCertificacaoExcluirFalha',
                                function (event, erro) {
                                    alert('Falha ao excuir a certificação');
                                });



                    }]);

