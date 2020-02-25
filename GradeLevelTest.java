import Pojo.GradeLevel;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GradeLevelTest {
    @Test
    public void gradeLevelTest() {
        Map<String, String> loginCredentials = new HashMap<>();
        loginCredentials.put("username", "nigeria_tenant_admin");
        loginCredentials.put("password", "TnvLOl54WxR75vylop2A");

        Cookies cookies = given()
                .contentType(ContentType.JSON)
                .body(loginCredentials)
                .when()
                .post("https://test-basqar.mersys.io/auth/login")
                .then()
                .statusCode(200)
                .extract().response().getDetailedCookies();

        // Create a grade level
        GradeLevel gl = new GradeLevel();
        gl.setActive(true);
        gl.setName("Groupp1");

        gl.setShortName("G1");

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(gl)
                .post("https://test-basqar.mersys.io/school-service/api/grade-levels")
                .then()
                .log().body()
                .statusCode(201);
    }
        @Test
        public void CreateWtihSameName() {

            Map<String, String> loginCredentials = new HashMap<>();
            loginCredentials.put("username", "nigeria_tenant_admin");
            loginCredentials.put("password", "TnvLOl54WxR75vylop2A");

            Cookies cookies = given()
                    .contentType(ContentType.JSON)
                    .body(loginCredentials)
                    .when()
                    .post("https://test-basqar.mersys.io/auth/login")
                    .then()
                    .statusCode(200)
                    .extract().response().getDetailedCookies();

            // Creating with same credentials
            GradeLevel gl = new GradeLevel();
            gl.setActive(true);
            gl.setName("Groupp1");

            gl.setShortName("G1");

            given()
                    .cookies(cookies)
                    .contentType(ContentType.JSON)
                    .body(gl)
                    .post("https://test-basqar.mersys.io/school-service/api/grade-levels")
                    .then()
                    .log().body()
                    .statusCode(400);
        }

    }
