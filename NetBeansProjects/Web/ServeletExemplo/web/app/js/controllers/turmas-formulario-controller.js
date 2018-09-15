angular.module('curso')
        .controller('turmasFormularioController',
                    ['$scope',
                    'ServicoTurma',
                    '$state',
                    '$stateParams',
                    function ($scope, ServicoTurma, $state, $stateParams) {

                        var self = this;
                        this.inicializar = function () {
                            $scope.turma = {};
                            $scope.titulo = "Nova Turma";
                            if ($stateParams.idTurma) {
                                self.carregarTurma($stateParams.idTurma);
                                $scope.titulo = "Editar Turma";
                            }
                        };
                        this.carregarTurma = function (id) {
                            ServicoTurma.buscarTurma(id)
                                    .then(function (response) {
                                        $scope.turma = response.data;
                                    }, function (erro) {
                                        alert('Não foi possível carregar a Turma [:(]');
                                    });
                        };

                        this.irParaLista = function () {
                            $state.go('turmas.lista');
                        };
                        this.mostrarMensagemErro = function () {
                            alert('Não foi possível  Salvar o Turma [:(]');
                        };

                        $scope.salvar = function (turma) {
                            if (turma.id) {
                                ServicoTurma.editar(turma);
                            } else {
                                ServicoTurma.incluir(turma);
                            }
                        };

                        $scope.$on('turmaSelecionado', function (event, turma) {
                            $scope.curso.turma = turma;
                        });

                        $scope.$on('servicoTurmaIncluirSucesso', function (event, turma) {
                            self.irParaLista();
                        });
                        $scope.$on('servicoTurmaIncluirFalha', function (event, erro) {
                            self.mostrarMensagemErro();
                        });
                        $scope.$on('servicoTurmaEditarSucesso', function (event, turma) {
                            self.irParaLista();
                        });
                        $scope.$on('servicoTurmaEditarFalha', function (event, erro) {
                            self.mostrarMensagemErro();
                        });

                        $scope.$on('turmaSelecionado', function (event,turma) {
                            $scope.curso.turma = turma;
                        });


                        this.inicializar();

                    }]);


