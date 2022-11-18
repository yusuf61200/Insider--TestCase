package PetStore.Methods;

import PetStore.BasePage.BasePage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Random;

import static PetStore.BasePage.BasePage.*;

public class Create {


    public static Random rand;
    public static Integer randNumber;

    public static void postMethod(){

        rand = new Random();
        randNumber=rand.nextInt(100000);

        JSONObject jsonPet = new JSONObject();
        jsonPet.put("id", randNumber);
        jsonPet.put("name", "Test Name" + " " + randNumber);
        jsonPet.put("status", "available");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add("https://www.hizliresim.com/ssmku6g");

        JSONObject jsonCategory = new JSONObject();
        jsonCategory.put("id", randNumber);
        jsonCategory.put("name", "Category Test Name" + " " + randNumber);

        JSONObject jsonTags = new JSONObject();
        jsonTags.put("id", randNumber);
        jsonTags.put("name", "Tags Test Name" + " " + randNumber);

        ArrayList tags = new ArrayList();
        tags.add(jsonTags);

        jsonPet.put("Category", jsonCategory);
        jsonPet.put("Tags", tags);
        jsonPet.put("PhotoUrls", jsonArray);


        String json = jsonPet.toString();

        RequestSpecification requestSpecification = RestAssured.given();
        Response response = (Response) requestSpecification
                .given()
                .baseUri(BasePage.URL)
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().body();


        String postResponse = response.asString();
        System.out.println(postResponse);

    }

    public static void postMethodN(){

        rand = new Random();
        randNumber = rand.nextInt(100000);

        JSONObject jsonPet = new JSONObject();
        jsonPet.put("id", randNumber);
        jsonPet.put("name", "Test Name" + " " + randNumber);
        jsonPet.put("status", "available");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add("Deneme Photo Url");

        JSONObject jsonCategory = new JSONObject();
        jsonCategory.put("id", randNumber);
        jsonCategory.put("name", "Category Test Name" + " " + randNumber);

        JSONObject jsonTags = new JSONObject();
        jsonTags.put("id", randNumber);
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
                .get()
                .then()
                .assertThat()
                .statusCode(405)
                .extract().response().body();

        String postResponse = response.asString();
        System.out.println(postResponse);

    }

}
