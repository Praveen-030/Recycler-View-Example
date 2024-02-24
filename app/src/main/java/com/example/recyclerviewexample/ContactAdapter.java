package com.example.recyclerviewexample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

        holder.llROw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_contacts);
                EditText etName = dialog.findViewById(R.id.etName);
                EditText etNumber = dialog.findViewById(R.id.etNumber);
                Button btnUpdate = dialog.findViewById(R.id.btnUpdate);
                TextView tvTitle = dialog.findViewById(R.id.tvaddUpdate);
                tvTitle.setText("Update Contacts");
                etName.setText(list.get(position).name);
                etNumber.setText(list.get(position).number);
                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name="",number="";
                        if(!etName.getText().toString().equals(""))
                        {
                            name = etName.getText().toString();
                        }else {
                            Toast.makeText(context,"Please enter Name",Toast.LENGTH_LONG).show();
                        }
                        if(!etNumber.getText().toString().equals(""))
                        {
                            number = etNumber.getText().toString();
                        }else {
                            Toast.makeText(context,"Please enter Number",Toast.LENGTH_LONG).show();
                        }
                        // set means changing data at pertucular index
                        list.set(position,new ContactModel(list.get(position).img,name,number));
                        //
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });


        holder.llROw.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure want to delete?")
                        .setIcon(R.drawable.delete)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                list.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Alter dialog box auto,atically dismiss on click of yes or no
                            }
                        });
                builder.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView name,number;
        ImageView img;
        LinearLayout llROw;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvContactName);
            number = itemView.findViewById(R.id.tvContactNumber);
            img = itemView.findViewById(R.id.imgContect);
            llROw = itemView.findViewById(R.id.llRow);

        }
    }
}
