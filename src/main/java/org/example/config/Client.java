package org.example.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class Client {

    public final static String MAIN_URL = "https://stellarburgers.nomoreparties.site/";
    public final static String LOGIN = "https://stellarburgers.nomoreparties.site/login";
    public final static String REGISTER = "https://stellarburgers.nomoreparties.site/register";

    public static final String DELETE = "https://stellarburgers.nomoreparties.site/api/auth/user/";
    public static final String FORGOT= "https://stellarburgers.nomoreparties.site/forgot-password";
    public static final String ACCOUNTPROFILE = "https://stellarburgers.nomoreparties.site/account/profile";
    protected RequestSpecification getSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://stellarburgers.nomoreparties.site")
                .build();
    }
}
