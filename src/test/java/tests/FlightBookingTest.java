package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pagesObjects.HomePage;
import pagesObjects.ResultsPage;

public class FlightBookingTest extends BaseTest {
    private HomePage homePage;
    private ResultsPage resultsPage;

    @BeforeClass
    public void setupPages() {
        System.out.println("Inside BeforeClass of FlightBookingTest");
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
    }

    @Test
    public void testThatResultsAppearForAOneWayJourney() {
        homePage.selectTripType(HomePage.TripType.ONE_WAY);
        homePage.enterOrigin("Bangalore");
        homePage.enterDestination("Delhi");
        homePage.selectRandomDepartureDate();
        homePage.searchFlights();
        resultsPage.waitForPageDisplay(driver);
        Assert.assertTrue(resultsPage.isSearchSummaryPresent());
    }
}
