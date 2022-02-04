//Status
//Retrieve the server’s current status
driver.getStatus();

//Execute Mobile Command
//Execute a native mobile command

driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));

//Session
//Create New Session
//Create a new session

DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
desiredCapabilities.setCapability(MobileCapabilityType.APP, "/path/to/ios/app.zip");

URL url = new URL("http://127.0.0.1:4723/wd/hub");

IOSDriver driver = new IOSDriver(url, desiredCapabilities);
String sessionId = driver.getSessionId().toString();

//End Session
//End the running session

driver.quit();

//Retrieve the capabilities of the specified session
Map<String, Object> caps = driver.getSessionDetails();

//Navigate backwards in the browser history, if possible (Web context only)
driver.back();

//Take a screenshot of the current viewport/window/page
File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

//Get the current application hierarchy XML (app) or page source (web)
String pageSource = driver.getPageSource();

//Configure the amount of time that a particular type of operation can execute for before they are aborted
driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

//Set Implicit Wait Timeout
//Set the amount of time the driver should wait when searching for elements
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//Set Script Timeout
//Set the amount of time, in milliseconds, that asynchronous scripts executed by execute async are permitted to run before they are aborted (Web context only)
driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

//Get Orientation
//Get the current device/browser orientation
ScreenOrientation orientation = driver.getOrientation();

//Get the current geo location
Location location = driver.location(); // Must be a driver that implements LocationContext

//Set the current geo location
driver.setLocation(new Location(49, 123, 10)); // Must be a driver that implements LocationContext

//Get available log types as a list of strings
Set<String> logTypes = driver.manage().logs().getAvailableLogTypes();

//Get the log for a given log type. Log buffer is reset after each request
LogEntries logEntries = driver.manage().logs().get("driver");

//Log event
//Store a custom event
CustomEvent evt = new CustomEvent();
evt.setEventName("funEvent");
evt.setVendor("appium");
driver.logEvent(evt);

//Device
//Start Activity
//Start an Android activity by providing package name and activity name
driver.startActivity(new Activity("com.example", "ActivityName"));

//Get the name of the current Android activity
String activity = driver.currentActivity();

//Get Current Package
//Get the name of the current Android package
String package = driver.getCurrentPackage();

//Install App
//Install the given app onto the device
driver.installApp("/Users/johndoe/path/to/app.apk");
driver.isAppInstalled("com.example.AppName");
driver.launchApp();
driver.runAppInBackground(Duration.ofSeconds(10));
driver.closeApp();
driver.resetApp();
driver.removeApp("com.example.AppName");
driver.activateApp('com.apple.Preferences');
driver.activateApp('io.appium.android.apis');
driver.terminateApp('com.apple.Preferences');
driver.terminateApp('io.appium.android.apis');
//Get Clipboard
//Get the content of the system clipboard
driver.getClipboard(ClipboardContentType.PLAINTEXT); // get plaintext
driver.getClipboardText();
// base64Content is Base64-encoded content
driver.setClipboard("label", ClipboardContentType.PLAINTEXT, base64Content);
driver.setClipboardText("happy testing");
//Emulate power state
driver.setPowerAC(PowerACState.OFF);
driver.setPowerCapacity(100);
//Push File
driver.pushFile("/data/local/tmp/foo.bar", new File("/Users/johndoe/files/foo.bar"));
//Interactions
driver.shake();
driver.lockDevice();
driver.unlockDevice();
boolean isLocked = driver.isDeviceLocked();
driver.rotate(new DeviceRotation(10, 10, 10));
//Keys
driver.pressKeyCode(AndroidKeyCode.SPACE, AndroidKeyMetastate.META_SHIFT_ON);
driver.longPressKeyCode(AndroidKeyCode.HOME);
driver.hideKeyboard();
boolean isKeyboardShown = driver.isKeyboardShown();
//Network
driver.toggleAirplaneMode();
driver.toggleData();
driver.toggleWifi();
//PerformanceData
List<List<Object>> performanceData = driver.getPerformanceData("my.app.package", "cpuinfo", 5);
List<String> performanceTypes = driver.getSupportedPerformanceDataTypes();

//ScreenRecording
driver.startRecordingScreen();
driver.startRecordingScreen(new BaseStartScreenRecordingOptions(....));

//Elements
MobileElement elementOne = (MobileElement) driver.findElementByAccessibilityId("SomeAccessibilityID");
MobileElement elementTwo = (MobileElement) driver.findElementByClassName("SomeClassName");

List<MobileElement> elementsOne = (List<MobileElement>) driver.findElementsByAccessibilityId("SomeAccessibilityID");
List<MobileElement> elementsTwo = (List<MobileElement>) driver.findElementsByClassName("SomeClassName");
//click
MobileElement el = driver.findElementByAccessibilityId("SomeId");
el.click();
//SendKeys
MobileElement element = (MobileElement) driver.findElementByAccessibilityId("SomeAccessibilityID");
element.sendKeys("Hello world!");
//Clear Elemet
MobileElement element = (MobileElement) driver.findElementByAccessibilityId("SomeAccessibilityID");
element.clear();
//Returns visible text for element
MobileElement element = (MobileElement) driver.findElementByClassName("SomeClassName");
String elText = element.getText();
//Get an element's tag name
MobileElement element = (MobileElement) driver.findElementByAccessibilityId("SomeAccessibilityID");
String tagName = element.getTagName();
//Get the value of an element's attribute
MobileElement element = (MobileElement) driver.findElementByAccessibilityId("SomeAccessibilityID");
String tagName = element.getAttribute("content-desc");

