package makeseleniumeasy.com;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import com.google.common.io.Files;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.internal.SpecificationMerger;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.apache.http.client.methods.RequestBuilder;

//static im

public class restfulbookerAPI {

    public static void main(String[] args) throws IOException {

        File file = new File("src/main/resources/payload.json");

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        RequestSpecification accept = requestSpecBuilder.setBaseUri("https://restful-booker.herokuapp.com/").
                setContentType(ContentType.JSON).addHeader("Accept", "application/json").
                addCookie("token","7a3cbc4f9b34016").build();

        RestAssured.given().log().all().spec(accept).body(file).when().post("booking").
                then().log().all().statusCode(200);




    }
}
