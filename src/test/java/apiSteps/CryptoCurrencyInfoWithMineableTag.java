package apiSteps;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIUtil;

public class CryptoCurrencyInfoWithMineableTag extends APIUtil {
	Response response;
	RequestSpecification requestCryptoCurrencyInfo;
	JSONObject respObj;

	@Given("^api key payload and (.+)$")
	public void api_key_payload_and(int id) throws Throwable {
		requestCryptoCurrencyInfo = given().spec(baseRequestBuilder(getCryptoCurrencyInfoRequest(id)));
	}

	@When("^api cryptocurrency info invoked$")
	public void api_cryptocurrency_info_invoked() throws Throwable {
		response = requestCryptoCurrencyInfo.when().get("cryptocurrency/info");
	}

	@Then("^validate that \"([^\"]*)\" with \"([^\"]*)\" \"([^\"]*)\" are printed out$")
	public void validate_that_something_with_something_something_are_printed_out(String symbol, String tags,
			String value) throws Throwable {

		respObj = new JSONObject(response.getBody().asPrettyString());
		retrieveCurrencyMatchingTags(respObj, symbol, tags, value);
	}

}
