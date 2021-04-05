package apiSteps;

import apiDefinitions.CryptocurrencyMapRequestAPIDetails;
import org.json.JSONObject;
import apiDefinitions.CryptocurrencyMapResponseAPIDetails;
import apiDefinitions.PriceConversionRequestAPIDetails;
import apiDefinitions.PriceConversionResponseAPIDetails;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.APIUtil;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PriceConversionSteps extends APIUtil {

	RequestSpecification requestCurrencyMap;
	RequestSpecification requestPriceConversion;
	Response response;

	CryptocurrencyMapResponseAPIDetails currencyMapResponse = new CryptocurrencyMapResponseAPIDetails();
	PriceConversionResponseAPIDetails priceConversionResponse = new PriceConversionResponseAPIDetails();

	HashMap<String, Integer> currencyInfo = new HashMap<String, Integer>();

	@Given("^api key is available$")
	public void api_key_is_available() throws Throwable {
		requestCurrencyMap = given().spec(baseRequestBuilder());
	}

	@When("^api cryptocurrency map invoked with get http request$")
	public void api_cryptocurrency_map_invoked_with_get_http_request() throws Throwable {
		currencyMapResponse = requestCurrencyMap.when().get("cryptocurrency/map")
				.as(CryptocurrencyMapResponseAPIDetails.class);
	}

	@Then("^cryptocurrency map response should return \"([^\"]*)\" error code$")
	public void cryptocurrency_map_response_should_return_something_error_code(int strArg1) throws Throwable {
		assertEquals(currencyMapResponse.getStatus().getError_code(), strArg1);
	}

	@And("^get id for (.+) from the response$")
	public void get_id_for_from_the_response(String cryptocurreny) throws Throwable {
		for (int i = 0; i < currencyMapResponse.getData().size(); i++) {
			if (currencyMapResponse.getData().get(i).getSymbol().equals(cryptocurreny)) {
				currencyInfo.put(currencyMapResponse.getData().get(i).getSymbol(),
						currencyMapResponse.getData().get(i).getId());
			}
		}
	}

	@When("^api \"([^\"]*)\" invoked with get http request with (.+) id and convert \"([^\"]*)\" to \"([^\"]*)\" currency$")
	public void api_something_invoked_with_get_http_request_with_id_and_convert_something_to_something_currency(
			String api, String symbol, float amount, String currency) throws Throwable {

		for (int i = 0; i < currencyInfo.size(); i++) {
			requestPriceConversion = given()
					.spec(baseRequestBuilder(getPriceConversionRequest(currencyInfo.get(symbol), amount, currency)));

			response = requestPriceConversion.when().get("tools/price-conversion");
		}
	}

	@Then("^price conversion response should return \"([^\"]*)\" as \"([^\"]*)\" and \"([^\"]*)\"$")
	public void price_conversion_response_should_return_something_as_something_and_something(String strArg1,
			String strArg2, String strArg3) throws Throwable {
		JSONObject respObj = new JSONObject(response.getBody().asPrettyString());
		assertKeyValueFromJsonObject(respObj, strArg3);
		assertKeyValueFromJsonObject(respObj, strArg1, strArg2);
	}

}
