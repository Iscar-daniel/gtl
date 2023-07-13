package org.example;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import step.WebSteps;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void runAutomation(){


        WebSteps invoker= new WebSteps();
        invoker.openPage();
        //login process
        invoker.login();
        //verify process
        assertThat("the title is not shown",invoker.isHomepageAvailable(),equals(true));
        //click sort high to low
        invoker.clickDropdown("hilo");
        //verify price
        assertThat("price is not sorted correctly",invoker.isMaxToMin(),equals(true));
        //click the first product
        assertThat("the data is not match",invoker.isHomepageAndDetailSame(1),equals(true));
        //buy the product and checkout
        invoker.buyProduct();
        assertThat("product or price is unmatch",invoker.);

    }
}
