/**
 * https://github.com/joeferner/node-http-mitm-proxy
 */
var Proxy = require('http-mitm-proxy');
var proxy = Proxy();

proxy.onError(function(ctx, err) {
  console.error('proxy error:', err);
});

proxy.onRequest(function(ctx, callback) {
  if (ctx.clientToProxyRequest.headers.host == 'neverssl.com') {
    ctx.use(Proxy.gunzip);

    ctx.onResponseData(function(ctx, chunk, callback) {
      chunk = new Buffer(chunk.toString().replace(/<h2.*?<\/h2>/g, '<h2>Pwned!</h2>'));
      return callback(null, chunk);
    });
  }
  return callback();
});

proxy.listen({port: 8171});
