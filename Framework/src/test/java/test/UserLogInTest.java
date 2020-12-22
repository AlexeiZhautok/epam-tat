package test;

import model.User;
import page.MainPage;
import page.ProfilePage;
import service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserLogInTest extends CommonConditions {
    @Test
    public void correctLogInTest() {
        User user = UserCreator.withCredentialsFromProperty();
        String expected = user.getEmail();
        new MainPage(driver)
                .openPage()
                .acceptAlert()
                .openLogInDialog()
                .logIn(user);
        String actual = new ProfilePage(driver)
                .checkInterferingNotifications()
                .openPage()
                .acceptAlert()
                .getUserEmailFieldText();
        Assert.assertEquals(expected, actual); } }