//Determine if a form or form-like element (checkbox, select, etc...) is selected
MobileElement element = (MobileElement) driver.findElementByAccessibilityId("SomeAccessibilityID");
boolean isSelected = element.isSelected();

//Determine if an element is currently enabled
MobileElement element = (MobileElement) driver.findElementByAccessibilityId("SomeAccessibilityID");
boolean isEnabled = element.isEnabled();

//Determine if an element is currently displayed
MobileElement element = (MobileElement) driver.findElementByAccessibilityId("SomeAccessibilityID");
boolean isDisplayed = element.isDisplayed();
//Submit a FORM element
MobileElement element = (MobileElement) driver.findElementByClassName("SomeClassName");
element.submit();

//Gets the active element of the current session
WebElement currentElement = driver.switchTo().activeElement();

//Test if two element IDs refer to the same element
// Overrides the Java Object .equals method
MobileElement elementOne = (MobileElement) driver.findElementByClassName("SomeClassName");
MobileElement elementTwo = (MobileElement) driver.findElementByClassName("SomeOtherClassName");
boolean isEqual = elementOne.equals(elementTwo);

//Get the current context in which Appium is running
String context = driver.getContext();

//Get all the contexts available to automate
Set<String> contextNames = driver.getContextHandles();

//Set the context being automated
Set<String> contextNames = driver.getContextHandles();
driver.context(contextNames.toArray()[1]);
// ...
driver.context("NATIVE_APP");

//Mouse
//Move the mouse by an offset of the specificed element
Actions action = new Actions(driver);
action.moveTo(element, 10, 10);
action.perform();

//Click any mouse button at the current mouse coordinates
Actions action = new Actions(driver);
action.moveTo(element);
action.click();
action.perform();

//Double-clicks at the current mouse coordinates (set by moveto).
Actions action = new Actions(driver);
action.moveTo(element);
action.doubleClick();
action.perform();

//Click and hold the left mouse button at the current mouse coordinates
Actions action = new Actions(driver);
action.moveTo(element);
action.clickAndHold();
action.perform();

//Releases the mouse button previously held
Actions action = new Actions(driver);
action.moveTo(element);
action.clickAndHold();
action.moveTo(element, 10, 10);
action.release();
action.perform();

//W3C Actions
//Perform a chain or multiple chains of keyboard and pointer (touch, mouse, stylus) actions

WebElement source = (MobileElement) driver.findElementsByAccessibilityId("SomeAccessibilityID");
WebElement target = (MobileElement) driver.findElementsByAccessibilityId("SomeOtherAccessibilityID");

Point source = dragMe.getCenter();
Point target = driver.findElementByAccessibilityId("dropzone").getCenter();
PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
Sequence dragNDrop = new Sequence(finger, 1);
dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), source.x, source.y));
dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700),
                    PointerInput.Origin.viewport(),target.x, target.y));
dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
driver.perform(Arrays.asList(dragNDrop));

//Touch
//Single tap on the touch enabled device
TouchActions action = new TouchActions(driver);
action.singleTap(element);
action.perform();

//Double tap on the touch screen using finger motion events
TouchActions action = new TouchActions(driver);
action.doubleTap(element);
action.perform();

//Finger move on the screen

TouchActions action = new TouchActions(driver);
action.down(10, 10);
action.moveTo(50, 50);
action.perform();

//Finger down on the screen
TouchActions action = new TouchActions(driver);
action.down(10, 10);
action.move(50, 50);
action.perform();

//Finger up on the screen
TouchActions action = new TouchActions(driver);
action.down(10, 10);
action.up(20, 20);
action.perform()

//Long press on the touch screen using finger motion events
TouchActions action = new TouchActions(driver);
action.longPress(element);
action.perform();

//Web
//SetWindow
driver.switchTo().window("handle");

//Close the current window (Web context only)
driver.close();

//Retrieve the current window handle (Web context only)
String windowHandle = driver.getWindowHandle();

//Retrieve the list of all window handles available to the session (Web context only)
Set<String> windowHandles = driver.getWindowHandles();

//Get the current page title (Web context only)
String title = driver.getTitle();

//Get the size of the specified window (Web context only)
Dimension windowSize = driver.manage().window().getSize();

//Navigation
//Navigate to a new URL (Web context) or open an Appium deep link (Native)
driver.get("http://appium.io/");

//Retrieve the URL of the current page (Web context only)
String url = driver.getCurrentUrl();

//Navigate backwards in the browser history, if possible (Web context only)
driver.back();

//Navigate forwards in the browser history, if possible (Web context only)
driver.forward();

//Refresh the current page. (Web context only)
driver.refresh();

//Inject a snippet of JavaScript into the page for execution in the context of the currently selected frame (Web context). Run a native mobile command (Native Context).
((JavascriptExecutor) driver).executeScript("window.setTimeout(arguments[arguments.length - 1], 500);");

//Execute Async Script
//Inject a snippet of JavaScript into the page for execution in the context of the currently selected frame (Web context only)
((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 500);");

//Change focus to another frame on the page (Web context only)
driver.switchTo().frame(3);

//Retrieve all cookies visible to the current page (Web context only)
Set<Cookie> allcookies = driver.manage().getCookies();

//Set a cookie (Web context only)
driver.manage().addCookie(new Cookie("foo", "bar"));

//Delete the cookie with the given name (Web context only)
driver.manage().deleteCookieNamed("cookie_name");

//Delete all cookies visible to current page (Web context only)
driver.manage().deleteAllCookies();

















































































