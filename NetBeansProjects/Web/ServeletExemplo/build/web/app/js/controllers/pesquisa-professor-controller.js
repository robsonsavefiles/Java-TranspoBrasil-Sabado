angular.module('curso')
        .controller('pesquisaProfessorController',
['$scope','ServicoProfessor',function($scope,ServicoProfessor){
    
    var self = this;
    
    this.inicializar = function(){
      $scope.professores = [];
      ServicoProfessor.buscarTodos();  
    };
    
    $scope.selecionar = function(professor){
        $scope.$emit('professorSelecionado',professor);
    };
    
    $scope.$on('servicoProfessorBuscarTodosSucesso',
    function(event, professores){
        $scope.professores = professores;
    });
    $scope.$on('servicoProfessorBuscarTodosFalha',
    function(event, erro){
        alert('Não foi possível carregar os professores');
    });
    
    this.inicializar();
        
}]);

