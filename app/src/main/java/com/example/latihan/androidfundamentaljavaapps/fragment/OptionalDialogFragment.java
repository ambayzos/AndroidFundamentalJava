package com.example.latihan.androidfundamentaljavaapps.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.latihan.androidfundamentaljavaapps.R;


public class OptionalDialogFragment extends DialogFragment {

    Button btnChoose, btnClose;
    RadioGroup rgOptions;
    RadioButton rbSaf, rbMou, rbLvg, rbMoyes;
    OnOptionDialogListener optionDialogListener;

    public OptionalDialogFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_optional_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnChoose = view.findViewById(R.id.btn_pilih);
        btnClose = view.findViewById(R.id.btn_close);
        rgOptions = view.findViewById(R.id.rg_options);
        rbSaf = view.findViewById(R.id.rb_saf);
        rbMou = view.findViewById(R.id.rb_mou);
        rbLvg = view.findViewById(R.id.rb_lvg);
        rbMoyes = view.findViewById(R.id.rb_moyes);




        btnChoose.setOnClickListener(v -> {
            int checkedRadioButton = rgOptions.getCheckedRadioButtonId();
            if (checkedRadioButton != 1){
                String coach = null;
                if (checkedRadioButton == R.id.rb_saf){
                    coach = rbSaf.getText().toString().trim();

                }else if(checkedRadioButton == R.id.rb_mou){
                    coach = rbMou.getText().toString().trim();
                }else if(checkedRadioButton == R.id.rb_lvg){
                    coach = rbLvg.getText().toString().trim();
                }else if (checkedRadioButton == R.id.rb_moyes){
                    coach = rbMoyes.getText().toString().trim();
                }

                if (optionDialogListener != null){
                    optionDialogListener.onOptionChosen(coach);
                }

                getDialog().dismiss();
            }
        });

        btnClose.setOnClickListener(v -> {
            getDialog().cancel();
        });

    }

    @Override
    public void onAttach(@NonNull  Context context) {
        super.onAttach(context);

        Fragment fragment = getParentFragment();

        if (fragment instanceof DetailCategoryFragment){
            DetailCategoryFragment detailCategoryFragment = (DetailCategoryFragment) fragment;
            this.optionDialogListener = detailCategoryFragment.onOptionDialogListener;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.optionDialogListener = null;
    }

    public interface OnOptionDialogListener{
        void onOptionChosen(String text);
    }
}