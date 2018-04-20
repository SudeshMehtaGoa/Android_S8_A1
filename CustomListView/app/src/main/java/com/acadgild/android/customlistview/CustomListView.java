package com.acadgild.android.customlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.acadgild.android.customlistview.adapter.CustomAdapter;
import com.acadgild.android.customlistview.beans.CustomHandler;

import java.util.ArrayList;

/**
 * Created by IT-110 on 6/21/2016.
 */
public class CustomListView extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView list;
    String subjects[]=new String[]{
            "Maths","Science", "English", "Chemistry", "Biology", "Physical Education", "Computers", "Music", "Moral Science"
    } ;
    ArrayList<CustomHandler> model= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list= (ListView)findViewById(R.id.list);
        for(int i=0; i<subjects.length; i++){
            CustomHandler handler= new CustomHandler();
            handler.setName(subjects[i]);
            handler.setDescription("This is description about "+ subjects[i]);
            model.add(handler);
        }
        CustomAdapter adapter= new CustomAdapter(this, model);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p/>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,subjects[position], Toast.LENGTH_SHORT).show();
    }
}
