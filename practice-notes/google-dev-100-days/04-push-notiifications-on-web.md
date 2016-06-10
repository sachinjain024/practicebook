Push Notifications on web
-------------------------

- Link: https://www.youtube.com/watch?v=Z_K8QPQe6oM&list=PLOU2XLYxmsIJDPXCTt5TLDu67271PruEk&index=4
- Available on web throught new set of APIs
- Using service workers and manifest.json

Steps:
1. Site/App adds Service Worker
2. Subscribe user to push service (Google Cloud Messaging)
3. Our Server sends data to GCM
4. GCM sends back to Service Worker
5. We receive the message via Service worker

- Service worker is a sort of task which runs in background without needing webapp to be opened.
- More Info: bit.ly/PushIntro (https://developers.google.com/web/updates/2015/03/push-notifications-on-the-open-web)