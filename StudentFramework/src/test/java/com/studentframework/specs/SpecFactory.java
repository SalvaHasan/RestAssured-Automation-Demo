package com.studentframework.specs;

import com.studentframework.tests.TestBase;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

public class SpecFactory extends TestBase {

    public static synchronized ResponseSpecification getGenericResponseSpec(){

        ResponseSpecBuilder responseSpec;
        ResponseSpecification responseSpecification;

        responseSpec = new ResponseSpecBuilder();
        responseSpec.expectHeader("Content-Type","application/json;charset=UTF-8");
        responseSpec.expectHeader("Transfer-Encoding","chunked");
        responseSpec.expectResponseTime(lessThan(5L), TimeUnit.SECONDS);
        responseSpecification = responseSpec.build();

        return responseSpecification;
    }

    public static synchronized RequestSpecification logPayloadResponseInfo(){
        RequestSpecBuilder requestSpec;
        RequestSpecification requestSpecification;

        requestSpec = new RequestSpecBuilder();

        if (prop.getProperty("log").equals("ENABLE")){
            requestSpec.addFilter(new AllureRestAssured());
        }

        requestSpecification = requestSpec.build();
        return requestSpecification;
    }

}
