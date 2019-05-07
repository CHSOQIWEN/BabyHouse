package com.bittch;

/**
 * Auther:CHAOQIWEN
 */
public class Intel implements CPU {
    private String brand;
    private String frequency;

    public Intel(String brand, String frequency) {
        this.brand = brand;
        this.frequency = frequency;
    }

    @Override
    public String getbrand() {
        return brand;
    }

    @Override
    public String getFrequency() {
        return frequency;
    }
}
