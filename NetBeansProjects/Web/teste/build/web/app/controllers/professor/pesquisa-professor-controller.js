angular.module('curso')
        .controller('pesquisaProfessorController',
['$scope', 'ServicoProfessor',
    function($scope, ServicoProfessor){
        
        var self = this;
        
        this.inicializar = function(){
            $scope.professores = [];
            ServicoProfessor.buscarProfessores();
        };
        
        $scope.selecionar = function(professor){
            $scope.$emit('professorSelecionado', professor);
        };
        
        $scope.$on('ServicoProfessorBuscarTodosSucesso', function(event, professores){
            $scope.professores = professores;
        });
        
        $scope.$on('ServicoProfessorBuscarTodosFalha', function(event, erro){
            alert('Não foi possível carregar os Professores');
        });
        
        
        this.inicializar();
        
    }]);
