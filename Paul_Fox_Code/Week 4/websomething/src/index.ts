import { Person } from './Person';
export class Startup {

    public static main(): void {
        const p = new Person("Paul", 23);
        console.log("Hello, World!");
    }

}