package com.example.dsaproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.VH> {

    final private List<String> list;
    RVClickInterface rvClickInterface;

    public ItemAdapter(List<String> list,RVClickInterface rvClickInterface) {
        this.list = list;
        this.rvClickInterface = rvClickInterface;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemlist,parent,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        String item = list.get(position);
        holder.txtItem.setText(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder{
        final private TextView txtItem;
        public VH(@NonNull View itemView) {
            super(itemView);
            txtItem =itemView.findViewById(R.id.txtItem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rvClickInterface.onItemClick(getAdapterPosition());
                }
            });
        }

    }

}
