package com.example.latihan.androidfundamentaljavaapps;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.latihan.androidfundamentaljavaapps.entity.Person;
import com.example.latihan.androidfundamentaljavaapps.listview.ListViewActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_pindah, btn_pindah_dgn_data, btn_move_object, btn_dial, btnMoveforResult;
    Button btnFragment, btnListView;
    TextView tvResult;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv_result);

        btn_pindah = findViewById(R.id.btn_move_activity);
        btn_pindah.setOnClickListener(this);

        btn_pindah_dgn_data = findViewById(R.id.btn_move_activity_data);
        btn_pindah_dgn_data.setOnClickListener(this);

        btn_move_object = findViewById(R.id.btn_move_activity_object);
        btn_move_object.setOnClickListener(this);

        btn_dial = findViewById(R.id.btn_dial_number);
        btn_dial.setOnClickListener(this);

        btnMoveforResult = findViewById(R.id.btn_move_for_result);
        btnMoveforResult.setOnClickListener(this);

        btnFragment = findViewById(R.id.btn_fragment);
        btnFragment.setOnClickListener(this);

        btnListView = findViewById(R.id.btn_list_view);
        btnListView.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_move_activity){
            Intent i = new Intent(MainActivity.this, Move_Activity.class);
            startActivity(i);
        }else if(v.getId() == R.id.btn_move_activity_data){
            Intent moveIntent = new Intent(MainActivity.this, Move_White_Data_Activity.class);
            moveIntent.putExtra(Move_White_Data_Activity.EXTRA_NAME, "ambay");
            moveIntent.putExtra(Move_White_Data_Activity.EXTRA_AGE,25);
            startActivity(moveIntent);
        }else if(v.getId() == R.id.btn_move_activity_object){
            Person person = new Person();
            person.setName("Ambay");
            person.setAge(25);
            person.setEmail("ahmad@gmaill");
            person.setCity("Tangerang");


            Intent moveObjectInten = new Intent(MainActivity.this, MoveWithObject.class);
            moveObjectInten.putExtra(MoveWithObject.EXTRA_PERSON, person);
            startActivity(moveObjectInten);
        }else if (v.getId() == R.id.btn_dial_number){
            String phoneNumber = "093333";
            Intent intentDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
            startActivity(intentDial);
        }else if (v.getId() == R.id.btn_move_for_result){
            Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
            startActivityForResult(moveForResultIntent, REQUEST_CODE);
        }else if (v.getId() == R.id.btn_fragment){
            Intent fragmentIntent = new Intent(MainActivity.this, FragmentActivity.class);
            startActivity(fragmentIntent);
        }else if (v.getId() == R.id.btn_list_view){
            Intent iList = new Intent(MainActivity.this, ListViewActivity.class);
            startActivity(iList);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE){
            if (requestCode == MoveForResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}