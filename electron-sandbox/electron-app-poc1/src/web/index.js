console.log('Demo Page opened');

if (window.interOp) {
    // console.log(window.interOp);

    const API = window.interOp;
    API.test();

    console.log('Setting Rules');
    API.setRules({a:1})
        .then(() => {
            console.log('Getting Rules');
            const rulesPromise = API.getRules();
            rulesPromise.then(rules => {
                console.log('Obtained Rules', rules);
            });
        });

    // https://www.electronjs.org/docs/api/web-contents#contentssendchannel-args
    const ipcRenderer = API.getIPCRenderer();
    ipcRenderer.on('intercepted', (event, message) => {
        console.log('Event', event);
        console.log('Message', message);
    });
}
