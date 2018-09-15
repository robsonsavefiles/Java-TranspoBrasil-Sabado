angular.module('curso')
        .controller('turmasListaController',
                    ['$scope',
                    'ServicoTurma',
                    '$state',
                    function ($scope, ServicoTurma, $state) {
                        $scope.turmas = [];

                        $scope.editar = function (turma) {
                            $state.go('turmas.editar', {idTurma: turma.id});

                        };

                        $scope.remover = function (turma) {
                            ServicoTurma.remover(turma);
                        };

                        $scope.$on('servicoTurmaBuscarTodosSucesso',
                                function (event, turmas) {
                                    $scope.turmas = turmas;
                                });

                        $scope.$on('servicoTurmaBuscarTodosFalha',
                                function (event, erro) {
                                    alert('Falha ao carregar os turmas');
                                });

                        $scope.$on('servicoTurmaRemoverSucesso',
                                function (event, turmaRemovida) {
                                    var item = null;
                                    angular.forEach($scope.turmas, function (turma) {
                                        if (turma.id === turmaRemovida.id) {
                                            item = turma;
                                        }
                                    });
                                    var index = $scope.turmas.indexOf(item);
                                    if (index > -1) {
                                        $scope.turmas.splice(index, 1);
                                    }

                                });

                        $scope.$on('servicoTurmaRemoverFalha',
                                function (event, erro) {
                                    alert('Falha ao excluir a Turma');
                                });

                        ServicoTurma.buscarTodos();


                    }]);


