const {ipcRenderer} = require('electron');
const log = console.log;

let myRules = {};

window.interOp = window.interOp || {
    test: function() {
        log('This is test function');
    },

    setRules: function(rules) {
        return new Promise(resolve => {
            setTimeout(() => {
                myRules = rules;
                resolve();
            }, 1000);
        });
    },

    getRules: function() {
        return new Promise((resolve) => {
            setTimeout(() => resolve(myRules), 1000);
        });
    },

    getIPCRenderer: () => {
        return ipcRenderer;
    }
};

console.log('This is preload script');
