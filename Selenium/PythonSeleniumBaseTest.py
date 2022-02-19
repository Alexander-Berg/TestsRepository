from selenium import webdriver
from selenium.webdriver.common.by import By


def test_eight_components():
    
#1.Start the session
    driver = webdriver.Chrome()

#2.Take action on browser
    driver.get("https://google.com")
    
#3.Request browser information
    assert driver.title == "Google"

#4.Establish Waiting Strategy
    driver.implicitly_wait(0.5)
    
#5.Find an element
    search_box = driver.find_element(by=By.NAME, value="q")
    search_button = driver.find_element(by=By.NAME, value="btnK")

#6.Take action on element
    search_box.send_keys("Selenium")
    search_button.click()

#7.Request element information
    search_box = driver.find_element(by=By.NAME, value="q")
    assert search_box.get_attribute("value") == "Selenium"
    
#8.End the session
    driver.quit()
