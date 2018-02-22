// console.log("Hello, World!");

// var num = 10;
// num = "Hello, World!";
// var num2 = new Number(10);
// console.log(num + num2);

// console.log(5 + "cat");
// console.log("cat" - 5);

// function printStatement(msg){

//     console.log(msg);

// }

// var ps = function(msg){

//     console.log(msg);
//     for(let o of arguments){

//         console.log(typeof o);

//     }

// }

// printStatement("Hello, printStatement!");
// ps("Hello, ps", 1, true, () =>{});

// function Person(name, age){

//     this.name = name;
//     this.age = age;

// }

// var p = new Person("August", 35);
// console.log(p.name + " is " .concat(p.age));
// console.log(p);
// console.log(typeof p);

// var teams = ['Saints', 'Falcons', 'Panthers', "Bucaneers"];
// teams.forEach(function(item){

// console.log(item);

// });


// var root = function() {

//     return function() {
//         console.log("I am the child of root");
//     }

// This is called immediately invoking function expression
// }();

// root();

var arr = [];
arr[99] = "Something";
arr['cat'] = "cat";

// for(var i = 0; i < arr.length; i++){

//     console.log(arr[i]);

// }

// for(var o of arr){

//     console.log(o);

// }

// for(var o in arr){

//     console.log(o);

// }

// var p = {

//     name: "Paul",
//     age: "23",
//     doWork: function() {

//         console.log("Code is Life");

//     }

// }

// console.log(p.name + " is " + p.age + " years old.");
// p.doWork();

// console.log(p.hasOwnProperty("retire"));

// p.retire = function() {

//     console.log("Florida here I come");

// }

// p.retire();

function Person(name, age){

    this.name = name;
    this.age = age;

}

Person.prototype = Object.create(Object.prototype);

Person.prototype.live = function(){

    console.log("I hate Mondays!");

}

Person.prototype.die = function(){

    console.log("Push up Daisies");

}

Person.prototype.payTaxes = function(){

    console.log("Sure.... go ahead and steal my money");

}

// var p1 = new Person("Paul", 23);

// console.log("p1.__proto__: " + p1.__proto__);
// console.log(p1);

// p1.live();
// p1.payTaxes();
// p1.die();

// Person.prototype.someValue = 10;

// console.log(p1.someValue);

function Student(name, age, major){

    //Bind the student to name and age, not person
    Person.call(this, name, age);
    this.major = major;

}

Student.prototype = Object.create(Person.prototype);
Student.prototype.goToClass = function(day){

    if(day && day === "Thursday"){

        return true;

    }
    return false;

}

var s1 = new Student("Sally", 20, "Computer Science");

console.log("s1.__proto__: " + s1.__proto__);
console.log(s1);

s1.live();
console.log("Should I go to class today?");
console.log(s1.goToClass("Tuesday") ? "Oh my favorite, Data Structures" : "Not Today");
s1.payTaxes;
s1.die();
