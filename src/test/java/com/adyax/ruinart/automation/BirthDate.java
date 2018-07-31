package com.adyax.ruinart.automation;

import org.openqa.selenium.WebElement;
/**
 * Created by mykhail on 5.2.18.
 */

public class BirthDate implements Comparable<BirthDate> {
    Integer index;
    Integer yearValue;
    WebElement yearElement;
    public BirthDate (Integer yearValue,  WebElement yearElement){
        this.yearValue = yearValue;
        this.yearElement = yearElement;
    }

    @Override
    public String toString() {
        return "Year :\n\tYear value: " + getYearValue() + "\n\t";
    }

    @Override
    public int compareTo(BirthDate Good)
    {
        return Double.compare(this.getYearValue(), Good.getYearValue());
    }
    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getYearValue() {
        return yearValue;
    }

    public void setYearValue(Integer amountResponse) {
        this.yearValue = amountResponse;
    }

    public WebElement getYearElement() {
        return yearElement;
    }

    public void setYearElement(WebElement priceElement) {
        this.yearElement = priceElement;
    }
}
