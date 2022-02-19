/***
 * ///////////////////////////////////////example, typical of test automation, that does not use a page object:///////////////////////////////
 * Tests login feature
 */
public class Login {

    public void testLogin() {
        // fill login data on sign-in page
        driver.findElement(By.name("user_name")).sendKeys("userName");
        driver.findElement(By.name("password")).sendKeys("my supersecret password");
        driver.findElement(By.name("sign-in")).click();

        // verify h1 tag is "Hello userName" after login
        driver.findElement(By.tagName("h1")).isDisplayed();
        assertThat(driver.findElement(By.tagName("h1")).getText(), is("Hello userName"));
    }
}
//////////////////////////////////////////////////////////////////
//Applying the page object techniques, this example could be rewritten like this in the following example of a page object for a Sign-in page.
///////////////////////////////////////////////////////////////////
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;

/**
 * Page Object encapsulates the Sign-in page.
 */
public class SignInPage {
    protected WebDriver driver;

    // <input name="user_name" type="text" value="">
    private By usernameBy = By.name("user_name");
    // <input name="password" type="password" value="">
    private By passwordBy = By.name("password");
    // <input name="sign_in" type="submit" value="SignIn">
    private By signinBy = By.name("sign_in");

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Login as valid user
     *
     * @param userName
     * @param password
     * @return HomePage object
     */
    public HomePage loginValidUser(String userName, String password) {
        driver.findElement(usernameBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(signinBy).click();
        return new HomePage(driver);
    }
}
////////////////////////////////////////////////////////
//and page object for a Home page could look like this.
////////////////////////////////////////////////////////

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object encapsulates the Home Page
 */
public class HomePage {
    protected WebDriver driver;

    // <h1>Hello userName</h1>
    private By messageBy = By.tagName("h1");

    public HomePage(WebDriver driver){
        this.driver = driver;
        if (!driver.getTitle().equals("Home Page of logged in user")) {
            throw new IllegalStateException("This is not Home Page of logged in user," +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    /**
     * Get message (h1 tag)
     *
     * @return String message text
     */
    public String getMessageText() {
        return driver.findElement(messageBy).getText();
    }

    public HomePage manageProfile() {
        // Page encapsulation to manage profile functionality
        return new HomePage(driver);
    }
  /* More methods offering the services represented by Home Page
  of Logged User. These methods in turn might return more Page Objects
  for example click on Compose mail button could return ComposeMail class object */
}

////////////////////////////////////////////
//So now, the login test would use these two page objects as follows.
///////////////////////////////////////////
/***
 * Tests login feature
 */
public class TestLogin {

    @Test
    public void testLogin() {
        SignInPage signInPage = new SignInPage(driver);
        HomePage homePage = signInPage.loginValidUser("userName", "password");
        assertThat(homePage.getMessageText(), is("Hello userName"));
    }

}
//One consequence of this approach is that it may be necessary to model (for example) both a successful and unsuccessful login,
// or a click could have a different result depending on the state of the app.
// When this happens, it is common to have multiple methods on the PageObject:
public class LoginPage {
    public HomePage loginAs(String username, String password) {
        // ... clever magic happens here
    }

    public LoginPage loginAsExpectingError(String username, String password) {
        //  ... failed login here, maybe because one or both of the username and password are wrong
    }

    public String getErrorMessage() {
        // So we can verify that the correct error is shown
    }
}
//The code presented above shows an important point: the tests, not the PageObjects, should be responsible for making assertions about the state of a page. For example:
public void testMessagesAreReadOrUnread() {
    Inbox inbox = new Inbox(driver);
    inbox.assertMessageWithSubjectIsUnread("I like cheese");
    inbox.assertMessageWithSubjectIsNotUnread("I'm not fond of tofu");
}
//could be re-written as:
public void testMessagesAreReadOrUnread() {
    Inbox inbox = new Inbox(driver);
    assertTrue(inbox.isMessageWithSubjectIsUnread("I like cheese"));
    assertFalse(inbox.isMessageWithSubjectIsUnread("I'm not fond of tofu"));
}

/***Summary
        The public methods represent the services that the page offers
        Try not to expose the internals of the page
        Generally don’t make assertions
        Methods return other PageObjects
        Need not represent an entire page
        Different results for the same action are modelled as different methods */

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the right page.
        if (!"Login".equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }
    }

    // The login page contains several HTML elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("passwd");
    By loginButtonLocator = By.id("login");

    // The login page allows the user to type their username into the username field
    public LoginPage typeUsername(String username) {
        // This is the only place that "knows" how to enter a username
        driver.findElement(usernameLocator).sendKeys(username);

        // Return the current page object as this action doesn't navigate to a page represented by another PageObject
        return this;
    }

    // The login page allows the user to type their password into the password field
    public LoginPage typePassword(String password) {
        // This is the only place that "knows" how to enter a password
        driver.findElement(passwordLocator).sendKeys(password);

        // Return the current page object as this action doesn't navigate to a page represented by another PageObject
        return this;
    }

    // The login page allows the user to submit the login form
    public HomePage submitLogin() {
        // This is the only place that submits the login form and expects the destination to be the home page.
        // A seperate method should be created for the instance of clicking login whilst expecting a login failure.
        driver.findElement(loginButtonLocator).submit();

        // Return a new page object representing the destination. Should the login page ever
        // go somewhere else (for example, a legal disclaimer) then changing the method signature
        // for this method will mean that all tests that rely on this behaviour won't compile.
        return new HomePage(driver);
    }

    // The login page allows the user to submit the login form knowing that an invalid username and / or password were entered
    public LoginPage submitLoginExpectingFailure() {
        // This is the only place that submits the login form and expects the destination to be the login page due to login failure.
        driver.findElement(loginButtonLocator).submit();

        // Return a new page object representing the destination. Should the user ever be navigated to the home page after submiting a login with credentials
        // expected to fail login, the script will fail when it attempts to instantiate the LoginPage PageObject.
        return new LoginPage(driver);
    }

    // Conceptually, the login page offers the user the service of being able to "log into"
    // the application using a user name and password.
    public HomePage loginAs(String username, String password) {
        // The PageObject methods that enter username, password & submit login have already defined and should not be repeated here.
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
}
