package PetStore.Methods;

import PetStore.BasePage.BasePage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

import static PetStore.BasePage.BasePage.*;
import static PetStore.Methods.Create.*;

public class Update {

    public static void putMethod(){

        JSONObject jsonPet = new JSONObject();
        jsonPet.put("id", randNumber);
        jsonPet.put("name", "Update Test Name" + " " + randNumber);
        jsonPet.put("status", "pending");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add("Deneme Photo Url Update");

        JSONObject jsonCategory = new JSONObject();
        jsonCategory.put("id", randNumber + 2);
        jsonCategory.put("name", "Category Test Name" + " " + randNumber);

        JSONObject jsonTags = new JSONObject();
        jsonTags.put("id", randNumber + 1);
        jsonTags.put("name", "Tags Test Name" + " " + randNumber);

        ArrayList tags = new ArrayList();
        tags.add(jsonTags);

        jsonPet.put("category", jsonCategory);
        jsonPet.put("tags", tags);
        jsonPet.put("photoUrls", jsonArray);


        String json = jsonPet.toString();

        RequestSpecification requestSpecification = RestAssured.given();
        Response response = (Response) requestSpecification
                .given()
                .baseUri(BasePage.URL)
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .put()
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().body();

        //logger.info("*** Put methoduna basarili bir sekilde istek atildi. ***");
        String postResponse = response.asString();
        System.out.println(postResponse);

    }
}
