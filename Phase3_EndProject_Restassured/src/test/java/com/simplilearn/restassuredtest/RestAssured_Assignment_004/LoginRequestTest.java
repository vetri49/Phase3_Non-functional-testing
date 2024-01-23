package com.simplilearn.restassuredtest.RestAssured_Assignment_004;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class LoginRequestTest {

	
	private static String baseURL = "https://petstore.swagger.io/v2/user/login";
    private static String username = "Uname001";
    private static String password = "@tt!tude";

    @Test(description="Test with login request")
    public void loginAndGetSession() {
         RestAssured.given()
                .auth()
                .basic(username, password)
                .contentType(ContentType.JSON)
                .when()
                .get(baseURL)
                .then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("message", containsString("logged in user session"))
                .extract().response();
    }
}
