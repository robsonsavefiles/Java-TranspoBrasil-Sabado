//define a criação de um modulo para a aplicação
angular.module('angular-base',['ui.router'])
        .config(function($stateProvider, $urlRouterProvider){
            $urlRouterProvider.otherwise("/");
            $stateProvider
                    .state("pagina1",{
                        url:'/pagina1',
                templateUrl : 'angularbase/paginas/pagina1.html',controller:'principalController'
                    })
                    .state("pagina2",{
                        url:'/pagina2',
                templateUrl : 'angularbase/paginas/pagina2.html',controller:'principalController'
                    })
                    .state("pagina3",{
                        url:'/pagina3',
                templateUrl : 'angularbase/paginas/pagina3.html',controller:'principalController'
                    })
                    .state("pagina4",{
                        url:'/pagina4',
                template : '<h1> Aqui vai a Pagina4 :) </h1>'
                    })
                    .state("pagina5",{
                        url:'/pagina5',
                templateUrl : 'angularbase/paginas/pagina5.html'
                    });
                    
});
