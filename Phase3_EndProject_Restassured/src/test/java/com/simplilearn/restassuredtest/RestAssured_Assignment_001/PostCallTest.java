package com.simplilearn.restassuredtest.RestAssured_Assignment_001;


import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class PostCallTest {

	   private static String baseURL = "https://petstore.swagger.io/v2/pet";
	   

	    @Test(description="Test on post call request")
	    public void testPostPet() {
	        String requestBody = "{\n" +
	                "\"id\": 2003,\n" +
	                "\"category\": {\n" +
	                "\"id\": 0,\n" +
	                "\"name\": \"string\"\n" +
	                "},\n" +
	                "\"name\": \"Doggie\",\n" +
	                "\"photoUrls\": [\n" +
	                "\"string\"\n" +
	                "],\n" +
	                "\"tags\": [\n" +
	                "{\n" +
	                "\"id\": 0,\n" +
	                "\"name\": \"string\"\n" +
	                "}\n" +
	                "],\n" +
	                "\"status\": \"available\"\n" +
	                "}";
	       
	        
	         RestAssured.given().baseUri(baseURL)
	                .contentType(ContentType.JSON)
	                .body(requestBody)
	                .when()
	                .post()
	                .then()
	                .statusCode(200)
	                .body("id",equalTo(2003))
	                .extract().response();

	        
	    }
	
}
