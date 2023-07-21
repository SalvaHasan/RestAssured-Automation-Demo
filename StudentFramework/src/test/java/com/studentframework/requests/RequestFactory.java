package com.studentframework.requests;

import com.github.javafaker.Faker;
import com.studentframework.tests.TestBase;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.studentframework.pojo.StudentObject;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class RequestFactory extends TestBase {

    RestClient restClient = new RestClient();
    @Step("Getting all students!")
    public Response getAllStudents(){
        Response response = restClient.getRequest("/list");
        return response;
    }


    @Step("Creating a new Student: {0}, {1}, {2}, {3}, {4}}")
    public Response createStudent(String firstName, String lastName,
                                 String email, String programme,
                                 List<String> courses){

        StudentObject student = new StudentObject();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setProgramme(programme);
        student.setCourses(courses);

        Response response = restClient.postRequest("",student);
        return response;
    }

    @Step("Updating a Student: {0}, {1}, {2}, {3}, {4}, {5}}")
    public Response updateStudent(String pathParam,String firstName, String lastName,
                                            String email, String programme,
                                            List<String> courses){

        StudentObject student = new StudentObject();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setProgramme(programme);
        student.setCourses(courses);

        Response response = restClient.putRequest("/"+pathParam,student);
        return response;
    }

    @Step("Deleting user with ID: {0}}")
    public Response deleteStudent(String pathParam){

        Response response = restClient.deleteRequest("/"+pathParam);
        return response;
    }


}
