package com.example.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.viewHolder> {

    Context context;
    ArrayList<ContactModel> list ;
    public ContactAdapter(Context context,ArrayList<ContactModel> list)
    {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.contact_card,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.name.setText(list.get(position).name);
        holder.number.setText(list.get(position).number);
        holder.img.setImageResource(list.get(position).img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView name,number;
        ImageView img;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvContactName);
            number = itemView.findViewById(R.id.tvContactNumber);
            img = itemView.findViewById(R.id.imgContect);

        }
    }
}
