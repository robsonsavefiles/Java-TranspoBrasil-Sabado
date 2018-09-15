angular.module('curso')
        .controller('alunosListaController',
                ['$scope',
                    'ServicoAluno',
                    '$state',
                    function ($scope, ServicoAluno, $state) {
                        $scope.alunos = [];

                        $scope.editar = function (aluno) {
                            $state.go('alunos.editar', {idAluno: aluno.id});
                        };

                        $scope.remover = function (aluno) {
                            ServicoAluno.remover(aluno);
                        };

                        $scope.$on('servicoAlunoBuscarTodosSucesso',
                                function (event, alunos) {
                                    $scope.alunos = alunos;
                                });

                        $scope.$on('servicoAlunoBuscarTodosFalha',
                                function (event, erro) {
                                    alert('Falha ao carregar os Alunos');
                                });

                        $scope.$on('servicoAlunoRemoverSucesso',
                                function (event, alunoRemovido) {
                                    var item = null;
                                    angular.forEach($scope.alunos, function (aluno) {
                                        if (aluno.id === alunoRemovido.id) {
                                            item = aluno;
                                        }
                                    });
                                    var index = $scope.alunos.indexOf(item);
                                    if (index > -1) {
                                        $scope.alunos.splice(index, 1);
                                    }

                                });

                        $scope.$on('servicoAlunoRemoverFalha',
                                function (event, erro) {
                                    alert('Falha ao excluir o aluno');
                                });

                        ServicoAluno.buscarTodos();


                    }]);


