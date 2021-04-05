package apiSteps;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import apiDefinitions.CryptocurrencyInfoResponseAPIDetails;
import apiDefinitions.CryptocurrencyMapResponseAPIDetails;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIUtil;

public class CryptoCurrencyInfoSteps extends APIUtil {
	Response response;
	JSONObject respObj;

	RequestSpecification requestCryptoCurrencyInfo;
	CryptocurrencyInfoResponseAPIDetails cryptoCurrencyInfoResponse = new CryptocurrencyInfoResponseAPIDetails();

	@Given("^api key and id \"([^\"]*)\" is available$")
	public void api_key_and_id_something_is_available(int strArg1) throws Throwable {
		requestCryptoCurrencyInfo = given().spec(baseRequestBuilder(getCryptoCurrencyInfoRequest(strArg1)));
	}

	@When("^api cryptocurrency info invoked with get http request$")
	public void api_cryptocurrency_info_invoked_with_get_http_request() throws Throwable {
		response = requestCryptoCurrencyInfo.when().get("cryptocurrency/info");
	}

	@Then("^cryptocurrency info response should return (.+) and (.+)$")
	public void cryptocurrency_info_response_should_return_and(String key, String value) throws Throwable {
		respObj = new JSONObject(response.getBody().asPrettyString());
		assertKeyValueFromJsonObject(respObj, key, value);
	}

	@And("^retrieve \"([^\"]*)\" website$")
	public void retrieve_something_website(String strArg1) throws Throwable {
		retrieveKeyValueFromJsonObject(respObj, strArg1);
	}

	@And("^verify that the \"([^\"]*)\" contain \"([^\"]*)\"$")
	public void verify_that_the_something_contain_something(String strArg1, String strArg2) throws Throwable {
		assertTrueKeyValueFromJsonObject(respObj, strArg1, strArg2);
	}

}
