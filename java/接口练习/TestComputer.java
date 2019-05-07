package com.bittch;

/**
 * Auther:CHAOQIWEN
 */
public class TestComputer {
    public static void main(String[] args) {

        CPU cpu=new Intel("intel-core i7","3.3GHZ");
        EMS ems=new Ddr("8G","ddr3");
        HardDisk hardDisk=new Ssd("512G");
        Computer computer=new Computer();
        computer.setCpu(cpu);
        computer.setEms(ems);
        computer.setHardDisk(hardDisk);
        computer.print();
    }
}
