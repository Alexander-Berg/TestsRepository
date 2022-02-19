# frozen_string_literal: true

RSpec.describe 'First Script' do
  it 'uses eight components' do
    #1. Start the session
    driver = Selenium::WebDriver.for :chrome

    #2. Take action on browser
    driver.get('https://google.com')

    #3. Request browser information
    expect(driver.title).to eq('Google')

    #driver.title # => 'Google'
    driver.manage.timeouts.implicit_wait = 500

    #4. Establish Waiting Strategy
    search_box = driver.find_element(name: 'q')
    search_button = driver.find_element(name: 'btnK')

    #5. Find an element
    search_box.send_keys('Selenium')
    search_button.click

    #6. Take action on element
    search_box = driver.find_element(name: 'q')

    #7. Request element information
    expect(attribute('value')).to eq('Selenium')
    
    #8. End the session
    driver.quit
  end
end
