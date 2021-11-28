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

public class SearchActivity extends AppCompatActivity implements RVClickInterface {
    List<String> sortAlgo;
    RecyclerView recyclerViewS;
    EditText edEntries, edSearch;
    ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        recyclerViewS = findViewById(R.id.recyclerViewSS);
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
        int key = Integer.parseInt(edSearch.getText().toString());

        String[] numberList = edEntries.getText().toString().split(",");
        Integer[] numbers = new Integer[numberList.length];

        for (int i = 0; i < numberList.length; i++) {
            numbers[i] = Integer.parseInt(numberList[i]);
        }


        switch (sortAlgo.get(position)) {
            case "Binary Search":
                int result = binarySearch(numbers,0, numbers.length-1,key);
                if (result == -1)
                    Toast.makeText(this, "Element not exist", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Element Exist at Index "+result, Toast.LENGTH_SHORT).show();
                break;

            case "Linear Search":
        }

        long end = System.currentTimeMillis();
        long f = end - start;
        Toast.makeText(this, "in " + f + " milli Seconds", Toast.LENGTH_SHORT).show();
    }

    private int binarySearch(Integer[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + r  / 2;

            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
}
