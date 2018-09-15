angular.module('curso')
        .controller('certificacoesListaController',
                ['$scope',
                    'ServicoCertificacao',
                    '$state',
                    function ($scope, ServicoCertificacao, $state) {
                        $scope.certificacoes = [];

                        $scope.editar = function (certificacao) {
                            $state.go('certificacoes.editar', {idCertificacoes: certificacao.id});

                        };

                        $scope.remover = function (certificacao) {
                            ServicoCertificacao.remover(certificacao);
                        };

                        $scope.$on('servicoCertificacaoBuscarTodosSucesso',
                                function (event, certificacoes) {
                                    $scope.certificacoes = certificacoes;
                                });

                        $scope.$on('servicoCertificacoesBuscarTodosFalha',
                                function (event, erro) {
                                    alert('Falha ao carregar as certificações');
                                });

                        $scope.$on('servicoCertificacaoRemoverSucesso',
                                function (event, certificacaoRemovido) {
                                    var item = null;
                                    angular.forEach($scope.certificacoes, function (certificacoes) {
                                        if (certificacoes.id === certificacaoRemovido.id) {
                                            item = certificacoes;
                                        }
                                    });
                                    var index = $scope.cursos.indexOf(item);
                                    if (index > -1) {
                                        $scope.certificacoes.splice(index, 1);
                                    }

                                });

                        $scope.$on('servicoCertificacaoRemoverFalha',
                                function (event, erro) {
                                    alert('Falha ao excluir o certificacao');
                                });

                        ServicoCertificacao.buscarTodos();


                    }]);


