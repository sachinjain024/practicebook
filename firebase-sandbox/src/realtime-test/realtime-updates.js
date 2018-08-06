/**
 * Created by sachinjain on 06/08/18.
 */

var messageContainer = document.getElementById("message");
var database = firebase.database();

var messageRef = firebase.database().ref('data/realTimeMessageTest');
messageRef.on('value', function(snapshot) {
  messageContainer.innerHTML = snapshot.val();
});
