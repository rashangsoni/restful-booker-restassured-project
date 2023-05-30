package com.booker.crudtest;

import com.booker.model.BookingPojo;
import com.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetTest extends TestBase {


    @Test
    public void getAllBookings() {

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setUsername("admin");
        bookingPojo.setPassword("password123");

        Response response = given()
                .body(bookingPojo)
                .when()
                .get("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getBookingById() {

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setUsername("admin");
        bookingPojo.setPassword("password123");

        Response response = given()
                .pathParam("id",1121)
                .body(bookingPojo)
                .when()
                .get("/booking"+"/{id}");
        response.then().statusCode(200);

        response.prettyPrint();
    }

}