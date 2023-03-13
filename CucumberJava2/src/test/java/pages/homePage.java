package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class homePage {

    protected WebDriver driver;
    protected JavascriptExecutor js = null;

    private By btAcceptAllCookies = By.id("onetrust-accept-btn-handler");

    private String cbDevicePurchasePrice = "return document.querySelector('#\\\\37 7837 > edi-section > edi-device-protection-form').shadowRoot.querySelector('#DeviceProtectionForm > edi-device-detection').shadowRoot.querySelector('#purchasePrice').shadowRoot.querySelector('#selected').getInnerHTML()";


    private String cbDevicePurchasePriceOption = "document.querySelector('#\\\\37 7837 > edi-section > edi-device-protection-form').shadowRoot.querySelector('#DeviceProtectionForm > edi-device-detection').shadowRoot.querySelector('#purchasePrice').shadowRoot.querySelector('#list > li:nth-child({OPTION})').click()";

    private String lbPriceDeviceProtectionInteger = "return document.querySelector('#\\\\37 7837 > edi-section > edi-card-slider > edi-card-vertical').shadowRoot.querySelector('#card > edi-card-vertical-content').shadowRoot.querySelector('div > div.price-container > h3 > edi-counter').shadowRoot.querySelector('#counter > span').getInnerHTML()";

    private String lbPriceDeviceProtectionDecimal = "return document.querySelector('#\\\\37 7837 > edi-section > edi-card-slider > edi-card-vertical').shadowRoot.querySelector('#card > edi-card-vertical-content').shadowRoot.querySelector('div > div.price-container > h3 > edi-counter > span').getInnerHTML()";

    private String lbPriceDeviceProtection = "";

    private String cbDevPurchasePriceOptionLength = "document.querySelector('#\\\\37 7837 > edi-section > edi-device-protection-form').shadowRoot.querySelector('#DeviceProtectionForm > edi-device-detection').shadowRoot.querySelector('#purchasePrice').shadowRoot.querySelector('#list').childNodes.length";

    public homePage(WebDriver driver){

        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public void clickAcceptAllCookies(){
        driver.findElement(btAcceptAllCookies).click();
    }

    public String getSelectedDevicePurchasePrice(){
       return js.executeScript(this.cbDevicePurchasePrice).toString();
    }

    public void selectDevicePurchasePrice(Integer option){

        String sOption = option.toString();
        String sReplace = this.cbDevicePurchasePriceOption.replace("{OPTION}",sOption);

        js.executeScript(sReplace);
    }

    private String getPriceDeviceProtectionInteger(){
        return js.executeScript(this.lbPriceDeviceProtectionInteger).toString();
    }

    private String getPriceDeviceProtectionDecimal(){
        return js.executeScript(this.lbPriceDeviceProtectionDecimal).toString();
    }

    public String getPriceDeviceProtection() throws InterruptedException {

        Thread.sleep(3000);
        return this.getPriceDeviceProtectionInteger() + this.getPriceDeviceProtectionDecimal();
    }

    public String getDevPurchasePriceOptionLength() {

        return js.executeScript(this.cbDevPurchasePriceOptionLength).toString();
    }


}
