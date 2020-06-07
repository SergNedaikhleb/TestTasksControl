import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.basePath;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class ApiTestGet {
    static final String access_token = "75e3u4sgb2khg673cbv2gjup";
    static final String token_type = "bearer";


    @BeforeClass
    public static void init() {
        RestAssured.baseURI="http://testapp.com";
        RestAssured.port=49123;
        RestAssured.basePath="/profile";
    }

    @Test
    public void getProfile() {

        given()
                .queryParam("Authorization", token_type + access_token)
                .when()
                .get(basePath)
                .then().statusCode(200)
                .body("token.size()", equalTo(3))
                .body("token.expires_in", lessThanOrEqualTo(3600))
                .body("token.access_token",
                        hasItem("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImouZG9lQHRlc3QuY29tIiwibmFtZSI6IkpvaG4gRG9lIiwicGVybWlzc2lvbiI6WyJSRUFEIiwiQ1JFQVRFIiwiREVMRVRFIl19.bRS_8EBE9Cc6EqZ00CprRvJC3Ik1VbqW63yxdZr50ak"))
                .body("token.token_type", hasItem(token_type));
    }
}
