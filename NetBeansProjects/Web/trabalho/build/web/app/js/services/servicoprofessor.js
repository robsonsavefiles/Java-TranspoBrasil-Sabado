angular.module('curso')
        .factory('ServicoCurso',
                ['$http', '$rootScope', function ($http, $rootScope) {

                        return {
                            buscarTodos: function () {
                                $http.get('cursos')
                                        .then(function (response) {
                                            $rootScope.$broadcast('servicoProfessorBuscarTodosSucesso', response.data);
                                        }, function (error) {
                                            $rootScope.$broadcast('servicoProfessorBuscarTodosSucesso', error);
                                        });
                                    }
                                };
                            }]);
                            