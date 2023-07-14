package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;

public class AccountPage extends Utility
{
    // - store Transaction, deposit and withdraw.
    By enterAmount= By.xpath("//input[@placeholder='amount']");
    By clickDepositButton= By.xpath("//button[@type='submit']");
    By actualTextDepositSuccessFully= By.xpath("//span[@class='error ng-binding']");
    By enterWithdrawAmount= By.xpath("//input[@placeholder='amount']");
    By clickOnWithdrawButton= By.xpath("//button[@type='submit']");
    By actualTextTransactionSuccessful= By.xpath("//span[@class='error ng-binding']");
    public void enterTheAmount()
    {
        //Enter amount 100
        sendTextToElement(enterAmount,"100");
    }
    public void clickDepositButton()
    {
        //click on "Deposit" Button
        clickOnElement(clickDepositButton);
    }
    public void verifySuccessfulMessage()
    {
        //verify message "Deposit Successful"
        assertVerifyText(actualTextDepositSuccessFully,"Deposit Successful","Amount is not deposited");
    }
    public void enterWithdrawAmount()
    {
        // Enter amount 50
        sendTextToElement(enterWithdrawAmount,"50");
    }
    public void clickOnWithdrawButton()
    {
        //click on "Withdraw" Button
        clickOnElement(clickOnWithdrawButton);
    }
    public void verifyTransactionSuccessfulMessage()
    {
        //verify message "Transaction Successful"
        assertVerifyText(actualTextTransactionSuccessful,"Transaction successful","Transaction is not successful");
    }
}
