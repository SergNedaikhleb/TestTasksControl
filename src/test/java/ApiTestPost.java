import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.basePath;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class ApiTestPost {
    static final String hash = "Z3JhbnRfdHlwZT1jbGllbnRfY3JlZGVudGlhbHM=";
    static final String token_type = "Basic";

    @BeforeClass
    public static void init() {
        RestAssured.baseURI="http://testapp.com";
        RestAssured.port=49123;
        RestAssured.basePath="/token";
    }
    @Test
    public void postProfile() {

        given()
                .contentType(ContentType.JSON)
                .param("login", "email")
                .param("password", "password")
                .header("Authorization", token_type + hash)
                .post(basePath)
                .then().statusCode(200)
                .body("userProfile.size()", lessThanOrEqualTo(6))
                .body("userProfile.firstName", equalTo("John"))
                .body("userProfile.lastName", equalTo("Doe"))
                .body("userProfile.email", equalTo("j.doe@test.com"))
                .body("userProfile.age", equalTo(25))
                .body("userProfile.profilePicture", equalTo("picture.jpg"))
                .body("userProfile.userRole", equalTo("Admin"));
    }
}
