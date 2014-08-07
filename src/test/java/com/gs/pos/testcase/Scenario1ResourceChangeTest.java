package com.gs.pos.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Scenario1ResourceChangeTest extends Scenario1TestHelper {


    @Test(groups = {"ygpos.validation1"})
    public void testPOS() {
        try {
            app.open();
            screen.click(POS_MANAGEMENT);
            screen.click(PRODUCT_INSERT);
            screen.type(PRODUCT_BARCODE_INSERT, "1111");
            screen.click(PRODUCT_SAVE);
            screen.find(INVALID_BARCODE);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(groups = {"ygpos.validation1"},enabled = false)
    public void testPOS1() {
        try {
            System.out.println("\"SSS\" = " + "SSS");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }


}
