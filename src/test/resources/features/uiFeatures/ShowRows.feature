@Show-Rows
Feature: To validate that the show rows drop down is working fine
	In order to validate that the shows rows drop down feature is working fine and is displaying correct number of rows as part the drop down that is selected

  @Show-Rows
  Scenario: Validate Show Rows drop-down
    Given I am on the CoinMarketCap home page "https://coinmarketcap.com/" with page title "Cryptocurrency Prices, Charts And Market Capitalizations | CoinMarketCap"
    When Show rows drop down is clicked
    And Select <rows> value from the drop-down menu
    Then I validate that <rows> rows are displayed
    
    Examples: 
     | rows |
     |  100 |
     |   50 |
     |   20 |