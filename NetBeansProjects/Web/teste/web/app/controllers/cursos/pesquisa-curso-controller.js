angular.module('curso')
        .controller('pesquisaCursoController',
['$scope', 'ServicoCurso',
    function($scope, ServicoCurso){
        
        var self = this;
        
        this.inicializar = function(){
            $scope.cursos = [];
            ServicoCurso.buscarCursos();
        };
        
        $scope.selecionar = function(curso){
            $scope.$emit('cursoSelecionado', curso);
        };
        
        $scope.$on('ServicoCursoBuscarTodosSucesso', function(event, cursos){
            $scope.cursos = cursos;
        });
        
        $scope.$on('ServicoCursoBuscarTodosFalha', function(event, erro){
            alert('Não foi possível carregar os Cursos');
        });
        
        
        this.inicializar();
        
    }]);
