// console.log("Hello, World!");

// var num = 10;
// //num = "Hello, World";
// var num2 = new Number(10);
// console.log(num + num2);

// console.log(5 + " cat");
// console.log("cat" - 5);

// function printStatement(msg) {
//     console.log(msg);
// }

// var ps = function(msg) {
//     console.log(msg);
//     for(let o of arguments) {
//         console.log(typeof o);
//     }
// }

// printStatement("Hello, printStatement");
//ps("Hello, ps", 1, true, () =>{});

// function Person(name, age) {
//     this.name = name;
//     this.age = age;
// }

// var p = new Person("August", 35);
// console.log(p.name + " is ".concat(p.age));
// console.log(typeof p);
// console.log(p);

// var teams = ['Saints', 'Falcons', 'Panthers', "Bucaneers"];
// teams.forEach(function(item){
//     console.log(item);
// });

var root = function() {
    return function() {
        console.log("I am the child of root");
    }
}();

root();

