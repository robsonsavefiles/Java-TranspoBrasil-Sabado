angular.module('projeto')
        .factory('ServicoProjeto',
                ['$http',
                    '$rootScope',
                    function ($http, $rootScope) {

                        return {
                            buscarProjetos: function () {
                                $http.get('projetos')
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoProjetoBuscarTodosSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoProjetoBuscarTodosFalha',
                                                            error);
                                                });
                            },
                            buscarProjeto: function (id) {
                                return $http.get('projetos?id=' + id);
                            },
                            editar: function (projeto) {
                                $http.put('projetos', angular.toJson(projeto))
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoProjetoEditarSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoProjetoEditarFalha',
                                                            error);
                                                });

                            },
                            incluir: function (projeto) {
                                $http.post('projetos', angular.toJson(projeto))
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoProjetoIncluirSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoProjetoIncluirFalha',
                                                            error);
                                                });
                            },
                            deleteProjeto: function (projeto) {
                                $http.delete('projetos?id=' + projeto.id)
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoProjetosExcluirSucesso', response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoProjetosExcluirFalha', error);
                                                });
                            }
                        };

                    }]);


