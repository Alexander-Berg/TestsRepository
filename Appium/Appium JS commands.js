//Status
//Retrieve the server’s current status

// webdriver.io example
driver.status();

// wd example
await driver.status();

//Execute Mobile Command
//Execute a native mobile command

// webdriver.io example
var result = browser.execute('mobile: scroll', {direction: 'down'})

// wd example
await driver.execute('mobile: scroll', {direction: 'down'});

//Session
//Create New Session
//Create a new session

// webdriver.io example
let options = { desiredCapabilities: {
    platformName: 'Android',
    platformVersion: '7.0',
    automationName: 'UiAutomator2',
    app: path.resolve('path', 'to', 'app.apk')
  }};
  let client = driver.newSession(options);
  
  // wd example
  let driver = await wd.promiseChainRemote({
    host: '127.0.0.1',
    port: 4723
  });
  let desiredCaps = {
    platformName: 'Android',
    platformVersion: '7.0',
    deviceName: 'Android Emulator',
    app: path.resolve('path', 'to', 'app.apk')
  };
  await driver.init(desiredCaps);
  
//End Session
//End the running session

// webdriver.io example
driver.deleteSession();

// wd example
await driver.quit();

//Retrieve the capabilities of the specified session

// webdriver.io example
let caps = driver.capabilities;

// wd example
let caps = await driver.sessionCapabilities();

//Navigate backwards in the browser history, if possible (Web context only)
// webdriver.io example
driver.back();

// wd example
await driver.back()

//Take a screenshot of the current viewport/window/page
// webdriver.io example
let screenshot = driver.takeScreenshot();

// wd example
let screenshot = await driver.takeScreenshot();

//Get the current application hierarchy XML (app) or page source (web)
// webdriver.io example
let source = driver.getPageSource();

// wd example
let pageSource = await driver.source();

//Configure the amount of time that a particular type of operation can execute for before they are aborted

// webdriver.io example
driver.setTimeouts(5000)

// wd example
await driver.setPageLoadTimeout(5000);

//Set Implicit Wait Timeout
//Set the amount of time the driver should wait when searching for elements
// webdriver.io example
driver.setImplicitTimeout(5000)

// wd example
await driver.setImplicitWaitTimeout(5000);

//Set Script Timeout
//Set the amount of time, in milliseconds, that asynchronous scripts executed by execute async are permitted to run before they are aborted (Web context only)
// webdriver.io example
driver.setAsyncTimeout(5000)

// wd example
await driver.setAsyncScriptTimeout(5000);

//Get Orientation
//Get the current device/browser orientation
// webdriver.io example
let orientation = driver.getOrientation();

// wd example
let orientation = await driver.getOrientation();

//Get the current geo location
// webdriver.io example
let location = driver.getGeoLocation();

// wd example
let location = await driver.getGeoLocation();

//Set the current geo location
// webdriver.io example
driver.setGeoLocation({latitude: "121.21", longitude: "11.56", altitude: "94.23"});

// wd example
await driver.setGeoLocation(121.21, 11.56, 10);

//Get available log types as a list of strings
// webdriver.io example
driver.getLogTypes()

// wd example
const logTypes = await driver.logTypes();

//Get the log for a given log type. Log buffer is reset after each request
// webdriver.io example
let logs = driver.getLogs('driver')

// wd example
const logs = await driver.log('driver');

//Log event
//Store a custom event
// webdriver.io example
driver.logEvent('appium', 'funEvent')

// wd example
// WD code here

//Device
//Start Activity
//Start an Android activity by providing package name and activity name

// webdriver.io example
driver.startActivity("com.example", "ActivityName");

// wd example
await driver.startActivity({
  appPackage: "com.example",
  appActivity: "ActivityName"
});

//Get the name of the current Android activity
// webdriver.io example
let activity = driver.getCurrentActivity();

// wd example
let activity = await driver.getCurrentActivity();

//Get Current Package
//Get the name of the current Android package
// webdriver.io example
let package = driver.getCurrentPackage();

// wd example
let package = await driver.getCurrentPackage();

