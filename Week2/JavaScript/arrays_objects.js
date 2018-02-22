//@ts-check
var arr = [];
arr[99] = "Something";
arr['cat'] = "Waffles";

// for(var i = 0; i < arr.length; i++) {
//     console.log(arr[i]);
// }

// for(var o of arr){
//     console.log(o);
// }

// for(var o in arr) {
//     console.log(o);
// }

// var p = {
//     name: "August",
//     age: 35,
//     doWork: function() {
//         return "Code is life";
//     }
// }

// console.log(p.name + " is " + p.age + " years old " + p.doWork());

// console.log(p.hasOwnProperty("retire"));

// p.retire = function() {
//     console.log("Florida here I come");
// }

// p.retire();

function Person(name, age) {
    this.name = name;
    this.age = age;
}

Person.prototype = Object.create(Object.prototype);
Person.prototype.live = function(){
    console.log("I hate Mondays!");
}

Person.prototype.die = function() {
    console.log("Push up daisies");
}

Person.prototype.payTaxes = function() {
    console.log("Sure go ahead and steal my money");
}

var p1 = new Person("August", 35);
// console.log(p1.name);
// console.log("p1.__proto__: " + p1.__proto__);
// console.log(p1);
// p1.live();
// p1.payTaxes();
// p1.die();

// Person.prototype.someValue = 10;

// console.log(p1.someValue);

function Student(name, age, major) {
    //Person(name, age);
    //bind the student to name and age
    //not Person
    Person.call(this, name, age);
    this.major = major;
}

Student.prototype = Object.create(Person.prototype);
Student.prototype.goToClass = function(day) {

    if(day && day === 'Thursday') {
        return true;
    }
    return false;
}

var s1 = new Student("John", 20, "Humanities");
console.log("s1.__proto__: " +s1.__proto__);
console.log(s1);
s1.live();
console.log("Should I go to class today?");
console.log(s1.goToClass("Tuesday") ? "Oh my favorite Sociology" : "Not today");
s1.payTaxes();
s1.die();
