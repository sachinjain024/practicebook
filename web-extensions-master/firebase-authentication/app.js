var logInElement = document.createElement('a');
var logOutElement = document.createElement('a');
var loginStatusElement = document.createElement('a');

function initFirebase() {
  // Initialize Firebase
  var config = {
    apiKey: "AIzaSyC2WOxTtgKH554wCezEJ4plxnMNXaUSFXY",
    authDomain: "requestly.firebaseapp.com",
    databaseURL: "https://requestly.firebaseio.com",
    projectId: "project-7820168409702389920",
    storageBucket: "project-7820168409702389920.appspot.com",
    messagingSenderId: "911299702852"
  };
  firebase.initializeApp(config);
}

function insertActionButtons() {
  // Insert logIn and logOut button on requestly page
  logInElement.className = 'btn btn-cta-login';
  logInElement.id = 'loginElement';
  logInElement.innerHTML = 'Login With Firebase';

  logOutElement.className = 'btn btn-cta-logout';
  logOutElement.id = 'logoutElement';
  logOutElement.innerHTML = 'Logout';

  loginStatusElement.className = 'btn btn-cta-loginstatus';
  loginStatusElement.id = 'loginStatusElement';
  loginStatusElement.innerHTML = 'Login Status';

  var target = document.getElementsByClassName('btns')[0];

  target.appendChild(logInElement);
  target.appendChild(logOutElement);
  target.appendChild(loginStatusElement);
}

function logInWithGoogle() {
  var provider = new firebase.auth.GoogleAuthProvider();
  firebase.auth().signInWithRedirect(provider);
}

function logout() {
  firebase.auth().signOut().then(function() {
    alert('Sign-out successful.');
  }).catch(function(error) {
    alert('Sign-out failed: ' + error);
  });
}

function checkLoginStatus() {
  var user = firebase.auth().currentUser;

  if (user) {
    alert('Current user is: ', user.toString());
  } else {
    alert('No user is logged in');
  }
}

function addListeners() {
  // Implement authentication on button click
  logInElement.addEventListener('click', logInWithGoogle);
  logOutElement.addEventListener('click', logout);
  loginStatusElement.addEventListener('click', checkLoginStatus);
}

function init() {
  initFirebase();
  insertActionButtons();
  addListeners();
}

init();
