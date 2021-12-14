package com.geekbrains.restAPI.imgur;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ImgurApiTest {

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = ImgurApiParams.API_URL + "/" + ImgurApiParams.API_VERSION;
    }

    ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(is(200))
            .expectBody("success", is(true))
            .expectBody("status", is(200))
            .build();


    @DisplayName("Тест на получение базовой информации об аккаунте")
    @Test
    @Disabled
    @Order(1)
    void testAccountBase() {
        String url = "account/" + ImgurApiParams.USERNAME;
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .spec(responseSpecification)
                .body("data.reputation_name", is("Neutral"))
                .body("data.reputation", is(0))
                .log()
                .all()
                .when()
                .get(url);
    }

    @DisplayName("Тест обновления информации о картинке")
    @Test
    @Disabled
    @Order(2)
    void testUpdateImageInformation() {
        String url = "image/" + "fhT8GDx";
//        given().get("").body().jsonPath().getString("data.id")

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addFormParam("title", "Sun")
                .addFormParam("description", "A simple mem")
                .build();

        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .spec(requestSpecification)
                .expect()
                .log()
                .all()
                .statusCode(is(200))
                .body("success", is(true))
                .body("data", is(true))
                .when()
                .post(url);
    }
    @DisplayName("Тест на получение информации об альбомах")
    @Test
    @Disabled
    @Order(3)
    void testAlbums() {
        String url = "account/" + ImgurApiParams.USERNAME + "/" + "albums/" + ImgurApiParams.PAGE;
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .spec(responseSpecification)
                .log()
                .all()
                .when()
                .get(url);
    }
    @DisplayName("Тест на получение информации об альбоме")
    @Test
    @Disabled
    @Order(4)
    void testAlbum() {
        String url = "account/" + ImgurApiParams.USERNAME + "/" + "album/" + ImgurApiParams.ALBUMHASH;
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .spec(responseSpecification)
                .body("data.images_count", is(2))
                .body("data.layout", is("blog"))
                .log()
                .all()
                .when()
                .get(url);
    }
    @DisplayName("Тест на получение идентификаторов альбомов")
    @Test
    @Disabled
    @Order(5)
    void testAlbumIDs() {
        String url = "account/" + ImgurApiParams.USERNAME + "/" + "albums/" + "ids/" + ImgurApiParams.PAGE;
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .spec(responseSpecification)
                .log()
                .all()
                .when()
                .get(url);
    }
    @DisplayName("Тест на получение количества альбомов")
    @Test
    @Disabled
    @Order(6)
    void testAlbumCount() {
        String url = "account/" + ImgurApiParams.USERNAME + "/" + "albums/" + "count";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .spec(responseSpecification)
                .body("data", is(2))
                .log()
                .all()
                .when()
                .get(url);
    }
    @DisplayName("Тест на получение информации об изображениях")
    @Test
    @Disabled
    @Order(7)
    void testImages() {
        String url = "account/" + ImgurApiParams.USERNAME + "/" + "images/" + ImgurApiParams.PAGE;
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .spec(responseSpecification)
                .log()
                .all()
                .when()
                .get(url);
    }
    @DisplayName("Тест на получение информации о конкретном изображении")
    @Test
    @Disabled
    @Order(8)
    void testImage() {
        String url = "account/" + ImgurApiParams.USERNAME + "/" + "image/" + "aoOv1tv";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .spec(responseSpecification)
                .body("data.id", is("aoOv1tv"))
                .body("data.description", is("This is an image of a heart outline."))
                .body("data.name", is("Триумф сборной России по хоккею на олимпиаде 2018"))
                .log()
                .all()
                .when()
                .get(url);
    }
    @DisplayName("Тест на получение идентификаторов изображений")
    @Test
    @Disabled
    @Order(9)
    void testImageIDs() {
        String url = "account/" + ImgurApiParams.USERNAME + "/" + "images/" + "ids/" + ImgurApiParams.PAGE;
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .spec(responseSpecification)
                .log()
                .all()
                .when()
                .get(url);
    }
    @DisplayName("Тест на получение количества изображений")
    @Test
    @Disabled
    @Order(10)
    void testImageCount() {
        String url = "account/" + ImgurApiParams.USERNAME + "/" + "images/" + "count";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .spec(responseSpecification)
                .body("data", is(16))
                .log()
                .all()
                .when()
                .get(url);
    }
    @DisplayName("Тест на получение информации об изображениях в альбоме")
    @Test
    @Disabled
    @Order(11)
    void testAlbumImages() {
        String url = "album/" + ImgurApiParams.ALBUMHASH + "/" + "images";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .spec(responseSpecification)
                .log()
                .all()
                .when()
                .get(url);
    }
    @DisplayName("Тест на добавление изображения в избранное")
    @Test
    @Disabled
    @Order(12)
    void testFavoriteAnImage() {
        String url = "image/" + "aoOv1tv";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .log()
                .all()
                .statusCode(is(200))
                .body("success", is(true))
                .body("data", is(true))
                .when()
                .post(url);
    }
}
