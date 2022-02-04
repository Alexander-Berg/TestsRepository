#Status
#Retrieve the server’s current status

# ruby_lib example
remote_status

# ruby_lib_core example
@driver.remote_status

#Execute Mobile Command
#Execute a native mobile command

# ruby_lib example
execute_script("mobile: scroll", { "direction" => "down"})

# ruby_lib_core example
@driver.execute_script("mobile: scroll", { "direction" => "down"})

#Session
#Create New Session
#Create a new session

# ruby_lib example
APP_PATH = '../../path/to/app.app'

desired_caps = {
  caps: {
    platformName:  'iOS',
    platformVersion: '10.2',
    deviceName:    'iPhone 6',
    app:           APP_PATH,
    automationName: "XCUITest"
  }
}

Appium::Driver.new(desired_caps).start_driver

# ruby_lib_core example
::Appium::Core.for(desired_caps).start_driver

#End Session
#End the running session

# ruby_lib example
quit

# ruby_lib_core example
@driver.quit

#Retrieve the capabilities of the specified session

# ruby_lib example
session_capabilities

# ruby_lib_core example
@driver.session_capabilities

#Navigate backwards in the browser history, if possible (Web context only)
# ruby_lib example
back

# ruby_lib_core example
@driver.back

#Take a screenshot of the current viewport/window/page

# ruby_lib example
driver.screenshot_as(:base64) # via core_lib

# ruby_lib_core example
@driver.screenshot_as(:base64)

#Get the current application hierarchy XML (app) or page source (web)
# ruby_lib example
page_source

# ruby_lib_core example
@driver.page_source

#Configure the amount of time that a particular type of operation can execute for before they are aborted

# ruby_lib example
timeout('pageLoad', 5) # Ruby translates it to seconds

# ruby_lib_core example
@driver.timeout('pageLoad', 5) # Ruby translates it to seconds

#Set Implicit Wait Timeout
#Set the amount of time the driver should wait when searching for elements
# ruby_lib example
manage.timeouts.implicit_wait = 5 # Ruby translates it to seconds

# ruby_lib_core example
@driver.manage.timeouts.implicit_wait = 5 # Ruby translates it to seconds

#Set Script Timeout
#Set the amount of time, in milliseconds, that asynchronous scripts executed by execute async are permitted to run before they are aborted (Web context only)
# ruby_lib example
script_timeout(5) # Ruby translates it to seconds

# ruby_lib_core example
@driver.script_timeout(5) # Ruby translates it to seconds

#Get Orientation
#Get the current device/browser orientation
# ruby_lib example
orientation

# ruby_lib_core example
@driver.orientation

#Get the current geo location
# ruby_lib example
location

# ruby_lib_core example
@driver.location

#Set the current geo location
# ruby_lib example
set_location(121.21, 11.56, 94.23)

# ruby_lib_core example
@driver.set_location(121.21, 11.56, 94.23)

#Get available log types as a list of strings
# ruby_lib example
get_available_log_types

# ruby_lib_core example
@driver.logs.available_types

#Get the log for a given log type. Log buffer is reset after each request
# ruby_lib example
get_log('driver')

# ruby_lib_core example
@driver.logs.get 'driver'

#Log event
#Store a custom event
# ruby_lib example
driver.log_event vendor: 'appium', event: 'funEvent'

# ruby_lib_core example
@driver.logs.event vendor: 'appium', event: 'funEvent'
@driver.logs.event = { vendor: 'appium', event: 'anotherEvent' }

#Device
#Start Activity
#Start an Android activity by providing package name and activity name

# ruby_lib example
start_activity app_package: "com.example", app_activity: "ActivityName"

# ruby_lib_core example
@driver.start_activity app_package: "com.example", app_activity: "ActivityName"

#Get the name of the current Android activity
# ruby_lib example
current_activity

# ruby_lib_core example
@driver.current_activity

#Get Current Package
#Get the name of the current Android package
# ruby_lib example
current_package

# ruby_lib_core example
@driver.current_package

