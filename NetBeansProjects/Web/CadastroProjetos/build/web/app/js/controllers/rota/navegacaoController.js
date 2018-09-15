angular.module("projeto")
        .controller("navegacaoController", ["$scope", function ($scope) {

                $scope.irParaLista = function () {
                    $scope.$broadcast("navegacaoLista");
                };

                $scope.irParaNovo = function () {
                    $scope.$broadcast("navegacaoNovo");
                };
            }]);