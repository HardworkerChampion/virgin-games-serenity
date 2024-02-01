package com.virgingames.virgininfo;

import com.virgingames.testbase.TestBase;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;

public class FirstSerenityTest extends TestBase {
    static String EUR = "?currency=EUR";

    @Test
    public void getAllList(){
        SerenityRest.given()
                .when()
                .get("/roxor"+ EUR)
                .then()
                .log()
                .all()
                .statusCode(200);
    }
}
