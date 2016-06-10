## [Course: Learn Android By Doing](https://www.udemy.com/learn-by-doing-android-for-beginners)

### Notes
1. Add Android/sDK/tools and Android/sdk/platform-tools to the path
2. Try adb and draw9patch from commmand to confirm the path 
3. Genymotion - Faster Android Emulator


### Resource:
- Resource: Drawables, Ids, Layouts, Strings, Menu
- Resource Identifiers: Each resource should have resource identifier
- R.java inside gen folder contain all Resource identifiers for each resource 
- Exampples: R.id.containerId, R.string.android_summary, R.layout.main
- Resources resources = getResources();
- We can use formatted string in resources as well.
- Inbuilt resource starte with @android:$resource/ while project resource start with @project:$resource/ . $resource can be string, drawable. 
In java we can refer to system resrouces by android.R.$resource.

### Activity
- onCreate method is called when an activity is instantiated

### Views
- AdapterViews: Spinner (Dropdown), ListView (Contact List), GridView (Galery)
- We can put top/bottom/right/left drawable to a text view to achieve image + text combination
- top_drawable property in xml and setCompoundDrawablesWithIntrims(l, t, r, b) in java 

### Layouts
- Layout Naming Convention: activity_traffic_lights, activity_hello_world
- LinearLayout arranges childViews in single row/column based on orientation (horizontal - default)

#### Table Layout
- Table Layout has stretchColumns property, set to * in order to stretch the content to full width
- android:layout_span is equivalent of colspan
- android:layout_column="1" is the index in which this view has to be placed

#### Scroll View
- Can have only one child either a layout or layout group
- Example: Mail screen Top header, footer fixed height and the remaining height should be given to message.
- Implementation: 
	RelativeLayout (header, footer: fixed and aligned to top and bottom respectively)
	ScrollView wrapped around textView should be position relative to top header and bottom footer.

### Context
- Has access to app's private data folder on device
- Can read various files and resources
- View class has 3 constructors and each expects first argument as constructor
- We can pass activity as context to View because it extends context
- getString(), getAssets(), getPackageName() etc
- Used by Views extensively

### Android Logging System
- android.util.log - Verbose, Debug, Info, Warn, Error
- Logcat for viewing logs
- Log.v, Log.d, Log.i, Log.w, Log.e
- Usage: Log.v (tag, msg) where tag is some constant to identify/relate more information to this log like className

### ADB Command Line
- adb kill-server: Stop all ADB devices
- adb devices: restart

### Deploy to Device
- Link: http://developer.android.com/tools/device.html

### Selector Drawable
  - We can define various states of button (like pressed, checked, unchecked with selector as root element inside drawable)
  - We can provide some states like when button is checked, background image should be checked_button_custom_bg

### Questions:
- Can we have multiple classes extending Activity class ?
If yes, how does Android differentiate main class.

- Types of EventListeners in Android Platform. Format of Android Activity
  
    public class myActivity extends Activity implements OnClickListener {

    }
Can a Java class implement two classes if there are two types of Events which should be listened ?
Answer: Yes, We have multiple interfaces like OnClickListener, OnLongClickListener, OnItemSelectedListener

- How do we handle multiple Activities and switch between activities ?

### Exercises

#### General Exercises
- [x] Create a new Android project at sandbox-area/android
- [x] Use String Resources
- [x] Formatting HTML Text and rendering HTML tags on page (HTML.fromHtml)
- [ ] Setting Links on Elements or Creating link element (By Java and XML) 
Hint: Use setAutoLinkMask(Linkify.WEB_URLS) and then use setText

#### Simple Interest Calculator
- [x] Make UI from Graphical Layout
- [x] Input Fields should be of type number
- [x] Add Click listener to button
- [x] Extract the values of input fields and seekbar
- [x] Update the value of years when seekbar value is changed
- [x] Set the final calculated value in output field
- [ ] Add Validation

### Links:
1. Fixed Compiler Output Path: http://stackoverflow.com/questions/16828110/android-studio-error-output-path-is-not-specified-for-modules
