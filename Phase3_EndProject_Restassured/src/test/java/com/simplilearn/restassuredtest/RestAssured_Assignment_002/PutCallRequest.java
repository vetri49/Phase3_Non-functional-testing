package com.simplilearn.restassuredtest.RestAssured_Assignment_002;

import java.util.HashMap;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutCallRequest {

	
	
	private static String baseURL = "https://petstore.swagger.io/v2/pet";
    private static HashMap<String, String> statusMap = new HashMap<>();

    static {
        statusMap.put("DEV", "available_DEV");
        statusMap.put("QA", "available_QA");
        statusMap.put("PROD", "available_PROD");
    }

    @Test
    @Parameters("environment")
    public void putCallTesting(String environment) {
        String status = statusMap.get(environment);

        String requestBody = "{ \r\n"
        		+ "\"id\": 9223372016900013000, \"category\": { \r\n"
        		+ "\"id\": 20021,       \r\n"
        		+ "\"name\": \"string\"},        \r\n"
        		+ "\"name\": \"doggie\", \"photoUrls\": [      \r\n"
        		+ "\"string\"        \r\n"
        		+ "], \"tags\": [         \r\n"
        		+ "{ \r\n"
        		+ "\"id\": 0, \r\n"
        		+ "\"name\": \"string\"         \r\n"
        		+ "}],          \r\n"
        		+ "\"status\": \""+status+"\"  \r\n"
        		+ "} ";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put(baseURL)
                .then()
                .statusCode(200)
                .body("category.id", equalTo(20021))
                .body("status", equalTo(status))
                .extract().response();
        
        System.out.println(response);
    }
}
