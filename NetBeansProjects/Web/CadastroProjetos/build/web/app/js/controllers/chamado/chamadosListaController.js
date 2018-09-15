angular.module("projeto")
        .controller("chamadosListaController", ["$rootScope", "$scope", "ChamadosService", "ProjetosService", "$state",
            function ($rootScope, $scope, ChamadosService, ProjetosService, $state) {
                this.inicializar = function () {
                    $rootScope.titulo = "Chamados";
                    $rootScope.subtitulo = "Lista";
                    ProjetosService.buscarTodos();
                    ChamadosService.buscarTodos();
                };

                $scope.irParaNovo = function () {
                    $state.go("chamados.novo");
                };

                $scope.irParaDetalhes = function (chamado) {
                    $state.go("chamados.detalhes", {"id": chamado.id});
                };

                $scope.irParaEditar = function (chamado) {
                    $state.go("chamados.editar", {"id": chamado.id});
                };

                $scope.remover = function (chamado) {
                    ChamadosService.remover(chamado);
                };

                $scope.atualizarChamados = function () {
                    ChamadosService.buscarPorProjeto($scope.projeto.id);
                };

                $scope.$on("chamadosServiceBuscarPorProjetoSucesso", function (event, chamados) {
                    $scope.chamados = chamados;
                });

                $scope.$on("chamadosServiceBuscarPorProjetoFalha", function (event, erro) {
                    alert("Não foi possível carregar os chamados!");
                });


                $scope.$on("projetosServiceBuscarTodosSucesso", function (event, projetos) {
                    $scope.projetos = projetos;
                });

                $scope.$on("projetosServiceBuscarTodosFalha", function (event, erro) {
                    alert("Não foi possível carregar os projetos!");
                });

                $scope.$on("chamadosServiceBuscarTodosSucesso", function (event, chamados) {
                    $scope.chamados = chamados;
                });

                $scope.$on("chamadosServiceBuscarTodosFalha", function (event, erro) {
                    alert("Falha ao carregar os chamados!");
                });

                $scope.$on("chamadosServiceRemoverSucesso", function (event, chamadoRemovido) {
                    var item = null;
                    angular.forEach($scope.chamados, function (chamado) {
                        if (chamado.id === chamadoRemovido.id) {
                            item = chamado;
                        }
                    });
                    var index = $scope.chamados.indexOf(item);
                    if (index > -1) {
                        $scope.chamados.splice(index, 1);
                    }
                });

                $scope.$on("chamadosServiceRemoverFalha", function (event, erro) {
                    alert("Falha ao remover o chamado!");
                });

                $scope.$on("navegacaoNovo", function (event) {
                    $scope.irParaNovo();
                });

                this.inicializar();
            }]);