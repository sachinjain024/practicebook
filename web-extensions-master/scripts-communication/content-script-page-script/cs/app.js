var logInElement = document.createElement('a');
var logOutElement = document.createElement('a');
var loginStatusElement = document.createElement('a');

function insertScript(url, callback) {
  var script = document.createElement('script');
  script.src = url;
  script.onload = callback;
  document.head.appendChild(script);
}

function insertFirebaseScript(callback) {
  var firebaseUrl = 'http://localhost:7070/scripts-communication/content-script-page-script/page/firebase-4.1.2.js';
  insertScript(firebaseUrl, callback);
}

function insertPageScript(callback) {
  var pageSriptUrl = 'http://localhost:7070/scripts-communication/content-script-page-script/page/page.js';
  insertScript(pageSriptUrl, callback);
}

function insertAllPageScripts(callback) {
  callback = callback || function() { console.log('All page scripts executed successfully!'); };

  insertFirebaseScript(function() {
    insertPageScript(callback)
  });
}

function insertActionButtons() {
  // Insert logIn and logOut button on requestly page
  logInElement.className = 'btn btn-cta-login';
  logInElement.id = 'loginElement';
  logInElement.innerHTML = 'Login With Firebase';
  logInElement.setAttribute('action', 'login');

  logOutElement.className = 'btn btn-cta-logout';
  logOutElement.id = 'logoutElement';
  logOutElement.innerHTML = 'Logout';
  logOutElement.setAttribute('action', 'logout');

  loginStatusElement.className = 'btn btn-cta-loginstatus';
  loginStatusElement.id = 'loginStatusElement';
  loginStatusElement.innerHTML = 'Login Status';
  loginStatusElement.setAttribute('action', 'loginStatus');

  var target = document.getElementsByClassName('btns')[0];

  target.appendChild(logInElement);
  target.appendChild(logOutElement);
  target.appendChild(loginStatusElement);
}

function sendMessageToPageScript(event) {
  // Cook message and send to page script to perform the corresponding action
  var action = event.target.getAttribute('action');
  window.postMessage({
    action: action,
    source: 'requestly_content_script'
  }, "http://www.requestly.in");
}

function handleMessageReceived(message) {
  alert(message.action);
}

function addListeners() {
  // Implement authentication on button click
  logInElement.addEventListener('click', sendMessageToPageScript);
  logOutElement.addEventListener('click', sendMessageToPageScript);
  loginStatusElement.addEventListener('click', sendMessageToPageScript);

  window.addEventListener('message', function(event) {
    if (event.data && event.data.source && event.data.source == 'requestly_page_script') {
      console.log('RQ: Received event from page script', event.data);
      handleMessageReceived(event.data);
    }
  });
}

function init() {
  insertAllPageScripts();
  insertActionButtons();
  addListeners();
}

init();
