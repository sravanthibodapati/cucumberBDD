package stepDefinition;

import static io.restassured.RestAssured.*;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.junit.Assert.*;

import java.io.IOException;

import resources.APIResources;
import resources.AddPlacePayload;
import resources.Utils;

public class StepDefinition extends Utils {
	RequestSpecification reqSpec;
	RequestSpecification req;
	ResponseSpecification resSpec;
	Response resp;
	static String placeid;

	AddPlacePayload payload = new AddPlacePayload();

	@Given("add place payload {string},{string},{string}")
	public void add_place_payload(String name, String language, String address) throws IOException {

		req = given().spec(reqSpecBuild()).body(payload.addPlacePayload(name, language, address));

	}

	@When("user calls the {string} with {string} http request")
	public void user_calls_the_with_http_request(String resource, String httpmethod) {
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		if (httpmethod.equalsIgnoreCase("POST"))

			resp = req.when().post(resourceAPI.getResource());

	}

	@Then("verify the API call got success with status code {int}")
	public void verify_the_api_call_got_success_with_status_code(Integer int1) {
		resp.getStatusCode();
		assertEquals(resp.getStatusCode(), 200);

	}

	@Then("{string} in the response body shows {string}")
	public void in_the_response_body_shows(String keyvalue, String expvalue) {
		String response = resp.asString();
		JsonPath js = new JsonPath(response);
		placeid = js.get("place_id");
		assertEquals(js.get(keyvalue), expvalue);

	}

	@Given("delete place payload")
	public void delete_place_payload() throws IOException {
		req = given().spec(reqSpecBuild()).body(payload.deletePlacePayload(placeid));
		
	
	}

}
