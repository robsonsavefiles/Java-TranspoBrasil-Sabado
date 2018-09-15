angular.module("projetos")
        .controller("navegacaoController", ["$scope", function ($scope) {

                $scope.irParaLista = function () {
                    $scope.$broadcast("navegacaoLista");
                };

                $scope.irParaNovo = function () {
                    $scope.$broadcast("navegacaoNovo");
                };

                $scope.$on("mudarTitulo", function (event, titulo) {
                    $scope.titulo = titulo;
                });

                $scope.$on("mudarSubtitulo", function (event, subtitulo) {
                    $scope.subtitulo = subtitulo;
                });

                $scope.$on("mudarTituloSubtitulo", function (event, titulo, subtitulo) {
                    $scope.titulo = titulo;
                    $scope.subtitulo = subtitulo;
                });

            }]);