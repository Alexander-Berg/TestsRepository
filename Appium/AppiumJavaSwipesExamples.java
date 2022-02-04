/**
 * Performs swipe from the center of screen
 *
 * @param dir the direction of swipe
 * @version java-client: 7.3.0
 **/
public void swipeScreen(Direction dir) {
    System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

    // Animation default time:
    //  - Android: 300 ms
    //  - iOS: 200 ms
    // final value depends on your app and could be greater
    final int ANIMATION_TIME = 200; // ms

    final int PRESS_TIME = 200; // ms

    int edgeBorder = 10; // better avoid edges
    PointOption pointOptionStart, pointOptionEnd;

    // init screen variables
    Dimension dims = driver.manage().window().getSize();

    // init start point = center of screen
    pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

    switch (dir) {
        case DOWN: // center of footer
            pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
            break;
        case UP: // center of header
            pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
            break;
        case LEFT: // center of left side
            pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
            break;
        case RIGHT: // center of right side
            pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
            break;
        default:
            throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
    }

    // execute swipe using TouchAction
    try {
        new TouchAction(driver)
                .press(pointOptionStart)
                // a bit more reliable when we add small wait
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();
    } catch (Exception e) {
        System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
        return;
    }

    // always allow swipe action to complete
    try {
        Thread.sleep(ANIMATION_TIME);
    } catch (InterruptedException e) {
        // ignore
    }
}

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;
}

/**
 * Performs swipe inside an element
 *
 * @param el  the element to swipe
 * @param dir the direction of swipe
 * @version java-client: 7.3.0
 **/
public void swipeElementAndroid(MobileElement el, Direction dir) {
    System.out.println("swipeElementAndroid(): dir: '" + dir + "'"); // always log your actions

    // Animation default time:
    //  - Android: 300 ms
    //  - iOS: 200 ms
    // final value depends on your app and could be greater
    final int ANIMATION_TIME = 200; // ms

    final int PRESS_TIME = 200; // ms

    int edgeBorder;
    PointOption pointOptionStart, pointOptionEnd;

    // init screen variables
    Rectangle rect = el.getRect();
    // sometimes it is needed to configure edgeBorders
    // you can also improve borders to have vertical/horizontal
    // or left/right/up/down border variables
    edgeBorder = 0;

    switch (dir) {
        case DOWN: // from up to down
            pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                    rect.y + edgeBorder);
            pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                    rect.y + rect.height - edgeBorder);
            break;
        case UP: // from down to up
            pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                    rect.y + rect.height - edgeBorder);
            pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                    rect.y + edgeBorder);
            break;
        case LEFT: // from right to left
            pointOptionStart = PointOption.point(rect.x + rect.width - edgeBorder,
                    rect.y + rect.height / 2);
            pointOptionEnd = PointOption.point(rect.x + edgeBorder,
                    rect.y + rect.height / 2);
            break;
        case RIGHT: // from left to right
            pointOptionStart = PointOption.point(rect.x + edgeBorder,
                    rect.y + rect.height / 2);
            pointOptionEnd = PointOption.point(rect.x + rect.width - edgeBorder,
                    rect.y + rect.height / 2);
            break;
        default:
            throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
    }

    // execute swipe using TouchAction
    try {
        new TouchAction(driver)
                .press(pointOptionStart)
                // a bit more reliable when we add small wait
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();
    } catch (Exception e) {
        System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
        return;
    }

    // always allow swipe action to complete
    try {
        Thread.sleep(ANIMATION_TIME);
    } catch (InterruptedException e) {
        // ignore
    }
}

/**
 * Performs small swipe from the center of screen
 *
 * @param dir the direction of swipe
 * @version java-client: 7.3.0
 **/
public void swipeScreenSmall(Direction dir) {
    System.out.println("swipeScreenSmall(): dir: '" + dir + "'"); // always log your actions

    // Animation default time:
    //  - Android: 300 ms
    //  - iOS: 200 ms
    // final value depends on your app and could be greater
    final int ANIMATION_TIME = 200; // ms

    final int PRESS_TIME = 200; // ms

    PointOption pointOptionStart, pointOptionEnd;

    // init screen variables
    Dimension dims = driver.manage().window().getSize();

    // init start point = center of screen
    pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

    // reduce swipe move into multiplier times comparing to swipeScreen move
    int mult = 10; // multiplier
    switch (dir) {
        case DOWN: // center of footer
            pointOptionEnd = PointOption.point(dims.width / 2, (dims.height / 2) + (dims.height / 2) / mult);
            break;
        case UP: // center of header
            pointOptionEnd = PointOption.point(dims.width / 2, (dims.height / 2) - (dims.height / 2) / mult);
            break;
        case LEFT: // center of left side
            pointOptionEnd = PointOption.point((dims.width / 2) - (dims.width / 2) / mult, dims.height / 2);
            break;
        case RIGHT: // center of right side
            pointOptionEnd = PointOption.point((dims.width / 2) + (dims.width / 2) / mult, dims.height / 2);
            break;
        default:
            throw new IllegalArgumentException("swipeScreenSmall(): dir: '" + dir.toString() + "' NOT supported");
    }

    // execute swipe using TouchAction
    try {
        new TouchAction(driver)
                .press(pointOptionStart)
                // a bit more reliable when we add small wait
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();
    } catch (Exception e) {
        System.err.println("swipeScreenSmall(): TouchAction FAILED\n" + e.getMessage());
        return;
    }

    // always allow swipe action to complete
    try {
        Thread.sleep(ANIMATION_TIME);
    } catch (InterruptedException e) {
        // ignore
    }
}

