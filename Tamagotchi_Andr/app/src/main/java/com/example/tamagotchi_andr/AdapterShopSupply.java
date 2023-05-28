package com.example.tamagotchi_andr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AdapterShopSupply extends BaseAdapter {
    private Context context;
    private List<ItemShopSupply> highTechItemsListShopSupply;
    private LayoutInflater inflater;

    public AdapterShopSupply(Context context, List<ItemShopSupply> highTechItemsListShopSupply) {
        this.context = context;
        this.highTechItemsListShopSupply = highTechItemsListShopSupply;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return highTechItemsListShopSupply.size();
    }

    @Override
    public Object getItem(int position) {
        return highTechItemsListShopSupply.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        // Inflate the layout to edit
        View view = inflater.inflate(R.layout.adapter_shop_supply, null);

        // Get the name and price for the current item
        ItemShopSupply currentItem = (ItemShopSupply) getItem(i);
        String itemName = currentItem.getName();
        double itemPrice = currentItem.getPrice();
        String imgPrefix = currentItem.getImgPrefix();

        // Edit the layout with the retrieved information
        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);

        TextView itemPriceView = view.findViewById(R.id.item_price);
        itemPriceView.setText(itemPrice + " Emeralds");

        ImageView itemIconView = view.findViewById(R.id.item_icon_shop);
        String resourceName = "icon_" + imgPrefix;
        int resId = context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
        itemIconView.setImageResource(resId);

        Button itemBuyButton = view.findViewById(R.id.item_buy);
        itemBuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (itemName) {
                    case "Stone hoe":
                        if (MainActivity.money >= itemPrice) {
                            MainActivity.money -= itemPrice;
                            MainActivity.stoneHoeState++;
                            MainActivity.hapiness += 10;
                            if (MainActivity.hapiness > 100) {
                                MainActivity.hapiness = 100;
                            }
                            Toast.makeText(context, "You have bought a Stone hoe for " + itemPrice + " Emeralds!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "You don't have enough Emeralds to buy a Stone hoe.", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "Iron shovel":
                        if (MainActivity.money >= itemPrice) {
                            MainActivity.money -= itemPrice;
                            MainActivity.ironShovelState++;
                            MainActivity.hapiness += 20;
                            if (MainActivity.hapiness > 100) {
                                MainActivity.hapiness = 100;
                            }
                            Toast.makeText(context, "You have bought an Iron shovel for " + itemPrice + " Emeralds!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "You don't have enough Emeralds to buy an Iron shovel.", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "Golden axe":
                        if (MainActivity.money >= itemPrice) {
                            MainActivity.money -= itemPrice;
                            MainActivity.goldenAxeState++;
                            MainActivity.hapiness += 30;
                            if (MainActivity.hapiness > 100) {
                                MainActivity.hapiness = 100;
                            }
                            Toast.makeText(context, "You have bought a Golden axe for " + itemPrice + " Emeralds!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "You don't have enough Emeralds to buy a Golden axe.", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "Diamond pickaxe":
                        if (MainActivity.money >= itemPrice) {
                            MainActivity.money -= itemPrice;
                            MainActivity.diamondPickaxeState++;
                            MainActivity.hapiness += 50;
                            if (MainActivity.hapiness > 100) {
                                MainActivity.hapiness = 100;
                            }
                            Toast.makeText(context, "You have bought a Diamond pickaxe for " + itemPrice + " Emeralds!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "You don't have enough Emeralds to buy a Diamond pickaxe.", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "Netherite sword":
                        if (MainActivity.money >= itemPrice) {
                            MainActivity.money -= itemPrice;
                            MainActivity.netheriteSwordState++;
                            MainActivity.hapiness += 80;
                            if (MainActivity.hapiness > 100) {
                                MainActivity.hapiness = 100;
                            }
                            Toast.makeText(context, "You have bought a Netherite sword for " + itemPrice + " Emeralds!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "You don't have enough Emeralds to buy a Netherite sword.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }
        });

        return view;
    }
}
