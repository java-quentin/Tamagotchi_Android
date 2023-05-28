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

public class AdapterInventoryFood extends BaseAdapter {

    private Context context;
    private List<ItemInventory> highTechItemsListInventory;
    private LayoutInflater inflater;

    public AdapterInventoryFood(Context context, List<ItemInventory> highTechItemsListInventory) {
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
        View view = inflater.inflate(R.layout.adapter_inventory_food, null);

        // Get the name and saturation for the current item
        ItemInventory currentItem = (ItemInventory) getItem(i);
        String itemName = currentItem.getName();
        double itemSaturation = currentItem.getPrice();
        Integer itemState = currentItem.getState();
        String imgPrefix = currentItem.getImgPrefix();

        // Edit the layout with the retrieved information
        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);

        TextView itemSaturationView = view.findViewById(R.id.item_saturation);
        itemSaturationView.setText("+" + itemSaturation + " saturation");

        TextView itemStateView = view.findViewById(R.id.item_state);
        itemStateView.setText("Have: " + itemState);

        ImageView itemIconView = view.findViewById(R.id.item_icon_inventory);
        String resourceName = "icon_" + imgPrefix;
        int resId = context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
        itemIconView.setImageResource(resId);

        Button itemUseButton = view.findViewById(R.id.item_use);
        itemUseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (itemName) {
                    case "French bread":
                        if (MainActivity.frenchBreadState > 0) {
                            MainActivity.saturation += itemSaturation;
                            if (MainActivity.saturation > 40) {
                                MainActivity.saturation = 40;
                            }
                            MainActivity.frenchBreadState--;
                            Toast.makeText(context, "You have eaten French Bread!", Toast.LENGTH_SHORT).show();
                            itemStateView.setText("Have : " + MainActivity.frenchBreadState);
                        } else {
                            Toast.makeText(context, "You don't have French Bread.", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "Fresh beetroot":
                        if (MainActivity.freshBeetrootState > 0) {
                            MainActivity.saturation += itemSaturation;
                            if (MainActivity.saturation > 40) {
                                MainActivity.saturation = 40;
                            }
                            MainActivity.freshBeetrootState--;
                            Toast.makeText(context, "You have eaten Fresh beetroot!", Toast.LENGTH_SHORT).show();
                            itemStateView.setText("Have : " + MainActivity.freshBeetrootState);
                        } else {
                            Toast.makeText(context, "You don't have Fresh beetroot.", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "Crunchy carrot":
                        if (MainActivity.crunchyCarrotState > 0) {
                            MainActivity.saturation += itemSaturation;
                            if (MainActivity.saturation > 40) {
                                MainActivity.saturation = 40;
                            }
                            MainActivity.crunchyCarrotState--;
                            Toast.makeText(context, "You have eaten Crunchy carrot!", Toast.LENGTH_SHORT).show();
                            itemStateView.setText("Have : " + MainActivity.crunchyCarrotState);
                        } else {
                            Toast.makeText(context, "You don't have Crunchy carrot.", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "Baked potato":
                        if (MainActivity.bakedPotatoState > 0) {
                            MainActivity.saturation += itemSaturation;
                            if (MainActivity.saturation > 40) {
                                MainActivity.saturation = 40;
                            }
                            MainActivity.bakedPotatoState--;
                            Toast.makeText(context, "You have eaten Baked potato!", Toast.LENGTH_SHORT).show();
                            itemStateView.setText("Have : " + MainActivity.bakedPotatoState);
                        } else {
                            Toast.makeText(context, "You don't have Baked potato.", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "Juicy apple":
                        if (MainActivity.juicyAppleState > 0) {
                            MainActivity.saturation += itemSaturation;
                            if (MainActivity.saturation > 40) {
                                MainActivity.saturation = 40;
                            }
                            MainActivity.juicyAppleState--;
                            Toast.makeText(context, "You have eaten Juicy apple!", Toast.LENGTH_SHORT).show();
                            itemStateView.setText("Have : " + MainActivity.juicyAppleState);
                        } else {
                            Toast.makeText(context, "You don't have Juicy apple.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }
        });

        return view;
    }
}