#Install App
#Install the given app onto the device
# ruby_lib example
install_app('/Users/johndoe/path/to/app.apk')

# ruby_lib_core example
@driver.install_app('/Users/johndoe/path/to/app.apk')

# ruby_lib example
app_installed?('com.example.AppName')

# ruby_lib_core example
@driver.app_installed?('com.example.AppName')
driver.IsAppInstalled("com.example.AppName");

# ruby_lib example
launch_app

# ruby_lib_core example
@driver.launch_app

# ruby_lib example
background_app(10)

# ruby_lib_core example
@driver.background_app(10)

# ruby_lib example
close_app

# ruby_lib_core example
@driver.close_app

# ruby_lib example
reset

# ruby_lib_core example
@driver.reset

# ruby_lib example
remove_app('com.example.AppName')

# ruby_lib_core example
@driver.remove_app('com.example.AppName')

# ruby_lib example
activate_app('com.apple.Preferences')
activate_app('io.appium.android.apis')

# ruby_lib_core example
@driver.activate_app('com.apple.Preferences')
@driver.activate_app('io.appium.android.apis')

# ruby_lib example
terminate_app('com.apple.Preferences')
terminate_app('io.appium.android.apis')

# ruby_lib_core example
@driver.terminate_app('com.apple.Preferences')
@driver.terminate_app('io.appium.android.apis')

#Get Clipboard
#Get the content of the system clipboard
# ruby_lib example
get_clipboard

# ruby_lib_core example
@driver.get_clipboard
# ruby_lib example
set_clipboard content: 'happy testing'

# ruby_lib_core example
@driver.set_clipboard content: 'happy testing'
#Emulate power state
# ruby_lib example
set_power_ac :on

# ruby_lib_core example
@driver.set_power_ac :on
# ruby_lib example
set_power_capacity 50

# ruby_lib_core example
@driver.set_power_capacity 50
#Push File
# ruby_lib example
push_file('/data/local/tmp/foo.bar', File.read('path/to/file.png'))

# ruby_lib_core example
@driver.push_file('/data/local/tmp/foo.bar', File.read('path/to/file.png'))
#Interactions
# ruby_lib example
shake

# ruby_lib_core example
@driver.shake
# ruby_lib example
lock
lock(5) # lock 5 seconds

# ruby_lib_core example
@driver.lock
@driver.lock(5) # lock 5 seconds

# ruby_lib example
unlock

# ruby_lib_core example
@driver.unlock

# ruby_lib example
device_locked?

# ruby_lib_core example
@driver.device_locked?

#Keys
# ruby_lib example
press_keycode(10)

# ruby_lib_core example
@driver.press_keycode(10)

# ruby_lib example
long_press_keycode(10)

# ruby_lib_core example
@driver.long_press_keycode(10)

# ruby_lib example
hide_keyboard

# ruby_lib_core example
@driver.hide_keyboard

# ruby_lib example
is_keyboard_shown

# ruby_lib_core example
@driver.is_keyboard_shown

#Network
# ruby_lib example
toggle_flight_mode

# ruby_lib_core example
@driver.toggle_flight_mode

# ruby_lib example
toggle_data

# ruby_lib_core example
@driver.toggle_data

# ruby_lib example
toggle_wifi

# ruby_lib_core example
@driver.toggle_wifi

#PerformanceData
# ruby_lib example
get_performance_data package_name: 'io.appium.android.apis', data_type: 'cpuinfo', data_read_timeout: 10

# ruby_lib_core example
@driver.get_performance_data package_name: 'io.appium.android.apis', data_type: 'cpuinfo', data_read_timeout: 10

# ruby_lib example
get_performance_data_types

# ruby_lib_core example
@driver.get_performance_data_types

#ScreenRecording
# ruby_lib example
start_recording_screen
start_recording_screen video_size: '1280x720', time_limit: '180', bit_rate: '5000000' # Android
start_recording_screen video_type: 'h264', time_limit: '260' # iOS

