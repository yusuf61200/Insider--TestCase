package PetStore.Methods;

import PetStore.BasePage.BasePage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static PetStore.BasePage.BasePage.logger;
import static PetStore.Methods.Create.*;

public class Delete {

    public static void deleteMethod(){

        RequestSpecification requestSpecification = RestAssured.given();

        Response response = (Response) requestSpecification
                .contentType(ContentType.JSON)
                .when()
                .delete(BasePage.URL + randNumber)
                .body();



        String getResponse = response.asString();
        System.out.println("Response: " + getResponse);
        Assert.assertEquals(response.statusCode(), 200);

    }
}
