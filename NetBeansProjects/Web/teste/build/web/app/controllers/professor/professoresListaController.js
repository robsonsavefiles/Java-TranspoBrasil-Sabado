angular.module('curso')
        .controller('professoresListaController',
                ['$scope', 'ServicoProfessor', '$state', function ($scope, ServicoProfessor, $state) {

                        $scope.professores = [];

                        $scope.editar = function (professor) {
                            $state.go('professores.editar', {idProfessor: professor.id});
                        };

                        $scope.remover = function (professor) {
                            ServicoProfessor.remover(professor);
                        };

                        $scope.VerCertifificado = function (professor) {
                            $state.go('professores.verCertificado', {idProfessor: professor.id});
                        };

                        ServicoProfessor.buscarProfessores();

                        $scope.$on('ServicoProfessorBuscarTodosSucesso',
                                function (event, professores) {
                                    $scope.professores = professores;
                                });

                        $scope.$on('ServicoProfessorBuscarTodosFalha',
                                function (event, erro) {
                                    alert('Falha ao carregar os professores');
                                });


                        $scope.$on('ServicoProfessorRemoverSucesso',
                                function (event, professorRemovido) {
                                    var item = null;
                                    angular.forEach($scope.professores, function (professores) {
                                        if (angular.equals(professores.id, professorRemovido.id)) {
                                            item = professores;
                                            console.log(professores.id);
                                        }
                                    });
                                    var index = $scope.professores.indexOf(item);
                                    if (index > -1) {
                                        $scope.professores.splice(index, 1);
                                    }
                                });

                        $scope.$on('ServicoProfessorRemoverFalha',
                                function (event, erro) {
                                    alert('Falha ao excuir o professor');
                                });



                        //Mapeamento do servlet que eu desejo utilizar
//        $http.get('cursos')
//                .then(function(response){
//                    $scope.cursos = response.data;
//                }, function(error){
//                    alert('Falha ao carregar os dados');
//                });

                    }]);

