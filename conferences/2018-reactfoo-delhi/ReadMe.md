ReactFoo 2018
-------------

## References
- https://reactfoo.in/2018-delhi/

## Talks

### React Internals (Ankit Muchalla, Postman)
- https://reactfoo.talkfunnel.com/2018-delhi/31-react-internals-how-understanding-react-implementa
- React Philosophy: UI = function(data)
- React Packages
- Declarative (React/Typescript) vs Imperative (Native JS) approach
- Renderers vs Reconcilers
- Diffing of lists is done using keys
- Virtual DOM != Shadow DOM
- Virtual DOM: Element Tree
- Fiber Reconciler: React 16+ (Aim: 60fps)
- Phases
	- Reconciliation - Prepare DOM (Interruptible)
	- Commit - Flusht to DOM (Uninterruptible)
- Fiber is like a unit of work (Kinda data structure)
- Uses requestIdleCallback browser API to perform async rendering

#### Refs
- http://www.mattgreer.org/articles/react-internals-part-one-basic-rendering/
- https://bogdan-lyashenko.github.io/Under-the-hood-ReactJS/
- https://www.youtube.com/watch?v=crM1iRVGpGQ (Dan explain Fiber)

### React Canvas (Arwa Lokhandwala, Bookmyshow)
- https://reactfoo.talkfunnel.com/2018-delhi/11-why-we-should-use-react-canvas
- Optimize Scaling Performance
- Use `transform` instead of top, left: Only composite step. top,left cause all the steps to be done
- Checkout performance monitor in dev console
- Debounce scroll events
- requestAnimationFrame
- Ability to render React canvas to canvas rather than DOM
- Group element is now supported in React
- RC can cause huge memory leak + Does not support responsive design
- BMS seat selection use React canvas and performance goes up drastically
- Alternative: React Konva, Pabla

### Write your own custom async rendered (Aziz Khambati, Anarock)
- https://reactfoo.talkfunnel.com/2018-delhi/26-create-your-own-custom-async-renderer-with-diffing
- pomber.github.io
- devconsole -> performance -> CPU
- Jake Archibald - Compositor Thread
- Don't block the main thread - Break things up. Do rendering part by part as and when browser go idle
- Reconciler: Virtual DOM, UI Agnostic, Diffing Algorithm is used
- Renderer: Updates DOM
- ReactDOM is bridge between Reconciler and Rendered
- ReactNative is bridge between ...
- react-tiny-dom is library (200LOC) Can be used for building your own renderer
- Webworkers are used to compute things in background
- Fiber Principles
- Node gives you cluster, Browsers give you web workers

#### Refs
- https://github.com/azizhk/rrrww/blob/async_initial/src/dom.js#L39-L51
- https://github.com/facebook/create-react-app (Create/Setup a new react app)
- http://azizhk.github.io/rrrww/async/
- Sync Rendering Example - https://azizhk.github.io/rrrww/
- Async Rendering Example - https://azizhk.github.io/rrrww/async/index.html

### Hidden Gems of Chrome Dev tools (Rachit Gulati, Microsoft Teams)
- @squiroid
- Chrome Tracing
	- When things are visible
	- When network call is made and how much time it has taken
- Flame Charts
- Memory Profiling
- Check if we can parallelize network calls
- Static snapshot (Heap snapshots)
- chrome://tracing

#### Refs
- https://addyosmani.com/blog/devtools-flame-charts/
- https://reactfoo.talkfunnel.com/2018-delhi/39-hidden-performance-gems-in-chrome-dev-tools-we-use

### Page Loading Performance (Prateek Rungta, Miranj)
- Prefetch page based on user interactions
- MouseOver ----> Click (300-400 ms)
- InstantClick/BarbaJs
- Uses pjax (PushState + Ajax)
- Critical Rendering Path
- Preload and Defer attributes
- Different image renditions
- Image compression

#### Refs
- https://reactfoo.talkfunnel.com/2018-delhi/35-page-loading-performance-strategies-from-the-field
- InstantClick prefetches the page (http://instantclick.io/)
- https://www.igvita.com/2012/07/19/latency-the-new-web-performance-bottleneck/

### Blazing Fast Websites with Gatsby (Kiran Abburi, JS Bangalore Group, neostack.com)
- React Components -> Gatsby -> Fast and Static websites
- Similar to Jekyll
- Takes care of performance optimization techniques in the website
- Instead of .yml, we use .js
- We write articles in markdown format and can also write in React Components
- Multiple Plugins available e.g. Offline support
- Good Plugin architecture
- webpagetest.org

### Deploy with Confidence (Vaibhav Lokhande, shaadi.com)
- https://reactfoo.talkfunnel.com/2018-delhi/2-deploying-with-confidence
- Slides: https://www.slideshare.net/vaibhavlokhande6/delhi-first-draft2
- Tool: StoryBook
- Automation testing tools
	- Cypress
	- NightWatch
	- Selenium
- You can also get videos of test case
- StoryBook enables early feedback
- TDD pays off in long term
- React enables quick unit testing 

### AR/VR experience with React (@shivank1995 Shivank Shekhar, particlepanda.xyz)
- Oculus Go
- React 360
- WebVR: JS API to access VR devices
- Frameworks: AFrame, React360
- XR: 1 API for VR, AR
- Allegro Graph
- Babylon JS
- Amazon Sumerian (VRScene render) - Very quick development, recently released
- Aframe is by Mozilla (Declarative HTML)
- React360: On top of React
- React VR is based on three.js
- AR: Augmented Reality
- VR: Virtual Reality
- ViroReact/ViroAR: Rapid Iteration + Good documentation
- experiementswithgoogle.com/webvr

#### Refs
- https://reactfoo.talkfunnel.com/2018-delhi/13-piggybacking-your-webvr-ar-experiences-with-react
- React VR: https://developers.facebook.com/videos/f8-2017/react-vr-build-amazing-vr-experiences-using-react/
- F8 2018: https://developers.facebook.com/videos/?category=f8_2018
- https://experiments.withgoogle.com/
- https://www.brighttalk.com/webcast/14711/296271