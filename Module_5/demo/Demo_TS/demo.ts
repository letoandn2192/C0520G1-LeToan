let isExist:boolean = false;
console.log(isExist); //true

let numberA:number = 6;

let str:string = "abc";

let myArray:string[] = ["a","b"];
myArray[3] = "c";
console.log(myArray.toString())

let myArray2: Array<number> = [8,8,9];

let zz:any;
zz = 5;
zz = "anc";
let myArray3: any[] = [1,true,"one"];

let myArray1:[string,number] = ["a",2];
// @ts-ignore
myArray1[2] = true;
// @ts-ignore
console.log(myArray1[2]);

let xx:[string,number];
xx = ["a",1];
xx[0] = "b";

// @ts-ignore
let sym1 = Symbol();
// @ts-ignore
let sym2 = Symbol();
console.log(sym1 == sym2);

enum Sex {MALE=1, FEMALE, OTHER};
let c:Sex  = Sex.FEMALE;
console.log(c);
console.log(Sex[c]);

class Student {
    id:number;
    name:string;
    constructor(id:number, name:string) {
        this.id = id;
        this.name = name;
    }
}
let student = new Student(1, "Tra");
console.log(student)


console.log(quang);
var quang:string = "Quang";

const PATH:string = "abc";
