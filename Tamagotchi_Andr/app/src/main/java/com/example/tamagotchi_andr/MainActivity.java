package com.example.tamagotchi_andr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ItemShopFood> highTechItemsListShopFood;
    private List<ItemShopSupply> highTechItemsListShopSupply;
    private List<ItemInventory> highTechItemsListInventory;
    private ListView inventoryListView;
    private ListView shopListView;

    public static int money = 20;
    public static int hapiness = 100;
    public static int saturation = 40;

    public static int frenchBreadState = 0;
    public static int freshBeetrootState = 0;
    public static int crunchyCarrotState = 0;
    public static int bakedPotatoState = 0;
    public static int juicyAppleState = 0;

    public static int stoneHoeState = 0;
    public static int ironShovelState = 0;
    public static int goldenAxeState = 0;
    public static int diamondPickaxeState = 0;
    public static int netheriteSwordState = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        checkHappiness();
        checkSaturation();

        ImageView gifImageView = findViewById(R.id.gif_allay);
        Glide.with(this)
                .asGif()
                .load(R.drawable.allay)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
                .into(gifImageView);

        TextView hapinessTextView = findViewById(R.id.happiness);
        String happinessText = "Hapinness : " + hapiness + "%";
        hapinessTextView.setText(happinessText);

        TextView saturationTextView = findViewById(R.id.saturation);
        String saturationText = "Saturation : " + saturation;
        saturationTextView.setText(saturationText);

        TextView moneyTextView = findViewById(R.id.money);
        String moneyText = "Emerald : " + money;
        moneyTextView.setText(moneyText);

        Button btnGames = findViewById(R.id.button_game);
        btnGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGames();
            }
        });

        Button btnShop = findViewById(R.id.button_shop);
        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShop();
            }
        });

        Button btnInventory = findViewById(R.id.button_inventory);
        btnInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInventory();
            }
        });
    }

    private void checkHappiness() {
        if (hapiness <= 0) {
            // Death message
            String message = "Oh no! Your Allay away due to a great depression. It's a sadness moment. 😢 \n You start over from the beginning.";
            Toast toast = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
            TextView textView = new TextView(MainActivity.this);
            textView.setText(message);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(16);
            toast.setView(textView);
            toast.show();

            resetValues();
            restartActivity();
        }
    }

    private void checkSaturation() {
        if (saturation <= 0) {
            // Death message
            String message = "Oh no! Your Allay away due to extreme hunger. It's a sadness moment. 😢 \n You start over from the beginning.";
            Toast toast = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
            TextView textView = new TextView(MainActivity.this);
            textView.setText(message);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(16);
            toast.setView(textView);
            toast.show();

            resetValues();
            restartActivity();
        }
    }

    private void resetValues() {
        money = 20;
        hapiness = 100;
        saturation = 40;

        frenchBreadState = 0;
        freshBeetrootState = 0;
        crunchyCarrotState = 0;
        bakedPotatoState = 0;
        juicyAppleState = 0;

        stoneHoeState = 0;
        ironShovelState = 0;
        goldenAxeState = 0;
        diamondPickaxeState = 0;
        netheriteSwordState = 0;
    }

    private void restartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    private void showGames() {
        setContentView(R.layout.activity_games);

        ImageView imageBlindTest = findViewById(R.id.image_blind_test);
        ImageView imageRockPaperScissors = findViewById(R.id.image_rock_paper_scissors);

        imageBlindTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBlindTestGame();
            }
        });

        imageRockPaperScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRockPaperScissorsGame();
            }
        });

        Button btnBack = findViewById(R.id.button_back_games);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack= new Intent(MainActivity.this, MainActivity.class);
                startActivity(intentBack);
            }
        });
    }

    private void showBlindTestGame() {
        Intent intent = new Intent(MainActivity.this, BlindTestGame.class);
        startActivity(intent);
    }

    private void showRockPaperScissorsGame() {
        Intent intent = new Intent(MainActivity.this, RockPaperScissorsGame.class);
        startActivity(intent);
    }

    private void showShop() {
        setContentView(R.layout.activity_shop);

        ImageView imageFood = findViewById(R.id.image_food);
        ImageView imageSupply = findViewById(R.id.image_supply);

        imageFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShopFood();
            }
        });

        imageSupply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShopSupply();
            }
        });
    }

    private void showShopFood() {
        setContentView(R.layout.activity_main);

        highTechItemsListShopFood = new ArrayList<>();
        highTechItemsListShopFood.add(new ItemShopFood("French bread", 4, 8, "bread"));
        highTechItemsListShopFood.add(new ItemShopFood("Fresh beetroot", 3, 6, "beetroot"));
        highTechItemsListShopFood.add(new ItemShopFood("Crunchy carrot", 2, 4, "carrot"));
        highTechItemsListShopFood.add(new ItemShopFood("Baked potato", 2, 4, "potato"));
        highTechItemsListShopFood.add(new ItemShopFood("Juicy apple", 3, 6, "apple"));

        shopListView = findViewById(R.id.list_view);
        shopListView.setAdapter(new AdapterShopFood(MainActivity.this, highTechItemsListShopFood));

        Button btnBack = findViewById(R.id.button_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack= new Intent(MainActivity.this, MainActivity.class);
                startActivity(intentBack);
            }
        });
    }

    private void showShopSupply() {
        setContentView(R.layout.activity_main);

        highTechItemsListShopSupply = new ArrayList<>();
        highTechItemsListShopSupply.add(new ItemShopSupply("Stone hoe", 10, "hoe"));
        highTechItemsListShopSupply.add(new ItemShopSupply("Iron shovel", 20, "shovel"));
        highTechItemsListShopSupply.add(new ItemShopSupply("Golden axe", 30, "axe"));
        highTechItemsListShopSupply.add(new ItemShopSupply("Diamond pickaxe", 80, "pickaxe"));
        highTechItemsListShopSupply.add(new ItemShopSupply("Netherite sword", 300, "sword"));

        shopListView = findViewById(R.id.list_view);
        shopListView.setAdapter(new AdapterShopSupply(MainActivity.this, highTechItemsListShopSupply));

        Button btnBack = findViewById(R.id.button_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack= new Intent(MainActivity.this, MainActivity.class);
                startActivity(intentBack);
            }
        });
    }

    private void showInventory() {
        setContentView(R.layout.activity_shop);

        ImageView imageFood = findViewById(R.id.image_food);
        ImageView imageSupply = findViewById(R.id.image_supply);

        imageFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInventoryFood();
            }
        });

        imageSupply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInventorySupply();
            }
        });
    }

    private void showInventorySupply() {
        setContentView(R.layout.activity_main);

        highTechItemsListInventory = new ArrayList<>();
        highTechItemsListInventory.add(new ItemInventory("Stone hoe", 10, "hoe", stoneHoeState));
        highTechItemsListInventory.add(new ItemInventory("Iron shovel", 20, "shovel", ironShovelState));
        highTechItemsListInventory.add(new ItemInventory("Golden axe", 30, "axe", goldenAxeState));
        highTechItemsListInventory.add(new ItemInventory("Diamond pickaxe", 80, "pickaxe", diamondPickaxeState));
        highTechItemsListInventory.add(new ItemInventory("Netherite sword", 300, "sword", netheriteSwordState));

        inventoryListView = findViewById(R.id.list_view);
        inventoryListView.setAdapter(new AdapterInventorySupply(MainActivity.this, highTechItemsListInventory));

        Button btnBack = findViewById(R.id.button_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack= new Intent(MainActivity.this, MainActivity.class);
                startActivity(intentBack);
            }
        });
    }

    private void showInventoryFood() {
        setContentView(R.layout.activity_main);

        highTechItemsListInventory = new ArrayList<>();
        highTechItemsListInventory.add(new ItemInventory("French bread", 8, "bread", frenchBreadState));
        highTechItemsListInventory.add(new ItemInventory("Fresh beetroot", 6, "beetroot", freshBeetrootState));
        highTechItemsListInventory.add(new ItemInventory("Crunchy carrot", 4, "carrot", crunchyCarrotState));
        highTechItemsListInventory.add(new ItemInventory("Baked potato", 4, "potato", bakedPotatoState));
        highTechItemsListInventory.add(new ItemInventory("Juicy apple", 6, "apple", juicyAppleState));

        inventoryListView = findViewById(R.id.list_view);
        inventoryListView.setAdapter(new AdapterInventoryFood(MainActivity.this, highTechItemsListInventory));

        Button btnBack = findViewById(R.id.button_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack= new Intent(MainActivity.this, MainActivity.class);
                startActivity(intentBack);
            }
        });
    }
}
