function storeCookie(key, value) {
    $.cookie(key, value);
}

function removeCookie(key) {
    $.removeCookie(key);
}

function getCookieValue(key) {
    return $.cookie(key);
}

module.exports = {
    store: storeCookie,
    remove: removeCookie,
    get: getCookie
}