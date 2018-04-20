package com.acadgild.android.arrayadapterexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class UIcomponentsExample extends AppCompatActivity  implements View.OnClickListener{

    EditText name, phone;
    RadioGroup gender;
    CheckBox eng_chk, fluency_chk, ielts_chk, toefl_chk;
    Button submit;
    Spinner age_grup;
    String[] ages= new String[]{"15-18", "19-21", "22-25", "25 & above"};
    String selected_age_group="", selected_gender="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= (EditText)findViewById(R.id.name);
        phone= (EditText)findViewById(R.id.phone);
        gender= (RadioGroup)findViewById(R.id.gender_group);
        eng_chk= (CheckBox)findViewById(R.id.english_chk);
        fluency_chk= (CheckBox)findViewById(R.id.fluency_chk);
        ielts_chk= (CheckBox)findViewById(R.id.ielts_chk);
        toefl_chk= (CheckBox)findViewById(R.id.toefl_chk);
        age_grup= (Spinner)findViewById(R.id.age_grup);
        submit= (Button)findViewById(R.id.submit);
        submit.setOnClickListener(this);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ages);
        age_grup.setAdapter(adapter);
        age_grup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_age_group=ages[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.male){
                    selected_gender= "male";
                }else {
                    selected_gender= "female";
                }
            }
        });
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit:
                String msg= "Name: "+ name.getText().toString()+ " Phone: "+ phone.getText().toString()+ " Gender= "+
                        selected_gender+ " English= "+ eng_chk.isChecked()+ " Fluency= "+ fluency_chk.isChecked()+
                        " IELTS= "+ ielts_chk.isChecked()+ " TOEFL= "+ toefl_chk.isChecked()+ " Age Group= "+ selected_age_group;
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

                break;
        }
    }
}
