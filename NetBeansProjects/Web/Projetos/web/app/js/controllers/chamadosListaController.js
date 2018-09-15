angular.module("projetos")
        .controller("chamadosListaController", ["$scope", "ChamadosService", "ProjetosService", "$state",
            function ($scope, ChamadosService, ProjetosService, $state) {
                this.inicializar = function () {
                    $scope.$emit("mudarTituloSubtitulo", "Chamados", "Lista");
                    ProjetosService.buscarTodos();
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