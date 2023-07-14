package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;

public class AddCustomerPage extends Utility
{
    By firstName= By.xpath("//input[@placeholder='First Name']");
    By lastName= By.xpath("//input[@placeholder='Last Name']");
    By postCode= By.xpath("//input[@placeholder='Post Code']");
    By clickAddCustomer= By.xpath("//button[@type='submit']");
    public void enterFirstName()
    {
        //enter FirstName
        sendTextToElement(firstName,"Vishwa");
    }
    public void enterLastName()
    {
        //enter LastName
        sendTextToElement(lastName,"Patel");
    }
    public void enterPostCode()
    {
        //enter PostCode
        sendTextToElement(postCode,"123456");
    }
    public void clickOnAddCustomer()
    {
        //click On "Add Customer" Button
        clickOnElement(clickAddCustomer);
    }
    public void verifyMessageCustomerAdded()
    {
        //verify message "Customer added successfully"
        // storing all required data one by one and then split it and compare it to verify the alert message
        String cxx="Customer";
        String added= "added";
        String successful="successfully";

        String alertMessage = driver.switchTo().alert().getText();
        String[] arr= alertMessage.split(" ");
        String cx= arr[0];
        String add= arr[1];
        String success= arr[2];

        if(cx.equalsIgnoreCase(cxx) && added.equalsIgnoreCase(add) && successful.equalsIgnoreCase(success))
        {
            System.out.println("Customer added message verify successfully");
        }
        else
        {
            System.out.println("Customer added message not found");
        }
    }
    public void acceptPopupByclickOnOKButton()
    {
        //click on "ok" button on popup.
        //This acceptAlert method is from Utility class
        acceptAlert();
    }

}
