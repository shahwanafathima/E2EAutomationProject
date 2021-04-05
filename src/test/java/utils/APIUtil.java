package utils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

import apiDefinitions.CryptocurrencyInfoRequestAPIDetails;
import apiDefinitions.CryptocurrencyMapRequestAPIDetails;
import apiDefinitions.PriceConversionRequestAPIDetails;
import apiDefinitions.PriceConversionResponseAPIDetails;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class APIUtil {

	public String getAPISpecProperties(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("src\\test\\resources\\data.properties");
		prop.load(file);
		return prop.getProperty(key);
	}

	public RequestSpecification baseRequestBuilder() throws IOException {
		String uri = getAPISpecProperties("uri");
		PrintStream log = new PrintStream("log.txt");
		RestAssured.baseURI = uri;
		RequestSpecification req = new RequestSpecBuilder().setBaseUri(uri)
				.addQueryParam("CMC_PRO_API_KEY", getAPISpecProperties("CMC_PRO_API_KEY"))
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
				.build();
		return req;
	}

	public RequestSpecification baseRequestBuilder(PriceConversionRequestAPIDetails apiDetails) throws IOException {
		String uri = getAPISpecProperties("uri");
		PrintStream log = new PrintStream("log.txt");
		RestAssured.baseURI = uri;
		RequestSpecification req = new RequestSpecBuilder().setBaseUri(uri)
				.addQueryParam("CMC_PRO_API_KEY", getAPISpecProperties("CMC_PRO_API_KEY"))
				.addQueryParam("amount", apiDetails.getAmount()).addQueryParam("convert", apiDetails.getConvert())
				.addQueryParam("id", apiDetails.getId()).addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		return req;
	}

	public RequestSpecification baseRequestBuilder(CryptocurrencyInfoRequestAPIDetails apiDetails) throws IOException {
		String uri = getAPISpecProperties("uri");
		PrintStream log = new PrintStream("log.txt");
		RestAssured.baseURI = uri;
		RequestSpecification req = new RequestSpecBuilder().setBaseUri(uri)
				.addQueryParam("CMC_PRO_API_KEY", getAPISpecProperties("CMC_PRO_API_KEY"))
				.addQueryParam("id", apiDetails.getId()).addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		return req;
	}

	public PriceConversionRequestAPIDetails getPriceConversionRequest(Integer id, float amount, String currency)
			throws IOException {
		PriceConversionRequestAPIDetails req = new PriceConversionRequestAPIDetails();
		req.setAmount(amount);
		req.setConvert(currency);
		req.setId(id);
		req.setCMC_PRO_API_KEY(getAPISpecProperties("CMC_PRO_API_KEY"));
		return req;
	}

	public CryptocurrencyInfoRequestAPIDetails getCryptoCurrencyInfoRequest(Integer id) throws IOException {
		CryptocurrencyInfoRequestAPIDetails req = new CryptocurrencyInfoRequestAPIDetails();
		req.setId(id);
		req.setCMC_PRO_API_KEY(getAPISpecProperties("CMC_PRO_API_KEY"));
		return req;
	}

	public static void assertKeyValueFromJsonObject(JSONObject json, String key, String expectedResponse) {

		boolean exists = json.has(key);
		Iterator<?> keys;
		String nextKeys;

		if (!exists) {
			keys = json.keys();
			while (keys.hasNext()) {
				nextKeys = (String) keys.next();
				try {
					if (json.get(nextKeys) instanceof JSONObject) {
						if (exists == false) {
							assertKeyValueFromJsonObject(json.getJSONObject(nextKeys), key, expectedResponse);
						}
					} else if (json.get(nextKeys) instanceof JSONArray) {
						JSONArray jsonarray = json.getJSONArray(nextKeys);
						for (int i = 0; i < jsonarray.length(); i++) {
							String jsonarrayString = jsonarray.get(i).toString();
							JSONObject innerJSON = new JSONObject(jsonarrayString);
							if (exists == false) {
								assertKeyValueFromJsonObject(innerJSON, key, expectedResponse);
							}
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} else {
			assertEquals(json.get(key).toString(), expectedResponse);
		}
	}

	public static void assertTrueKeyValueFromJsonObject(JSONObject json, String key, String expectedResponse) {

		boolean exists = json.has(key);
		Iterator<?> keys;
		String nextKeys;

		if (!exists) {
			keys = json.keys();
			while (keys.hasNext()) {
				nextKeys = (String) keys.next();
				try {
					if (json.get(nextKeys) instanceof JSONObject) {
						if (exists == false) {
							assertTrueKeyValueFromJsonObject(json.getJSONObject(nextKeys), key, expectedResponse);
						}
					} else if (json.get(nextKeys) instanceof JSONArray) {
						JSONArray jsonarray = json.getJSONArray(nextKeys);
						for (int i = 0; i < jsonarray.length(); i++) {
							String jsonarrayString = jsonarray.get(i).toString();
							JSONObject innerJSON = new JSONObject(jsonarrayString);
							if (exists == false) {
								assertTrueKeyValueFromJsonObject(innerJSON, key, expectedResponse);
							}
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} else {
			assertTrue((json.get(key).toString()).contains(expectedResponse));
		}
	}

	public static void assertKeyValueFromJsonObject(JSONObject json, String key) {

		boolean exists = json.has(key);
		Iterator<?> keys;
		String nextKeys;

		if (!exists) {
			keys = json.keys();
			while (keys.hasNext()) {
				nextKeys = (String) keys.next();
				try {
					if (json.get(nextKeys) instanceof JSONObject) {
						if (exists == false) {
							assertKeyValueFromJsonObject(json.getJSONObject(nextKeys), key);
						}
					} else if (json.get(nextKeys) instanceof JSONArray) {
						JSONArray jsonarray = json.getJSONArray(nextKeys);
						for (int i = 0; i < jsonarray.length(); i++) {
							String jsonarrayString = jsonarray.get(i).toString();
							JSONObject innerJSON = new JSONObject(jsonarrayString);
							if (exists == false) {
								assertKeyValueFromJsonObject(innerJSON, key);
							}
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} else {
			assertNotNull(json.get(key).toString());
		}
	}

	public static void retrieveKeyValueFromJsonObject(JSONObject json, String key) {

		boolean exists = json.has(key);
		Iterator<?> keys;
		String nextKeys;

		if (!exists) {
			keys = json.keys();
			while (keys.hasNext()) {
				nextKeys = (String) keys.next();
				try {
					if (json.get(nextKeys) instanceof JSONObject) {
						if (exists == false) {
							retrieveKeyValueFromJsonObject(json.getJSONObject(nextKeys), key);
						}
					} else if (json.get(nextKeys) instanceof JSONArray) {
						JSONArray jsonarray = json.getJSONArray(nextKeys);
						for (int i = 0; i < jsonarray.length(); i++) {
							String jsonarrayString = jsonarray.get(i).toString();
							JSONObject innerJSON = new JSONObject(jsonarrayString);
							if (exists == false) {
								retrieveKeyValueFromJsonObject(innerJSON, key);
							}
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} else {
			System.out.println((json.get(key)));
		}
	}

	public static void retrieveCurrencyMatchingTags(JSONObject json, String symbol, String key, String value) {

		boolean exists = json.has(key);
		Iterator<?> keys;
		String nextKeys;

		if (!exists) {
			keys = json.keys();
			while (keys.hasNext()) {
				nextKeys = (String) keys.next();
				try {
					if (json.get(nextKeys) instanceof JSONObject) {
						if (exists == false) {
							retrieveCurrencyMatchingTags(json.getJSONObject(nextKeys), symbol, key, value);
						}
					} else if (json.get(nextKeys) instanceof JSONArray) {
						JSONArray jsonarray = json.getJSONArray(nextKeys);
						for (int i = 0; i < jsonarray.length(); i++) {
							String jsonarrayString = jsonarray.get(i).toString();
							JSONObject innerJSON = new JSONObject(jsonarrayString);
							if (exists == false) {
								retrieveCurrencyMatchingTags(innerJSON, symbol, key, value);
							}
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} else {
			if ((json.get(key).toString()).contains(value)) {
				System.out.println(json.get(symbol));
			}else {
				System.out.println("tags not matching");
			}
		}
	}

}