//////////////////////////IOS XCUITest///////////////////
/**
 * Performs swipe inside an element
 *
 * @param el  the element to swipe
 * @param dir the direction of swipe
 * @version java-client: 7.3.0
 **/
public void swipeElementIOS(MobileElement el, Direction dir) {
    System.out.println("swipeElementIOS(): dir: '" + dir + "'"); // always log your actions

    // Animation default time:
    //  - Android: 300 ms
    //  - iOS: 200 ms
    // final value depends on your app and could be greater
    final int ANIMATION_TIME = 200; // ms

    final int PRESS_TIME = 500; // ms

    // init screen variables
    Dimension dims = driver.manage().window().getSize();
    Rectangle rect = el.getRect();

    // check element overlaps screen
    if (rect.x >= dims.width || rect.x + rect.width <= 0
            || rect.y >= dims.height || rect.y + rect.height <= 0) {
        throw new IllegalArgumentException("swipeElementIOS(): Element outside screen");
    }

    // init borders per your app screen
    // or make them configurable with function variables
    int leftBorder, rightBorder, upBorder, downBorder;
    leftBorder = 0;
    rightBorder = 0;
    upBorder = 0;
    downBorder = 0;

    // find rect that overlap screen
    if (rect.x < 0) {
        rect.width = rect.width + rect.x;
        rect.x = 0;
    }
    if (rect.y < 0) {
        rect.height = rect.height + rect.y;
        rect.y = 0;
    }
    if (rect.width > dims.width)
        rect.width = dims.width;
    if (rect.height > dims.height)
        rect.height = dims.height;

    PointOption pointOptionStart, pointOptionEnd;
    switch (dir) {
        case DOWN: // from up to down
            pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                    rect.y + upBorder);
            pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                    rect.y + rect.height - downBorder);
            break;
        case UP: // from down to up
            pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                    rect.y + rect.height - downBorder);
            pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                    rect.y + upBorder);
            break;
        case LEFT: // from right to left
            pointOptionStart = PointOption.point(rect.x + rect.width - rightBorder,
                    rect.y + rect.height / 2);
            pointOptionEnd = PointOption.point(rect.x + leftBorder,
                    rect.y + rect.height / 2);
            break;
        case RIGHT: // from left to right
            pointOptionStart = PointOption.point(rect.x + leftBorder,
                    rect.y + rect.height / 2);
            pointOptionEnd = PointOption.point(rect.x + rect.width - rightBorder,
                    rect.y + rect.height / 2);
            break;
        default:
            throw new IllegalArgumentException("swipeElementIOS(): dir: '" + dir + "' NOT supported");
    }

    // execute swipe using TouchAction
    try {
        new TouchAction(driver)
                .press(pointOptionStart)
                // a bit more reliable when we add small wait
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();
    } catch (Exception e) {
        System.err.println("swipeElementIOS(): TouchAction FAILED\n" + e.getMessage());
        return;
    }

    // always allow swipe action to complete
    try {
        Thread.sleep(ANIMATION_TIME);
    } catch (InterruptedException e) {
        // ignore
    }
}

////////////////////////////////Android 'UIScrollable' swipe: Simple example//////////////////////////////////
//Search by text
// Page object
@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
        ".scrollIntoView(new UiSelector().text(\"exact_text\"))")
MobileElement element;

@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
        ".scrollIntoView(new UiSelector().textContains(\"part_text\"))")
MobileElement element;

// FindElement
MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
        "new UiScrollable(new UiSelector().scrollable(true))" +
         ".scrollIntoView(new UiSelector().text(\"exact_text\"))"));

MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
        "new UiScrollable(new UiSelector().scrollable(true))" +
         ".scrollIntoView(new UiSelector().textContains(\"part_text\"))"));

