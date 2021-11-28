package com.example.dsaproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements RVClickInterface{
    List<String> sortAlgo;
    RecyclerView recyclerViewS;
    EditText edEntries,edSearch;
    ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        recyclerViewS = findViewById(R.id.recyclerViewS);
        edEntries = findViewById(R.id.edEntries);
        edSearch = findViewById(R.id.edSearch);

        sortAlgo = new ArrayList<>();
        sortAlgo.add("Binary Search");
        sortAlgo.add("Linear Search");

        itemAdapter = new ItemAdapter(sortAlgo, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewS.setLayoutManager(linearLayoutManager);
        recyclerViewS.setAdapter(itemAdapter);
        itemAdapter.notifyDataSetChanged();


    }

    @Override
    public void onItemClick(int position) {
        long start = System.currentTimeMillis();

        edEntries.getText().toString();
        edSearch.getText().toString();
        String[] numberList = edEntries.getText().toString().split(",");
        Integer[] numbers = new Integer[numberList.length];

        for (int i = 0; i < numberList.length; i++) {
            numbers[i] = Integer.parseInt(numberList[i]);
        }


        switch (sortAlgo.get(position)){
            case "Binary Search":
                int key =Integer.parseInt(String.valueOf(edSearch));
                binarySearch(numbers,numbers.length,key);

            case "Linear Search":
        }
    }

    private void binarySearch(Integer[] numbers,int length,int key) {
        int low = 0;
        int high = length - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;

            if (numbers[mid] == key) {
                System.out.println("found at " + ++mid);
                break;
            } else if (numbers[mid] > key) {
                high = mid - 1;
            } else if (numbers[mid] < key) {
                low = mid + 1;
            }
        }
        if (low>high){
            Toast.makeText(this, key+" Not Found", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, key+" Found", Toast.LENGTH_SHORT).show();
        }
    }
}