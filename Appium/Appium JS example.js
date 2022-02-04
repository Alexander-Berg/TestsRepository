//Appium test framework initialization
// javascript
const opts = {
    path: '/wd/hub',
    port: 4723,
    capabilities: {
      platformName: "Android",
      platformVersion: "8",
      deviceName: "Android Emulator",
      app: "/path/to/the/downloaded/ApiDemos-debug.apk",
      appPackage: "io.appium.android.apis",
      appActivity: ".view.TextFields",
      automationName: "UiAutomator2"
    }
  };
  
  async function main () {
    const client = await wdio.remote(opts);
  
    await client.deleteSession();
  }
  
  main();

  //Test Commands
  // javascript

const field = await client.$("android.widget.EditText");
await field.setValue("Hello World!");
const value = await field.getText();
assert.strictEqual(value, "Hello World!")

//All together
// javascript

const wdio = require("webdriverio");
const assert = require("assert");

const opts = {
  path: '/wd/hub',
  port: 4723,
  capabilities: {
    platformName: "Android",
    platformVersion: "8",
    deviceName: "Android Emulator",
    app: "/path/to/the/downloaded/ApiDemos-debug.apk",
    appPackage: "io.appium.android.apis",
    appActivity: ".view.TextFields",
    automationName: "UiAutomator2"
  }
};

async function main () {
  const client = await wdio.remote(opts);

  const field = await client.$("android.widget.EditText");
  await field.setValue("Hello World!");
  const value = await field.getText();
  assert.strictEqual(value,"Hello World!");

  await client.deleteSession();
}

main();

//example of creating a test session for Windows Alarms & Clock app written in C#:

// Launch the AlarmClock app
DesiredCapabilities appCapabilities = new DesiredCapabilities();
appCapabilities.SetCapability("app", "Microsoft.WindowsAlarms_8wekyb3d8bbwe!App");
AlarmClockSession = new WindowsDriver<WindowsElement>(new Uri("http://127.0.0.1:4723"), appCapabilities);
// Control the AlarmClock app
AlarmClockSession.FindElementByAccessibilityId("AddAlarmButton").Click();
AlarmClockSession.FindElementByAccessibilityId("AlarmNameTextBox").Clear();

//example of creating a test session for Windows Notepad app:

// Launch Notepad
DesiredCapabilities appCapabilities = new DesiredCapabilities();
appCapabilities.SetCapability("app", @"C:\Windows\System32\notepad.exe");
NotepadSession = new WindowsDriver<WindowsElement>(new Uri("http://127.0.0.1:4723"), appCapabilities);
// Control the Notepad app
NotepadSession.FindElementByClassName("Edit").SendKeys("This is some text");

