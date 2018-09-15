angular.module('curso')
        .controller('professoresDetalheController',
                ['$scope', 'ServicoProfessor','$stateParams', '$state', function ($scope, ServicoProfessor, $stateParams, $state) {


                        var self = this;
                        
                        this.inicializar = function () {

                            $scope.professor = {};
                            if ($stateParams.idProfessor) {
                                self.carregarCertificacao($stateParams.idProfessor);
                                $scope.titulo = $scope.professor.nome;
                            }else{
                                $state.go('professores.listar');
                                alert('Professor não encontrado!');
                            }
                        };

                        this.carregarCertificacao = function (id) {

                            ServicoProfessor.buscarProfessor(id)
                                    .then(function (response) {
                                        $scope.professor = response.data;
                                    }, function (erro) {
                                        alert('Não foi possível carregar o professor' + erro);
                                    });

                        };   
                        
                        self.inicializar();
                        
                    }]);

