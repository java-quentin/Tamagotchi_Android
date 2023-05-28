package com.example.tamagotchi_andr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterInventorySupply extends BaseAdapter {

    private Context context;
    private List<ItemInventory> highTechItemsListInventory;
    private LayoutInflater inflater;

    public AdapterInventorySupply(Context context, List<ItemInventory> highTechItemsListInventory) {
        this.context = context;
        this.highTechItemsListInventory = highTechItemsListInventory;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return highTechItemsListInventory.size();
    }

    @Override
    public Object getItem(int position) {
        return highTechItemsListInventory.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        // Inflate the layout to edit
        View view = inflater.inflate(R.layout.adapter_inventory_supply, null);

        // Get the name and price for the current item
        ItemInventory currentItem = (ItemInventory) getItem(i);
        String itemName = currentItem.getName();
        double itemPrice = currentItem.getPrice();
        Integer itemState = currentItem.getState();
        String imgPrefix = currentItem.getImgPrefix();

        // Edit the layout with the retrieved information
        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);

        TextView itemPriceView = view.findViewById(R.id.item_price);
        itemPriceView.setText(itemPrice + " Emeralds");

        TextView itemStateView = view.findViewById(R.id.item_state);
        itemStateView.setText("Have: " + itemState);

        ImageView itemIconView = view.findViewById(R.id.item_icon_inventory);
        String resourceName = "icon_" + imgPrefix;
        int resId = context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
        itemIconView.setImageResource(resId);

        return view;
    }
}
