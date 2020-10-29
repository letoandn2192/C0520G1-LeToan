var isExist = false;
console.log(isExist); //true
var numberA = 6;
var str = "abc";
var myArray = ["a", "b"];
myArray[3] = "c";
console.log(myArray.toString());
var myArray2 = [8, 8, 9];
var zz;
zz = 5;
zz = "anc";
var myArray3 = [1, true, "one"];
var myArray1 = ["a", 2];
// @ts-ignore
myArray1[2] = true;
// @ts-ignore
console.log(myArray1[2]);
var xx;
xx = ["a", 1];
xx[0] = "b";
// @ts-ignore
var sym1 = Symbol();
// @ts-ignore
var sym2 = Symbol();
console.log(sym1 == sym2);
var Sex;
(function (Sex) {
    Sex[Sex["MALE"] = 1] = "MALE";
    Sex[Sex["FEMALE"] = 2] = "FEMALE";
    Sex[Sex["OTHER"] = 3] = "OTHER";
})(Sex || (Sex = {}));
;
var c = Sex.FEMALE;
console.log(c);
console.log(Sex[c]);
var Student = /** @class */ (function () {
    function Student(id, name) {
        this.id = id;
        this.name = name;
    }
    return Student;
}());
var student = new Student(1, "Tra");
console.log(student);
console.log(quang);
var quang = "Quang";
