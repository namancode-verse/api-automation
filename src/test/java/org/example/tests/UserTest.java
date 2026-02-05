package org.example.tests;

import org.example.base.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserTest extends BaseTest {

    private static int userId;
    private static String name = "Naman Kumar";
    private static String email = "naman" + System.currentTimeMillis() + "@mail.com";
    private static String gender = "male";
    private static String status = "active";

    // 1️⃣ CREATE USER
    @Test(priority = 1)
    public void createUser() {

        String payload = "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"gender\": \"" + gender + "\",\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";

        userId =
                given()
                        .body(payload)
                        .when()
                        .post("/users")
                        .then()
                        .statusCode(201)
                        .contentType("application/json")
                        .body("id", notNullValue())
                        .body("name", equalTo(name))
                        .body("email", equalTo(email))
                        .body("gender", equalTo(gender))
                        .body("status", equalTo(status))
                        .extract()
                        .path("id");

        System.out.println("Created User ID: " + userId);
    }

    // 2️⃣ GET USER
    @Test(priority = 2)
    public void getUser() {

        given()
                .when()
                .get("/users/" + userId)
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("id", equalTo(userId))
                .body("email", equalTo(email));
    }

    // 3️⃣ UPDATE USER
    @Test(priority = 3)
    public void updateUser() {

        String updatedName = "Naman Updated";

        String payload = "{\n" +
                "  \"name\": \"" + updatedName + "\"\n" +
                "}";

        given()
                .body(payload)
                .when()
                .put("/users/" + userId)
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("name", equalTo(updatedName));

        // update local reference
        name = updatedName;
    }

    // 4️⃣ DELETE USER
    @Test(priority = 4)
    public void deleteUser() {

        given()
                .when()
                .delete("/users/" + userId)
                .then()
                .statusCode(204);
    }

    // 5️⃣ VERIFY DELETION
    @Test(priority = 5)
    public void verifyUserDeleted() {

        given()
                .when()
                .get("/users/" + userId)
                .then()
                .statusCode(404);
    }
}