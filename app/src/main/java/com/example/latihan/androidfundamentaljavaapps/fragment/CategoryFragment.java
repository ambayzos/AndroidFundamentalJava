package com.example.latihan.androidfundamentaljavaapps.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.latihan.androidfundamentaljavaapps.R;

public class CategoryFragment extends Fragment implements View.OnClickListener {



    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnDetailCategory = view.findViewById(R.id.btn_detail_category);
        btnDetailCategory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_detail_category){

            DetailCategoryFragment mdetailCategoryFragment = new DetailCategoryFragment();

            Bundle mbundle = new Bundle();
            mbundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle");
            String description = "Kategori ini akan berisi produk-produk lifestyle";

            mdetailCategoryFragment.setArguments(mbundle);
            mdetailCategoryFragment.setDescription(description);

            /*
            Method addToBackStack akan menambahkan fragment ke backstack
            Behaviour dari back button akan cek fragment dari backstack,
            jika ada fragment di dalam backstack maka fragment yang akan di close / remove
            jika sudah tidak ada fragment di dalam backstack maka activity yang akan di close / finish
             */

            FragmentManager mfragmentManager = getFragmentManager();
            if (mfragmentManager != null){
                mfragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, mdetailCategoryFragment, DetailCategoryFragment.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }

        }

    }
}