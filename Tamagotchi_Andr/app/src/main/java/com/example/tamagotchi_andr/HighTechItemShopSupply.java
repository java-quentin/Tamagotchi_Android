package com.example.tamagotchi_andr;

public class HighTechItemShopSupply {
    private String name;
    private double price;
    private int saturation;
    private String imgPrefix;


    public HighTechItemShopSupply(String name, double price, String imgPrefix)
    {
        this.name = name;
        this.price = price;
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

}
