angular.module('curso')
 .factory('ServicoCertificacao',
          ['$http',
           '$rootScope',
       function($http,$rootScope){
           
           return {
               
               buscarTodos: function(){
                   $http.get('certificacoes')
                   .then(function(response){
                       $rootScope.$broadcast('servicoCertificacaoBuscarTodosSucesso',response.data);
                   },function(error){
                       $rootScope.$broadcast('servicoCertificacaoBuscarTodosFalha',error);
                   });
               },
               
               buscarCertificacoes: function(id){
                  return  $http.get('certificacoes?id='+id);
               },
               editar: function(certificacao){
                   $http.put('certificacoes',JSON.stringify(certificacao))
                   .then(function(response){
                       $rootScope.$broadcast('servicoCertificacaoEditarSucesso',response.data);
                   },function(error){
                       $rootScope.$broadcast('servicoCertificacaoEditarFalha',error);
                   });
               },
               incluir: function(certificacao){
                   $http.post('certificacoes',angular.toJson(curso))
                   .then(function(response){
                       $rootScope.$broadcast('servicoCertificacaoIncluirSucesso',response.data);
                   },function(error){
                       $rootScope.$broadcast('servicoCertificacaoIncluirFalha',error);
                   });
               },
               remover: function(certificacao){
                   $http.delete('certificacoes?id='+certificacao.id)
                   .then(function(response){
                       $rootScope.$broadcast('servicoCertificacaoRemoverSucesso',response.data);
                   },function(error){
                       $rootScope.$broadcast('servicoCertificacaoRemoverFalha',error);
                   });
               }
               
           }
       }]);

