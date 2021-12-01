package com.example.dsaproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
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
        sortAlgo.add("Binary\nSearch");
        sortAlgo.add("Linear\nSearch");

        itemAdapter = new ItemAdapter(sortAlgo, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,RecyclerView.VERTICAL,false);
        recyclerViewS.setLayoutManager(gridLayoutManager);
        recyclerViewS.setAdapter(itemAdapter);
        itemAdapter.notifyDataSetChanged();


    }

    @Override
    public void onItemClick(int position) {
        if (!edEntries.getText().toString().isEmpty()){
            long start = System.currentTimeMillis();

            edEntries.getText().toString();
            int key = Integer.parseInt(edSearch.getText().toString());

            String[] numberList = edEntries.getText().toString().split(",");
            Integer[] numbers = new Integer[numberList.length];

            for (int i = 0; i < numberList.length; i++) {
                numbers[i] = Integer.parseInt(numberList[i]);
            }


            switch (sortAlgo.get(position)) {
                case "Binary\nSearch":
                    binarySearch(numbers, 0, numbers.length-1, key);
                    break;

                case "Linear\nSearch":
                    int lS = linearSearch(numbers,key);
                    if (lS == -1){
                        Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(this, "Found at "+lS, Toast.LENGTH_SHORT).show();
                    }
                    break;
            }

            long end = System.currentTimeMillis();
            long f = end - start;
//            Toast.makeText(this, "in " + f + " milli Seconds", Toast.LENGTH_SHORT).show();
            timeMessage("in " + f + " milli Seconds");
        }else
            Toast.makeText(this, "Pehlay kuch enter to kro", Toast.LENGTH_SHORT).show();

    }
    private void timeMessage(String s) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Time Consumed")
                .setIcon(R.drawable.ic_baseline_timer_24)
                .setMessage(s)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        alertDialog.show();
    }

    private void binarySearch(Integer[] arr, int first, int last, int key){
        int mid = (first + last)/2;
        while( first <= last ){
            if ( arr[mid] < key ){
                first = mid + 1;
            }else if ( arr[mid] == key ){
                Toast.makeText(this, "Element is found at index: " + mid, Toast.LENGTH_SHORT).show();
                break;
            }else{
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        if ( first > last ){
            Toast.makeText(this, "Element not found", Toast.LENGTH_SHORT).show();
        }
    }

    private int linearSearch(Integer[] arr, int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
}
