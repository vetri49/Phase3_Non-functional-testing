package com.simplilearn.restassuredtest.RestAssured_Assignment_001;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetCallTest {
	
	private static String baseURL = "https://petstore.swagger.io/v2/pet";
    
	
	 @Test(description="Test on Get call request")
	    public void testGetPet() {
		    int petId=2003;
	        Response response = RestAssured.given()
	                .when()
	                .get(baseURL + "/" + petId)
	                .then()
	                .statusCode(200)
	                .extract().response();

	        assertTrue(response.getBody().asString().contains("status"));
	        assertTrue(response.getBody().asString().contains("id"));
	        assertEquals(response.jsonPath().get("status"), "available");
	    }

}
