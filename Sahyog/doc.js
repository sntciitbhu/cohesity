if (localStorage.getItem('doc') !== 'true') {
    window.location = 'index.html';
}
function signOut() {
    localStorage.setItem('doc','false');
    location.reload();
}