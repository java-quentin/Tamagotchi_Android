package com.example.tamagotchi_andr;

public class HighTechItemShopFood {
    private String name;
    private double price;
    private int saturation;
    private String imgPrefix;


    public HighTechItemShopFood(String name, double price, int saturation, String imgPrefix)
    {
        this.name = name;
        this.price = price;
        this.saturation = saturation;
        this.imgPrefix = imgPrefix;
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

    public int getSaturation()
    {
        return saturation;
    }

}
