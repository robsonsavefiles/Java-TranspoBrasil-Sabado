angular.module('curso')
        .controller('alunosListaController',
                ['$scope', 'ServicoAlunos', '$state', function ($scope, ServicoAlunos, $state) {

                        $scope.alunos = [];

                        $scope.editar = function (aluno) {
                            $state.go('alunos.editar', {idAluno: aluno.id});
                        };

                        $scope.remover = function (aluno) {
                            ServicoAlunos.deleteAluno(aluno);
                        };

                        ServicoAlunos.buscarAlunos();

                        $scope.$on('servicoAlunosBuscarTodosSucesso',
                                function (event, alunos) {
                                    $scope.alunos = alunos;
                                });

                        $scope.$on('ServicoAlunosBuscarTodosFalha',
                                function (event, erro) {
                                    alert('Falha ao carregar os Alunos');
                                });


                        $scope.$on('ServicoAlunosExcluirSucesso',
                                function (event, AlunoRemovido) {
                                    var item = null;
                                    angular.forEach($scope.alunos, function (aluno) {
                                        if (angular.equals(aluno.id, AlunoRemovido.id)) {
                                            item = aluno;
                                            console.log(aluno.id);
                                        }
                                    });
                                    var index = $scope.alunos.indexOf(item);
                                    if (index > -1) {
                                        $scope.alunos.splice(index, 1);
                                    }
                                });

                        $scope.$on('ServicoAlunoExcluirFalha',
                                function (event, erro) {
                                    alert('Falha ao excuir o Aluno');
                                });



                    }]);

