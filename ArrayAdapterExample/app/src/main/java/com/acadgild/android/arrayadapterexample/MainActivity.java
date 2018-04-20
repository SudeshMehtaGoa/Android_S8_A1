package com.acadgild.android.arrayadapterexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by IT-110 on 6/20/2016.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn1= (Button)findViewById(R.id.ui_btn);
        Button btn2= (Button)findViewById(R.id.list_btn);

        View.OnClickListener click= new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, UIcomponentsExample.class);
                startActivity(intent);
            }
        };

        btn1.setOnClickListener(click);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, ListExample.class);
                startActivity(intent);
            }
        });
    }
}
