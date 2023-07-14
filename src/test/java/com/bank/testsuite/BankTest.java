package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.annotations.Test;

public class BankTest extends BaseTest
{
    HomePage homePage= new HomePage();
    BankManagerLoginPage bankManagerLoginPage= new BankManagerLoginPage();
    AddCustomerPage addCustomerPage= new AddCustomerPage();
    OpenAccountPage openAccountPage= new OpenAccountPage();
    CustomerLoginPage customerLoginPage= new CustomerLoginPage();
    CustomersPage customersPage= new CustomersPage();
    AccountPage accountPage= new AccountPage();

    //1.bankManagerShouldAddCustomerSuccessfully.
    @Test
    public void bankManagerShouldAddCustomerSuccessfully() throws InterruptedException
    {
        //1.1 click On "Bank Manager Login" Tab
        homePage.ClickOnBankMangerLoginButton();

        //1.2 click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddCustomer();
        Thread.sleep(1000);

        //1.3 enter FirstName
        addCustomerPage.enterFirstName();

        //1.4 enter LastName
        addCustomerPage.enterLastName();

        //1.5 enter PostCode
        addCustomerPage.enterPostCode();

        //1.6 click On "Add Customer" Button
        addCustomerPage.clickOnAddCustomer();

        //1.7 popup display
        //1.8 verify message "Customer added successfully"
        addCustomerPage.verifyMessageCustomerAdded();

        //1.9 click on "ok" button on popup.
        addCustomerPage.acceptPopupByclickOnOKButton();
    }

    //2. bankManagerShouldOpenAccountSuccessfully.
    @Test
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException
    {
        //2.1 click On "Bank Manager Login" Tab
        homePage.ClickOnBankMangerLoginButton();

        //2.2 click On "Open Account" Tab
        bankManagerLoginPage.clickOnOpenAccountTab();
        Thread.sleep(1000);

        //2.3 Search customer that created in first test
        openAccountPage.searchCustomer();

        //2.4 Select currency "Pound"
        openAccountPage.selectCurrencyPound();

        //2.5 click on "process" button
        openAccountPage.clickOnProcessButton();

        //2.6 popup displayed
        //2.7 verify message "Account created successfully"
        openAccountPage.verifyMessageAccountCreated();

        //2.8 click on "ok" button on popup.
        openAccountPage.acceptPopupByClickingOk();
        Thread.sleep(1000);
    }

    //3. customerShouldLoginAndLogoutSuccessfully.
    @Test
    public void customerShouldLoginAndLogoutSuccessfully()
    {
        //3.1 click on "Customer Login" Tab
        homePage.clickOnCustomerLoginTab();

        //3.2 search customer that you created.
        customerLoginPage.searchCustomer();

        //3.3 click on "Login" Button
        customerLoginPage.clickOnLoginButton();

        //3.4 verify "Logout" Tab displayed.
        customersPage.verifyTabLogout();

        //3.5 click on "Logout"
        customersPage.clickOnLogoutButton();

        //3.6 verify "Your Name" text displayed.
        customersPage.verifyTextYourName();
    }

    //4. customerShouldDepositMoneySuccessfully.
    @Test
    public void customerShouldDepositMoneySuccessfully()
    {
        //4.1 click on "Customer Login" Tab
        homePage.clickOnCustomerLoginTab();

        //4.2 search customer that you created.
        customerLoginPage.searchCustomer();

        //4.3 click on "Login" Button
        customerLoginPage.clickOnLoginButton();

        //4.4 click on "Deposit" Tab
        customersPage.clickOnDepositTab();

        //4.5 Enter amount 100
        accountPage.enterTheAmount();

        //4.6 click on "Deposit" Button
        accountPage.clickDepositButton();

        //4.7 verify message "Deposit Successful"
        accountPage.verifySuccessfulMessage();
    }

    //5. customerShouldWithdrawMoneySuccessfully
    @Test
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException
    {
        //5.1 click on "Customer Login" Tab
        homePage.clickOnCustomerLoginTab();

        //5.2 search customer that you created.
        customerLoginPage.searchCustomer();

        //5.3 click on "Login" Button
        customerLoginPage.clickOnLoginButton();

        //5.4 click on "Withdraw" Tab
        customersPage.clickOnWithdrawlTab();

        //5.5 Enter amount 50
        accountPage.enterWithdrawAmount();

        //5.6 click on "Withdraw" Button
        accountPage.clickOnWithdrawButton();
        Thread.sleep(1000);

        //5.7 verify message "Transaction Successful"
        accountPage.verifyTransactionSuccessfulMessage();
    }
}
