package com.example.tamagotchi_andr;

public class ItemInventory {
    private String name;
    private double price;
    private String imgPrefix;
    private Integer state;


    public ItemInventory(String name, double price, String imgPrefix, Integer state)
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

    public Integer getState() {
        return state;
    }
}
