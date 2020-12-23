package ru.samsung.itschool.mdev.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class Fragment1 extends Fragment {

    private String val;
    private Button btn3,btn4;
    View view;
    FragmentDataListener fListener;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentDataListener) {
            fListener = (FragmentDataListener) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
             val = getArguments().getString("val");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_1, container, false);
        btn3 = view.findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // печать полученного значения от Активности
                //  Snackbar.make(view.findViewById(R.id.fr1root),val,Snackbar.LENGTH_LONG).show();

                // Отправка строки обратно в Активность
                fListener.onFragmentDataListener("Back string!!!!!");
            }
        });
        return view;
    }

    public interface FragmentDataListener {
        void onFragmentDataListener(String str);
    }
}