package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;

public class BankManagerLoginPage extends Utility
{
    By addCustomer= By.xpath("//button[normalize-space()='Add Customer']");
    By openAccountTab= By.xpath("//button[normalize-space()='Open Account']");
    public void clickOnAddCustomer()
    {
        //click On "Add Customer" Tab
        clickOnElement(addCustomer);
    }
    public void clickOnOpenAccountTab()
    {
        //click On "Open Account" Tab
        clickOnElement(openAccountTab);
    }
}
