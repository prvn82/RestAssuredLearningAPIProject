package makeseleniumeasy.com;

import io.restassured.RestAssured;

public class defaultvalueAPI {

    public static void main(String[] args) {

        RestAssured
                .given()
                // Logging all details
                .log()
                .all()
                .when()
                .get();
    }
}
