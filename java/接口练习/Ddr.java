package com.bittch;

/**
 * Auther:CHAOQIWEN
 */
public class Ddr implements EMS {
    private String size;
    private String type;

    public Ddr(String size, String type) {
        this.size = size;
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getSize() {
        return size;
    }
}
