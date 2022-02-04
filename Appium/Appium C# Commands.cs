//Status
//Retrieve the server’s current status

// TODO

//Execute Mobile Command
//Execute a native mobile command

driver.ExecuteScript("mobile:scroll", new Dictionary<string, string> { { "direction", "down" } });

//Session
//Create New Session
//Create a new session

AppiumOptions capabilities = new AppiumOptions();
appiumOptions.AddAdditionalCapability(MobileCapabilityType.PlatformName, "Android");
appiumOptions.AddAdditionalCapability(MobileCapabilityType.PlatformVersion, "7.1.1");
appiumOptions.AddAdditionalCapability(MobileCapabilityType.DeviceName, "Android Device");
appiumOptions.AddAdditionalCapability("appPackage", "com.instagram.android");
appiumOptions.AddAdditionalCapability("appActivity", "com.instagram.android.activity.MainTabActivity");

AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new Uri("http://127.0.0.1:4723/wd/hub"), appiumOptions);

//End Session
//End the running session

driver.Quit();

//Retrieve the capabilities of the specified session

ICapabilities caps = driver.Capabilities;

//Navigate backwards in the browser history, if possible (Web context only)
driver.Navigate().Back();

//Take a screenshot of the current viewport/window/page
Screenshot screenshot = driver.GetScreenshot();

//Get the current application hierarchy XML (app) or page source (web)
string pageSource = driver.PageSource;

//Configure the amount of time that a particular type of operation can execute for before they are aborted
driver.Manage().Timeouts().PageLoad = TimeSpan.FromSeconds(30);

//Set Implicit Wait Timeout
//Set the amount of time the driver should wait when searching for elements
driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(30);

//Set Script Timeout
//Set the amount of time, in milliseconds, that asynchronous scripts executed by execute async are permitted to run before they are aborted (Web context only)
// TODO C# sample

//Get Orientation
//Get the current device/browser orientation
ScreenOrientation orientation = driver.Orientation;

//Get the current geo location
Location location = driver.Location;

//Set the current geo location
driver.Location.Altitude = 94.23;
driver.Location.Latitude = 121.21;
driver.Location.Longitude = 11.56;

//Get available log types as a list of strings
IReadOnlyCollection<string> logTypes = driver.Manage().Logs.AvailableLogTypes;

//Get the log for a given log type. Log buffer is reset after each request
ILogs logs = driver.Manage().Logs;

//Log event
//Store a custom event
// csharp Code here

//Device
//Start Activity
//Start an Android activity by providing package name and activity name

driver.StartActivity("com.example", "ActivityName");

//Get the name of the current Android activity
string activity = driver.CurrentActivity;

//Get Current Package
//Get the name of the current Android package
string package = driver.CurrentPackage;

//Install App
//Install the given app onto the device
driver.InstallApp("/Users/johndoe/path/to/app.apk")
driver.isAppInstalled("com.example.AppName");
driver.LaunchApp();
driver.BackgroundApp(10)
driver.CloseApp();
driver.ResetApp();
driver.RemoveApp("com.example.AppName");
driver.activateApp('com.apple.Preferences');
driver.activateApp('io.appium.android.apis');
// Supports only `mobile: queryAppState` for iOS, XCUITest
//Get Clipboard
//Get the content of the system clipboard
// CSharp Code here
//Emulate power state
//Push File
driver.PushFile("/data/local/tmp/foo.bar", new FileInfo("/Users/johndoe/files/foo.bar"))
//Interactions
driver.ShakeDevice();
driver.Lock(); // Supported by IOSDriver & AndroidDriver
driver.Unlock(); // Supported by IOSDriver & AndroidDriver
bool isLocked = driver.IsLocked(); // Supported by IOSDriver & AndroidDriver
driver.Rotate(new Dictionary<string, int> { { "x", 114 }, { "y", 198 }, { "duration", 5 }, { "radius", 3 }, { "rotation", 220 }, { "touchCount", 2 } });

//Keys
driver.PressKeyCode(WindowsKeyCode.Windows);
driver.LongPressKeyCode(WindowsKeyCode.Back);
driver.HideKeyboard();

//Network
driver.toggleData();

//PerformanceData
//ScreenRecording
driver.StartRecordingScreen(
    AndroidStartScreenRecordingOptions.GetAndroidStartScreenRecordingOptions()
        .WithTimeLimit(TimeSpan.FromSeconds(10))
        .WithBitRate(500000)
        .WithVideoSize("720x1280"));

//Elements
# ruby_lib example
find_element(:accessibility_id, 'SomeAccessibilityID')

# ruby_lib_core example
@driver.find_element(:accessibility_id, 'SomeAccessibilityID')
IEnumerable<AppiumWebElement> elementsOne = driver.FindElementsByAccessibilityId("SomeAccessibilityID");
IEnumerable<AppiumWebElement> elementsTwo = driver.FindElementsByClassName("SomeClassName");

