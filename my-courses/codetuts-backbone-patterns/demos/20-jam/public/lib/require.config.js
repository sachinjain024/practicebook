var jam = {
    "packages": [
        {
            "name": "backbone",
            "location": "lib/backbone",
            "main": "backbone.js"
        },
        {
            "name": "jquery",
            "location": "lib/jquery",
            "main": "jquery.js"
        },
        {
            "name": "underscore",
            "location": "lib/underscore",
            "main": "underscore.js"
        }
    ],
    "version": "0.2.1",
    "shim": {}
};

if (typeof require !== "undefined" && require.config) {
    require.config({packages: jam.packages, shim: jam.shim});
}
else {
    var require = {packages: jam.packages, shim: jam.shim};
}

if (typeof exports !== "undefined" && typeof module !== "undefined") {
    module.exports = jam;
}