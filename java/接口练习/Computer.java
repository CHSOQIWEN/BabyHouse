package com.bittch;

/**
 * Auther:CHAOQIWEN
 */
public class Computer {
    private CPU cpu;
    private EMS ems;
    private HardDisk hardDisk;

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public EMS getEms() {
        return ems;
    }

    public void setEms(EMS ems) {
        this.ems = ems;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }
    public void print(){
        System.out.println("计算机基本信息：\n"+
                        "cpu:"+cpu.getbrand()+","+cpu.getFrequency()+"\n"+
                "ems:"+ems.getSize()+","+ems.getType()+"\n"+
        "hardDisk:"+hardDisk.getCapacity());
    }


}
