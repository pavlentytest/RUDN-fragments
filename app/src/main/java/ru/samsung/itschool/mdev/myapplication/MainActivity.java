package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Fragment1.FragmentDataListener{

    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button) {
            // показываем 1 фрагмент
            loadFragment(new Fragment1());
        } else {
            // показываем 2 фрагмент
           // loadFragment(new Fragment2());
            MyDialog md = new MyDialog();
            md.show(getSupportFragmentManager(),"dialog1");
        }

    }

    private void loadFragment(Fragment f) {
        FragmentManager fm = getSupportFragmentManager();

        Bundle args = new Bundle();
        args.putString("val","something!!!");
        f.setArguments(args);

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frLayout,f);
        ft.commit();
    }


    @Override
    public void onFragmentDataListener(String str) {
        Snackbar.make(findViewById(R.id.root),str,Snackbar.LENGTH_LONG).show();
    }
}