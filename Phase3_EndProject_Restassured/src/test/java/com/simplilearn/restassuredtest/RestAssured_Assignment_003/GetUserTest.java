package com.simplilearn.restassuredtest.RestAssured_Assignment_003;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetUserTest {
	
	private static String baseURL = "https://petstore.swagger.io/v2/user/Uname001";

    @Test
    public void getUserDetails() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(baseURL)
                .then()
                .statusCode(200)
                .body("username", equalTo("Uname001"))
                .body("email", equalTo("Positive@Attitude.com"))
                .body("userStatus", equalTo(1))
                .extract().response();
    }

}
