package com.virgingames.virgininfo;

import com.virgingames.constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import java.util.HashMap;
import java.util.List;

public class VirginSteps {

    @Step("Getting all students information")
    public ValidatableResponse getAllVirginInfo() {
        return SerenityRest.given()
                .when().get(EndPoints.GET_ALL_INFO)
                .then().statusCode(200).log().all();
    }

    @Step("Getting data with Currency EUR")
    public ValidatableResponse getDataEUREndPoints() {
        return SerenityRest.given().log().all()
                .queryParam("currency", "EUR")
                .contentType(ContentType.JSON)
                .when()
                .get(EndPoints.GET_ALL_INFO)
                .then().statusCode(200).log().all();
    }

    @Step("Getting data with Currency SEK")
    public ValidatableResponse getDataSEKEndPoints() {
        return SerenityRest.given().log().all()
                .queryParam("currency", "SEK")
                .contentType(ContentType.JSON)
                                                                                                                .when()
                .get(EndPoints.GET_ALL_INFO)
                .then().statusCode(200).log().all();
    }

    @Step
    public List<HashMap<String, Object>> getAllDataByEndPoint(String currency) {
        return SerenityRest.given().log().all()
                .queryParam("currency", currency)
                .contentType(ContentType.JSON)
                .when()
                .get(EndPoints.GET_ALL_INFO)
                .then().statusCode(200)
                .extract().path("data.pots.currency");
    }
}