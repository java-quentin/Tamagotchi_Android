package com.example.tamagotchi_andr;

public class ItemShopSupply {
    private String name;
    private double price;
    private String imgPrefix;


    public ItemShopSupply(String name, double price, String imgPrefix)
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
