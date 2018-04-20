package com.mehta.android.ands8a1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

/*
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
*/


public class AscDesActivity extends AppCompatActivity {

    ListView list;
    String[] strMonths= new String[]{"January","February","March","April","May","June",
            "July","August", "September","October", "November", "December"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asc_des);

        list= (ListView)findViewById(R.id.lstMonth);
        Button btnDesc =(Button)findViewById(R.id.btnDesc);
        Button btnAsc =(Button)findViewById(R.id.btnAsc);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strMonths);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(AscDesActivity.this, strMonths[position], Toast.LENGTH_SHORT).show();
            }
        });


        /* Alphabetical descending order */

        btnDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.sort(strMonths, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
                ArrayAdapter<String> adapterDesc= new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, strMonths);
                list.setAdapter(adapterDesc);
            }
        });

        /* alphabetical ascending order */
        btnAsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.sort(strMonths);
                ArrayAdapter<String> adapterAsc= new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, strMonths);
                list.setAdapter(adapterAsc);
           }
        });
    }

}
