angular.module("projeto")
        .directive("textInput", function () {
            return{
                restrict: "E",
                replace: true,
                transclude: true,
                scope: {
                    colClass: "@",
                    label: "@",
                    inputName: "@",
                    placeholder: "@",
                    type: "@",
                    model: "=",
                    disabled: "="
                },
                templateUrl: "app/partials/directives/textInput.html"
            };
        });

