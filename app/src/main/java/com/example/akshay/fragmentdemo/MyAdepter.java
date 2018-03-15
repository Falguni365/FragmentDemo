package com.example.akshay.fragmentdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Akshay on 27-02-2018.
 */

public class MyAdepter extends RecyclerView.Adapter<MyAdepter.ViewHolder>{


    private List<RecyclerItem> listItems;
    private Context mContext;

    public MyAdepter(List<RecyclerItem> listItems, Context mContext) {
        this.listItems = listItems;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final RecyclerItem item = listItems.get(position);
        holder.textTitle.setText(item.getTitle());
        holder.textDescription.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public TextView textTitle;
        public TextView textDescription;
        public ViewHolder(View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
        }
    }

}
