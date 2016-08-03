package com.example.admin.simpleparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    private String jsonComplex = "{\"students\":[{\"name\":\"Juan\",\"age\":20,\"grade\":8.1},{\"name\":\"Miguel\",\"age\":23,\"grade\":8.3},{\"name\":\"Roberto\",\"age\":39,\"grade\":9.3},{\"name\":\"Luis\",\"age\":19,\"grade\":6.9},{\"name\":\"Gaudencio\",\"age\":25,\"grade\":4.3}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new GsonBuilder().create();
        Result result = gson.fromJson(jsonComplex, Result.class);

    }

    public void doMagic(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }
}