//Install App
//Install the given app onto the device
// webdriver.io example
driver.installApp('/Users/johndoe/path/to/app.apk')

// wd example
await driver.installAppOnDevice('/Users/johndoe/path/to/app.apk');
// webdriver.io example
driver.isAppInstalled('com.example.AppName')

// wd example
await driver.isAppInstalledOnDevice('com.example.AppName');

// webdriver.io example
driver.launchApp();

// wd example
await driver.launchApp();

// webdriver.io example
driver.background(10);

// wd example
await driver.backgroundApp(10);

// webdriver.io example
driver.closeApp();

// wd example
await driver.closeApp();

// webdriver.io example
driver.reset();

// wd example
await driver.resetApp();

// webdriver.io example
driver.removeApp('com.example.AppName')

// wd example
await driver.removeAppFromDevice('com.example.AppName');

// webdriver.io example
driver.activateApp(null, 'com.apple.Preferences')
driver.activateApp('io.appium.android.apis')

// wd example
// Supports only `mobile: queryAppState` for iOS, XCUITest

//Get Clipboard
//Get the content of the system clipboard
self.driver.get_clipboard()
self.driver.get_clipboard_text()
// webdriver.io example
driver.setClipboard('happy testing', 'plaintext')

// wd example
await driver.setClipboard('happy testing', 'plaintext')
//Emulate power state
// webdriver.io example
driver.powerAC('on')
// webdriver.io example
driver.powerCapacity(50)
//Push File
// webdriver.io example
let data = new Buffer("Hello World").toString('base64');
driver.pushFile('/data/local/tmp/file.txt', data);

// wd example
await driver.pushFileToDevice('/data/local/tmp/foo.bar', 'QXJlIHlvdXIgYmVlcnMgb2theT8=');
//Interactions
// webdriver.io example
driver.shake();

// wd example
await driver.shake();
// webdriver.io example
driver.lock();

// wd example
await driver.lock();

// webdriver.io example
driver.lock()
  .unlock();

// wd example
await driver.lock();
await driver.unlock();

// webdriver.io example
driver.isLocked();

// wd example
let isLocked = await driver.isLocked();

// webdriver.io example
driver.rotateDevice(100, 100);

// wd example
driver.rotateDevice({x: 114, y: 198, duration: 5, radius: 3, rotation: 220, touchCount: 2});

//Keys
// webdriver.io example
driver.pressKeyCode(10);

// wd example
await driver.pressKeycode(10);

// webdriver.io example
driver.longPressKeyCode(10);

// wd example
await driver.longPressKeycode(10);

// webdriver.io example
driver.hideKeyboard();

// wd example
await driver.hideDeviceKeyboard();
// webdriver.io example
driver.isKeyboardShown();

// wd example
await driver.isKeyboardShown();

//Network
// webdriver.io example
driver.toggleAirplaneMode();

// wd example
await driver.toggleAirplaneMode();

// webdriver.io example
driver.toggleData();

// wd example
await driver.toggleData();

// webdriver.io example
driver.toggleWiFi();

// wd example
await driver.toggleWiFi();

//PerformanceData
// webdriver.io example
driver.getPerformanceData('my.app.package', 'cpuinfo', 5);

// wd example
await driver.getPerformanceData('my.app.package', 'cpuinfo', 5);
// webdriver.io example
driver.getPerformanceDataTypes();

// wd example
await driver.getSupportedPerformanceDataTypes();

//ScreenRecording
// webdriver.io example
driver.startRecordingScreen();

//Elements
// webdriver.io example
$("~SomeAccessibilityId");
// wd example
let elementOne = await driver.elementByAccessibilityId("SomeAccessibilityID");
let elementTwo = await driver.element("id", "SomeID");
// webdriver.io example
$$("~SomeAccessibilityId");

// wd example
let elementsOne = await driver.elementsByAccessibilityId("SomeAccessibilityID");
let elementsTwo = await driver.elements("id", "SomeID");
//click
// webdriver.io example
$('#SomeId').click();

