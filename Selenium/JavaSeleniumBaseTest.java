import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSelenium {
    public static void main(String[] args) {
        
        //Start the session
        driver = new ChromeDriver();

        //Take action on browser
        driver.get("https://google.com");
        
        //Request browser information 
        driver.getTitle(); // => "Google"
        
        //Establish Waiting Strategy
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        
        //Find an element
        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.name("btnK"));
        
        //Take action on element
        searchBox.sendKeys("Selenium");
        searchButton.click();
        
        // Request element information
        searchBox = driver.findElement(By.name("q"));
        searchBox.getAttribute("value"); // => "Selenium"
        
        //End the session
        driver.quit();
    }
}


