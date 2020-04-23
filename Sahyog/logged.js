function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
    location.reload();
    });
}
function onSignIn(googleUser) {
var profile = googleUser.getBasicProfile();
if (window.location.href === "https://sahyog.netlify.com/signin.html#" || window.location.href === "https://sahyog.netlify.com/signin.html" ) {
    window.location = "https://sahyog.netlify.com/";
}
document.querySelector('.signinbtn').setAttribute('style','display:none;');
document.querySelector('.pcontent').setAttribute('style','display:block;');
document.querySelector('.pcontent').innerHTML = profile.getName();
}
if (localStorage.getItem('doc') === 'true') {
    window.location = 'doctor.html';
}