package com.example.tamagotchi_andr;

public class HighTechItemInventory {
    private String name;
    private double price;
    private String imgPrefix;
    private String state;


    public HighTechItemInventory(String name, double price, String imgPrefix, String state)
    {
        this.name = name;
        this.price = price;
        this.imgPrefix = imgPrefix;
        this.state = state;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public String getImgPrefix()
    {
        return imgPrefix;
    }

    public String getState() {
        return state;
    }
}
