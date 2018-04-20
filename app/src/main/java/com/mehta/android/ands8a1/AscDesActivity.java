package com.mehta.android.ands8a1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.View;
import android.widget.Toast;

/*
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
*/


public class AscDesActivity extends AppCompatActivity {

    ListView list;
    String[] strMonths= new String[]{"January","February","March","April","May","June",
            "July","August", "September","October", "November", "December"};
    boolean blnOrderMode=true;

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
                if(blnOrderMode)
                    Toast.makeText(AscDesActivity.this, strMonths[position], Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AscDesActivity.this, strMonths[11-position], Toast.LENGTH_SHORT).show();
            }
        });



        btnDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strTempMonths = new String[12];
                for(int i=0; i<12;i++){
                    strTempMonths[11-i]=strMonths[i];
                }
                ArrayAdapter<String> adapterDesc= new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, strTempMonths);
                list.setAdapter(adapterDesc);
                blnOrderMode=false;
            }
        });

        btnAsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<String> adapterAsc= new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, strMonths);
                list.setAdapter(adapterAsc);
                blnOrderMode=true;
            }
        });
    }

}
