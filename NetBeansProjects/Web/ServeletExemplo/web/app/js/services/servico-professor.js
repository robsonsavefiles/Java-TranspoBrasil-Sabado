angular.module('curso')
        .factory('ServicoProfessor',
                ['$http',
                    '$rootScope',
                    function ($http, $rootScope) {

                        return {
                            buscarTodos: function (id) {
                                $http.get('professores?id=' + id)
                                        .then(function (response) {
                                            $rootScope.$broadcast('servicoProfessorBuscarTodosSucesso', response.data);
                                        }, function (error) {
                                            $rootScope.$broadcast('servicoProfessorBuscarTodosFalha', error);
                                        });
                            },
                            buscarProfessores: function () {
                                $http.get('professores')
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoProfessorBuscarTodosSucesso', response.data);
                                        }, function (error) {
                                            $rootScope.$broadcast('ServicoProfessorBuscarTodosFalha', error);
                                        });
                            },
                            editar: function (professor) {
                                $http.put('professores', angular.toJson(professor))
                                        .then(function (response) {
                                            $rootScope.$broadcast('servicoProfessorEditarSucesso', response.data);
                                        }, function (error) {
                                            $rootScope.$broadcast('servicoProfessorEditarFalha', error);
                                        });
                            },
                            incluir: function (professor) {
                                $http.post('professores', angular.toJson(professor))
                                        .then(function (response) {
                                            $rootScope.$broadcast('servicoProfessorIncluirSucesso', response.data);
                                        }, function (error) {
                                            $rootScope.$broadcast('servicoProfessorIncluirFalha', error);
                                        });
                            },
                            remover: function (professor) {
                                $http.delete('professores?id=' + professor.id)
                                        .then(function (response) {
                                            $rootScope.$broadcast('servicoProfessorRemoverSucesso', response.data);
                                        }, function (error) {
                                            $rootScope.$broadcast('servicoProfessorRemoverFalha', error);
                                        });
                            }

                        };
                    }]);

