"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var person_1 = require("./person");
var Startup = /** @class */ (function () {
    function Startup() {
    }
    Startup.main = function () {
        var p = new person_1.Person("Paul", 23);
        console.log(p.name + " is " + p.age + " years old");
        return 0;
    };
    return Startup;
}());
Startup.main();
//# sourceMappingURL=startup.js.map