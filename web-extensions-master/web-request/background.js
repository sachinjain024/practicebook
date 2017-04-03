var BG = BG || {};
BG.Methods = BG.Methods || {};

BG.Methods.modifyUrl = function(details) {
  if (details.url.indexOf('yahoo') >= 0) {
    return { redirectUrl: 'http://requestly.in?utm_source=web-extension' };
  }

  if (details.url.indexOf('facebook') >= 0) {
    return { redirectUrl: 'javascript:' };            
  }
};

chrome.webRequest.onBeforeSendHeaders.addListener(
  BG.Methods.modifyUrl, { urls: ['<all_urls>'] }, ['blocking']
);

chrome.webRequest.onBeforeRequest.addListener(
  function(details) {
    if (details.url.indexOf('localhost') === -1) return;

    console.table([{
      type: details.type,
      url: details.url,
      parentFrameId: details.parentFrameId,
      frameId: details.frameId
    }]);
  },
  {
    urls: ['<all_urls>']
  }
);
