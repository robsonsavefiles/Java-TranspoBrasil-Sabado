angular.module('lab').directive('philInput', function () {
    return{
        restrict: 'E',
        scope: {
            mobile: '@',
            personalComputer: '@',
            label: '@',
            inputClass: '@',
            model: '=',
            inputName: '@',
            placeholder: '@',
            type: '@',
            minLength: '@',
            maxLength: '@',
            required: '@'
        },
        templateUrl: 'app/partials/directives/inputForm.html'
    };
});





//app/partials/directives/