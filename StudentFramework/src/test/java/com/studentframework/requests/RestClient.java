package com.studentframework.requests;

import com.studentframework.specs.SpecFactory;
import com.studentframework.tests.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestClient extends TestBase {

    public Response getRequest(String requestPath){

        Response response = given()
                .spec(SpecFactory.logPayloadResponseInfo())
                .when()
                .get(requestPath);
        response.prettyPrint();
        return response;
    }

    public Response postRequest(String requestPath, Object body){

        Response response = given()
                .contentType(ContentType.JSON)
                .spec(SpecFactory.logPayloadResponseInfo())
                .when()
                .body(body)
                .post(requestPath);

        response.prettyPrint();
        return response;
    }

    public Response deleteRequest(String requestPath){

        Response response = given()
                .spec(SpecFactory.logPayloadResponseInfo())
                .when()
                .delete(requestPath);

        response.prettyPrint();
        return response;
    }

    public Response putRequest(String requestPath, Object body){

        Response response = given()
                .contentType(ContentType.JSON)
                .spec(SpecFactory.logPayloadResponseInfo())
                .when()
                .body(body)
                .put(requestPath);

        response.prettyPrint();
        return response;
    }


}
