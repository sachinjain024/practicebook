const {ipcRenderer} = require('electron');

const Store = require('electron-store');
const store = new Store({ watch: true });

window.interOp = window.interOp || {
    setRules: function(rules) {
        return new Promise(resolve => {
            store.set(rules);
            ipcRenderer.send('datastore:changed');
            resolve();
        });
    },

    getRules: function() {
        return new Promise((resolve) => {
            resolve(store.store);
        });
    },

    getIPCRenderer: () => {
        return ipcRenderer;
    },

    openStorageFile: () => {
        store.openInEditor();
    }
};

console.log('This is preload script');
