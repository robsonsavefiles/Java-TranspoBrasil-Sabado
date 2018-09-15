angular.module('curso')
        .controller('cursosListaController',
                ['$scope',
                    'ServicoCurso',
                    '$state',
                    function ($scope, ServicoCurso, $state) {
                        $scope.cursos = [];

                        $scope.editar = function (curso) {
                            $state.go('cursos.editar', {idCurso: curso.id});

                        };

                        $scope.remover = function (curso) {
                            ServicoCurso.remover(curso);
                        };

                        $scope.$on('servicoCursoBuscarTodosSucesso',
                                function (event, cursos) {
                                    $scope.cursos = cursos;
                                });

                        $scope.$on('servicoCursoBuscarTodosFalha',
                                function (event, erro) {
                                    alert('Falha ao carregar os cursos');
                                });

                        $scope.$on('servicoCursoRemoverSucesso',
                                function (event, cursoRemovido) {
                                    var item = null;
                                    angular.forEach($scope.cursos, function (curso) {
                                        if (curso.id === cursoRemovido.id) {
                                            item = curso;
                                        }
                                    });
                                    var index = $scope.cursos.indexOf(item);
                                    if (index > -1) {
                                        $scope.cursos.splice(index, 1);
                                    }

                                });

                        $scope.$on('servicoCursoRemoverFalha',
                                function (event, erro) {
                                    alert('Falha ao excluir o curso');
                                });

                        ServicoCurso.buscarTodos();


                    }]);


