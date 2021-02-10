const { app, BrowserWindow, ipcMain } = require('electron');
const path = require('path');

const Store = require('electron-store');
const store = new Store({ watch: true });

// Handle creating/removing shortcuts on Windows when installing/uninstalling.
if (require('electron-squirrel-startup')) { // eslint-disable-line global-require
  app.quit();
}

const createWindow = () => {
  // Create the browser window.
  const browserWindow = new BrowserWindow({
    width: 800,
    height: 600,
    show: false,
    webPreferences: {
      preload: MAIN_WINDOW_PRELOAD_WEBPACK_ENTRY,
      nodeIntegration: false,
      contextIsolation: false
    }
  });

  // and load the index.html of the app.
  // mainWindow.loadURL(MAIN_WINDOW_WEBPACK_ENTRY);
  browserWindow.loadURL('http://localhost:8080');

  // Open the DevTools.
  browserWindow.webContents.openDevTools();

  browserWindow.once('ready-to-show', () => {
    browserWindow.show();
    browserWindow.webContents.send('test-event', {
      'foo': 'bar'
    });

    // console.log('Setting up onDidAnyChange listener');
    // store.onDidAnyChange(function(newValue, oldValue) {
    //   console.log('newValue:', newValue);
    //   console.log('oldValue:', oldValue);
    // });

    // console.log('Setting up onDidChange listener');
    // store.onDidChange('a', function(newValue, oldValue) {
    //   console.log('newValue:', newValue);
    //   console.log('oldValue:', oldValue);
    // });

    // store.set({a: 10});
  });
};

ipcMain.on('datastore:changed', (event, arg) => {
  let newData = store.store;
  console.log('DataStore:', newData);
});

// This method will be called when Electron has finished
// initialization and is ready to create browser windows.
// Some APIs can only be used after this event occurs.
app.on('ready', createWindow);

// Quit when all windows are closed, except on macOS. There, it's common
// for applications and their menu bar to stay active until the user quits
// explicitly with Cmd + Q.
app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') {
    app.quit();
  }
});

app.on('activate', () => {
  // On OS X it's common to re-create a window in the app when the
  // dock icon is clicked and there are no other windows open.
  if (BrowserWindow.getAllWindows().length === 0) {
    createWindow();
  }
});

// In this file you can include the rest of your app's specific main process
// code. You can also put them in separate files and import them here.