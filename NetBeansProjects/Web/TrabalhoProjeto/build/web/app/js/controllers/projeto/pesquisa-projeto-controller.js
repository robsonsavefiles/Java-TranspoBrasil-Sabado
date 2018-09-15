angular.module('projeto')
        .controller('pesquisaProjetosController',
                ['$scope', 'ServicoProjeto',
                    function ($scope, ServicoProjeto) {

                        var self = this;

                        this.inicializar = function () {
                            $scope.projetos = [];
                            ServicoProjeto.buscarProjetos();
                        };

                        $scope.selecionar = function (projeto) {
                            $scope.$emit('projetoSelecionado', projeto);
                        };

                        $scope.$on('ServicoProjetoBuscarTodosSucesso', function (event, projeto) {
                            $scope.projetos = projeto;
                        });

                        $scope.$on('ServicoProjetoBuscarTodosFalha', function (event, erro) {
                            alert('Não foi possível carregar os Projetos');
                        });


                        this.inicializar();

                    }]);
