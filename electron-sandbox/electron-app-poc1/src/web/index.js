console.log('Demo Page opened');

if (window.interOp) {
    const API = window.interOp;

    console.log('Setting Rules');
    API.setRules({'a': Date.now()})
        .then(() => {
            console.log('Getting Rules');
            const rulesPromise = API.getRules();
            rulesPromise.then(rules => {
                console.log('Obtained Rules', rules);
            });
        });

    // https://www.electronjs.org/docs/api/web-contents#contentssendchannel-args
    const ipcRenderer = API.getIPCRenderer();
    ipcRenderer.on('test-event', (event, message) => {
        console.log('Message', message);
    });
}
