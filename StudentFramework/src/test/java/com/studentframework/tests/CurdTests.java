package com.studentframework.tests;
import com.github.javafaker.Faker;
import com.studentframework.requests.RequestFactory;
import com.studentframework.specs.SpecFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(TestResultLogger.class)
public class CurdTests extends TestBase {

    @Tag("Smoke")
    @Tag("Regression")
    @Story("Student App")
    @DisplayName("Get all students")
    @Description("Test description")
    @Test
    void getAllStudents() {

        RequestFactory request = new RequestFactory();
        request.getAllStudents().then()
                .spec(SpecFactory.getGenericResponseSpec())
                .statusCode(200);

    }

    @Tag("Smoke")
    @Tag("Regression")
    @Story("Student App")
    @DisplayName("Create a new student")
    @Description("Test description")
    @Test
    void createStudent() {

        Faker fake = new Faker();
        List<String> courses = new ArrayList<String>();
        courses.add("C++");
        courses.add("Python");
        String firstName = fake.name().firstName();
        String lastName = fake.name().lastName();
        String email = fake.internet().emailAddress();
        String programme = "Comp Sci";

        RequestFactory request = new RequestFactory();
        request.createStudent(firstName,lastName,email,
                        programme,courses).then()
                .spec(SpecFactory.getGenericResponseSpec())
                .statusCode(123);
    }

    @Tag("Sanity")
    @Tag("Regression")
    @Story("Student App")
    @DisplayName("Update student information")
    @Description("Test description")
    @Test
    void updateStudent(){
        Faker fake = new Faker();
        List<String> courses = new ArrayList<String>();
        courses.add("C++");
        courses.add("Java");
        String ID = "99";
        String firstName = fake.name().firstName();
        String lastName = fake.name().lastName();
        String email = fake.internet().emailAddress();
        String programme = "Comp Sci";

        RequestFactory request = new RequestFactory();
        request.updateStudent(ID,firstName,lastName,email,
                programme,courses).then()
                .spec(SpecFactory.getGenericResponseSpec())
                .statusCode(200);
    }

    @Tag("Sanity")
    @Tag("Regression")
    @Tag("Smoke")
    @Story("Student App")
    @DisplayName("Delete student information")
    @Description("Test description")
    @Test
    void deleteStudent(){
        String ID = "111";

        RequestFactory request = new RequestFactory();
        request.deleteStudent(ID).then()
                .statusCode(204);
    }
}