# ruby_lib_core example
@driver.start_recording_screen
@driver.start_recording_screen video_size: '1280x720', time_limit: '180', bit_rate: '5000000' # Android
@driver.start_recording_screen video_type: 'h264', time_limit: '260' # iOS

#Elemetns
# ruby_lib example
find_element(:accessibility_id, 'SomeAccessibilityID')

# ruby_lib_core example
@driver.find_element(:accessibility_id, 'SomeAccessibilityID')
# ruby_lib example
find_elements(:accessibility_id, "~SomeAccessibilityID")

# ruby_lib_core example
@driver.find_elements(:accessibility_id, "~SomeAccessibilityID")
#click
# ruby_lib example
find_element(:accessibility_id, 'SomeId').click

# ruby_lib_core example
@driver.find_element(:accessibility_id, 'SomeId').click

#SendKeys
# ruby_lib example
find_element(:accessibility_id, "SomeAccessibilityID").send_keys("Hello World!")

# ruby_lib_core example
@driver.find_element(:accessibility_id, "SomeAccessibilityID").send_keys("Hello World!")

#Clear Elemet
# ruby_lib example
find_element(:accessibility_id, "SomeAccessibilityID").clear

# ruby_lib_core example
@driver.find_element(:accessibility_id, "SomeAccessibilityID").clear

#Returns visible text for element
# ruby_lib example
element = find_element :accessibility_id, "SomeAccessibilityID"
element.text

# ruby_lib_core example
element = @driver.find_element :accessibility_id, "SomeAccessibilityID"
element.text

#Get an element's tag name
# ruby_lib example
find_element(:accessibility_id, 'SomeAccessibilityID').tag_name

# ruby_lib_core example
@driver.find_element(:accessibility_id, 'SomeAccessibilityID').tag_name

#Get the value of an element's attribute
# ruby_lib example
find_element(:accessibility_id, 'SomeAccessibilityID').attribute("content-desc")

# ruby_lib_core example
@driver.find_element(:accessibility_id, 'SomeAccessibilityID').attribute("content-desc")

#Determine if a form or form-like element (checkbox, select, etc...) is selected
# ruby_lib example
find_element(:accessibility_id, "SomeAccessibilityID").selected?

# ruby_lib_core example
@driver.find_element(:accessibility_id, "SomeAccessibilityID").selected?

#Determine if an element is currently enabled
# ruby_lib example
find_element(:accessibility_id, "SomeAccessibilityID").enabled?

# ruby_lib_core example
@driver.find_element(:accessibility_id, "SomeAccessibilityID").enabled?

#Determine if an element is currently displayed
# ruby_lib example
find_element(:accessibility_id, "SomeAccessibilityID").displayed?

# ruby_lib_core example
@driver.find_element(:accessibility_id, "SomeAccessibilityID").displayed?

#Submit a FORM element
# ruby_lib example
element = find_element :class_name, "someClass"
element.submit element

# ruby_lib_core example
element = @driver.find_element :class_name, "someClass"
element.submit element

#Gets the active element of the current session
# ruby_lib example
switch_to.active_element

# ruby_lib_core example
@driver.switch_to.active_element

#Test if two element IDs refer to the same element
# ruby_lib example
element1 = find_element :class_name, "someClass"
element2 = find_element :class_name, "someOtherClass"
element1 == element2

# ruby_lib_core example
element1 = @driver.find_element :class_name, "someClass"
element2 = @driver.find_element :class_name, "someOtherClass"
element1 == element2

#Get the current context in which Appium is running
# ruby_lib example
context = current_context

# ruby_lib_core example
context = @driver.current_context
#Get all the contexts available to automate
# ruby_lib example
context = available_contexts

# ruby_lib_core example
context = @driver.available_contexts

#Set the context being automated
# ruby_lib example
webview = available_contexts[1]
set_context(webview)
# ...
set_context('NATIVE_APP')

# ruby_lib_core example
webview = @driver.available_contexts[1]
@driver.set_context(webview)
# ...
@driver.set_context('NATIVE_APP')

#Mouse
#Move the mouse by an offset of the specificed element
# ruby_lib example
mouse.move_to(element)
mouse.move_to(element, 5, 5)

