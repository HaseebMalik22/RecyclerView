package com.example.recyclerviewprac;

import androidx.appcompat.app.AppCompatActivity;
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


    ArrayList<ContactModel> arrContacts = new ArrayList<>();
    FloatingActionButton btnOpenDialog;
    RecyclerContactAdapter adapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //find id of recycler
        RecyclerView recyclerView =findViewById(R.id.recyclerContact);




        //dialog of add
        btnOpenDialog=findViewById(R.id.btnOpenDialog);
        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_updatelayout);
                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = null, number=null;

                        if (!edtName.getText().toString().equals(null)) {
                            name = edtName.getText().toString();
                        }else {
                            Toast.makeText(MainActivity.this, "please enter contact name", Toast.LENGTH_SHORT).show();
                        }

                        if (!edtNumber.getText().toString().equals(null)) {
                            number = edtNumber.getText().toString();
                        }else {
                            Toast.makeText(MainActivity.this, "please enter number", Toast.LENGTH_SHORT).show();
                        }

                        arrContacts.add(new ContactModel(name, number));
                        adapter.notifyItemInserted(arrContacts.size()-1);

                        recyclerView.scrollToPosition(arrContacts.size()-1);

                        dialog.dismiss();






                    }
                });

                dialog.show();


            }
        });











        arrContacts.add(new ContactModel(R.drawable.a, "haseeb", "1231564654"));
        arrContacts.add(new ContactModel(R.drawable.b, "haseeb1", "123112564654"));
        arrContacts.add(new ContactModel(R.drawable.c, "haseeb2", "1231564654"));
        arrContacts.add(new ContactModel(R.drawable.d, "haseeb3", "1231564654"));
        arrContacts.add(new ContactModel(R.drawable.e, "haseeb4", "1231564654"));
        arrContacts.add(new ContactModel(R.drawable.f, "haseeb5", "1231564654"));
        arrContacts.add(new ContactModel(R.drawable.g, "haseeb6", "1231564654"));
        arrContacts.add(new ContactModel(R.drawable.h, "haseeb7", "1231564654"));
        arrContacts.add(new ContactModel(R.drawable.a, "haseeb8", "1231564654"));
        arrContacts.add(new ContactModel(R.drawable.j, "haseeb9", "1231564654"));
        arrContacts.add(new ContactModel(R.drawable.a, "haseeb", "1231564654"));
        arrContacts.add(new ContactModel(R.drawable.b, "haseeb1", "123112564654"));
        arrContacts.add(new ContactModel(R.drawable.c, "haseeb2", "1231564654"));
        arrContacts.add(new ContactModel(R.drawable.d, "haseeb3", "1231564654"));


        //setting layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerContactAdapter adapter =new RecyclerContactAdapter(this,arrContacts);
        recyclerView.setAdapter(adapter);




    }
}