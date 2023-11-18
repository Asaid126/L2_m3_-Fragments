package com.example.l2_m3__fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainFragment extends Fragment {
    private Button btnNext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
    }
    private void initListener() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Сумка    (бандл)
                Bundle bundle=new Bundle();
                bundle.putString("login","qwerty");//то что написано после "login" передастся в secondFragment в данном случае это qwerty
                //Мы ложим сумку    (бандл ложим в созданный секондФрагмент)
                SecondFragment secondFragment=new SecondFragment();
                secondFragment.setArguments(bundle);
                //Мы летим с сумкой в пункт назначения (new SecondFragment() поменяли на созданный secondFragment)
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,secondFragment).addToBackStack(null).commit();
            }
        });

    }

    private void initView() {
        btnNext=requireActivity().findViewById(R.id.btn_next);
    }

}