//click
MobileElement el = driver.FindElement(MobileByAccessibilityID("Some ID");
el.click();
//Example
MobileElement el = driver.FindElement(MobileById("Some ID");
el.click();

//SendKeys
MobileElement el = driver.FindElement(MobileByAccessibilityID("Some ID");
el.SendKeys("Some Text");

//Example
MobileElement el = driver.FindElement(MobileById("Some ID");
el.SendKeys("Hello World");

//Clear Elemet
var element = driver.FindElementByAccessibilityId("SomeAccessibilityID");
element.Clear();

//Returns visible text for element
var element = driver.FindElementByClassName("SomeClassName");
string elText = element.Text;

//Get an element's tag name
var element = driver.FindElementByAccessibilityId("SomeAccessibilityID");
string tagName = element.TagName;

//Get the value of an element's attribute
var element = driver.FindElementByAccessibilityId("SomeAccessibilityID");
string tagName = element.GetAttribute("content-desc");

//Determine if a form or form-like element (checkbox, select, etc...) is selected
var element = driver.FindElementByAccessibilityId("SomeAccessibilityID");
bool isSelected = element.Selected;

//Determine if an element is currently enabled
var element = driver.FindElementByAccessibilityId("SomeAccessibilityID");
bool isEnabled = element.Enabled;

//Determine if an element is currently displayed
var element = driver.FindElementByAccessibilityId("SomeAccessibilityID");
bool isDisplayed = element.Displayed;

//Submit a FORM element
var element = driver.FindElementByClassName("SomeClassName");
element.Submit();

//Gets the active element of the current session
IWebElement currentElement = driver.SwitchTo().ActiveElement();

//Test if two element IDs refer to the same element
var elementOne = driver.FindElementByClassName("SomeClassName");
var elementTwo = driver.FindElementByClassName("SomeOtherClassName");
bool isEqual = elementOne.Equals(elementTwo);

//Get the current context in which Appium is running
string Context = driver.Context;

//Get all the contexts available to automate
List<string> AllContexts = new List<string>();
     foreach (var context in (driver.Contexts))
     {
         AllContexts.Add(context);
     }

//Set the context being automated

// Switch to specific webview
  List<string> AllContexts = new List<string>();
    foreach (var context in (driver.Contexts))
    {
        AllContexts.Add(context);
    }
  driver.Context = (AllContexts[1]);
 // Switch to NATIVE_APP
 driver.Context = ("NATIVE_APP");

//Mouse
//Move the mouse by an offset of the specificed element
Actions action = new Actions(driver);
action.MoveToElement(element, 10, 10);
action.Perform();

//Click any mouse button at the current mouse coordinates
Actions action = new Actions(driver);
action.MoveToElement(element);
action.Click();
action.Perform();

//Double-clicks at the current mouse coordinates (set by moveto).
Actions action = new Actions(driver);
action.MoveToElement(element);
action.DoubleClick();
action.Perform();

//Click and hold the left mouse button at the current mouse coordinates
Actions action = new Actions(driver);
action.MoveToElement(element);
action.ClickAndHold();
action.Perform();

//Releases the mouse button previously held
Actions action = new Actions(driver);
action.MoveToElement(element);
action.ClickAndHold();
action.MoveToElement(element, 10, 10);
action.Release();
action.Perform();

//W3C Actions
//Perform a chain or multiple chains of keyboard and pointer (touch, mouse, stylus) actions
var inputDevice = new PointerInputDevice(PointerKind.Touch);
var actionSequence = new ActionSequence(inputDevice, 0);

actionSequence.AddAction(inputDevice.CreatePointerMove(element));
actionSequence.AddAction(inputDevice.CreatePointerDown(PointerButton.TouchContact));
actionSequence.AddAction(inputDevice.CreatePause(TimeSpan.FromSeconds(1)));
actionSequence.AddAction(inputDevice.CreatePointerUp(PointerButton.TouchContact));

driver.PerformActions(new List<ActionSequence> {actionSequence});

//Touch
//Single tap on the touch enabled device
TouchAction touchAction = new TouchAction(driver);
touchAction.Tap(element).Perform();

//Double tap on the touch screen using finger motion events
TouchActions action = new TouchActions(driver);
action.DoubleTap(element);
action.Perform();

//Finger move on the screen
TouchActions action = new TouchActions(driver);
action.Down(10, 10);
action.Move(50, 50);
action.Perform();

//Finger down on the screen
TouchActions action = new TouchActions(driver);
action.Down(10, 10);
action.Move(50, 50);
action.Perform();

//Finger up on the screen
TouchActions action = new TouchActions(driver);
action.Down(10, 10);
action.Up(20, 20);
action.Perform();

//Long press on the touch screen using finger motion events
var touchAction = new TouchAction(Driver);
touchAction.LongPress(element).Perform();

//Web
//SetWindow
driver.SwitchTo().Window("handle");

//Close the current window (Web context only)
driver.Close();

//Retrieve the current window handle (Web context only)
string windowHandle = driver.CurrentWindowHandle;

//Retrieve the list of all window handles available to the session (Web context only)
IEnumerable<string> windowHandles = driver.WindowHandles;

//Get the current page title (Web context only)
string title = driver.Title;

//Get the size of the specified window (Web context only)
Size windowSize = driver.Manage().Window.Size;

//Navigation
//Navigate to a new URL (Web context) or open an Appium deep link (Native)
driver.Navigate().GoToUrl("http://appium.io");

//Retrieve the URL of the current page (Web context only)
string url = driver.Url;

//Navigate backwards in the browser history, if possible (Web context only)
driver.Navigate().Back();

//Navigate forwards in the browser history, if possible (Web context only)
driver.Navigate().Forward();

//Refresh the current page. (Web context only)
driver.Navigate().Refresh();

//Inject a snippet of JavaScript into the page for execution in the context of the currently selected frame (Web context). Run a native mobile command (Native Context).//Execute Async Script
//Inject a snippet of JavaScript into the page for execution in the context of the currently selected frame (Web context only)
//Change focus to another frame on the page (Web context only)
driver.SwitchTo().Frame(3);

//Retrieve all cookies visible to the current page (Web context only)
IEnumerable<Cookie> allCookies = driver.Manage().Cookies.AllCookies;

//Set a cookie (Web context only)
driver.Manage().Cookies.AddCookie(new Cookie("foo", "bar"));

//Delete the cookie with the given name (Web context only)
driver.Manage().Cookies.DeleteCookieNamed("cookie_name");

//Delete all cookies visible to current page (Web context only)
driver.Manage().Cookies.DeleteAllCookies();






