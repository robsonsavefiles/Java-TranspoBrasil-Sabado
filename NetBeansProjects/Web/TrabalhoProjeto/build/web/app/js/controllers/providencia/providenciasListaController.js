angular.module('projeto')
        .controller('providenciasListaController',
                ['$scope', 'ServicoProvidencia', '$state', function ($scope, ServicoProvidencia, $state) {

                        $scope.providencias = [];

                        $scope.editar = function (providencia) {
                            $state.go('providencias.editar', {idProvidencia: providencia.id});
                        };

                        $scope.remover = function (providencia) {
                            ServicoProvidencia.remover(providencia);
                        };

                        $scope.VerChamado = function (providencia) {
                            $state.go('providencias.verChamado', {idProvidencia: providencia.id});
                        };

                        ServicoProvidencia.buscarProvidencia();

                        $scope.$on('ServicoProvidenciaBuscarTodosSucesso',
                                function (event, providencias) {
                                    $scope.providencias = providencias;
                                });

                        $scope.$on('ServicoProvidenciaBuscarTodosFalha',
                                function (event, erro) {
                                    alert('Falha ao carregar as providencias');
                                });


                        $scope.$on('ServicoProvidenciaRemoverSucesso',
                                function (event, providenciaRemovida) {
                                    var item = null;
                                    angular.forEach($scope.providencias, function (providencias) {
                                        if (angular.equals(providencias.id, providenciaRemovida.id)) {
                                            item = providencias;
                                            console.log(providencias.id);
                                        }
                                    });
                                    var index = $scope.providencias.indexOf(item);
                                    if (index > -1) {
                                        $scope.providencias.splice(index, 1);
                                    }
                                });

                        $scope.$on('ServicoProvidenciaRemoverFalha',
                                function (event, erro) {
                                    alert('Falha ao excuir o providencia');
                                });

                    }]);

