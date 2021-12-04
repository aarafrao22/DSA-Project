package com.example.dsaproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.VH> {

    final private List<String> list;
    private List<Integer> imageList;
    private RVClickInterface rvClickInterface;

    public ItemAdapter(List<String> list, List<Integer> imageList, RVClickInterface rvClickInterface) {
        this.list = list;
        this.imageList = imageList;
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
        int item2 = imageList.get(position);
        holder.imageView.setImageResource(item2);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder{
        final private TextView txtItem;
        private ImageView imageView;
        public VH(@NonNull View itemView) {
            super(itemView);
            txtItem =itemView.findViewById(R.id.txtItem);
            imageView =itemView.findViewById(R.id.imageIcon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rvClickInterface.onItemClick(getAdapterPosition());
                }
            });
        }

    }

}
