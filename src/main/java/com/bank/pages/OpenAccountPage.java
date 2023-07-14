package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;

public class OpenAccountPage extends Utility
{
    By searchCustomer= By.xpath("//select[@id='userSelect']");
    By selectCurrency= By.xpath("//select[@id='currency']");
    By clickProcess= By.xpath("//button[contains(text(),'Process')]");

    public void searchCustomer()
    {
        //Search customer that created in first test
        selectByVisibleTextFromDropDown(searchCustomer,"Hermoine Granger");
    }
    public void selectCurrencyPound()
    {
        //Select currency "Pound"
        selectByValueFromDropDown(selectCurrency,"Pound");
    }
    public void clickOnProcessButton()
    {
        //click on "process" button
        clickOnElement(clickProcess);
    }
    public void verifyMessageAccountCreated()
    {
        //verify message "Account created successfully"
        // storing all required data one by one and then split it and compare it to verify the alert message
        String acc="Account";
        String create= "created";
        String success="successfully";

        String alertMessage = driver.switchTo().alert().getText();
        String[] arr= alertMessage.split(" ");
        String account= arr[0];
        String created= arr[1];
        String successfully= arr[2];

        if(account.equalsIgnoreCase(acc) && created.equalsIgnoreCase(create) && success.equalsIgnoreCase(successfully))
        {
            System.out.println("Account created successfully message verify successfully");
        }
        else
        {
            System.out.println("Account created message not found");
        }
    }
    public void acceptPopupByClickingOk()
    {
        //click on "ok" button on popup.
        //This acceptAlert method is from Utility class
        acceptAlert();
    }
}
