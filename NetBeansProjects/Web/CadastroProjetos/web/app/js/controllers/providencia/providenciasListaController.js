angular.module("projeto")
        .controller("providenciasListaController", ["$rootScope", "$scope", "ProvidenciasService", "ProjetosService", "ChamadosService", "$state",
            function ($rootScope, $scope, ProvidenciasService, ProjetosService, ChamadosService, $state) {
                this.inicializar = function () {
                    $rootScope.titulo = "Providências";
                    $rootScope.subtitulo = "Lista";
                    ProvidenciasService.buscarTodos();
                    ProjetosService.buscarTodos();
                };

                $scope.irParaNovo = function () {
                    $state.go("providencias.novo");
                };

                $scope.irParaDetalhes = function (chamado, providencia) {
                    $state.go("providencias.detalhes", {"chamadoId": chamado.id, "id": providencia.id});
                };

                $scope.irParaEditar = function (chamado, providencia) {
                    $state.go("providencias.editar", {"chamadoId": chamado.id, "id": providencia.id});
                };

                $scope.remover = function (chamado, providencia) {
                    ProvidenciasService.remover(chamado.id, providencia.id);
                };

                $scope.$on("projetosServiceBuscarTodosSucesso", function (event, projetos) {
                    $scope.projetos = projetos;
                });

                $scope.$on("projetosServiceBuscarTodosFalha", function (event, erro) {
                    alert("Não foi possível carregar os projetos!");
                });

                $scope.atualizarChamados = function () {
                    $scope.chamado = {};
                    ChamadosService.buscarPorProjeto($scope.projeto.id);
                };

                $scope.$on("chamadosServiceBuscarPorProjetoSucesso", function (event, chamados) {
                    $scope.chamados = chamados;
                });

                $scope.$on("chamadosServiceBuscarPorProjetoFalha", function (event, erro) {
                    alert("Não foi possível carregar os chamados!");
                });

                $scope.atualizarProvidencias = function () {
                    $scope.providencias = $scope.chamado.providencias;
                };

                $scope.$on("providenciasServiceBuscarTodosSucesso", function (event, providencias) {
                    $scope.providencias = providencias;
                });

                $scope.$on("providenciasServiceBuscarTodosFalha", function (event, erro) {
                    alert("Falha ao carregar os providencias!");
                });

                $scope.$on("providenciasServiceRemoverSucesso", function (event, providenciaRemovida) {
                    var item = null;
                    angular.forEach($scope.providencias, function (providencia) {
                        if (providencia.id === providenciaRemovida.id) {
                            item = providencia;
                        }
                    });
                    var index = $scope.providencias.indexOf(item);
                    if (index > -1) {
                        $scope.providencias.splice(index, 1);
                    }
                });

                $scope.$on("providenciasServiceRemoverFalha", function (event, erro) {
                    alert("Falha ao remover o chamado!");
                });

                $scope.$on("navegacaoNovo", function (event) {
                    $scope.irParaNovo();
                });

                this.inicializar();
            }]);