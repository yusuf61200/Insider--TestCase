package PetStore.Methods;

import PetStore.BasePage.BasePage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static PetStore.BasePage.BasePage.*;
import static PetStore.Methods.Create.*;
import static io.restassured.RestAssured.given;

public class Read {

    public static void getMethodP(){

        RequestSpecification requestSpecification = given();

        Response response = (Response) requestSpecification
                .contentType(ContentType.JSON)
                .when()
                .get(BasePage.URL + randNumber)
                .body();


        int getStatusCodeSubject = given()
                .contentType(ContentType.JSON)
                .when()
                .get(BasePage.URL + randNumber)
                .getStatusCode();

        String getResponse = response.asString();
        System.out.println(getResponse);

        System.out.println("Response Code: " + getStatusCodeSubject);
        Assert.assertEquals(getStatusCodeSubject, 200);

    }

    public static void getMethodN(){

        RequestSpecification requestSpecification = RestAssured.given();

        Response response = (Response) requestSpecification
                .contentType(ContentType.JSON)
                .when()
                .get(BasePage.URL + "String Text")
                .body();


        int getStatusCodeSubject = given()
                .contentType(ContentType.JSON)
                .when()
                .get(BasePage.URL + "String Text")
                .getStatusCode();

        String getResponse = response.asString();
        System.out.println(getResponse);

        System.out.println("Response Code: " + getStatusCodeSubject);
        Assert.assertEquals(getStatusCodeSubject, 400);

    }

    public static void getNotAllowed(){

        RequestSpecification requestSpecification = RestAssured.given();

        Response response = (Response) requestSpecification
                .contentType(ContentType.JSON)
                .when()
                .post(BasePage.URL + 123)
                .body();

        int getStatusCodeSubject = given()
                .contentType(ContentType.JSON)
                .when()
                .post(BasePage.URL + 123)
                .getStatusCode();

        String getResponse = response.asString();
        System.out.println(getResponse);

        System.out.println("Response Code: " + getStatusCodeSubject);
        Assert.assertEquals(getStatusCodeSubject, 405);

    }

}
