package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;

public class CustomersPage extends Utility
{
    By actualTabLogout= By.xpath("//button[contains(text(),'Logout')]");
    By clickLogout= By.xpath("//button[contains(text(),'Logout')]");
    By actualTextYourName= By.xpath("//label[contains(text(),'Your Name :')]");
    By clickDepositTab= By.xpath("//button[normalize-space()='Deposit']");
    By clickOnWithdrawTab= By.xpath("//button[normalize-space()='Withdrawl']");
    public void verifyTabLogout()
    {
        //verify "Logout" Tab displayed.
        boolean logoutTab= driver.findElement(actualTabLogout).isDisplayed();
    }
    public void clickOnLogoutButton()
    {
        //click on "Logout"
        clickOnElement(clickLogout);
    }
    public void verifyTextYourName()
    {
        //verify "Your Name" text displayed.
        assertVerifyText(actualTextYourName,"Your Name :","Your name text not displayed");
    }
    public void clickOnDepositTab()
    {
        //click on "Deposit" Tab
        clickOnElement(clickDepositTab);
    }
    public void clickOnWithdrawlTab()
    {
        //click on "Withdraw" Tab
        clickOnElement(clickOnWithdrawTab);
    }
}
