package com.gs.pos.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Scenario1ResourceChangeTest extends Scenario1TestHelper {

    @BeforeClass
    public void before() {
      System.setProperty("spring.profiles.active","e26");
      System.setProperty("target.scenario.name","ibm");

    }

    @Test(groups = {"ygpos.validation1"},enabled = true)
    public void testPOS() {
        try {
            app.open();
            screen.click(key1);
            screen.click(key2);
            screen.type(key3, "1111");
            screen.click(key4);
            screen.find(key5);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(groups = {"ygpos.validation1"})
    public void testPOS1() {
        try {
            System.out.println("\"SSS\" = " + "SSS");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(enabled = false)
    public void testPOS2() {
        try {
            app.open();
            screen.click(key1);
            screen.click(key2);
            screen.type(key3, "1111");
            screen.click(key4);
            screen.find(key5);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
