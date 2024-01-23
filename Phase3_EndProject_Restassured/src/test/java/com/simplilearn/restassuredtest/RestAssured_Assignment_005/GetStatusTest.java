package com.simplilearn.restassuredtest.RestAssured_Assignment_005;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class GetStatusTest {

	 private static final String BASE_URL = "https://petstore.swagger.io/v2/pet/findByStatus";

	    @DataProvider(name = "statusProvider")
	    public Object[][] statusProvider() {
	        return new Object[][] {
	                {"available"},
	                {"pending"},
	                {"sold"}
	        };
	    }

	    @Test(dataProvider = "statusProvider")
	    public void testPetStatus(String status) {
	        Response response = RestAssured.given()
	                .param("status", status)
	                .when()
	                .get(BASE_URL)
	                .then()
	                .statusCode(200)
	                .contentType(ContentType.JSON)
	                .extract()
	                .response();

	        // Validate that all pet details have the correct status
	        response.then().assertThat().body("status", Matchers.everyItem(Matchers.equalTo(status)));
	    }
}
