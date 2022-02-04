#Status
#Retrieve the server’s current status
selenium.webdriver.common.utils.is_url_connectable(port)

#Execute Mobile Command
#Execute a native mobile command

self.driver.execute_script("mobile: scroll", {'direction': 'down'})

#Session
#Create New Session
#Create a new session

desired_caps = {
  'platformName': 'Android',
  'platformVersion': '7.0',
  'deviceName': 'Android Emulator',
  'automationName': 'UiAutomator2',
  'app': PATH('/path/to/app')
}
self.driver = webdriver.Remote('http:#127.0.0.1:4723/wd/hub', desired_caps)

#End Session
#End the running session

self.driver.quit()

#Retrieve the capabilities of the specified session

desired_caps = self.driver.session

#Navigate backwards in the browser history, if possible (Web context only)
self.driver.back()

#Take a screenshot of the current viewport/window/page
screenshotBase64 = self.driver.get_screenshot_as_base64()

#Get the current application hierarchy XML (app) or page source (web)
source = self.driver.page_source

#Configure the amount of time that a particular type of operation can execute for before they are aborted
self.driver.set_page_load_timeout(5000)

#Set Implicit Wait Timeout
#Set the amount of time the driver should wait when searching for elements
self.driver.implicitly_wait(5) # waits 5 seconds

#Set Script Timeout
#Set the amount of time, in milliseconds, that asynchronous scripts executed by execute async are permitted to run before they are aborted (Web context only)
self.driver.set_script_timeout(5000)

#Get Orientation
#Get the current device/browser orientation
orientation = self.driver.orientation

#Get the current geo location
location = self.driver.location()

#Set the current geo location
self.driver.set_location(49, 123, 10)

#Get available log types as a list of strings
log_types = driver.log_types

#Get the log for a given log type. Log buffer is reset after each request
logs = driver.get_log('driver')

#Log event
#Store a custom event
driver.log_event('appium', 'funEvent')

#Device
#Start Activity
#Start an Android activity by providing package name and activity name
self.driver.start_activity("com.example", "ActivityName");

#Get the name of the current Android activity
activity = self.driver.current_activity;

#Get Current Package
#Get the name of the current Android package
package = self.driver.current_package;

#Install App
#Install the given app onto the device
self.driver.install_app('/Users/johndoe/path/to/app.apk');
self.driver.is_app_installed('com.example.AppName');
self.driver.launch_app()
self.driver.background_app(10)
self.driver.close_app()
self.driver.reset()
self.driver.remove_app('com.example.AppName');
driver.activate_app('com.apple.Preferences')
driver.activate_app('io.appium.android.apis')
driver.terminateApp('com.apple.Preferences');
driver.terminateApp('io.appium.android.apis');
#Get Clipboard
#Get the content of the system clipboard
self.driver.get_clipboard()
self.driver.get_clipboard_text()
self.driver.set_clipboard('happy testing')
self.driver.set_clipboard_text('happy testing')
#Emulate power state
self.driver.set_power_ac(Power.AC_OFF)
self.driver.set_power_capacity(50)
#Push File
dest_path = '/data/local/tmp/test_push_file.txt'
data = bytes('This is the contents of the file to push to the device.', 'utf-8')
self.driver.push_file(dest_path, base64.b64encode(data).decode('utf-8'))
#Interactions
self.driver.shake();
self.driver.lock();
self.driver.unlock();
boolean isLocked = driver.isDeviceLocked();

#Keys
self.driver.press_keycode(10);
self.driver.long_press_keycode(10);
self.driver.hide_keyboard()
driver.is_keyboard_shown()
#Network
driver.toggle_wifi()

#PerformanceData
self.driver.get_performance_data('my.app.package', 'cpuinfo', 5)
self.driver.get_performance_data_types()

#ScreenRecording
self.driver.start_recording_screen()

#Elements
el = self.driver.find_element_by_accessibility_id('SomeAccessibilityID')

el = driver.find_element(AppiumBy.ACCESSIBILITY_ID,'SomeAccessibilityID')
#click
el = self.driver.find_element_by_accessibility_id('SomeId')
el.click();
#SendKeys
self.driver.find_element_by_accessibility_id('SomeAccessibilityID').send_keys('Hello world!')

#Clear Elemet
self.driver.find_element_by_accessibility_id('SomeAccessibilityID').clear()
#Returns visible text for element
el = self.driver.find_element_by_accessibility_id('SomeAccessibilityID')
text = el.text

#Get an element's tag name
tagName = self.driver.find_element_by_accessibility_id('SomeAccessibilityID').tag_name
#Get the value of an element's attribute
tagName = self.driver.find_element_by_accessibility_id('SomeAccessibilityID').get_attribute('content-desc')

#Determine if a form or form-like element (checkbox, select, etc...) is selected
self.driver.find_element_by_accessibility_id('SomeAccessibilityID').is_selected()