//Search by id
         // Page object
         @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
                 ".scrollIntoView(new UiSelector().resourceIdMatches(\".*part_id.*\"))")
         MobileElement element;
         
         // FindElement
         MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                 "new UiScrollable(new UiSelector().scrollable(true))" +
                  ".scrollIntoView(new UiSelector().resourceIdMatches(\".*part_id.*\"))"));
         
//Search by id and text
         // Page object
         @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
                 ".scrollIntoView(new UiSelector().resourceIdMatches(\".*part_id.*\").text(\"exact_text\"))")
         MobileElement element;
         
         // FindElement
         MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                 "new UiScrollable(new UiSelector().scrollable(true))" +
                  ".scrollIntoView(new UiSelector().resourceIdMatches(\".*part_id.*\").text(\"exact_text\"))"));
         
//Long view issue
//For some longer views it is necessary to increase "setMaxSearchSwipes". This value allows to set the maximum count of swipe retries made until the search is stopped.
         
         // set max swipes to 10
         // FindElement
         MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                 "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(10)" +
                  ".scrollIntoView(new UiSelector().text(\"exact_text\"))"));

                  ///////////////////////////Android 'UIScrollable' swipe: Multiple scroll views example/////////////////////
    //By instance
                  // first scrollView
                  // FindElement
                  MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                          "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                           ".scrollIntoView(new UiSelector().text(\"exact_text\"))"));
                  
                  // second scrollView
                  // FindElement
                  MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                          "new UiScrollable(new UiSelector().scrollable(true).instance(1))" +
                           ".scrollIntoView(new UiSelector().text(\"exact_text\"))"));
                  
    //By id
                  // FindElement
                  MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                          "new UiScrollable(new UiSelector().resourceIdMatches(\".*part_id.*\").scrollable(true))" +
                           ".scrollIntoView(new UiSelector().text(\"exact_text\"))"));
                  

                        ///////////////////iOS 'mobile:': Screen swipe//////////////////////
/**
 * Performs screen scroll
 *
 * @param dir the direction of scroll
 * @version java-client: 7.3.0
 **/
public void mobileScrollScreenIOS(Direction dir) {
    System.out.println("mobileScrollScreenIOS(): dir: '" + dir + "'"); // always log your actions

    // Animation default time:
    //  - iOS: 200 ms
    // final value depends on your app and could be greater
    final int ANIMATION_TIME = 200; // ms
    final HashMap<String, String> scrollObject = new HashMap<String, String>();

    switch (dir) {
        case DOWN: // from down to up (! differs from mobile:swipe)
            scrollObject.put("direction", "down");
            break;
        case UP: // from up to down (! differs from mobile:swipe)
            scrollObject.put("direction", "up");
            break;
        case LEFT: // from left to right (! differs from mobile:swipe)
            scrollObject.put("direction", "left");
            break;
        case RIGHT: // from right to left (! differs from mobile:swipe)
            scrollObject.put("direction", "right");
            break;
        default:
            throw new IllegalArgumentException("mobileScrollIOS(): dir: '" + dir + "' NOT supported");
    }
    try {
        driver.executeScript("mobile:scroll", scrollObject); // swipe faster then scroll
        Thread.sleep(ANIMATION_TIME); // always allow swipe action to complete
    } catch (Exception e) {
        System.err.println("mobileScrollIOS(): FAILED\n" + e.getMessage());
        return;
    }
}

/**
 * Performs screen swipe
 *
 * @param dir the direction of swipe
 * @version java-client: 7.3.0
 **/
public void mobileSwipeScreenIOS(Direction dir) {
    System.out.println("mobileSwipeScreenIOS(): dir: '" + dir + "'"); // always log your actions

    // Animation default time:
    //  - iOS: 200 ms
    // final value depends on your app and could be greater
    final int ANIMATION_TIME = 200; // ms
    final HashMap<String, String> scrollObject = new HashMap<String, String>();

    switch (dir) {
        case DOWN: // from up to down (! differs from mobile:scroll)
            scrollObject.put("direction", "down");
            break;
        case UP: // from down to up  (! differs from mobile:scroll)
            scrollObject.put("direction", "up");
            break;
        case LEFT: // from right to left  (! differs from mobile:scroll)
            scrollObject.put("direction", "left");
            break;
        case RIGHT: // from left to right  (! differs from mobile:scroll)
            scrollObject.put("direction", "right");
            break;
        default:
            throw new IllegalArgumentException("mobileSwipeScreenIOS(): dir: '" + dir + "' NOT supported");
    }
    try {
        driver.executeScript("mobile:swipe", scrollObject);
        Thread.sleep(ANIMATION_TIME); // always allow swipe action to complete
    } catch (Exception e) {
        System.err.println("mobileSwipeScreenIOS(): FAILED\n" + e.getMessage());
        return;
    }
}

