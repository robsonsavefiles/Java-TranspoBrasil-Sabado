angular.module('curso')
        .controller('turmasListaController',
                ['$scope', 'ServicoTurmas', '$state', function ($scope, ServicoTurmas, $state) {

                        $scope.turmas = [];

                        $scope.editar = function (turma) {
                            $state.go('turmas.editar', {idTurma: turma.id});
                        };

                        $scope.remover = function (turma) {
                            ServicoTurmas.deleteTurma(turma);
                        };

                        ServicoTurmas.buscarTurmas();

                        $scope.$on('servicoTurmasBuscarTodosSucesso',
                                function (event, turmas) {
                                    $scope.turmas = turmas;
                                });

                        $scope.$on('ServicoTurmasBuscarTodosFalha',
                                function (event, erro) {
                                    alert('Falha ao carregar as turmas');
                                });


                        $scope.$on('ServicoTurmasExcluirSucesso',
                                function (event, turmaRemovido) {
                                    var item = null;
                                    angular.forEach($scope.turmas, function (turma) {
                                        if (angular.equals(turma.id, turmaRemovido.id)) {
                                            item = turma;
                                            console.log(turma.id);
                                        }
                                    });
                                    var index = $scope.turmas.indexOf(item);
                                    if (index > -1) {
                                        $scope.turmas.splice(index, 1);
                                    }
                                });

                        $scope.$on('ServicoTurmasExcluirFalha',
                                function (event, erro) {
                                    alert('Falha ao excuir a turma');
                                });



                    }]);

