package com.poulstar.pricereport_sat_19;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder>
{
    ArrayList<Item> main_data;
    Context context;

    public MainAdapter(ArrayList<Item> main_data, Context context){
        this.main_data = main_data;
        this.context =context;

    }


    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(MainAdapter.MainHolder holder, int position) {
        Item current_item = main_data.get(position);
        holder.name.setText(current_item.getName());
        holder.price.setText(current_item.getPrice());
        holder.base.setText(current_item.getBase());
        holder.date.setText(current_item.getDate());

    }

    @Override
    public int getItemCount() {

        return main_data.size();
    }

    public class MainHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView price;
        TextView date;
        TextView base;

        public MainHolder( View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            date = itemView.findViewById(R.id.last_refresh);
            base = itemView.findViewById(R.id.base);


        }
    }
}
