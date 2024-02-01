package com.virgingames.cucumber.steps;

import com.virgingames.virgininfo.VirginSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;

public class MyStepDefs {
    static ValidatableResponse response;
    @Steps
    VirginSteps steps;
    @When("User sends a GET request to list endpoint")
    public void userSendsAGETRequestToListEndpoint() {
        response = steps.getAllVirginInfo();

    }


    @When("User sends a GET request to list endpoint with currency as a GBP")
    public void userSendsAGETRequestToListEndpointWithCurrencyAsAGBP() {
        steps.getAllVirginInfo();
    }

    @When("User sends a GET request to list endpoint with currency as a EUR")
    public void userSendsAGETRequestToListEndpointWithCurrencyAsAEUR() {
        steps.getDataEUREndPoints();


    }

    @When("User sends a GET request to list endpoint with currency as a SEK")
    public void userSendsAGETRequestToListEndpointWithCurrencyAsASEK() {
        steps.getDataSEKEndPoints();
    }

    @Then("I verify currency is in SEK")
    public void iVerifyCurrencyIsInSEK() {
        List<HashMap<String,Object>> expectedCurrency = steps.getDataSEKEndPoints().extract().path("data.pots.currency");
        Assert.assertTrue(expectedCurrency.contains("SEK"));
    }

    @Then("I verify currency is in EUR")
    public void iVerifyCurrencyIsInEUR() {
        List<HashMap<String,Object>> expectedCurrency = steps.getDataEUREndPoints().extract().path("data.pots.currency");
        Assert.assertTrue(expectedCurrency.contains("EUR"));


    }

    @Then("I verify currency is in GBP")
    public void iVerifyCurrencyIsInGBP() {
        List<HashMap<String,Object>> expectedCurrency = steps.getAllVirginInfo().extract().path("data.pots.currency");
        Assert.assertTrue(expectedCurrency.contains("GBP"));


    }

    @When("User send Get request to list endpoint with currency as {string}")
    public void userSendGetRequestToListEndpointWithCurrencyAs(String currency) {
        steps.getAllDataByEndPoint(currency);
    }

    @Then("Verify currency {string}")
    public void verifyCurrency(String currency) {
        List<HashMap<String, Object>> expectedCurrency = steps.getAllDataByEndPoint(currency);
        Assert.assertTrue(expectedCurrency.contains(currency));
    }
}
