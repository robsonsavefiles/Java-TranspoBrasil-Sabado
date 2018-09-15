angular.module('curso')
        .controller('cursosListaController',
                ['$scope', 'ServicoCurso', '$state', function ($scope, ServicoCurso, $state) {

                        $scope.cursos = [];

                        $scope.editar = function (curso) {
                            $state.go('cursos.editar', {idCurso:curso.id});
                        };

                        $scope.remover = function (curso) {
                            ServicoCurso.delete(curso);
                        };

                        ServicoCurso.buscarCursos();

                        $scope.$on('ServicoCursoBuscarTodosSucesso',
                                function (event, cursos) {
                                    $scope.cursos = cursos;
                                });

                        $scope.$on('ServicoCursoBuscarTodosFalha',
                                function (event, erro) {
                                    alert('Falha ao carregar os cursos');
                                });


                        $scope.$on('ServicoCursoExcluirSucesso',
                                function (event, cursoRemovido) {
                                    var item = null;
                                    angular.forEach($scope.cursos, function (curso) {
                                        if (angular.equals(curso.id, cursoRemovido.id)) {
                                            item = curso;
                                            console.log(curso.id);
                                        }
                                    });
                                    var index = $scope.cursos.indexOf(item);
                                    if (index > -1) {
                                        $scope.cursos.splice(index, 1);
                                    }
                                });

                        $scope.$on('ServicoCursoExcluirFalha',
                                function (event, erro) {
                                    alert('Falha ao excuir o curso');
                                });



                        //Mapeamento do servlet que eu desejo utilizar
//        $http.get('cursos')
//                .then(function(response){
//                    $scope.cursos = response.data;
//                }, function(error){
//                    alert('Falha ao carregar os dados');
//                });

                    }]);