# ruby_lib_core example
@driver.mouse.move_to(element)
@driver.mouse.move_to(element, 5, 5)

#Click any mouse button at the current mouse coordinates
# ruby_lib example
action.move_to(element).click.perform

# ruby_lib_core example
@driver.action.move_to(element).click.perform

#Double-clicks at the current mouse coordinates (set by moveto).
# ruby_lib example
action.move_to(element).double_click.perform

# ruby_lib_core example
@driver.action.move_to(element).double_click.perform

#Click and hold the left mouse button at the current mouse coordinates
# ruby_lib example
action.move_to(element).click_and_hold.perform

# ruby_lib_core example
@driver.action.move_to(element).click_and_hold.perform

#Releases the mouse button previously held
# ruby_lib example
action.click_and_hold(el).move_to(el, 10, 10).release.perform

# ruby_lib_core example
@driver.action.click_and_hold(el).move_to(el, 10, 10).release.perform

#W3C Actions
#Perform a chain or multiple chains of keyboard and pointer (touch, mouse, stylus) actions
# ruby_lib example
# Send keys to an element
# Build Single action chain
action_builder = action
keyboard = action_builder.key_inputs
el = find_element(id: "some_id")
action.click(el).pause(keyboard).pause(keyboard).pause(keyboard).send_keys('keys').perform

# Build multiple action chains
# Example: expressing a 1-second pinch-and-zoom
# with a 500ms wait after the fingers first touch:
f1 = ::Selenium::WebDriver::Interactions.pointer(:touch, name: 'finger1')
f1.create_pointer_move(duration: 1, x: 200, y: 500, origin: ::Selenium::WebDriver::Interactions::PointerMove::VIEWPORT)
f1.create_pointer_down(:left)
f1.create_pause(0.5)
f1.create_pointer_move(duration: 1, x: 200, y: 200, origin: ::Selenium::WebDriver::Interactions::PointerMove::VIEWPORT)
f1.create_pointer_up(:left)

f2 = ::Selenium::WebDriver::Interactions.pointer(:touch, name: 'finger2')
f2.create_pointer_move(duration: 1, x: 200, y: 500, origin: ::Selenium::WebDriver::Interactions::PointerMove::VIEWPORT)
f2.create_pointer_down(:left)
f2.create_pause(0.5)
f2.create_pointer_move(duration: 1, x: 200, y: 800, origin: ::Selenium::Web@Driver::Interactions::PointerMove::VIEWPORT)
f2.create_pointer_up(:left)

perform_actions [f1, f2]

# ruby_lib_core example
# Send keys to an element
# Build Single action chain
action_builder = @driver.action
keyboard = action_builder.key_inputs
el = @driver.find_element(id: "some_id")
@driver.action.click(el).pause(keyboard).pause(keyboard).pause(keyboard).send_keys('keys').perform

# Build multiple action chains
# Example: expressing a 1-second pinch-and-zoom
# with a 500ms wait after the fingers first touch:
f1 = ::Selenium::WebDriver::Interactions.pointer(:touch, name: 'finger1')
f1.create_pointer_move(duration: 1, x: 200, y: 500, origin: ::Selenium::WebDriver::Interactions::PointerMove::VIEWPORT)
f1.create_pointer_down(:left)
f1.create_pause(0.5)
f1.create_pointer_move(duration: 1, x: 200, y: 200, origin: ::Selenium::WebDriver::Interactions::PointerMove::VIEWPORT)
f1.create_pointer_up(:left)

f2 = ::Selenium::WebDriver::Interactions.pointer(:touch, name: 'finger2')
f2.create_pointer_move(duration: 1, x: 200, y: 500, origin: ::Selenium::WebDriver::Interactions::PointerMove::VIEWPORT)
f2.create_pointer_down(:left)
f2.create_pause(0.5)
f2.create_pointer_move(duration: 1, x: 200, y: 800, origin: ::Selenium::Web@Driver::Interactions::PointerMove::VIEWPORT)
f2.create_pointer_up(:left)

