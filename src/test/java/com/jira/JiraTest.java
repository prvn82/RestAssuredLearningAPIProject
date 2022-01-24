package com.jira;

import com.jira.payloadgenerator.AuthenticationPayloadclass;
import com.jira.payloadgenerator.createIssue.fields;
import com.jira.payloadgenerator.createIssue.issuetypepayload;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import java.io.File;
import java.util.Locale;

public class JiraTest {

    public static void main(String[] args) {

        RestAssured.baseURI="http://localhost:8080";

        SessionFilter sessionFilter = new SessionFilter();

       AuthenticationPayloadclass auth = new AuthenticationPayloadclass();
       auth.setUsername("prvn83");
       auth.setPassword("praVEEn06*");



        //Getting Session ID
        //Saving newly created sessionID in sessionFilter
        RestAssured.given().header("content-type","application/json").body(auth).filter(sessionFilter).when().post("rest/auth/1/session").then().log().all().statusCode(200);

        // Creating issue
        String res =RestAssured.given().header("content-type","application/json").filter(sessionFilter).
                body("{\n" +
                        "    \"fields\": {\n" +
                        "        \"project\": {\n" +
                        "            \"key\": \"AP\"\n" +
                        "        },\n" +
                        "        \"summary\": \"something's wrong\",\n" +
                        "        \"issuetype\": {\n" +
                        "            \"name\": \"Bug\"\n" +
                        "        },\n" +
                        "        \"description\": \"description\"\n" +
                        "        \n" +
                        "    }\n" +
                        "}").when().post("rest/api/2/issue").then().log().all().statusCode(201).extract().asString();

        JsonPath js = new JsonPath(res);
        String Issue_id = js.getString("id");

        //Adding comment to Created issue

        RestAssured.given().header("content-type","application/json").filter(sessionFilter).pathParam("key",Issue_id).
                body("{\n" +
                        "    \"body\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eget venenatis elit. Duis eu justo eget augue iaculis fermentum. Sed semper quam laoreet nisi egestas at posuere augue semper.\",\n" +
                        "    \"visibility\": {\n" +
                        "        \"type\": \"role\",\n" +
                        "        \"value\": \"Administrators\"\n" +
                        "    }\n" +
                        "}").when().post("rest/api/2/issue/{key}/comment").then().log().all().statusCode(201);


        //Add file to Issue

        RestAssured.given().header("X-Atlassian-Token","no-check").header("content-type","multipart/form-data").filter(sessionFilter).
                multiPart(new File("/Users/pk736868/IdeaProjects/RestAssuredLearningAPIProject/src/main/resources/Test.txt")).pathParam("key",Issue_id).
                when().post("/rest/api/2/issue/{key}/attachments").then().log().all().statusCode(200);




        // Get issue details
        RestAssured.given().header("content-type","application/json").filter(sessionFilter).pathParam("key",Issue_id).queryParam("fields","comment").
                when().get("/rest/api/2/issue/{key}").then().log().all().statusCode(200);













    }
}
