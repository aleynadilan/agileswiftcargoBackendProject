package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.Given;
import org.hamcrest.Matchers;
import org.junit.Assert;
import utilities.API_Utilities.API_Methods;

import static hooks.HooksAPI.spec;
import static io.restassured.RestAssured.given;


public class API_Stepdefinitions extends BaseTest {

    String mesaj = null;

    @Given("The api user sets {string} path parameters.")
    public void the_api_user_sets_path_parameters(String pathParam) {
        API_Methods.pathParam(pathParam);
    }

    @Given("The api user sends a GET request and saves the returned response.")
    public void the_api_user_sends_a_get_request_and_saves_the_returned_response() {
        response = given()
                .spec(spec)
                .when()
                .get(API_Methods.fullPath);

        response.prettyPrint();
    }

    @Given("The api user verifies that the status code is {int}.")
    public void the_api_user_verifies_that_the_status_code_is(int code) {
        response.then()
                .assertThat()
                .statusCode(code);
    }

    @Given("The api user verifies that the {string} information in the response body is {string}.")
    public void the_api_user_verifies_that_the_information_in_the_response_body_is(String key, String value) {
        response.then()
                .assertThat()
                .body(key, Matchers.equalTo(value));
    }

    @Given("The api user verifies the information in the response body for the entry with the specified {int} index, including {string}, {string}, {string}, {string}, {int}, {string} and {string}.")
    public void the_api_user_verifies_the_information_in_the_response_body_for_the_entry_with_the_specified_index_including_and(int dataIndex, String name, String phone, String address, String string4, Integer int2, String string5, String string6) {
        repJP = response.jsonPath();

        Assert.assertEquals(name, repJP.getString("data[" + dataIndex + "].name"));
        Assert.assertEquals(phone, repJP.getString("data[" + dataIndex + "].phone"));
        Assert.assertEquals(address, repJP.getString("data[" + dataIndex + "].address"));
    }

    @Given("The api user sends a GET request, saves the returned response, and verifies that the status code is '401' with the reason phrase Unauthorized.")
    public void the_api_user_sends_a_get_request_saves_the_returned_response_and_verifies_that_the_status_code_is_with_the_reason_phrase_unauthorized() {
        try {
            response = given()
                    .spec(spec)
                    .when()
                    .get(API_Methods.fullPath);
        } catch (Exception e) {
            mesaj = e.getMessage();
        }
        System.out.println("Mesaj : " + mesaj);
        Assert.assertEquals(configLoader.getApiConfig("unauthorizedExceptionMessage"),mesaj);
    }
}
