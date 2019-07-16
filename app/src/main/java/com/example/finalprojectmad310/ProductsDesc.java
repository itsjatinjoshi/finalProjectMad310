package com.example.finalprojectmad310;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductsDesc extends AppCompatActivity {


    ImageView ivFoodImage;
    TextView  tvFoodName, tvFoodID, tvFoodCountry, tvFoodUnit, tvFoodQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_desc);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Food Detail");
        actionBar.setSubtitle("All Details you can find here");

        ivFoodImage = findViewById(R.id.ivFoodImage);
        tvFoodName= findViewById(R.id.tvFoodName);
        tvFoodID = findViewById(R.id.tvFoodID);
        tvFoodCountry = findViewById(R.id.tvFoodCountry);
        tvFoodUnit = findViewById(R.id.tvFoodUnit);
        tvFoodQuantity = findViewById(R.id.tvFoodQuantity);

        Intent i = getIntent();

        Products p = i.getParcelableExtra("data");


        Picasso.get().load(p.getImgs()).into(ivFoodImage);

        tvFoodName.setText(p.getFoodName());
        tvFoodID.setText(p.getFoodId());
        tvFoodCountry.setText(p.getFoodCountry());
        tvFoodUnit.setText(p.getFoodUnit());
        tvFoodQuantity.setText(p.getFoodQuantity());

    }
}
