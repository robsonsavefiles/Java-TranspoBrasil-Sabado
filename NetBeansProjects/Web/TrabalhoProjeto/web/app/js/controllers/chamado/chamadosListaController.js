angular.module('projeto')
        .controller('chamadosListaController',
                ['$scope', 'ServicoProjeto', 'ServicoChamado', '$state', function ($scope, ServicoProjeto, ServicoChamado, $state) {

                        var self = this;
                        this.inicializar = function () {
                            $scope.chamados = [];
                            $scope.projetos = [];
                            $scope.projeto = {};
                            ServicoProjeto.buscarProjetos();
                            ServicoChamado.bus
                        };

                        $scope.editar = function (chamado) {
                            $state.go('chamados.editar', {idChamado: chamado.id});
                        };

                        $scope.remover = function (chamado) {
                            ServicoChamado.delete(chamado);
                        };



                        $scope.$on('ServicoChamadoBuscarTodosSucesso',
                                function (event, chamados) {
                                    $scope.chamados = chamados;
                                });

                        $scope.$on('ServicoChamadoBuscarTodosFalha',
                                function (event, erro) {
                                    alert('Falha ao carregar os chamados');
                                });


                        $scope.$on('ServicoChamadoExcluirSucesso',
                                function (event, chamadoRemovido) {
                                    var item = null;
                                    angular.forEach($scope.chamados, function (chamado) {
                                        if (angular.equals(chamado.id, chamadoRemovido.id)) {
                                            item = chamado;
                                            console.log(chamado.id);
                                        }
                                    });
                                    var index = $scope.chamados.indexOf(item);
                                    if (index > -1) {
                                        $scope.chamados.splice(index, 1);
                                    }
                                });

                        $scope.$on('ServicoChamadoExcluirFalha',
                                function (event, erro) {
                                    alert('Falha ao excuir o chamado');
                                });


                        $scope.$on('ServicoProjetoBuscarTodosSucesso',
                                function (event, projetos) {
                                    $scope.projetos = projetos;
                                });

                        $scope.$on('ServicoProjetoBuscarTodosFalha',
                                function (event, erro) {
                                    alert('Falha ao carregar os chamados');
                        });
                        
                        $scope.onProjetoSelecionado = function(){
                          ServicoChamado.buscarPorProjeto($scope.projeto);  
                        };

                        self.inicializar();

                    }]);

