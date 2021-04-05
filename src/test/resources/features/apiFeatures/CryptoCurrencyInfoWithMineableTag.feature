@CryptoCurrencyInfo-WithMineableTag
Feature: Validate that the cryptocurrencies with mineable tag are printed 

  Scenario: Validate that the cryptocurrencies with mineable tag are printed 
    Given api key payload and <id>
    When api cryptocurrency info invoked
    Then validate that "symbol" with "tags" "mineable" are printed out

    Examples:
    |id|
    |1 |
    |2 |
    |3 |
    |4 |
    |5 |
    |6 |
    |7 |
    |8 |
    |9 |
    |10 |
    