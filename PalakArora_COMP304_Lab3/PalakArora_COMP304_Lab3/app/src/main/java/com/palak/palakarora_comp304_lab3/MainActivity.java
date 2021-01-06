package com.palak.palakarora_comp304_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] activities = new String[] { "Exercise 1","Exercise 2","Exercise 3"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, activities);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = null;

                if (activities[position].equals("Exercise 1")){
                    intent = new Intent(getBaseContext(), Activity1.class);
                } else if (activities[position].equals("Exercise 2")){
                    intent = new Intent(getBaseContext(), Activity2.class);
                } else if (activities[position].equals("Exercise 3")) {
                    intent = new Intent(getBaseContext(), Activity3.class);
                }
                startActivity(intent);
            }
        });

    }
}