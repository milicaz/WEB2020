$(document).ready(function() {
$('#loginForm').submit(function(event) {
event.preventDefault();

let username = $('#usernameLogin').val();
let password = $('#passwordLogin').val();

if (username === "") {
alert("Unestite svoj username")
return
}
if (password === "") {
alert("Unesite svoj password")
return
}

$.post({
url: 'rest/auth/login',
data: JSON.stringify({ username, password }),
contentType: 'application/json',
success: function(data) {
localStorage.setItem('jwt', JSON.stringify(data.accessToken));
showMainPage();
},
error: function() {
alert("Logovanje je neuspesno.")
}
});
});
});

function showMainPage() {
$.get({
url: 'rest/auth/currentUser',
contentType: 'application/json',
success: function(user) {
if (user.role == "ADMIN") {
window.location = './adminMainPage.html'
} else if (user.role == "HOST") {
window.location = './hostMainPage.html'
}
else {
window.location = './guestMainPage.html'
}
}
});
}