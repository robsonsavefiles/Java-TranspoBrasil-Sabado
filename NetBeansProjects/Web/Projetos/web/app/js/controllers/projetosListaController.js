angular.module("projetos")
        .controller("projetosListaController", ["$scope", "ProjetosService", "$state",
            function ($scope, ProjetosService, $state) {
                this.inicializar = function () {
                    $scope.$emit("mudarTituloSubtitulo", "Projetos", "Lista");
                    ProjetosService.buscarTodos();
                };

                $scope.irParaNovo = function () {
                    $state.go("projetos.novo");
                };

                $scope.irParaDetalhes = function (projeto) {
                    $state.go("projetos.detalhes", {"id": projeto.id});
                };

                $scope.irParaEditar = function (projeto) {
                    $state.go("projetos.editar", {"id": projeto.id});
                };

                $scope.remover = function (projeto) {
                    ProjetosService.remover(projeto);
                };

                $scope.$on("projetosServiceBuscarTodosSucesso", function (event, projetos) {
                    $scope.projetos = projetos;
                });

                $scope.$on("projetosServiceBuscarTodosFalha", function (event, erro) {
                    alert("Falha ao carregar os projetos!");
                });

                $scope.$on("projetosServiceRemoverSucesso", function (event, projetoRemovido) {
                    var item = null;
                    angular.forEach($scope.projetos, function (projeto) {
                        if (projeto.id === projetoRemovido.id) {
                            item = projeto;
                        }
                    });
                    var index = $scope.projetos.indexOf(item);
                    if (index > -1) {
                        $scope.projetos.splice(index, 1);
                    }
                });

                $scope.$on("projetosServiceRemoverFalha", function (event, erro) {
                    alert("Falha ao remover o projeto!");
                });

                $scope.$on("navegacaoNovo", function (event) {
                    $scope.irParaNovo();
                });

                this.inicializar();
            }]);