// wd example
let element = await driver.elementByAccessibilityId('id', 'SomeId');
await element.click();

//SendKeys
// webdriver.io example
$("~SomeAccessibilityId").addValue("Enter");

// wd example
let element = await driver.elementByAccessibilityId("SomeAccessibilityID");
await element.type("Hello world!")

//Clear Elemet
// webdriver.io example
$("~SomeAccessibilityId").clearValue();

// wd example
let element = await driver.elementByAccessibilityId("SomeAccessibilityID");
await element.clear();

//Returns visible text for element
// webdriver.io example
$("~SomeAccessibilityId").getText();

// wd example
let element = await driver.elementByAccessibilityId("SomeAccessibilityID");
await element.text();

//Get an element's tag name
// webdriver.io example
let tagName = $("~SomeAccessibilityId").getTagName();

// wd example
let element = await driver.elementByAccessibilityId("SomeAccessibilityID");
let tagName = await element.getTagName();

//Get the value of an element's attribute
// webdriver.io example
let attribute = $("~SomeAccessibilityId").getAttribute("content-desc");

// wd example
let element = await driver.elementByAccessibilityId("SomeAccessibilityID");
let tagName = await element.getAttribute("content-desc");

//Determine if a form or form-like element (checkbox, select, etc...) is selected
// webdriver.io example
let isSelected = $("~SomeAccessibilityId").isSelected();

// wd example
let element = await driver.elementByAccessibilityId("SomeAccessibilityID");
let isSelected = await element.isSelected();

//Determine if an element is currently enabled
// webdriver.io example
let isEnabled = $("~SomeAccessibilityId").isEnabled();

// wd example
let element = await driver.elementByAccessibilityId("SomeAccessibilityID");
let isEnabled = await element.isEnabled();

//Determine if an element is currently displayed
// webdriver.io example
let isDisplayed = $("~SomeAccessibilityId").isDisplayed();

// wd example
let element = await driver.elementByAccessibilityId("SomeAccessibilityID");
let isDisplayed = await element.isDisplayed();

//Submit a FORM element
// webdriver.io example
let formElement = $("~SomeAccessibilityId");
driver.elementSubmit(formElement.elementId);

// wd example
let element = await driver.elementByAccessibilityId("SomeAccessibilityID");
await element.submit();

//Gets the active element of the current session
// webdriver.io example
driver.getActiveElement();

// wd example
let element = await driver.active();

//Test if two element IDs refer to the same element
// webdriver.io example
let elementOne = $("someClass");
let elementTwo = $("someOtherClass");
let isEqual = elementOne.isEqual(elementTwo);

// wd example
let elementOne = await driver.elementByClassName("someClass");
let elementTwo = await driver.elementByClassName("someOtherClass");
let isEqual = await elementOne.equalsElement(elementTwo);

//Get the current context in which Appium is running
// webdriver.io example
let context = driver.getContext();

// wd example
let context = await driver.currentContext();

//Get all the contexts available to automate
// webdriver.io example
let contexts = driver.getContexts();

// wd example
let contexts = await driver.contexts();

//Set the context being automated
// webdriver.io example
let contexts = driver.getContexts();
driver.switchContext(contexts[1]);
// ...
driver.switchContext('NATIVE_APP');

// wd example
let contexts = await driver.contexts();
await driver.context(contexts[1]);
// ...
await driver.context('NATIVE_APP');

//Mouse
//Move the mouse by an offset of the specificed element
// webdriver.io example
$(element).moveTo(10, 10);

// wd example
await driver.moveTo(element, 10, 10);

//Click any mouse button at the current mouse coordinates
// webdriver.io example
$("~SomeId").click();

// wd example
await driver.moveTo(element);
await driver.click();

//Double-clicks at the current mouse coordinates (set by moveto).
// webdriver.io example
$("~SomeId").doubleClick();

// wd example
await driver.moveTo(element);
await driver.doubleclick();

//Click and hold the left mouse button at the current mouse coordinates
// webdriver.io example
driver.moveTo(element);
driver.buttonDown();

