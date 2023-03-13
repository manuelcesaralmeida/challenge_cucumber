package Business;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.homePage;

import java.util.HashMap;

public class businessPrice {

    HashMap<String, String> mapRangePrices = new HashMap<String, String>();

    WebDriver driver = null;
    homePage home = null;

    public businessPrice(WebDriver driver){
        mapRangePrices.put("THB 2,000 - 6,000", "฿39.00");
        mapRangePrices.put("THB 6,001 - 10,000", "฿59.00");
        mapRangePrices.put("THB 10,001 - 15,000", "฿79.00");
        mapRangePrices.put("THB 15,001 - 22,000", "฿139.00");
        mapRangePrices.put("THB 22,001 - 26,000", "฿159.00");
        mapRangePrices.put("THB 26,001 - 36,000", "฿179.00");
        mapRangePrices.put("THB 36,001 - 65,000", "฿289.00");

        this.driver = driver;
        this.home = new homePage(driver);
    }


    public boolean validatePrices(int i) throws InterruptedException {
        boolean bRes = false;

        String selectedDevicePurchasePrice = "";
        String priceDeviceProtection = "";

        home.selectDevicePurchasePrice(i);
        selectedDevicePurchasePrice = home.getSelectedDevicePurchasePrice();
        System.out.println("selectedDevicePurchasePrice = "+selectedDevicePurchasePrice );

        priceDeviceProtection = mapRangePrices.get(selectedDevicePurchasePrice);
        System.out.println("priceDeviceProtection (MAP) = "+priceDeviceProtection );

        priceDeviceProtection = home.getPriceDeviceProtection();
        System.out.println("priceDeviceProtection = "+priceDeviceProtection );

        bRes = home.getPriceDeviceProtection().equals(mapRangePrices.get(selectedDevicePurchasePrice));

        return bRes;

    }

    public boolean validatePrices(int i,String price_range) throws InterruptedException {
        boolean bRes = false;

        String selectedDevicePurchasePrice = "";
        String priceDeviceProtection = "";


        home.selectDevicePurchasePrice(i);
        selectedDevicePurchasePrice = home.getSelectedDevicePurchasePrice();
        bRes = price_range.equals(selectedDevicePurchasePrice);

        System.out.println("selectedDevicePurchasePrice = "+selectedDevicePurchasePrice );
        System.out.println("price_range                 = "+price_range );
        System.out.println("bRes                        = "+bRes );
        System.out.println("------------------------------------------------");
        System.out.println("                                                 ");


        return bRes;

    }
}
