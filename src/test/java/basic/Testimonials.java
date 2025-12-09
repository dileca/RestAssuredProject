package basic;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testimonials {

    static String baseURL = "https://www.ndosiautomation.co.za";
    static String authToken;

    @Test(priority = 1)
    public void loginUserTest() {

        String path = "/API/login";
        String payload = "{\n" +
                "    \"email\": \"user_419809@example.com\",\n" +
                "    \"password\": \"SecurePass123!\"\n" +
                "}";

        Response responseBody = RestAssured.given()
                .baseUri(baseURL)
                .basePath(path)
                .header("Content-Type", "application/json")
                .body(payload)
                .log().all()
                .post().prettyPeek();

        int actualStatusCode = responseBody.getStatusCode();
        authToken = responseBody.jsonPath().getString("data.token");
        System.out.println(authToken);
        Assert.assertEquals(actualStatusCode, 200, "Status code should be 200");

    }

    @Test(priority = 2)
    public void createTestimonial() {
        String path = "/API/testimonials";
        String payload = "{\n" +
                "  \"title\": \"Great Service!\",\n" +
                "  \"content\": \"This is my testimonial content describing the excellent service I received.\",\n" +
                "  \"rating\": 5,\n" +
                "  \"isPublic\": true\n" +
                "}";

        Response responseBody = RestAssured.given()
                .baseUri(baseURL)
                .basePath(path)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + authToken)
                .body(payload)
                .log().all()
                .post().prettyPeek();


        int actualStatusCode = responseBody.getStatusCode();
        Assert.assertEquals(actualStatusCode, 201, "Status code should be 201");

    }




}
