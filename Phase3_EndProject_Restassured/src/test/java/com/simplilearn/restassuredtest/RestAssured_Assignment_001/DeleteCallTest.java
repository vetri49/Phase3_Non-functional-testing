package com.simplilearn.restassuredtest.RestAssured_Assignment_001;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteCallTest {
	
	private static String baseURL = "https://petstore.swagger.io/v2/pet"; 
	
	@Test(description="Test on delete call request")
    public void testDeletePet() {
		
		int petId=2003;
        Response response = RestAssured.given()
                .when()
                .delete(baseURL + "/" + petId)
                .then()
                .statusCode(200)
                .extract().response();

        assertTrue(response.getBody().asString().contains("code"));
        assertTrue(response.getBody().asString().contains("message"));
        assertEquals(response.jsonPath().get("message"), String.valueOf(petId));
    }

}
