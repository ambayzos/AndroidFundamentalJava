package com.example.latihan.androidfundamentaljavaapps.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.latihan.androidfundamentaljavaapps.R;
import com.example.latihan.androidfundamentaljavaapps.adapter.HeroAdapter;
import com.example.latihan.androidfundamentaljavaapps.entity.Hero;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    //listview dengan array adapter
   // private String[] dataName = {"Cut Nyak Dien","Ki Hajar Dewantara","Moh Yamin","Patitmura","R A Kartini","Sukarno"};

    //listView dengan adapter
    private HeroAdapter adapter;
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private ArrayList<Hero> heroes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        //listview dengan array adapter
//        ListView listView = findViewById(R.id.lv_list);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, dataName);
//        listView.setAdapter(adapter);

        ListView listView = findViewById(R.id.lv_list);
        adapter = new HeroAdapter(this);
        listView.setAdapter(adapter);
        
        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, heroes.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //memasukkan data
    private void addItem() {
        heroes = new ArrayList<>();

        for (int i =0; i < dataName.length; i++){
            Hero hero = new Hero();
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            heroes.add(hero);
        }
        adapter.setHeroes(heroes);
    }




    //inisialisasi array
    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
}