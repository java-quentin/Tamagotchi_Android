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

public class HighTechItemAdapterShopSupply extends BaseAdapter {
    private Context context;
    private List<HighTechItemShopSupply> highTechItemsListShopSupply;
    private LayoutInflater inflater;

    public HighTechItemAdapterShopSupply(Context context, List<HighTechItemShopSupply> highTechItemsListShopSupply)
    {
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
        //On récupère le layout à éditer
        View view = inflater.inflate(R.layout.adapter_shop_supply, null);

        //Pour un item courant je récupère le nom et le prix
        HighTechItemShopSupply currentItem = (HighTechItemShopSupply) getItem(i);
        String itemName = currentItem.getName();
        double itemPrice = currentItem.getPrice();
        String imgPrefix = currentItem.getImgPrefix();

        //J'édite le layout avec les informations récupérées
        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);

        TextView itemPriceView = view.findViewById(R.id.item_price);
        itemPriceView.setText(itemPrice + "€");

        ImageView itemIconView = view.findViewById(R.id.item_icon_shop);
        String resourceName = "icon_" + imgPrefix;
        int resId = context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
        itemIconView.setImageResource(resId);

        Button itemBuyButton = view.findViewById(R.id.item_buy);
        itemBuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Vous avez acheté " + itemName + " pour "+ itemPrice + "€ !", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
