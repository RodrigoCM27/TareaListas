package com.example.jugostropicales;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import com.example.jugostropicales.adapter.JuiceAdapter;
import com.example.jugostropicales.model.Juice;

public class ListaActivity extends AppCompatActivity {

    private Context mContext;

    private ListView jugos;
    private JuiceAdapter jugosAdapter;

    private List<Juice> jugosArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        jugosArray.add(new Juice(1, "Naranja",5,R.drawable.naranja));
        jugosArray.add(new Juice(2, "Frutilla",6,R.drawable.frutilla));
        jugosArray.add(new Juice(3, "Piña",6,R.drawable.pinia));
        jugosArray.add(new Juice(4, "Mango",6,R.drawable.mango));
        jugosArray.add(new Juice(5, "Limon",5,R.drawable.limon));

        initViews();
        addEvents();
    }

    private void initViews() {
        jugos = findViewById(R.id.jugos);

        jugosAdapter = new JuiceAdapter(mContext, jugosArray);
        jugos.setAdapter(jugosAdapter);
    }

    private void addEvents() {
        jugos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Juice juice = jugosArray.get(position);
                Intent intent = new Intent(mContext, ProductActivity.class);
                intent.putExtra(Constants.KEY_JUGO, new Gson().toJson(juice));
                startActivity(intent);
            }
        });
    }
}
