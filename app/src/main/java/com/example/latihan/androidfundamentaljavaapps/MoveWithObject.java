package com.example.latihan.androidfundamentaljavaapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.latihan.androidfundamentaljavaapps.entity.Person;

import java.util.ArrayList;

public class MoveWithObject extends AppCompatActivity {

    public static final String EXTRA_PERSON = "extra_person";
    public static final String EXTRA_TEST = "tes";
    TextView tvObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        tvObject = findViewById(R.id.tv_object_received);


        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name :"+person.getName() +",\nEmail :"+person.getEmail()+ ",\nAge :"+person.getAge()+ ",\nLokasi :"+person.getCity();
        tvObject.setText(text);

    }
}