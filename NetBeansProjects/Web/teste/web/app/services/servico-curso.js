angular.module('curso')
        .factory('ServicoCurso',
                ['$http',
                    '$rootScope',
                    function ($http, $rootScope) {

                        return{
                            buscarCurso : function (id){
                              return $http.get('cursos?id='+id);  
                            },
                            buscarCursos: function () {
                                $http.get('cursos')
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoCursoBuscarTodosSucesso', response.data);
                                        }, function (error) {
                                            $rootScope.$broadcast('ServicoCursoBuscarTodosFalha', error);
                                        });
                            },
                            editar: function (curso) {
                                $http.put('cursos', angular.toJson(curso))
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoCursoEditarSucesso', response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoCursoEditarFalha', error);
                                                });
                            },
                            delete: function (curso) {
                                $http.delete('cursos?id=' + curso.id)
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoCursoExcluirSucesso', response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoCursoExcluirFalha', error);
                                                });
                            },
                            incluir: function (curso) {
                                $http.post('cursos', angular.toJson(curso))
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoCursoIncluirSucesso', response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoCursoIncluirFalha', error);
                                                });
                            }

                        };

                    }]);