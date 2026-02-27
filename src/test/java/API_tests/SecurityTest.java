package API_tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.*;

public class SecurityTest {
    // GenerateSecurityTests.java
    @Test
    public void sqlInjectionShouldFail() {
        given()
                .contentType("application/json")
                .body("{\"query\":\"' OR 1=1 --\"}")
                .when()
                .post("/generate")
                .then()
                .statusCode(400);
    }

    @Test
    public void xssPayloadShouldBeSanitized() {
        given()
                .contentType("application/json")
                .body("{\"query\":\"<script>alert(1)</script>\"}")
                .when()
                .post("/generate")
                .then()
                .statusCode(400);
    }

    @Test
    public void checkSecurityHeaders() {
        given()
                .when()
                .post("/generate")
                .then()
                .header("X-Frame-Options", "DENY")
                .header("X-Content-Type-Options", "nosniff");
    }
}
