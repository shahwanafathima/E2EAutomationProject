@Filter
Feature: Validate that the results are displayed as per the filter selected 
  I want to validate that when i apply the filter then the results are displayed based on the filter applied and not any other records

  @Filer-MarketCap-Price
  Scenario: Validate the results are filtered
   Given I am on the CoinMarketCap home page "https://coinmarketcap.com/" with page title "Cryptocurrency Prices, Charts And Market Capitalizations | CoinMarketCap"
   When Filters is clicked
   And Add Filter is clicked
   And expand Market Cap option
   And click <marketCap> Market Cap option
   And click Apply Filter button under Market Cap Range
   And expand Price option
   And click <price> Price option
   And click Apply Filter button under Price Range
   And click Show results button
   Then validate that the results are within <price> Price range
   And validate that the results are within <marketCap> Market Cap range
   
    Examples: 
     | marketCap		|price      	 |
     | $1B - $10B   |$101 - $1,000 |
   
