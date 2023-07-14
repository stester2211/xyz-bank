package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility
{
    By loginButton = By.xpath("//button[contains(text(),'Bank Manager Login')]");
    By customerLogin= By.xpath("//button[contains(text(),'Customer Login')]");
    public void ClickOnBankMangerLoginButton()
    {
        //click On "Bank Manager Login" Tab
        clickOnElement(loginButton);
    }
    public void clickOnCustomerLoginTab()
    {
        //click on "Customer Login" Tab
        clickOnElement(customerLogin);
    }

}
