@Price-Conversion
Feature: To validate the price conversion using price-conversion API 

  @Price-Conversion-ID
  Scenario: To validate the price conversion using price-conversion API based on the bitcoin id retrived from cryptocurrency map API
    Given api key is available
    When api cryptocurrency map invoked with get http request
    Then cryptocurrency map response should return "0" error code
    And get id for <cryptocurreny> from the response
   	When api "price conversion" invoked with get http request with <cryptocurreny> id and convert "10" to "BOB" currency
    Then price conversion response should return "error_code" as "0" and "price"

    Examples: 
      | cryptocurreny  |
      | BTC        	   |
      | USDT        	 |
      | ETH        	   |
      
