angular.module('curso').controller('pesquisaProfessorController',
        ['$scope', 'ServicoProfessor', function ($scope, ServicoProfessor) {
                var self = this;
                this.inicializar = function () {
                    ServicoProfessor.buscarTodos();
                };

                $scope.selecionar = function (professor) {
                    $scope.$emit('professorSelecionado', professor);

                };
                $scope.$on('servicoProfessorBuscarTodosSucesso',
                        function (event, professores) {

                        });
                $scope.$on('servicoProfessorBuscarTodosFalha',
                        function (event, erro) {
                            alert('Nao foi possivel carregar os professores');

                        });
                this.inicializar();

            }]);


