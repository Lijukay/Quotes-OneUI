package com.lijukay.quotes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import dev.oneuiproject.oneui.layout.ToolbarLayout;

public class PersonsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.persons_activity);

        ToolbarLayout toolbarLayoutPersons = findViewById(R.id.toolbar_persons);

        String person = "Person's name not set";

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            person = extras.getString("person");
        }

        toolbarLayoutPersons.setTitle(person);

    }



}
