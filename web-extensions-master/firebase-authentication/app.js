var signInElement = document.createElement('a');
signInElement.className = 'btn btn-cta-signin';
signInElement.id = 'signInElement';
signInElement.innerHTML = 'Sign In With Firebase';

var target = document.getElementsByClassName('btns')[0];

target.appendChild(signInElement);
signInElement.addEventListener('click', function() {
  alert('clicked');
});
