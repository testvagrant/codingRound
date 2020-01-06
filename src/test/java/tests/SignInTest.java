package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pagesObjects.HomePage;

public class SignInTest extends BaseTest {
    private HomePage homePage;

    @BeforeClass
    public void setupPages() {
        System.out.println("Inside BeforeClass of SignInTest");
        homePage = new HomePage(driver);
    }

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
        homePage.openUserAccountMenu();
        homePage.openSignInForm();
        homePage.clickSignIn();
        Assert.assertTrue(homePage.getSignInErrorText().contains("There were errors in your submission"));
    }
}
