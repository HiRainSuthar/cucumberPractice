Feature: Heroku app test automation practice

  Scenario: Basic auth testing
    Given User is on herokuApp homepage
    When User click on basic Auth link
    Then login popup should not appear

  Scenario: Modal popup close
    Given User is on herokuApp landingpage
    When User click on Entry ad link
    Then close the modal popup appeared