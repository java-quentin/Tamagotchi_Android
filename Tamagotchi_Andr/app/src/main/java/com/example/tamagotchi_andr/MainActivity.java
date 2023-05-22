package com.example.tamagotchi_andr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<HighTechItemShopFood> highTechItemsListShopFood;
    private List<HighTechItemShopSupply> highTechItemsListShopSupply;
    private List<HighTechItemInventory> highTechItemsListInventory;
    private ListView inventoryListView;
    private ListView shopListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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

    private void showGames() {
        setContentView(R.layout.adapter_games);

        ImageView imageBlindTest = findViewById(R.id.image_blind_test);
        ImageView image = findViewById(R.id.image_);

        imageBlindTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void showShop() {
        setContentView(R.layout.adapter_shop);

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
        highTechItemsListShopFood.add(new HighTechItemShopFood("Baguette française bien cuite", 4, 8, "baguette"));
        highTechItemsListShopFood.add(new HighTechItemShopFood("Betterave bien fraîche", 3, 6, "betterave"));
        highTechItemsListShopFood.add(new HighTechItemShopFood("Carotte bien croquante", 2, 4, "carotte"));
        highTechItemsListShopFood.add(new HighTechItemShopFood("Patates cuitent aux feux de bois", 2, 4, "patate"));
        highTechItemsListShopFood.add(new HighTechItemShopFood("Pomme bien juteuse", 3, 6, "pomme"));

        shopListView = findViewById(R.id.list_view);
        shopListView.setAdapter(new HighTechItemAdapterShopFood(MainActivity.this, highTechItemsListShopFood));

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
        highTechItemsListShopSupply.add(new HighTechItemShopSupply("Chapeau de fermier en paille", 30, "chapeau_de_fermier"));
        highTechItemsListShopSupply.add(new HighTechItemShopSupply("Fourche en acier", 20, "fourche"));
        highTechItemsListShopSupply.add(new HighTechItemShopSupply("Peigne colorer", 2, "peigne"));
        highTechItemsListShopSupply.add(new HighTechItemShopSupply("Tracteur dernier cri", 5000, "tracteur"));
        highTechItemsListShopSupply.add(new HighTechItemShopSupply("Grange luxueuse", 20000, "grange"));

        shopListView = findViewById(R.id.list_view);
        shopListView.setAdapter(new HighTechItemAdapterShopSupply(MainActivity.this, highTechItemsListShopSupply));

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
        setContentView(R.layout.activity_main);

        highTechItemsListInventory = new ArrayList<>();
        highTechItemsListInventory.add(new HighTechItemInventory("Baguette française bien cuite", 4, "baguette", "doesnt"));
        highTechItemsListInventory.add(new HighTechItemInventory("Betterave bien fraîche", 3, "betterave", "doesnt"));
        highTechItemsListInventory.add(new HighTechItemInventory("Carotte bien croquante", 2, "carotte", "doesnt"));
        highTechItemsListInventory.add(new HighTechItemInventory("Patates cuitent aux feux de bois", 2, "patate", "doesnt"));
        highTechItemsListInventory.add(new HighTechItemInventory("Pomme bien juteuse", 3, "pomme", "doesnt"));

        highTechItemsListInventory.add(new HighTechItemInventory("Chapeau de fermier en paille", 30, "chapeau_de_fermier", "doesnt"));
        highTechItemsListInventory.add(new HighTechItemInventory("Fourche en acier", 20, "fourche", "doesnt"));
        highTechItemsListInventory.add(new HighTechItemInventory("Peigne colorer", 2, "peigne", "doesnt"));
        highTechItemsListInventory.add(new HighTechItemInventory("Tracteur dernier cri", 5000, "tracteur", "doesnt"));
        highTechItemsListInventory.add(new HighTechItemInventory("Grange luxueuse", 20000, "grange", "doesnt"));

        inventoryListView = findViewById(R.id.list_view);
        inventoryListView.setAdapter(new HighTechItemAdapterInventory(MainActivity.this, highTechItemsListInventory));

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
