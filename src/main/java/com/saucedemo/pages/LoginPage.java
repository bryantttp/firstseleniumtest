package com.saucedemo.pages;

import org.openqa.selenium.By;

// Page object model (This class) Should reflect the application
public class LoginPage extends BasePage{
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("#login_button_container h3");

    private void setUsername(String username){
        set(usernameField,username);
    }

    public void setPassword(String password){
        set(passwordField,password);
    }

    public ProductsPage clickLoginButton(){
        click(loginButton);
        return new ProductsPage();
    }

    public ProductsPage logIntoApplication(String username, String password){
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }

    public String getErrorMessages(){
        return find(errorMessage).getText();
    }
}
