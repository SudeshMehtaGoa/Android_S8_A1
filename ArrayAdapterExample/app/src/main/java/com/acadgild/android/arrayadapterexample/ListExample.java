package com.acadgild.android.arrayadapterexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by IT-110 on 6/20/2016.
 */
public class ListExample extends AppCompatActivity {

    ListView list;
    String[] subjects= new String[]{"English", "Hindi", "Maths", "Science", "Computers", "Punjabi", "Sanskrit", "French", "Arts",
    "Biology", "Music", "Physical Education"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_example);
        list= (ListView)findViewById(R.id.list);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subjects);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListExample.this, subjects[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
