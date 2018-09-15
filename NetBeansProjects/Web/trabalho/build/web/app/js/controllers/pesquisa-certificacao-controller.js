angular.module('curso')
        .controller('pesquisaCertificacaoController',
                ['$scope', 'ServicoCertificacao', function ($scope, ServicoCertificacao) {

                        var self = this;

                        this.inicializar = function () {
                            $scope.certificacoes = [];
                            ServicoCertificacao.buscarTodos();
                        };

                        $scope.selecionar = function (certificacao) {
                            $scope.$emit('certificacaoSelecionado', certificacao);
                        };

                        $scope.$on('servicoCertificacaoBuscarTodosSucesso',
                                function (event, certificacoes) {
                                    $scope.certificacoes = certificacoes;
                                });
                        $scope.$on('servicoCertificacaoBuscarTodosFalha',
                                function (event, erro) {
                                    alert('Não foi possível carregar as Certificacoes');
                                });

                        this.inicializar();

                    }]);

