angular.module('curso')
        .controller('pesquisaCursoController',
['$scope','ServicoCurso',function($scope,ServicoCurso){
    
    var self = this;
    
    this.inicializar = function(){
      $scope.cursos = [];
      ServicoCurso.buscarTodos();  
    };
    
    $scope.selecionar = function(curso){
        $scope.$emit('cursoSelecionado',curso);
    };
    
    $scope.$on('servicoCursoBuscarTodosSucesso',
    function(event, curso){
        $scope.cursos = curso;
    });
    $scope.$on('servicoCursoBuscarTodosFalha',
    function(event, erro){
        alert('Não foi possível carregar os cursos');
    });
    
    this.inicializar();
        
}]);

