package com.geekbrains.lesson4;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MiniMarketApiTest {
    private static Long id;

    @Test
    @Disabled
    @Order(1)
    void testCreateNewProduct() {
        Product product = given().when()
                 .contentType(ContentType.JSON)
                 .body(
                         Product.builder()
                                 .title("Ice Cream")
                                 .price(90)
                                 .categoryTitle("Food")
                                 .build()
                 )
                 .log().all()
                 .expect()
                 .body("id", notNullValue())
                 .log().all()
                 .when()
                 .post("http://localhost:8189/market/api/v1/products")
                 .as(Product.class);
        id = product.getId();
    }

    @Test
    @Disabled
    @Order(2)
    void testDeleteById() {
        given().when()
                .contentType(ContentType.JSON)
                .log().all()
                .expect()
                .log().all()
                .when()
                .post("http://localhost:8189/market/api/v1/products" + id);
    }
}
