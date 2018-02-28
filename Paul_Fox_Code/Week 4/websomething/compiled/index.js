"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Person_1 = require("./Person");
var Startup = /** @class */ (function () {
    function Startup() {
    }
    Startup.main = function () {
        var p = new Person_1.Person("Paul", 23);
        console.log("Hello, World!");
    };
    return Startup;
}());
exports.Startup = Startup;
//# sourceMappingURL=index.js.map