// wd example
await driver.moveTo(element);
await driver.buttonDown();

//Releases the mouse button previously held
// webdriver.io example
driver.moveTo(element);
driver.buttonDown();
driver.moveTo(element, 10, 10);
driver.buttonUp();

// wd example
await driver.moveTo(element);
await driver.buttonDown();
await driver.moveTo(element, 10, 10);
await driver.buttonUp();

//Perform a chain or multiple chains of keyboard and pointer (touch, mouse, stylus) actions

// webdriver.io example
// Example: expressing a 1-second pinch-and-zoom
// with a 500ms wait after the fingers first touch:
driver.performActions([{
    "type": "pointer",
    "id": "finger1",
    "parameters": {"pointerType": "touch"},
    "actions": [
        {"type": "pointerMove", "duration": 0, "x": 100, "y": 100},
        {"type": "pointerDown", "button": 0},
        {"type": "pause", "duration": 500},
        {"type": "pointerMove", "duration": 1000, "origin": "pointer", "x": -50, "y": 0},
        {"type": "pointerUp", "button": 0}
    ]
}, {
    "type": "pointer",
    "id": "finger2",
    "parameters": {"pointerType": "touch"},
    "actions": [
        {"type": "pointerMove", "duration": 0, "x": 100, "y": 100},
        {"type": "pointerDown", "button": 0},
        {"type": "pause", "duration": 500},
        {"type": "pointerMove", "duration": 1000, "origin": "pointer", "x": 50, "y": 0},
        {"type": "pointerUp", "button": 0}
    ]
}]);

// release an action
driver.releaseActions();

// wd example
// Performs a 'pinch-and-zoom'
var actions = new wd.W3CActions(driver);
var touchInput = actions.addTouchInput();
touchInput.pointerMove({duration: 0, x: 100, y: 100});
touchInput.pointerDown({button: 0});
touchInput.pause({duration: 500});
touchInput.pointerMove({duration: 1000, origin: 'pointer', x: -50, y: 100});
touchInput.pointerUp({button: 0});
var secondTouchInput = actions.addTouchInput();
secondTouchInput.pointerMove({duration: 0, x: 200, y: 200});
secondTouchInput.pointerDown({button: 0});
secondTouchInput.pause({duration: 300});
secondTouchInput.pointerMove({duration: 1000, origin: 'pointer', x: 50, y: 100});
secondTouchInput.pointerUp({button: 0});
await actions.perform();

//W3C Actions
// Releases any previously run actions (e.g.: if a key is 'down' because of /actions, releases it using key up)
await driver.releaseW3CActions();

//Touch
//Single tap on the touch enabled device
// webdriver.io example
browser.touchAction({
    action: 'tap',
    x: 30,
    y: 20
  })
  
  // wd example
  // Using tapElement method
  await driver.tapElement(elementOne);
  
  // Using touch actions
  let action = new wd.TouchAction();
  action.tap({el: element});
  await action.perform();
  
//Double tap on the touch screen using finger motion events  
// webdriver.io example
driver.touchDoubleClick(element.elementId);
// wd example
// Using tapElement method
await driver.tapElement(elementOne);

// Using touch actions
let action = new wd.TouchAction();
action.tap({el: element});
await action.perform();

//Finger move on the screen
// webdriver.io example
driver.multiTouchPerform([
    { action: 'press', options: { x: 100, y: 250 }},
    { action: 'moveTo', options: { x: 300, y: 100 }},
    { action: 'release' }
  ]);
  
  // wd example
  let action = new wd.TouchAction(driver);
  action.press({x: 10, y: 10})
        .wait(1000)
        .moveTo({x: 50, y: 50})
        .release();
  await action.perform();
  
//Finger down on the screen  
// webdriver.io example
driver.touchDown(10, 10);

// wd example
// Using tapElement method
await driver.tapElement(elementOne);

// Using touch actions
let action = new wd.TouchAction();
action.press({x: 10, y: 10});
action.moveTo({x: 50, y: 50});
await action.perform();

//Finger up on the screen
// webdriver.io example
driver.touchUp(10, 10);

