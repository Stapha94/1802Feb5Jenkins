class Person {

    constructor(name, age){

        this.name = name;
        this.age = age;

    }

    live(){}
    payTax(){}
    dir(){}

}

var Person2 = (function(){

    function Person(name, age){
        this.name = name;
        this.age = age;

    }

    Person.live = function() {}
    Person.payTax = function() {}
    Person.die = function() {}

    return Person;

})()

var p1 = Person("Paul", 23);
var p2 = Person2("Sally", 21);