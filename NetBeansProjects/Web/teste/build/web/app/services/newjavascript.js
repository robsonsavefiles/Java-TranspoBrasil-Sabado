angular.module('curso')
        .factory('ServicoCurso',
                ['$http',
                    '$rootScope',
                    function ($http, $rootScope) {

                        return {
                            buscarTodos: function () {
                                $http.get('cursos')
                                        .then(function (response) {
                                            $rootScope.$broadcast('servicoCursoBuscarTodosSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('servicoCursoBuscarTodosFalha',
                                                            error);
                                                });
                            },
                            
                            buscarCurso : function (id){
                              return $http.get('curso?id='+id);  
                            },
                            
                            editar: function (curso) {
                                $http.put('cursos', JSON.stringify(curso))
                                        .then(function (response) {
                                            $rootScope.$broadcast('servicoCursoEditarSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('servicoCursoEditarFalha',
                                                            error);
                                                });

                            },
                            incluir: function (curso) {
                                $http.post('cursos',JSON.stringify(curso))
                                        .then(function (response) {
                                            $rootScope.$broadcast('servicoCursoIncluirSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('servicoCursoIncluirFalha',
                                                            error);
                                                });
                            },
                            remover: function (curso) {
                                $http.delete('cursos?id='+curso.id)
                                        .then(function (response) {
                                            $rootScope.$broadcast('servicoCursoRemoverSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('servicoCursoRemoverFalha',
                                                            error);
                                                });
                            }
                        };

                    }]);/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