@driver.perform_actions [f1, f2]

#Touch
#Single tap on the touch enabled device
# ruby_lib example
touch_action.single_tap(element).perform

# ruby_lib_core example
@driver.touch_action.single_tap(element).perform

#Double tap on the touch screen using finger motion events
# ruby_lib example
touch_action.double_tap(element).perform

# ruby_lib_core example
@driver.touch_action.double_tap(element).perform

#Finger move on the screen
# ruby_lib example
touch_action.down(element).move_to().perform

# ruby_lib_core example
@driver.touch_action.down(element).move_to().perform

#Finger down on the screen
# ruby_lib example
touch_action.down(element).move().perform

# ruby_lib_core example
@driver.touch_action.down(element).move().perform

#Finger up on the screen
# ruby_lib example
touch_action.down(element).up(50, 50).perform

# ruby_lib_core example
@driver.touch_action.down(element).up(50, 50).perform

#Long press on the touch screen using finger motion events
# ruby_lib example
touch_action.long_press(element).perform

# ruby_lib_core example
@driver.touch_action.long_press(element).perform

#Web
#SetWindow
# ruby_lib example
switch_to.window("handle")

# ruby_lib_core example
@driver.switch_to.window("handle")

#Close the current window (Web context only)
# ruby_lib example
close

# ruby_lib_core example
@driver.close

#Retrieve the current window handle (Web context only)
# ruby_lib example
window_handle

# ruby_lib_core example
@driver.window_handle

#Retrieve the list of all window handles available to the session (Web context only)
# ruby_lib example
window_handles

# ruby_lib_core example
@driver.window_handles

#Get the current page title (Web context only)
# ruby_lib example
title

# ruby_lib_core example
@driver.title

#Get the size of the specified window (Web context only)
# ruby_lib example
window_size
window_size("handleName")

# ruby_lib_core example
@driver.window_size
@driver.window_size("handleName")

#Navigation
#Navigate to a new URL (Web context) or open an Appium deep link (Native)
# ruby_lib example
get("http:#appium.io")

# ruby_lib_core example
@driver.get("http:#appium.io")

#Retrieve the URL of the current page (Web context only)
# ruby_lib example
current_url

# ruby_lib_core example
@driver.current_url

#Navigate backwards in the browser history, if possible (Web context only)
# ruby_lib example
back

# ruby_lib_core example
@driver.back

#Navigate forwards in the browser history, if possible (Web context only)
# ruby_lib example
forward

# ruby_lib_core example
@driver.forward

#Refresh the current page. (Web context only)
# ruby_lib example
navigate.refresh

# ruby_lib_core example
@driver.navigate.refresh

#Inject a snippet of JavaScript into the page for execution in the context of the currently selected frame (Web context). Run a native mobile command (Native Context).
# ruby_lib example
execute_script("document.title")

# ruby_lib_core example
@driver.execute_script("document.title")

#Execute Async Script
#Inject a snippet of JavaScript into the page for execution in the context of the currently selected frame (Web context only)
# ruby_lib example
execute_async_script("document.title")

# ruby_lib_core example
@driver.execute_async_script("document.title")

#Change focus to another frame on the page (Web context only)
# ruby_lib example
switch_to.frame(3)

# ruby_lib_core example
@driver.switch_to.frame(3)

#Retrieve all cookies visible to the current page (Web context only)
# ruby_lib example
manage.all_cookies

# ruby_lib_core example
@driver.manage.all_cookies

#Set a cookie (Web context only)
# ruby_lib example
manage.add_cookie(:name => 'foo', :value => 'bar')

# ruby_lib_core example
@driver.manage.add_cookie(:name => 'foo', :value => 'bar')

#Delete the cookie with the given name (Web context only)
# ruby_lib example
delete_cookie("cookie_name")

# ruby_lib_core example
@driver.delete_cookie("cookie_name")

#Delete all cookies visible to current page (Web context only)
# ruby_lib example
manage.delete_all_cookies

# ruby_lib_core example
@driver.manage.delete_all_cookies


