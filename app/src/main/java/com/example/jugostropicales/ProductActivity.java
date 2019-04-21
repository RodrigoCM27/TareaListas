package com.example.jugostropicales;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import com.example.jugostropicales.model.Juice;

public class ProductActivity extends AppCompatActivity {

    private Context mContext;

    private ImageView jugo;

    private TextView jugoNombre;
    private TextView jugoPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        mContext = this;
        initViews();
        receiveData();
    }

    private void initViews() {
        jugo = findViewById(R.id.jugo);
        jugoNombre = findViewById(R.id.jugoNombre);
        jugoPrecio = findViewById(R.id.jugoPrecio);
    }

    private void receiveData() {
        Intent intent = getIntent();
        String json = intent.getStringExtra(Constants.KEY_JUGO);
        Juice juice = new Gson().fromJson(json, Juice.class);
        jugo.setImageResource(juice.getImagen());
        jugoNombre.setText(juice.getNombre());
        jugoPrecio.setText(juice.getPrecio());
    }
}
