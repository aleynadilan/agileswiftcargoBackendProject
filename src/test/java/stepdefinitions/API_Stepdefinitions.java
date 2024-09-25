package stepdefinitions;

import base.BaseTest;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.junit.Assert;
import pojos.Pojo;
import utilities.API_Utilities.API_Methods;
import utilities.API_Utilities.TestData;

import java.util.HashMap;
import java.util.Map;

import static hooks.HooksAPI.spec;
import static io.restassured.RestAssured.given;


public class API_Stepdefinitions extends BaseTest {

    Pojo hubAdd;
    Gson gson = new Gson();
    TestData testData = new TestData();

    String reqBody;
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
        Assert.assertEquals(configLoader.getApiConfig("unauthorizedExceptionMessage"), mesaj);
    }

    @Given("The api user verifies that the data in the response body includes {int}, {string}, {string}, {string}, {string}, {int}, {string} and {string}.")
    public void the_api_user_verifies_that_the_data_in_the_response_body_includes_and(int id, String name, String phone, String address, String string4, Integer int2, String string5, String string6) {
        response.then()
                .assertThat()
                .body("id", Matchers.equalTo(id),
                        "name", Matchers.equalTo(name),
                        "phone", Matchers.equalTo(phone),
                        "address", Matchers.equalTo(address));
    }

    @Given("The api user prepares a POST request containing {string}, {string} and {string} information to send to the api hubadd endpoint.")
    public void the_api_user_prepares_a_post_request_containing_and_information_to_send_to_the_api_hubadd_endpoint(String name, String phone, String address) {
        requestBody.put("name", name);
        requestBody.put("phone", phone);
        requestBody.put("address", address);

        reqBody = requestBody.toString();

        System.out.println("Post Body : " + requestBody);
    }

    @Given("The api user sends a POST request and saves the returned response.")
    public void the_api_user_sends_a_post_request_and_saves_the_returned_response() {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody)
                .post(API_Methods.fullPath);

        response.prettyPrint();
    }

    @Given("The api user prepares a POST request containing {string} and {string} information to send to the api hubadd endpoint.")
    public void the_api_user_prepares_a_post_request_containing_and_information_to_send_to_the_api_hubadd_endpoint(String phone, String address) {
        hubAdd = new Pojo(phone, address);

        reqBody = gson.toJson(hubAdd);
        System.out.println("Post Body : " + hubAdd);
    }

    @Given("The api user prepares a POST request that contains no data.")
    public void the_api_user_prepares_a_post_request_that_contains_no_data() {
        hubAdd = new Pojo();

    }

    @Given("The api user prepares a patch request to send to the api hubedit endpoint.")
    public void the_api_user_prepares_a_patch_request_to_send_to_the_api_hubedit_endpoint() {
        map = testData.hubRequestBody();

        System.out.println("Patch body : " + map);
    }

    @Given("The api user sends a PATCH request and saves the returned response.")
    public void the_api_user_sends_a_patch_request_and_saves_the_returned_response() {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(map)
                .patch(API_Methods.fullPath);

        response.prettyPrint();
    }

    @Given("The api user verifies that the id information in the returned response body is the same as the id path parameter written in the endpoint.")
    public void the_api_user_verifies_that_the_id_information_in_the_returned_response_body_is_the_same_as_the_id_path_parameter_written_in_the_endpoint() {
        repJP = response.jsonPath();

        Assert.assertEquals(API_Methods.id,repJP.getInt("data[0].id"));
    }

    @Given("The api user sends a PATCH request, saves the returned response, and verifies that the status code is '401' with the reason phrase Unauthorized.")
    public void the_api_user_sends_a_patch_request_saves_the_returned_response_and_verifies_that_the_status_code_is_with_the_reason_phrase_unauthorized() {
        try {
            response = given()
                    .spec(spec)
                    .contentType(ContentType.JSON)
                    .when()
                    .body(map)
                    .patch(API_Methods.fullPath);
        } catch (Exception e) {
           mesaj= e.getMessage();
        }

        System.out.println("Mesaj : " + mesaj);
        Assert.assertEquals(configLoader.getApiConfig("unauthorizedExceptionMessage"),mesaj);
    }

    @Given("The api user verifies that name is {string}")
    public void the_api_user_verifies_that_name_is(String value) {
        map = response.as(HashMap.class);

        reqBody = gson.toJson(map);
        Assert.assertEquals(value, map.get("name"));
    }

    @Given("The api user sends a DELETE request and saves the returned response.")
    public void the_api_user_sends_a_delete_request_and_saves_the_returned_response() {
        response = given()
                .spec(spec)
                .when()
                .delete(API_Methods.fullPath);

        response.prettyPrint();
    }
    @Given("The api user verifies that the data Deleted id information in the returned response body is the same as the id path parameter written in the endpoint.")
    public void the_api_user_verifies_that_the_data_deleted_id_information_in_the_returned_response_body_is_the_same_as_the_id_path_parameter_written_in_the_endpoint() {
        map = response.as(HashMap.class);

        String pathId = String.valueOf(API_Methods.id);

        Assert.assertEquals(pathId,((Map) (map.get("data"))).get("Deleted ID"));
    }
}
