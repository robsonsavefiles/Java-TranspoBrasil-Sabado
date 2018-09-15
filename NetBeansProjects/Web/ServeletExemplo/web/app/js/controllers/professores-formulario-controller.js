angular.module('curso')
        .controller('professoresFormularioController',
                ['$scope',
                    'ServicoProfessor',
                    '$state',
                    '$stateParams',
                    function ($scope, ServicoProfessor, $state, $stateParams) {

                        var self = this;
                        this.inicializar = function () {
                            $scope.professor = {};
                            $scope.titulo = "Novo Professor";
                            $scope.certificacoes = [];

                            if ($stateParams.idProfessor) {
                                self.carregarProfessor($stateParams.idProfessor);
                                $scope.titulo = "Editar Professor";
                            }
                        };
                        this.carregarProfessor = function (id) {
                            ServicoProfessor.buscarProfessor(id)
                                    .then(function (response) {
                                        $scope.professor = response.data;
                                    }, function (erro) {
                                        alert('Não foi possível carregar o professor [:(]');
                                    });
                        };

                        this.irParaLista = function () {
                            $state.go('professores.lista');
                        };
                        this.mostrarMensagemErro = function () {
                            alert('Não foi possível  Salvar o Professor [:(]');
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

                        $scope.$on('servicoProfessorIncluirSucesso', function (event, professor) {
                            self.irParaLista();
                        });
                        $scope.$on('servicoProfessorIncluirFalha', function (event, erro) {
                            self.mostrarMensagemErro();
                        });
                        $scope.$on('servicoProfessorEditarSucesso', function (event, professor) {
                            self.irParaLista();
                        });
                        $scope.$on('servicoProfessorEditarFalha', function (event, erro) {
                            self.mostrarMensagemErro();
                        });
                         $scope.$on('certificacaoSelecionado', function (event, certificacao) {
                            var existe = false;
                            angular.forEach($scope.certificacoes,function(certi, key){
                                if(angular.equals(certificacao,certi)){
                                    $scope.certificacoes.splice(key,1);
                                    $scope.professor.certificacoes = $scope.certificacoes;
                                    existe= true;
                                }
                            });
                            if(!existe){
                                $scope.certificacoes.push(certificacao);
                                $scope.professor.certificacoes = $scope.certificacoes;
                            }
                            
                        });
                        

                        this.inicializar();

                    }]);


