var BG = BG || {};
BG.Methods = BG.Methods || {};

BG.Methods.modifyUrlBeforeHeaders = function(details) {
  if (details.url.indexOf('yahoo') >= 0) {
    return { redirectUrl: 'http://requestly.in?utm_source=web-extension' };
  }

  if (details.url.indexOf('facebook') >= 0) {
    return { cancel: true };
  }
};

chrome.webRequest.onBeforeSendHeaders.addListener(
  // Try to modify request on before send headers
  BG.Methods.modifyUrlBeforeHeaders, { urls: ['<all_urls>'] }, ['blocking']
);

chrome.webRequest.onBeforeRequest.addListener(
  function(details) {
    // Try to modify requests on before request
    if (details.url.indexOf('localhost') !== -1) {
      return { cancel: true };
    }

    console.table([{
      type: details.type,
      url: details.url,
      parentFrameId: details.parentFrameId,
      frameId: details.frameId
    }]);
  },
  {
    urls: ['<all_urls>']
  },
  ['blocking']
);
