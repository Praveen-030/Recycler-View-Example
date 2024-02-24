package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ContactAdapter adapter;
    FloatingActionButton add;
    ArrayList<ContactModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.floatAdd);
        recyclerView = findViewById(R.id.recyclerContacts);
        //setting up layout style
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();

        //updating contacts
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_contacts);
                EditText etName = dialog.findViewById(R.id.etName);
                EditText etNumber = dialog.findViewById(R.id.etNumber);
                Button btnUpdate = dialog.findViewById(R.id.btnUpdate);
                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name="",number="";
                        if(!etName.getText().toString().equals(""))
                        {
                            name = etName.getText().toString();
                        }else {
                            Toast.makeText(MainActivity.this,"Please enter Name",Toast.LENGTH_LONG).show();
                        }
                        if(!etNumber.getText().toString().equals(""))
                        {
                            number = etNumber.getText().toString();
                        }else {
                            Toast.makeText(MainActivity.this,"Please enter Number",Toast.LENGTH_LONG).show();
                        }

                        list.add(new ContactModel(R.drawable.f,name,number));
                        adapter.notifyItemInserted(list.size()-1);
                        recyclerView.scrollToPosition(list.size()-1);

                        dialog.dismiss();
                    }
                });dialog.show();
            }
        });

        list.add(new ContactModel(R.drawable.a,"Praveen","9876543210"));
        list.add(new ContactModel(R.drawable.b,"Aman","1234567890"));
        list.add(new ContactModel(R.drawable.c,"Abhishekh","8899446633"));
        list.add(new ContactModel(R.drawable.d,"Akshay","1000022345"));
        list.add(new ContactModel(R.drawable.e,"Boy","7865987632"));
        list.add(new ContactModel(R.drawable.f,"Chaman","4536786567"));
        list.add(new ContactModel(R.drawable.g,"Ritik","1234323456"));
        list.add(new ContactModel(R.drawable.h,"Shubham","9876547678"));
        list.add(new ContactModel(R.drawable.a,"Ketan","98765445678"));
        list.add(new ContactModel(R.drawable.b,"Sahil","9876543210"));
        list.add(new ContactModel(R.drawable.c,"Japneet","9876543210"));
        list.add(new ContactModel(R.drawable.d,"Rohit","983353210"));
        list.add(new ContactModel(R.drawable.e,"Hardik","9222476210"));
        list.add(new ContactModel(R.drawable.f,"Pandya","9876543210"));
        list.add(new ContactModel(R.drawable.g,"Manish","9876543210"));
        list.add(new ContactModel(R.drawable.h,"MAnoj","9876543210"));
        list.add(new ContactModel(R.drawable.a,"Mayank","9876543210"));
        list.add(new ContactModel(R.drawable.b,"Kamlesh","9876543210"));
        list.add(new ContactModel(R.drawable.c,"Deepak","9876543210"));
        list.add(new ContactModel(R.drawable.d,"Sharma","9876543210"));
        list.add(new ContactModel(R.drawable.e,"Hudda","9876543210"));
        list.add(new ContactModel(R.drawable.f,"Kaur","98744563455"));
        list.add(new ContactModel(R.drawable.g,"Shubhman","984456545654"));
        list.add(new ContactModel(R.drawable.h,"Arya","9567845674"));

        // calling adapter class constructor
        adapter = new ContactAdapter(this,list);
        recyclerView.setAdapter(adapter);
    }
}