angular.module('projeto')
        .controller('pesquisaChamadoController',
                ['$scope', 'ServicoChamado',
                    function ($scope, ServicoChamado) {

                        var self = this;

                        this.inicializar = function () {
                            $scope.chamados = [];
                            ServicoChamado.buscarChamados();
                        };

                        $scope.selecionar = function (chamado) {
                            $scope.$emit('chamadoSelecionado', chamado);
                        };

                        $scope.$on('ServicoChamadoBuscarTodosSucesso', function (event, chamados) {
                            $scope.chamados = chamados;
                        });

                        $scope.$on('ServicoChamadoBuscarTodosFalha', function (event, erro) {
                            alert('Não foi possível carregar os Chamados');
                        });


                        this.inicializar();

                    }]);
