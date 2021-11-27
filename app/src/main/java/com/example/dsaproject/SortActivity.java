package com.example.dsaproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortActivity extends AppCompatActivity implements RVClickInterface {

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

        itemAdapter = new ItemAdapter(sortAlgo, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewS.setLayoutManager(linearLayoutManager);
        recyclerViewS.setAdapter(itemAdapter);
        itemAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {

        String[] numberList = edEntries.getText().toString().split(",");
        Integer[] numbers = new Integer[numberList.length];

        for (int i = 0; i < numberList.length; i++) {
            numbers[i] = Integer.parseInt(numberList[i]);
        }

        switch (sortAlgo.get(position)) {
            case "Merge Sort":

                //

            case "Quick Sort":
                //

            case "Insertion Sort":
                InsertionSort(numbers, numbers.length);
                sortedText.setText(Arrays.toString(numbers));
                break;
                //

            case "Selection Sort":
                SelectionSort(numbers, numbers.length);
                sortedText.setText(Arrays.toString(numbers));
                break;
                //

            case "Bubble Sort":

                BubbleSort(numbers, numbers.length);
                sortedText.setText(Arrays.toString(numbers));
                break;
            //
        }
    }

    private void BubbleSort(Integer[] numbers, int length) {
        if (length < 2) {
            return;
        }
        for (int i = 0; i < length; i++) {
            if (numbers[i] < numbers[i + 1]) {
                Integer temp = numbers[i];
                numbers[i] = numbers[i + 1];
                numbers[i + 1] = temp;
            }
        }
        BubbleSort(numbers, length - 1);

    }

    private void SelectionSort(Integer[] numbers, int length) {
        int min;

        for (int i = 0; i < length; i++) {
            min = i;
            for (int j = 0; j < length; j++) {
                if (numbers[min] < numbers[j]) {
                    min = j;
                    int temp = numbers[min];
                    numbers[min] = numbers[i];
                    numbers[i] = temp;
                }

            }
        }
    }

    private void InsertionSort(Integer[] numbers, int length) {

        int temp = 0;

        for (int i = 0; i < numbers.length - 1; i++) {

            /////////number of passes

            for (int j = 0; j < numbers.length - 1 - i; j++) {

                ///////////iterations in each pass

                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

}

