angular.module('projeto')
        .controller('providenciasDetalheController',
                ['$scope', 'ServicoProvidencia', '$stateParams', '$state', function ($scope, ServicoProvidencia, $stateParams, $state) {


                        var self = this;

                        this.inicializar = function () {

                            $scope.providencia = {};
                            if ($stateParams.idProvidencia) {
                                self.carregarProvidencia($stateParams.idProvidencia);
                                $scope.titulo = $scope.providencia.nome;
                            } else {
                                $state.go('providencias.listar');
                                alert('Providencia não encontrada!');
                            }
                        };

                        this.carregarCertificacao = function (id) {

                            ServicoProvidencia.buscarProvidencia(id)
                                    .then(function (response) {
                                        $scope.providencia = response.data;
                                    }, function (erro) {
                                        alert('Não foi possível carregar o providencia' + erro);
                                    });

                        };

                        self.inicializar();

                    }]);

