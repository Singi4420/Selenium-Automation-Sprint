package com.genos.sdet.tests;

import com.genos.sdet.base.BaseClass;
import com.genos.sdet.pages.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseClass{

    @Test
    public void testTextBox() {

       

        TextBoxPage textBoxPage = new TextBoxPage(driver);

        textBoxPage.enterName("Genos");
        textBoxPage.enterCurrentAddress("Chennai");

        String nameValue = textBoxPage.getName();
        String currentAddressValue = textBoxPage.getCurrentAddress();

        Assert.assertEquals(nameValue, "Genos");
        Assert.assertEquals(currentAddressValue, "Chennai");

       
    }
}


       

        
    

