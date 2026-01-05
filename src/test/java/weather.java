import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class weather {
   package test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class test {

        static String baseURL = "http://api.openweathermap.org";

        @Test
        public void registerWeatherStation() {

            String path = "/data/3.0/stations?appid=f31404aed7e27d3bb39bb80ceea07911";
            String payload = " {\n" +
                    "  \"external_id\": \"WS-001\",\n" +
                    "  \"name\": \"Downtown Weather Station\",\n" +
                    "  \"owner\": \"NYC Municipality\",\n" +
                    "  \"latitude\": 40.7128,\n" +
                    "  \"longitude\": -74.0060,\n" +
                    "  \"exclude\": \"minutely,alerts\",\n" +
                    "  \"units\": \"metric\",\n" +
                    "  \"language\": \"english\"\n" +
                    " \n" +
                    "}";

            Response responseBody = RestAssured.given()
                    .baseUri(baseURL)
                    .basePath(path)
                    .header("Content-Type", "application/json")
                    .body(payload)
                    .log().all()
                    .post().prettyPeek();

            int actualStatusCode = responseBody.getStatusCode();
            Assert.assertEquals(actualStatusCode, 201, "Status code should be 201");
        }


    }


}
