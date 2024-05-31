package com.example.airquality;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> gymName;
    private List<String> gymLocation;
    private List<Integer> mImageIds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Custom Toolbar");
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.list);

        gymName = Arrays.asList("String 1", "String 2", "String 3");
        gymLocation = Arrays.asList("String 1", "String 2", "String 3");
        mImageIds = Arrays.asList(R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background);

        CustomListAdapter adapter = new CustomListAdapter(this, gymName, mImageIds,gymLocation);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0 : Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                    case 1 : Intent intent1 = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent1);
                    case 2 : Intent intent2 = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent2);
                        break;
                }
            }
        });
    }
}