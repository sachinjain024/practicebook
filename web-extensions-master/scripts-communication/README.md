# Communication between different types of scripts inside Web extension ecosystem

## Different Types of scripts
- Page Scripts: Normal scripts present on web page
- Content Scripts: Chrome extension script which run in the context of the page but has access to set of chrome apis
- Popup Scripts: Run inside the popup of chrome extension. Has access to background context and scripts.
- Background scripts: Run in background of extension.

## Content script - Page script

### Test
- Inject a page script running on localhost on some page. Now, try to communicate between both the scripts.
