export class Employee {

    constructor(

        public firstName: string,
        public lastName: string,
        private SSN: string,
        public email: string,
        private password: string,
        public employeId: number,
        public departmentId: number,
        public supervisorId: number,

    ) {}
}
