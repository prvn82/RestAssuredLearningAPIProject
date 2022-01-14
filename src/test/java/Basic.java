import io.restassured.RestAssured;
import io.restassured.internal.ResponseSpecificationImpl;
import io.restassured.path.json.JsonPath;
import javafx.beans.binding.When;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;

import java.util.Map;

public class Basic {

    private static String place_id;

    private static JsonPath js ;

    public static void main(String[] args) {


        //Adding New place
        RestAssured.baseURI="https://rahulshettyacademy.com";

        String res = RestAssured.given().queryParam("key","qaclick123").body(Payload.AddPlacePayload()).when().post("/maps/api/place/add/json").then().log().all().
                assertThat().body("scope", Matchers.equalTo("APP")).extract().response().asString();


        js = new JsonPath(res);

        place_id=js.get("place_id");

        //Updating Address of now place created

        RestAssured.given().queryParam("key","qaclick123").body(Payload.updateAddress_InExistingPlace(place_id)).
                when().put("/maps/api/place/update/json").then().assertThat().statusCode(200).body("msg",Matchers.equalTo("Address successfully updated"));


        //Validating If address is updated or not

        String response =RestAssured.given().queryParam("key","qaclick123").queryParam("place_id",place_id).
                when().get("/maps/api/place/get/json").then().assertThat().statusCode(200).extract().asString();

        js= new JsonPath(response);

        Assert.assertEquals(js.get("address"),"70 Summer walk, USA","Failed !! Address is not updated");



        //Testing testCase on Mock APIs

        JsonPath jp= new JsonPath(Payload.CoursePrice());
        System.out.println("No of courses "+jp.getInt("courses.size()"));

        System.out.println("Purchases amount " +jp.getInt("dashboard.purchaseAmount"));

        System.out.println("Title for first course "+jp.get("courses[0].title"));

        int size = jp.getInt("courses.size()");
        for(int i=0;i<size;i++){
            System.out.println((i+1)+" :"+jp.get("courses["+i+"].title")+" has "+jp.get("courses["+i+"].price")+ " copies");
        }





    }



}
