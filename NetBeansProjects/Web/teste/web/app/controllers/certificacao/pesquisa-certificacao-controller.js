angular.module('curso')
        .controller('pesquisaCertificacoesController',
['$scope', 'ServicoCertificacoes',
    function($scope, ServicoCertificacoes){
        
        var self = this;
        
        this.inicializar = function(){
            $scope.certificacoes = [];
            ServicoCertificacoes.buscarCertificacoes();
        };
        
        $scope.selecionar = function(certificacao){
            $scope.$emit('certificacaoSelecionado', certificacao);
        };
        
        $scope.$on('servicoCertificacaoBuscarTodosSucesso', function(event, certificacoes){
            $scope.certificacoes = certificacoes;
        });
        
        $scope.$on('ServicoCertificacaoBuscarTodosFalha', function(event, erro){
            alert('Não foi possível carregar os Professores');
        });
        
        
        this.inicializar();
        
    }]);
