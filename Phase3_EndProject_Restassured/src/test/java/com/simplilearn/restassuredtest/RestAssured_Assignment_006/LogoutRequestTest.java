package com.simplilearn.restassuredtest.RestAssured_Assignment_006;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
public class LogoutRequestTest {
	

    @Test(description="Test with logout scemario")
    public void testLogoutEndpoint() {
        

       
        RestAssured.given()
        .baseUri("https://petstore.swagger.io/v2/user")
            .when()
                .get("/logout")
            .then()
                .assertThat()
                .statusCode(200)  // Validate response status code
                .body("code", equalTo(200))  // Validate 'code' field in the response
                .body("message", equalTo("ok"));  // Validate 'message' field in the response
    }

}
