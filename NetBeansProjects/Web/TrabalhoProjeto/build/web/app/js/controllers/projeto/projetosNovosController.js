angular.module('projeto').controller('projetosNovosController', ['$scope',
    'ServicoProjeto',
    '$state',
    '$stateParams',
    function ($scope, ServicoProjeto, $state, $stateParams) {

        var self = this;


        this.inicializar = function () {

            $scope.titulo = "Novo Projeto";
            $scope.projeto = {};
            if ($stateParams.idProjeto) {
                self.carregarProjeto($stateParams.idProjeto);
                $scope.titulo = "Editar Projeto";
            }
        };

        this.carregarProjeto = function (id) {

            ServicoProjeto.buscarProjeto(id)
                    .then(function (response) {
                        $scope.projeto = response.data;
                    }, function (erro) {
                        alert('Não foi possível carregar o projeto');
                    });

        };

        this.irParaLista = function () {
            $state.go('projetos.lista');
        };

        this.mostrarMensagemErro = function () {
            alert('Não foi possivel salvar o Projeto');
        };


        $scope.salvar = function (projeto) {
            if (projeto.id) {
                ServicoProjeto.editar(projeto);
            } else {
                ServicoProjeto.incluir(projeto);
            }
        };


        $scope.$on('projetoSelecionado', function (event, projeto) {
            $scope.projeto = projeto;
        });

        $scope.$on('ServicoProjetoIncluirSucesso', function (event, projeto) {
            self.irParaLista();
        });

        $scope.$on('ServicoProjetoIncluirFalha', function (event, projeto) {
            self.mostrarMensagemErro();
        });


        $scope.$on('ServicoProjetoEditarSucesso', function (event, projeto) {
            self.irParaLista();
        });

        $scope.$on('ServicoProjetoEditarFalha', function (event, projeto) {
            self.mostrarMensagemErro();
        });





        this.inicializar();

    }]);