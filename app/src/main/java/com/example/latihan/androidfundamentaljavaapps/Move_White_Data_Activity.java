package com.example.latihan.androidfundamentaljavaapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Move_White_Data_Activity extends AppCompatActivity {
    TextView move_data;
    public static final String EXTRA_AGE = "extra_age";
    public static final String EXTRA_NAME = "extra_nama";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_white_data);

        move_data = findViewById(R.id.tv_data_received);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE,0);

        String text = "Name :"+ name +",Your Agae :"+age;
        move_data.setText(text);

    }
}