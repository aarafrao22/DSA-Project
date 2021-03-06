package com.example.dsaproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
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
    List<Integer> imageList;
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
        sortAlgo.add("Merge\nSort");
        sortAlgo.add("Quick\nSort");
        sortAlgo.add("Insertion\nSort");
        sortAlgo.add("Selection\nSort");
        sortAlgo.add("Bubble\nSort");

        imageList = new ArrayList<>();
        imageList.add(R.drawable.ic_baseline_merge_type_24);
        imageList.add(R.drawable.ic_baseline_quickreply_24);
        imageList.add(R.drawable.ic_baseline_insertion);
        imageList.add(R.drawable.ic_baseline_selection);
        imageList.add(R.drawable.ic_baseline_bubble_chart_24);

        itemAdapter = new ItemAdapter(sortAlgo, imageList,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,RecyclerView.VERTICAL,false);
        recyclerViewS.setLayoutManager(gridLayoutManager);
        recyclerViewS.setAdapter(itemAdapter);
        itemAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        if (!edEntries.getText().toString().isEmpty()){
            long start = System.currentTimeMillis();

            String[] numberList = edEntries.getText().toString().split(",");
            Integer[] numbers = new Integer[numberList.length];

            for (int i = 0; i < numberList.length; i++) {
                numbers[i] = Integer.parseInt(numberList[i]);
            }

            switch (sortAlgo.get(position)) {
                case "Merge\nSort":
                    MergeSort(numbers, 0, numbers.length - 1);
                    sortedText.setText(Arrays.toString(numbers));
                    break;


                case "Quick\nSort":
                    quickSort(numbers, 0, numbers.length - 1);
                    sortedText.setText(Arrays.toString(numbers));


                    break;
                //

                case "Insertion\nSort":
                    InsertionSort(numbers, numbers.length);
                    sortedText.setText(Arrays.toString(numbers));
                    break;
                //

                case "Selection\nSort":
                    SelectionSort(numbers, numbers.length);
                    sortedText.setText(Arrays.toString(numbers));
                    break;
                //

                case "Bubble\nSort":
                    BubbleSort(numbers, numbers.length);
                    sortedText.setText(Arrays.toString(numbers));
                    break;
                //
            }

            long end = System.currentTimeMillis();
            long f = end - start;
            timeMessage((int) f+" Milli Seconds");
        }else {
            timeMessage("???????? ?????? ?????? ???? ?????? ??????????");
        }
    }

    private void timeMessage(String s) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Time Consumed")
                .setIcon(R.drawable.ic_baseline_timer_24)
                .setNegativeButton("????????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setMessage(s)
                .setPositiveButton("???????? ????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create();
        alertDialog.show();
    }

//    private void BubbleSort(Integer[] numbers, int length) {
//
//        for (int i = 0; i < length; i++) {
//            if (numbers[i] < numbers[i + 1]) {
//                int temp = numbers[i];
//                numbers[i] = numbers[i + 1];
//                numbers[i + 1] = temp;
//            }
//        }
//        BubbleSort(numbers, length - 1);
//
//    }

    private void BubbleSort(Integer arr[],int length) {
        for (int i = 0; i < length-1; i++)
            for (int j = 0; j < length-i-1; j++)
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
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

    //Merge

    private void merge(Integer arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private void MergeSort(Integer[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            MergeSort(arr, l, m);
            MergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    ////////////////////////////////////


    // QUICK


    private void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partition(Integer[] arr, int low, int high) {

        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    //////////////////////////////////////

}

