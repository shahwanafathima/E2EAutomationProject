@CryptoCurrency-info
Feature: To validate the response of cryptocurrency/info API

  @Price-Conversion-ID
  Scenario: To validate the response of cryptocurrency/info API
    Given api key and id "1027" is available
    When api cryptocurrency info invoked with get http request
    Then cryptocurrency info response should return <key> and <value>
    And retrieve "technical_doc" website
    And verify that the "tags" contain "mineable"
    
    Examples: 
    |key|value|
    |logo|https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png|
    |technical_doc|["https://github.com/ethereum/wiki/wiki/White-Paper"]|
    |symbol|ETH|
    |date_added|2015-08-07T00:00:00.000Z|
    |error_code|0|
    
    
    
    
   
      
