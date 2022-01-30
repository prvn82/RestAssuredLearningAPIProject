package makeseleniumeasy.com;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

public class JSONSchemaValidator {



    @Test
    public void validateSchema(){

        RestAssured.baseURI="https://reqres.in/";

        ValidatableResponse page = RestAssured.given().log().all().queryParam("page", 2).
                when().get("api/users").
                then().log().all().statusCode(200).assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("untitled.json"));

       // System.out.println(page.);


    }
}
