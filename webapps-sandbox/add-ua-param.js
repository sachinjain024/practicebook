var params = window.location.search;
var uaList = ['iphone', 'android_phone', 'windows_phone', 'blackberry_phone'];

console.log("Test:" + params);

/**
 * If ua query param is not present, add it
 * If ua query param is present, do not do anything
 */
function addUserAgentInformationInQueryParams(paramString) {
    var separator = '&',
        randomIndex = Math.ceil(Math.random()*100) % uaList.length,
        paramValue;

    
    if (!paramString) {
        separator = '?';
    }
    
    // If ua param is not present then just add it and return
    if (paramString.indexOf('ua') === -1) {
        return paramString + separator + 'ua' + '=' + uaList[randomIndex];
    } else {
        return null;
    }
}


var newSearchString = addUserAgentInformationInQueryParams(window.location.search);

if (newSearchString !== null) {
    window.location.search = newSearchString;
}
