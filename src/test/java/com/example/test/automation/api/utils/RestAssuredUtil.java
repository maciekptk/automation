package com.example.test.automation.api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RestAssuredUtil {

  static String baseUrl;

  public static Response sendPost(Object body, String endpoint, String authUsername, String authPassword) {
    return given()
        .spec(defaultRequestSpec())
        .contentType(ContentType.JSON)
        .auth()
        .basic(authUsername, authPassword)
        .body(body)
        .when()
        .log().all()
        .post(endpoint);
  }

  public static Response sendPost(Object body, String endpoint) {
    return given()
        .spec(defaultRequestSpec())
        .contentType(ContentType.JSON)
        .body(body)
        .when()
        .log().all()
        .post(endpoint);
  }

  public static Response sendGet(String endpoint) {
    return given()
        .spec(defaultRequestSpec())
        .when()
        .log().all()
        .get(endpoint);
  }

  public static Response sendGet(String endpoint, int postId) {
    return given()
        .spec(defaultRequestSpec())
        .pathParam("postId", postId)
        .when()
        .log().all()
        .get(endpoint);
  }

  private static RequestSpecification defaultRequestSpec() {
    return new RequestSpecBuilder()
        .setBaseUri(baseUrl)
        .build();
  }

  @Value("${api.base-url}")
  public void setBaseUrl(String baseUrl) {
    RestAssuredUtil.baseUrl = baseUrl;
  }
}
