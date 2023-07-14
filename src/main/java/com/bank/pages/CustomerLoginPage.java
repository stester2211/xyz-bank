package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;

public class CustomerLoginPage extends Utility
{
    By searchCustomer= By.xpath("//select[@id='userSelect']");
    By clickLoginButton= By.xpath("//button[contains(text(),'Login')]");

    public void searchCustomer()
    {
        //search customer that you created.
        selectByValueFromDropDown(searchCustomer,"1");
    }
    public void clickOnLoginButton()
    {
        //click on "Login" Button
        clickOnElement(clickLoginButton);
    }
}
