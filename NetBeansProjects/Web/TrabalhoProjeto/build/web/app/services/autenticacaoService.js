angular.module('projeto')
        .factory('AutenticacaoService',
                ['$http', '$rootScope', '$cookies',
                    function ($http, $rootScope, $cookies) {

                        var user = null;

                        return{
                            login: function (credencial) {

                                $http.post('api/login', JSON.stringify(credencial))
                                        .then(function (response) {
                                            user = response.data;
                                            $cookies.putObject('credencial', user);
                                            $rootScope.$broadcast('loginComSucesso', user);

                                        }, function (error) {

                                            $rootScope.$broadcast('loginComErro');
                                        });
                            },
                            logout: function () {
                                user = null;
                                $cookies.remove('credencial');
                                $rootScope.$broadcast('logoutComSucesso');
                            },
                            getUsuario: function () {
                                user = $cookies.getObject('credencial', user);
                                return user;
                            }
                        };
                    }]);
