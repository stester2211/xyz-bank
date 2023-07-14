package com.bank.utilities;

import com.bank.browserfactory.ManageBrowser;
import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utility extends ManageBrowser
{
    /**
     * 1. This method will click on element
     */
    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }

    /**
     * 2. This method will get text from element
     */
    public String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }

    /**
     * 3. This method will send the text to
     */
    public void sendTextToElement(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will return list of WebElements
     */
    public List<WebElement> getListOfElements(By by)
    {
        return driver.findElements(by);
    }

    //******************************SelectDropdown*************************************
    //4. From here --------->  All 3 Select Options method
    /**
     * 4.1 This method will select the option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text)
    {
        WebElement dropdown= driver.findElement(by);
        Select select= new Select(dropdown);
        select.selectByVisibleText(text);
    }

    /**
     * 4.2 This method will select the option by index
     */
    public void selectByIndexFromDropDown(By by, int indexNumber)
    {
        WebElement dropdown= driver.findElement(by);
        Select select=new Select(dropdown);
        select.selectByIndex(indexNumber);
    }

    /**
     * 4.3 This method will select the option by value
     */
    public void selectByValueFromDropDown(By by, String valueText)
    {
        new Select(driver.findElement(by)).selectByValue(valueText);
    }

    //*************************Alerts**********************************************
    // 5 From here --------> All 5 alerts method starts
    /**
     * 5.1 Alerts method for switch to alert
     */
    public void switchToAlertOption(By by)
    {
        clickOnElement(by); // click on alert button
        driver.switchTo().alert(); // create alert object and switch to alert
    }

    /**
     * 5.2 Alert method for getting text
     */
    public void getAlertText()
    {
        //System.out.println("Alert text are : "+driver.switchTo().alert().getText());
        driver.switchTo().alert().getText();
    }

    /**
     * 5.3 Alert method for accepting alert
     */
    public void acceptAlert()
    {
        driver.switchTo().alert().accept();
    }

    /**
     * 5.4 Alert method for dismiss/canceling alert
     */
    public void dismissAlert()
    {
        driver.switchTo().alert().dismiss();
    }

    /**
     * 5.5 Alert method for sending text to alert
     */
    public void sendTextToAlert(String alertText)
    {
        driver.switchTo().alert().sendKeys(alertText);
    }

    //****************************MouseHoverAction*************************************
    /**
     * 6.  Action ---> mouse hover
     */
    public void mouseHoverAction(By by, By by1)
    {
        WebElement text1= driver.findElement(by);
        WebElement text2= driver.findElement(by1);
        new Actions((driver)).moveToElement(text1).moveToElement(text2).click().build().perform();
    }

    /**
     * 6.2  Action ---> mouse hover for 3
     */
    public void mouseHoverActionforThree(By by, By by1, By by3)
    {
        WebElement text1= driver.findElement(by);
        WebElement text2= driver.findElement(by1);
        WebElement text3= driver.findElement(by3);
        new Actions((driver)).moveToElement(text1).moveToElement(text2).moveToElement(text3).click().build().perform();
    }

    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }


    //***************** Assert ********************************
    /**
     * 7. Assert ---> to verify the text
     */
    public void assertVerifyText(By by,String expectedText,String text)
    {
        String actualText=getTextFromElement(by);
        Assert.assertEquals(actualText,expectedText,text);
    }

    /**
     * 7.1 Assert ---> to verify the text By string
     */
    public void assertVerifyTextString(String actualText,String expectedText,String text)
    {
        // actualText=getTextFromElement(by);
        Assert.assertEquals(actualText,expectedText,text);
    }

    //************************** Waits Methods *********************************************//

    /**
     * This method will use to wait until  VisibilityOfElementLocated
     */
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    /**
     * Verify List of element
     */
    public void listOfElementVerify(By by,By by1, String selectOneText, By by3)
    {
        // Storing products names in list
        List<WebElement> productsElementsList = driver.findElements(by);
        List<String> productsNameListBefore = new ArrayList<>();
        for (WebElement value : productsElementsList) {
            productsNameListBefore.add(value.getText());
        }

        // Select Sort By filter “Given Requirement”
        selectByVisibleTextFromDropDown(by1, selectOneText);

        // After Sorting value
        productsElementsList = driver.findElements(by3);
        List<String> productsNameListAfter = new ArrayList<>();
        for (WebElement value : productsElementsList) {
            productsNameListAfter.add(value.getText());
        }

        // Sort the before name list into Ascending Order
        productsNameListBefore.sort(String.CASE_INSENSITIVE_ORDER);// Ascending order
        // Verify the products name display in alphabetical order
        Assert.assertEquals(productsNameListBefore, productsNameListAfter);
    }

    /**
     * Product List in decending
     */
    public void listOfElementVerifyInReverse(By by,By by1, String selectOneText, By by3)
    {
        // Storing products names in list
        List<WebElement> productsElementsList = driver.findElements(by);
        List<String> productsNameListBefore = new ArrayList<>();
        for (WebElement value : productsElementsList) {
            productsNameListBefore.add(value.getText());
        }

        // Select Sort By filter “Given Requirement”
        selectByVisibleTextFromDropDown(by1, selectOneText);

        // After Sorting value
        productsElementsList = driver.findElements(by3);
        List<String> productsNameListAfter = new ArrayList<>();
        for (WebElement value : productsElementsList) {
            productsNameListAfter.add(value.getText());
        }

        // Sort the before name list into Ascending Order
        productsNameListBefore.sort(String.CASE_INSENSITIVE_ORDER);// Ascending order
        Collections.reverse(productsNameListBefore);
        // Verify the products name display in alphabetical order
        Assert.assertEquals(productsNameListBefore, productsNameListAfter);
    }
}
