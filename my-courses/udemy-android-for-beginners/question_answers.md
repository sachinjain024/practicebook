### Context vs Activity vs View vs Fragment

 A context in general provides an interface to access information about the application's execution environment. In Android, the context allows you to access resources (both system and application specific ones) such as drawables, string resources, application's private data folder, etc., and also gives you access to Android's system level services such as the PackageManger, AlarmService, NotificationService, etc.,

 The context is instantiated only by the Android system. Concrete implementations of context include but not limited to Application, Activity and Service classes.

 Each Activity has it's own context, so they are unique. We don't use contexts on their own because Context itself is an abstract class. And the Android system is responsible for instantiating Activity and Application instances (they are concrete implementations of Context).

 View and Fragment

 When it comes to View and Fragment, a view obviously requires a context in order to fetch it's resources. A Button needs to fetch it's background drawable or string which requires a Context. This is supplied to the View by the Activity on which it draws itself. Take a look at the View class, all constructors require a Context parameter.

 Fragments are just like views, they are not implementations of Context because that would be redundant (All fragments lie inside an Activity). Therefore they receive their context from the host Activity.

 Take a look at the onCreate, onCreateView and onViewCreated methods. The Context parameter is supplied by the host Activity. 