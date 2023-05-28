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

public class AdapterShopFood extends BaseAdapter {
    private Context context;
    private List<ItemShopFood> highTechItemsListShopFood;
    private LayoutInflater inflater;

    public AdapterShopFood(Context context, List<ItemShopFood> highTechItemsListShopFood) {
        this.context = context;
        this.highTechItemsListShopFood = highTechItemsListShopFood;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return highTechItemsListShopFood.size();
    }

    @Override
    public Object getItem(int position) {
        return highTechItemsListShopFood.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        // Inflate the layout to edit
        View view = inflater.inflate(R.layout.adapter_shop_food, null);

        // Get the name and price for the current item
        ItemShopFood currentItem = (ItemShopFood) getItem(i);
        String itemName = currentItem.getName();
        double itemPrice = currentItem.getPrice();
        int itemSaturation = currentItem.getSaturation();
        String imgPrefix = currentItem.getImgPrefix();

        // Edit the layout with the retrieved information
        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);

        TextView itemPriceView = view.findViewById(R.id.item_price);
        itemPriceView.setText(itemPrice + " Emeralds");

        TextView itemSaturationView = view.findViewById(R.id.item_saturation);
        itemSaturationView.setText("+" + itemSaturation + " saturation");

        ImageView itemIconView = view.findViewById(R.id.item_icon_shop);
        String resourceName = "icon_" + imgPrefix;
        int resId = context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
        itemIconView.setImageResource(resId);

        Button itemBuyButton = view.findViewById(R.id.item_buy);
        itemBuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (itemName) {
                    case "French bread":
                        if (MainActivity.money >= itemPrice) {
                            MainActivity.money -= itemPrice;
                            MainActivity.frenchBreadState++;
                            Toast.makeText(context, "You have bought French bread for " + itemPrice + " Emeralds!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "You don't have enough Emeralds to buy French bread.", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "Fresh beetroot":
                        if (MainActivity.money >= itemPrice) {
                            MainActivity.money -= itemPrice;
                            MainActivity.freshBeetrootState++;
                            Toast.makeText(context, "You have bought Fresh beetroot for " + itemPrice + " Emeralds!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "You don't have enough Emeralds to buy Fresh beetroot.", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "Crunchy carrot":
                        if (MainActivity.money >= itemPrice) {
                            MainActivity.money -= itemPrice;
                            MainActivity.crunchyCarrotState++;
                            Toast.makeText(context, "You have bought Crunchy carrot for " + itemPrice + " Emeralds!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "You don't have enough Emeralds to buy Crunchy carrot.", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "Baked potato":
                        if (MainActivity.money >= itemPrice) {
                            MainActivity.money -= itemPrice;
                            MainActivity.bakedPotatoState++;
                            Toast.makeText(context, "You have bought Baked potato for " + itemPrice + " Emeralds!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "You don't have enough Emeralds to buy Baked potato.", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "Juicy apple":
                        if (MainActivity.money >= itemPrice) {
                            MainActivity.money -= itemPrice;
                            MainActivity.juicyAppleState++;
                            Toast.makeText(context, "You have bought Juicy apple for " + itemPrice + " Emeralds!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "You don't have enough Emeralds to buy Juicy apple.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }
        });

        return view;
    }
}
