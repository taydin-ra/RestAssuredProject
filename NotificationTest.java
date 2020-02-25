import Pojo.Email;
import Pojo.Notification;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class NotificationTest {
    @Test
    public void notificationTest() {
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

        // Create a notification

        Notification not=new Notification();
        Email email = new Email();

        email.setSubject("bbbb");
        email.setContent("asd");
        List<Email> emails=new ArrayList<Email>();
        emails.add(email);

        not.setName("group1");
        not.setActive(true);
        not.setDescription("tesss");
        not.setSchoolId("5e035f8c9ea1a129f71ac585");
        not.setSendEmail(true);
        not.setType("UPCOMING_EXAM_DEADLINE");
        not.setSms("sms");
        not.setSendEmail(false);
        not.setEmail(emails);


    String notId=    given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(not)
                .when()
                .post("https://test-basqar.mersys.io/school-service/api/notifications")
                .then()
                .log().body()
                .statusCode(201)
            .extract().jsonPath().getString("id");

    // edit the notification
        Notification not1=new Notification();
        Email email1 = new Email();

        email1.setSubject("bbbb");
        email1.setContent("asd");
        List<Email> emails1=new ArrayList<Email>();
        emails.add(email);

        not1.setName("updatedgroup1");
        not1.setActive(true);
        not1.setDescription("tesss");
        not1.setSchoolId("5e035f8c9ea1a129f71ac585");
        not1.setSendEmail(true);
        not1.setType("UPCOMING_EXAM_DEADLINE");
        not1.setSms("sms");
        not1.setSendEmail(false);
        not1.setEmail(emails);
        not1.setId(notId);
        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(not1)
                .put("https://test-basqar.mersys.io/school-service/api/notifications")
                .then()
                .log().body()
                .statusCode(200);

        // delete the notification

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .delete("https://test-basqar.mersys.io/school-service/api/notifications/"+notId)
                .then()
                .statusCode(200)
                ;
    }
}