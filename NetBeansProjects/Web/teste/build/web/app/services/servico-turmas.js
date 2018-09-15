angular.module('curso')
        .factory('ServicoTurmas',
                ['$http',
                    '$rootScope',
                    function ($http, $rootScope) {

                        return {
                            buscarTurmas: function () {
                                $http.get('turmas')
                                        .then(function (response) {
                                            $rootScope.$broadcast('servicoTurmasBuscarTodosSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('servicoTurmasBuscarTodosFalha',
                                                            error);
                                                });
                            },
                            
                            buscarTurma : function (id){
                              return $http.get('turmas?id='+id);  
                            },
                            
                            editar: function (turma) {
                                $http.put('turmas', angular.toJson(turma))
                                        .then(function (response) {
                                            $rootScope.$broadcast('servicoTurmasEditarSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('servicoTurmasEditarFalha',
                                                            error);
                                                });

                            },
                            incluir: function (turma) {
                                $http.post('turmas',angular.toJson(turma))
                                        .then(function (response) {
                                            $rootScope.$broadcast('servicoTurmasIncluirSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('servicoTurmasIncluirFalha',
                                                            error);
                                                });
                            },
                            deleteTurma: function (turma) {
                                $http.delete('turmas?id=' + turma.id)
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoTurmasExcluirSucesso', response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoTurmasExcluirFalha', error);
                                                });
                            }
                        };

                    }]);


