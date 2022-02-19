
const {Builder, By, Key, until} = require('selenium-webdriver');

(async function firstScript() {
  try {
    //1. Start the session
    let driver = await new Builder().forBrowser('chrome').build();
    //2. Take action on browser
    await driver.get('https://www.google.com');

    //3. Request browser information
    await driver.getTitle();// => "Google"
    
    //4. Establish Waiting Strateg
    driver.manage().setTimeouts({implicit: 1000})
    driver.manage().window().maximize();

    //5. Find an element 
    let searchBox = await driver.findElement(By.name('q'));
    let searchButton = await driver.findElement(By.name('btnK'));

    //6. Take action on element
    await searchBox.sendKeys('Selenium');
    await searchButton.click();

    //7. Request element information
    await driver.findElement(By.name('q')).getAttribute("value");

    //8. End the session
    await driver.quit();
  } catch (error) {
    console.log(error)
  }
})();