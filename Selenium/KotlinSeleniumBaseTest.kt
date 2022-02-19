import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

fun main() {
    //1. Start the session
    val driver = ChromeDriver()

    //2. Take action on browser
    driver.get("https://google.com")

    //3. Request browser information
    driver.getTitle(); // => "Google"

    //4. Establish Waiting Strategy
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500))

    //5. Find an element
    val searchBox = driver.findElement(By.name("q"));
    val searchButton = driver.findElement(By.name("btnK"));

    //6. Take action on element
    searchBox.sendKeys("Selenium");
    searchButton.click();

    //7. Request element information
    driver.findElement(By.name("q")).getAttribute("value"); // => "Selenium"

    //8. End the session
    driver.quit()
}