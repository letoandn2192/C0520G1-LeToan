function handleTimeOut(timeOut) {
    // @ts-ignore
    return new Promise(function (resolve, reject) {
        setTimeout(resolve, timeOut);
    });
}
var test = handleTimeOut(5000);
test.then(function () {
    console.log("LAP");
})
    .then(function () {
    return handleTimeOut(3000);
})
    .then(function () {
    console.log("TRINH");
})
    .then(function () {
    return handleTimeOut(1000);
})
    .then(function () {
    console.log("JAVASCRIPT");
});
var x = 5, y = 10, z = 15;
x = y; //x would be 10
console.log(x);
x += 1; //x would be 6
console.log(x);
