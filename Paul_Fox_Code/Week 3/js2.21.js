// function testVar(){

//     var x = 5;

//     {
//         var x = 10;
//     }

//     console.log(x);

// }

// testVar();

// function testLet(){

//     let y = 5;
//     var self = this;
//     {
//         let y = 10;
//         console.log(self.y);
//     }
//     console.log(y);

// }

// testLet();

// const day = "Wednesday";
// console.log(day);
// //day = "Thursday";

// class Person {
//     constructor(name, age){
//         this.name = name;
//         this.age = age;
//     }
// }

// class Student extends Person {
//     constructor(name, age, major){
//         super(name, age);
//         this.major = major;
//     }
// }

// let people = new Map();
// people.set(1, new Person("John", 21))
//     .set(2, new Person("Erica", 27))
//     .set(3, new Person("Steven", 74));

// people.forEach((person)=>{
//     console.log(`${person.name} is ${person.age} years old`)
// });

// let items = new Map([
//     ["grapes", 2.99],
//     ["cheddar", 1.75],
//     ["bread", 2.99]
// ]);

// for(let k of items.keys()){

//     console.log(`${k} is on sale for ${items.get(k)}`);
    
// }

// function Sum(num1, num2){

//     num2 && num2 ? num2 : null;
//     if(num2 != null){
//         console.log(num1 + num2);
//     }
//     return function Sum(num2){
//         console.log(num1 + num2);
//     }

// };

// Sum(11)(4);
// Sum(11, 3);

