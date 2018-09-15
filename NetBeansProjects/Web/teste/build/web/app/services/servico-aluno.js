angular.module('curso')
        .factory('ServicoAlunos',
                ['$http',
                    '$rootScope',
                    function ($http, $rootScope) {

                        return {
                            buscarAlunos: function () {
                                $http.get('alunos')
                                        .then(function (response) {
                                            $rootScope.$broadcast('servicoAlunosBuscarTodosSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('servicoAlunosBuscarTodosFalha',
                                                            error);
                                                });
                            },
                            
                            buscarAluno : function (id){
                              return $http.get('alunos?id='+id);  
                            },
                            
                            editar: function (aluno) {
                                $http.put('alunos', angular.toJson(aluno))
                                        .then(function (response) {
                                            $rootScope.$broadcast('servicoAlunosEditarSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('servicoAlunosEditarFalha',
                                                            error);
                                                });

                            },
                            incluir: function (aluno) {
                                $http.post('alunos',angular.toJson(aluno))
                                        .then(function (response) {
                                            $rootScope.$broadcast('servicoAlunosIncluirSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('servicoAlunosIncluirFalha',
                                                            error);
                                                });
                            },
                            deleteAluno: function (aluno) {
                                $http.delete('alunos?id=' + aluno.id)
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoAlunosExcluirSucesso', response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoAlunosExcluirFalha', error);
                                                });
                            }
                        };

                    }]);


