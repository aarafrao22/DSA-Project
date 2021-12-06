package com.example.dsaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSort, btnSearch, btnLinkedList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = findViewById(R.id.btnSearch);
        btnSort = findViewById(R.id.btnSort);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(searchIntent);
            }
        });

        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sortIntent = new Intent(MainActivity.this,SortActivity.class);
                startActivity(sortIntent);

            }
        });
        btnLinkedList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sortIntent = new Intent(MainActivity.this,SortActivity.class);
                startActivity(sortIntent);

            }
        });
    }
}