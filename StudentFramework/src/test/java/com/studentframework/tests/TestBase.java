package com.studentframework.tests;

import com.studentframework.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.TestWatcher;

public class TestBase {

    public static PropertyReader prop;

    @BeforeAll
    public static void init(){
        prop = PropertyReader.getInstance();
        RestAssured.baseURI = prop.getProperty("baseURI");
        RestAssured.port = Integer.parseInt(prop.getProperty("port"));
        RestAssured.basePath = prop.getProperty("basePath");
    }
}
