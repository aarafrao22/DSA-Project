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

public class SortActivity extends AppCompatActivity implements RVClickInterface{

    List<String> sortAlgo;
    RecyclerView recyclerViewS;
    EditText edEntries;
    ItemAdapter itemAdapter;
    TextView sortedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);

        recyclerViewS = findViewById(R.id.recyclerViewS);
        sortedText = findViewById(R.id.txtSorted);
        edEntries = findViewById(R.id.edEntries);

        sortAlgo = new ArrayList<>();
        sortAlgo.add("Merge Sort");
        sortAlgo.add("Quick Sort");
        sortAlgo.add("Insertion Sort");
        sortAlgo.add("Selection Sort");
        sortAlgo.add("Bubble Sort");

        itemAdapter = new ItemAdapter(sortAlgo,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewS.setLayoutManager(linearLayoutManager);
        recyclerViewS.setAdapter(itemAdapter);
        itemAdapter.notifyDataSetChanged();





    }

    @Override
    public void onItemClick(int position) {
//        Toast.makeText(this, sortAlgo.get(position), Toast.LENGTH_SHORT).show();
        switch (sortAlgo.get(position)){
            case "Merge Sort":
                //

            case "Quick Sort":
                //

            case "Insertion Sort":
                //

            case "Selection Sort":
                //

            case "Bubble Sort":
                //

        }
    }
}