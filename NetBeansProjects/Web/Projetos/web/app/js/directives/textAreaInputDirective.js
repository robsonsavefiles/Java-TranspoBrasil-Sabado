angular.module("projetos")
        .directive("textAreaInput", function () {
            return{
                restrict: "E",
                replace: true,
                transclude: true,
                scope: {
                    colClass: "@",
                    label: "@",
                    inputName: "@",
                    placeholder: "@",
                    model: "=",
                    disabled: "="
                },
                templateUrl: "app/partials/directives/textAreaInput.html"
            };
        });

