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

public class HighTechItemAdapterInventory extends BaseAdapter {

    private Context context;
    private List<HighTechItemInventory> highTechItemsListInventory;
    private LayoutInflater inflater;

    public HighTechItemAdapterInventory(Context context, List<HighTechItemInventory> highTechItemsListInventory)
    {
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
        //On récupère le layout à éditer
        View view = inflater.inflate(R.layout.adapter_inventory, null);

        //Pour un item courant je récupère le nom et le prix
        HighTechItemInventory currentItem = (HighTechItemInventory) getItem(i);
        String itemName = currentItem.getName();
        double itemPrice = currentItem.getPrice();
        String itemState = currentItem.getState();
        String imgPrefix = currentItem.getImgPrefix();

        //J'édite le layout avec les informations récupérées
        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);

        TextView itemPriceView = view.findViewById(R.id.item_price);
        itemPriceView.setText(itemPrice + "€");

        TextView itemStateView = view.findViewById(R.id.item_state);
        itemStateView.setText("State : " + itemState + " buy");

        ImageView itemIconView = view.findViewById(R.id.item_icon_inventory);
        String resourceName = "icon_" + imgPrefix;
        int resId = context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
        itemIconView.setImageResource(resId);

        return view;
    }
}
