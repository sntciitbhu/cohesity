document.querySelector('.nbtn').onclick = function() {
    document.querySelector('.nbtn').setAttribute('style','display:none;')
    document.querySelector('.dbtn').setAttribute('style','display:none;')
    document.querySelector('.abc').classList.remove('hideme');
}
document.querySelector('.dbtn').onclick = function() {
    document.querySelector('.nbtn').setAttribute('style','display:none;')
    document.querySelector('.dbtn').setAttribute('style','display:none;')
    document.querySelector('.def').classList.remove('hideme');
    document.querySelector('.dli').classList.remove('hideme');
}
document.querySelector('.dloginbtn').onclick = function() {
    var email = document.querySelector('.dlogine').value;
    var password = document.querySelector('.dloginp').value;
    if (email === 'abc@abc.com' && password === '1234') {
        localStorage.setItem('doc','true');
        window.location = 'doctor.html';
    } else {
        alert('Invalid Credentials');
    }
}