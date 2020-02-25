import Pojo.Location;
import Pojo.School;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class LocationTest {
    @Test
    public void LocationTest() {
        School sch = new School();
        Location location = new Location();
        location.setName("Georg");
        location.setShortName("Fdd22d1lffrr");
        location.setActive(true);
        sch.setId("5e035f8c9ea1a129f71ac585");
        location.setType("CLASS");
        location.setSchool(sch);
        location.setCapacity(3);


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
// Create a location
       String locationId= given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(location)
                .when()
                .post("https://test-basqar.mersys.io/school-service/api/location")
                .then()
                .log().body()
                .statusCode(201)
               .extract().jsonPath().getString("id");

        // Update the location
        Location location1 = new Location();
        School sch1=new School();
        location1.setName("Updatedg44");
        location1.setShortName("UFdddlffrr");
        location1.setActive(true);
        sch1.setId("5e035f8c9ea1a129f71ac585");
        location1.setType("CLASS");
        location1.setSchool(sch);
        location1.setCapacity(3);
        location1.setId(locationId);

//
        given()
                .cookies(cookies)
                .body(location1)

                .contentType(ContentType.JSON)
                .when()
                .put("https://test-basqar.mersys.io/school-service/api/location")
                .then()
                .log().body()
                .statusCode(200);

        // delete the location

        given()
                .cookies( cookies )
                .when()
                .log().body()
                .delete( "https://test-basqar.mersys.io/school-service/api/location/" + locationId )
                .then()
                .log().body()
                .statusCode( 200 )
        ;
    }



    }



