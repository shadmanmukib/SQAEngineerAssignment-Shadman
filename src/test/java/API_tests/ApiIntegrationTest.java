package API_tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.*;

public class ApiIntegrationTest {

        @BeforeClass
        public void init() {
            baseURI = "http://localhost:8000";
        }

        @Test
        public void testGenerateEndpointReturnsMockResponse() {
            given()
                    .contentType("application/json")
                    .body("{\"query\":\"Summarize contract\"}")
                    .when()
                    .post("/generate")
                    .then()
                    .statusCode(200)
                    .body("result", notNullValue())
                    .time(lessThan(1500L));
        }

}
