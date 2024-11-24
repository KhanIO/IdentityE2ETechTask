package com.webuyanycar.base;

public class Car {
    private String reg;
    private String make;
    private String year;
    private String model;

    public Car(String reg, String make, String model, String year) {
        this.reg = reg;
        this.make = make;
        this.year = year;
        this.model = model;

    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getReg() {
        return reg;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public String toString() {
        return ("VARIANT_REG: " + getReg() + "MAKE: " + getMake() + "MODEL: " + getModel() +
                "YEAR: " + getYear());

    }
}
