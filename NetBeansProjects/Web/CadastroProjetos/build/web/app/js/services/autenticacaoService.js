angular.module("projeto")
        .factory("AutenticacaoService", ["$http", "$rootScope", "$cookies", function ($http, $rootScope, $cookies) {
                var usuario = null;

                return {
                    login: function (credencial) {
                        $http.post("login", angular.toJson(credencial)).then(
                                function (response) {
                                    usuario = response.data;
                                    $cookies.putObject("credencial", usuario);
                                    $rootScope.$broadcast("loginComSucesso", usuario);
                                },
                                function (error) {
                                    $rootScope.$broadcast("loginComErro", error);
                                });
                    },
                    logout: function () {
                        usuario = null;
                        $cookies.remove("credencial");
                        $rootScope.$broadcast("logoutComSucesso", usuario);
                    },
                    getUsuario: function () {
                        return $cookies.getObject("credencial");
                    }
                };
            }]);