// wd example
// Using tapElement method
await driver.tapElement(elementOne);

// Using touch actions
let action = new wd.TouchAction();
action.press({x: 10, y: 10});
action.release({x: 20, y: 20});
await action.perform();

//Long press on the touch screen using finger motion events
// webdriver.io example
driver.touchPerform({
    action: 'longPress',
    options: {
      element: element
    }
  });
  
  // wd example
  // Using touch actions
  let action = new wd.TouchAction();
  action.longPress({el: element});
  await action.perform();
  
//Web
//SetWindow  
// webdriver.io example
driver.switchToWindow("handle");

// wd example
await driver.window("handle");

//Close the current window (Web context only)
// webdriver.io example
driver.closeWindow();

// wd example
await driver.close();

//Retrieve the current window handle (Web context only)
// webdriver.io example
let handle = driver.getWindowHandle();

// wd example
let windowHandle = await driver.windowHandle();

//Retrieve the list of all window handles available to the session (Web context only)
// webdriver.io example
let handles = driver.getWindowHandles();

// wd example
let windowHandle = await driver.windowHandles();

//Get the current page title (Web context only)
// webdriver.io example
let handle = driver.getTitle();

// wd example
let title = await driver.title();

//Get the size of the specified window (Web context only)
// webdriver.io example
let position = driver.getWindowRect();

// wd example
let handleOneSize = await driver.getWindowSize();
let handleTwoSize = await driver.getWindowSize("handleName");

//Navigation
//Navigate to a new URL (Web context) or open an Appium deep link (Native)
// webdriver.io example
driver.url("http://appium.io");

// wd example
await driver.get("http://appium.io/");

//Retrieve the URL of the current page (Web context only)
// webdriver.io example
let url = driver.getUrl();

// wd example
let url = await driver.url();

//Navigate backwards in the browser history, if possible (Web context only)
// webdriver.io example
driver.back();

// wd example
await driver.back();

//Navigate forwards in the browser history, if possible (Web context only)
// webdriver.io example
driver.forward();

// wd example
await driver.forward();

//Refresh the current page. (Web context only)
// webdriver.io example
driver.refresh();

// wd example
await driver.refresh();

//Inject a snippet of JavaScript into the page for execution in the context of the currently selected frame (Web context). Run a native mobile command (Native Context).
// webdriver.io example
var result = browser.execute(function(a, b, c, d) {
    // browser context - you may not access client or console
    return a + b + c + d;
  }, 1, 2, 3, 4)
  
  // node.js context - client and console are available
  console.log(result); // outputs: 10
  
  // wd example
  await driver.execute('document.title');
  
//Execute Async Script
//Inject a snippet of JavaScript into the page for execution in the context of the currently selected frame (Web context only)  
// webdriver.io example
driver.setAsyncTimeout(5000)
var result = browser.executeAsync(function(a, b, c, d, done) {
    // browser context - you may access neither client nor console
    setTimeout(function() {
        done(a + b + c + d);
    }, 3000);
}, 1, 2, 3, 4)

// node.js context - client and console are available
console.log(result); // outputs: 10

// wd example
await driver.safeExecuteAsync('document.title');

//Change focus to another frame on the page (Web context only)
// webdriver.io example
driver.switchToFrame(3);

// wd example
await driver.frame(3);

//Retrieve all cookies visible to the current page (Web context only)
// webdriver.io example
let cookies = driver.getCookies();

// wd example
let cookies = await driver.allCookies();

//Set a cookie (Web context only)
// webdriver.io example
driver.setCookies([{
    name: 'myCookie',
    value: 'some content'
  }]);
  
  // wd example
  let cookies = await driver.setCookie({name: 'foo', value: 'bar'});
  
//Delete the cookie with the given name (Web context only)
// webdriver.io example
driver.deleteCookies("cookie_name");

// wd example
await driver.deleteCookie("cookie_name");

//Delete all cookies visible to current page (Web context only)
// webdriver.io example
driver.deleteCookies();

// wd example
await driver.deleteAllCookies();




