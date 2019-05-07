package com.bittch;

/**
 * Auther:CHAOQIWEN
 */
public class Ssd implements HardDisk {
    private String capacity;

    public Ssd(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getCapacity() {
        return capacity;
    }
}
