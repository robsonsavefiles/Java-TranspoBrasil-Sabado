angular.module('curso')
        .factory('ServicoProfessor',
                ['$http',
                    '$rootScope',
                    function ($http, $rootScope) {

                        return{
                            buscarProfessor: function (id) {
                                return $http.get('professores?id=' + id);
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
                                            $rootScope.$broadcast('ServicoProfessorEditarSucesso', response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoProfessorEditarFalha', error);
                                                });
                            },
                            remover: function (professor) {
                                $http.delete('professores?id=' + professor.id)
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoProfessorRemoverSucesso', response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoProfessorRemoverFalha', error);
                                                });
                            },
                            incluir: function (professor) {
                                $http.post('professores', angular.toJson(professor))
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoProfessorIncluirSucesso', response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoProfessorIncluirFalha', error);
                                                });
                            }
                        };

                    }]);