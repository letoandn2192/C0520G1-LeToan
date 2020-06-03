function checkInfo() {
    let idCheck = document.getElementById('id').value;
    let passCheck = document.getElementById('password').value;
    if(idCheck == 'Admin'){
        if(passCheck == 'TheMaster'){
            document.getElementById('screen').innerHTML = 'Welcome !';
        }else if(passCheck == ''){
            document.getElementById('screen').innerHTML = 'Canceled';
        }else{
            document.getElementById('screen').innerHTML = 'Wrong Password';
        }
    }else if(idCheck == null){
        document.getElementById('screen').innerHTML = 'Canceled';
    }else{
        document.getElementById('screen').innerHTML = "I don't know you";
    }
}