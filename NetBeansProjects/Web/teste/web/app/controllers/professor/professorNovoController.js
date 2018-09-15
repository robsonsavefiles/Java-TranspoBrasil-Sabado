angular.module('curso')
        .controller('professorNovoController',
                ['$scope',
                    'ServicoProfessor',
                    '$state',
                    '$stateParams',
                    function ($scope, ServicoProfessor, $state, $stateParams) {

                        var self = this;


                        this.inicializar = function () {

                            $scope.titulo = "Novo Professor";
                            $scope.certificacoes = [];
                            $scope.professor = {};
                            if ($stateParams.idProfessor) {
                                self.carregarProfessor($stateParams.idProfessor);
                                $scope.titulo = "Editar Curso";
                            }
                        };

                        this.carregarProfessor = function (id) {

                            ServicoProfessor.buscarProfessor(id)
                                    .then(function (response) {
                                        $scope.professor = response.data;
                                    }, function (erro) {
                                        alert('Não foi possível carregar o curso');
                                    });

                        };

                        this.irParaLista = function () {
                            $state.go('professores.lista');
                        };

                        this.mostrarMensagemErro = function () {
                            alert('Não foi possivel salvar o Professor');
                        };


                        $scope.salvar = function (professor) {
                            if (professor.id) {
                                ServicoProfessor.editar(professor);
                            } else {
                                ServicoProfessor.incluir(professor);
                            }
                        };


                        $scope.$on('professorSelecionado', function (event, professor) {
                            $scope.professor.professor = professor;
                        });

                        $scope.$on('ServicoProfessorIncluirSucesso', function (event, curso) {
                            self.irParaLista();
                        });

                        $scope.$on('ServicoProfessorIncluirFalha', function (event, curso) {
                            self.mostrarMensagemErro();
                        });


                        $scope.$on('ServicoProfessorEditarSucesso', function (event, curso) {
                            self.irParaLista();
                        });

                        $scope.$on('ServicoProfessorEditarFalha', function (event, curso) {
                            self.mostrarMensagemErro();
                        });

                        $scope.$on('certificacaoSelecionado', function (event, certificacao) {
                            var exist = false;
                            angular.forEach($scope.certificacoes, function (cert, key) {
                                if (angular.equals(cert, certificacao)) {
                                    $scope.certificacoes.splice(key, 1);
                                    $scope.professor.certificacoes = $scope.certificacoes;
                                    exist = true;
                                }
                            });
                            if (!exist) {
                                $scope.certificacoes.push(certificacao);
                                $scope.professor.certificacoes = $scope.certificacoes;
                            }
                        });



                        this.inicializar();

                    }]);