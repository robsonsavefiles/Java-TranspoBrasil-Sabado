angular.module('projeto')
        .controller('projetosListaController',
                ['$scope', 'ServicoProjeto', '$state', function ($scope, ServicoProjeto, $state) {

                        $scope.projetos = [];

                        $scope.editar = function (projeto) {
                            $state.go('projetos.editar', {idProjeto: projeto.id});
                        };

                        $scope.remover = function (projeto) {
                            ServicoProjeto.deleteProjeto(projeto);
                        };

                        ServicoProjeto.buscarProjetos();

                        $scope.$on('ServicoProjetoBuscarTodosSucesso',
                                function (event, projetos) {
                                    $scope.projetos = projetos;
                                });

                        $scope.$on('ServicoProjetoBuscarTodosFalha',
                                function (event, erro) {
                                    alert('Falha ao carregar os projetos');
                                });


                        $scope.$on('ServicoProjetoExcluirSucesso',
                                function (event, projetoRemovido) {
                                    var item = null;
                                    angular.forEach($scope.projetos, function (projeto) {
                                        if (angular.equals(projeto.id, projetoRemovido.id)) {
                                            item = projeto;
                                            console.log(projeto.id);
                                        }
                                    });
                                    var index = $scope.proejetos.indexOf(item);
                                    if (index > -1) {
                                        $scope.projetos.splice(index, 1);
                                    }
                                });

                        $scope.$on('ServicoProjetoExcluirFalha',
                                function (event, erro) {
                                    alert('Falha ao excuir o Projeto');
                                });



                    }]);

