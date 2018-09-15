angular.module('projeto')
        .controller('pesquisaProvidenciasController',
                ['$scope', 'ServicoProvidencia',
                    function ($scope, ServicoProvidencia) {

                        var self = this;

                        this.inicializar = function () {
                            $scope.providencias = [];
                            ServicoProvidencia.buscarProvidencias();
                        };

                        $scope.selecionar = function (providencia) {
                            $scope.$emit('providenciaSelecionado', providencia);
                        };

                        $scope.$on('ServicoProvidenciaBuscarTodosSucesso', function (event, providencias) {
                            $scope.providencias = providencias;
                        });

                        $scope.$on('ServicoProvidenciaBuscarTodosFalha', function (event, erro) {
                            alert('Não foi possível carregar as Providencias');
                        });


                        this.inicializar();

                    }]);
