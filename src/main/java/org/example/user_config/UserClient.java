package org.example.user_config;

import io.restassured.response.ValidatableResponse;
import org.example.config.Client;

import static io.restassured.RestAssured.given;

public class UserClient extends Client {
    String name;
    String email;
    String password;

    public UserClient(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public ValidatableResponse register(User user) {
        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .post("/api/auth/register")
                .then();

    }
    public ValidatableResponse delete(String token) {
        return given()
                .spec(getSpec())
                .auth().oauth2(token.replace("Bearer ", ""))
                .when()
                .delete("/api/auth/user")
                .then();

    }

}



