"use strict";
var AppSettings = (function () {
    function AppSettings() {
    }
    Object.defineProperty(AppSettings, "API_ENDPOINT", {
        get: function () {
            return 'http://localhost:18080/rest';
        },
        enumerable: true,
        configurable: true
    });
    return AppSettings;
}());
exports.AppSettings = AppSettings;
