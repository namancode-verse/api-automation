package org.example.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected static String token;

    @BeforeClass
    public void setup() {

        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";

        token = System.getenv("GOREST_TOKEN");

        System.out.println("TOKEN FROM ENV = " + token);

        if (token == null || token.isEmpty()) {
            throw new RuntimeException("❌ GOREST_TOKEN is not set!");
        }

        RestAssured.requestSpecification = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", token);
    }
}