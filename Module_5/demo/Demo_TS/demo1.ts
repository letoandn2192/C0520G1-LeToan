// @ts-ignore
let pro = new Promise(
    function (resolve, reject) {
        console.log("hello");
    }
)

let connectDB = function (user, pass) {
    // @ts-ignore
    return new Promise(
        function (resolve, reject) {
            setTimeout(function () {
                if (user != "admin" || pass != "123") {
                    return reject("username or password not correct");
                } else {
                    return resolve("codegym.vn");
                }
            }, 2000);
        }
    )
}

let getData = function (url) {
    // @ts-ignore
    return new Promise(
        function (resolve, reject) {
            setTimeout(function () {
                if (url != "codegym.vn") {
                    return reject("URL format not good");
                } else {
                    return resolve("C05 Module 5");
                }
            }, 2000);
        }
    )
};

connectDB("admin", "123")
    .then(
        url => getData(url+"aa")
        // ,error => console.log("ERROR_1: " +error)
    )
    .then(
        data => console.log("DATA: "+ data)
        // ,error => console.log("ERROR_2: "+ error)
    ).catch(error => console.log("ERROR: " +error));
