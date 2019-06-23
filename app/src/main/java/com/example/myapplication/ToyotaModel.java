package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ToyotaModel extends AppCompatActivity {
    TextView name, position;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toyota_model);
        name = (TextView)findViewById(R.id.name);
        position = (TextView)findViewById(R.id.position);

        bundle = getIntent().getExtras();
        try {
//            String itemName = getIntent().getStringExtra("itemName");
//            String itemPosition = getIntent().getStringExtra("position");
//            name.setText(itemName);
//            position.setText(itemPosition);
            position.setText(bundle.getString("position"));
            name.setText(bundle.getString("itemName"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
