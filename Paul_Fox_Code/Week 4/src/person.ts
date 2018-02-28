export class Person {

    name: string;
    age: number;

    constructor(name: string, age: number){

        this.name = name;
        this.age = age;

    }

    public live(): void {}
    public payTax(): void {}
    public die(): void {}

}