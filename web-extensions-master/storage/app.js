var browser = chrome,
  storageType = 'local',
  key = 'pageLoadCount';

alert('Storage: Content Script loaded');

browser.storage.onChanged.addListener(function(changes, namespace) {
  console.log('Storage Event Listener: Chrome Storage Changed');
  console.log(changes, namespace);
});

browser.storage[storageType].get(key, function(object) {
  var count = Number(object[key]) || 0;
  console.log('Storage: Current Page Count is: ', count);
  browser.storage[storageType].set({ pageLoadCount: count + 1 }, function() {
    console.log('Storage: Page Count updated');
  });
});