#Determine if an element is currently enabled
self.driver.find_element_by_accessibility_id('SomeAccessibilityID').is_enabled()

#Determine if an element is currently displayed
self.driver.find_element_by_accessibility_id('SomeAccessibilityID').is_displayed()

#Submit a FORM element
el = self.driver.find_element_by_accessibility_id('SomeAccessibilityID')
el.submit();

#Gets the active element of the current session
element = driver.switch_to.active_element

#Test if two element IDs refer to the same element
#Get the current context in which Appium is running
context = driver.current_context
# or
context = driver.context

#Get all the contexts available to automate
contexts = driver.contexts

#Set the context being automated
webview = driver.contexts[1]
driver.switch_to.context(webview)
# ...
driver.switch_to.context('NATIVE_APP')

#Mouse
#Move the mouse by an offset of the specificed element
actions = ActionChains(driver)
actions.move_to(element, 10, 10)
actions.perform()

#Click any mouse button at the current mouse coordinates
actions = ActionChains(driver)
actions.move_to_element(element)
actions.click()
actions.perform()

#Double-clicks at the current mouse coordinates (set by moveto).
actions = ActionChains(driver)
actions.move_to_element(element)
actions.double_click()
actions.perform()

#Click and hold the left mouse button at the current mouse coordinates
actions = ActionChains(driver)
actions.move_to_element(element)
actions.click_and_hold()
actions.perform()

#Releases the mouse button previously held
actions = ActionChains(driver)
actions.move_to_element(element)
actions.click_and_hold()
actions.move_to_element(element, 10, 10)
action.release();
actions.perform()

#W3C Actions
#Perform a chain or multiple chains of keyboard and pointer (touch, mouse, stylus) actions

element = driver.find_element_by_accessibility_id("elId")
actions = ActionChains(driver)
actions.move_to_element(element)
actions.click(hidden_submenu)
actions.perform()

#Touch
#Single tap on the touch enabled device
from appium.webdriver.common.touch_action import TouchAction
# ...
actions = TouchAction(driver)
actions.tap(element)
actions.perform()

#Double tap on the touch screen using finger motion events
from appium.webdriver.common.touch_action import TouchAction
# ...
actions = TouchAction(driver)
actions.double_tap(element)
actions.perform()

#Finger move on the screen

from appium.webdriver.common.touch_action import TouchAction
# ...
actions = TouchAction(driver)
actions.tap_and_hold(element)
actions.move_to(element, 50, 50)
actions.perform()

#Finger down on the screen
from appium.webdriver.common.touch_action import TouchAction
# ...
actions = TouchAction(driver)
actions.tap_and_hold(element)
actions.move(50, 50)
actions.perform()

#Finger up on the screen
from appium.webdriver.common.touch_action import TouchAction
# ...
actions = TouchAction(driver)
actions.tap_and_hold(20, 20)
actions.release(50, 50)
actions.perform()

#Long press on the touch screen using finger motion events
from appium.webdriver.common.touch_action import TouchAction
# ...
actions = TouchAction(driver)
actions.long_press(element)
actions.perform()

#Web
#SetWindow
self.driver.switch_to.window("handle")

#Close the current window (Web context only)
self.driver.close()

#Retrieve the current window handle (Web context only)
window_handle = self.driver.current_window_handle

#Retrieve the list of all window handles available to the session (Web context only)
window_handles = self.driver.window_handles

#Get the current page title (Web context only)
title = self.driver.title

#Get the size of the specified window (Web context only)
handle_one_size = self.driver.get_window_size()
handle_two_size = self.driver.get_window_size("handleName")

#Navigation
#Navigate to a new URL (Web context) or open an Appium deep link (Native)
self.driver.get("http:#appium.io/")

#Retrieve the URL of the current page (Web context only)
url = self.driver.current_url()

#Navigate backwards in the browser history, if possible (Web context only)
self.driver.back()

#Navigate forwards in the browser history, if possible (Web context only)
self.driver.forward()

#Refresh the current page. (Web context only)
driver.refresh();

#Inject a snippet of JavaScript into the page for execution in the context of the currently selected frame (Web context). Run a native mobile command (Native Context).
self.driver.execute_script(‘document.title’)

#Execute Async Script
#Inject a snippet of JavaScript into the page for execution in the context of the currently selected frame (Web context only)
self.driver.execute_async_script(‘document.title’)

#Change focus to another frame on the page (Web context only)
self.driver.switch_to.frame(3)

#Retrieve all cookies visible to the current page (Web context only)
cookies = self.driver.get_cookies()

#Set a cookie (Web context only)
self.driver.add_cookie({name: 'foo', value: 'bar'})

#Delete the cookie with the given name (Web context only)
self.driver.delete_cookie("cookie_name")

#Delete all cookies visible to current page (Web context only)
self.driver.delete_all_cookies()

