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

function logInWithGoogle() {
  var provider = new firebase.auth.GoogleAuthProvider();
  provider.addScope('profile');
  provider.addScope('email');
  // firebase.auth().signInWithRedirect(provider);

  firebase.auth().signInWithPopup(provider).then(function(result) {
    // This gives you a Google Access Token. You can use it to access the Google API.
    var token = result.credential.accessToken;
    var user = result.user;

    sendMessageToContentScript({ action: 'user logged in' });
  }).catch(function(error) {
    // Handle Errors here.
    var errorCode = error.code;
    var errorMessage = error.message;
    // The email of the user's account used.
    var email = error.email;
    // The firebase.auth.AuthCredential type that was used.
    var credential = error.credential;
    // ...

    alert('Error login');
    console.log(error);
  });
}

function logout() {
  firebase.auth().signOut().then(function() {
    sendMessageToContentScript({action: 'Sign-out successful.'});
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

function sendMessageToContentScript(message) {
  message['source'] = 'requestly_page_script';
  window.postMessage(message, "http://www.requestly.in");
}

function addMessageListener() {
  window.addEventListener('message', function(event) {
    if (event.data && event.data.source == 'requestly_content_script') {
      console.log('Received message: ', event.data);

      if (event.data.action == 'login') {
        logInWithGoogle();
      }

      if (event.data.action == 'logout') {
        logout();
      }

      if (event.data.action == 'loginStatus') {
        checkLoginStatus();
      }
    }
  });
}

function init() {
  initFirebase();
  addMessageListener();
}

init();
