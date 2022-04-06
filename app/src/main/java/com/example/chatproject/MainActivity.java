package com.example.chatproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edt_message;
    ImageView img_send,imgBack;
    RecyclerView Recycler_chat;


    List<model_list_chat> List_data;
    private Adapter_List_Chat ap_chat;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initilize();

    }



    private void initilize()
    {
        findView();
        SetupView();
        SetupListener();
    }



    private void findView()
    {
        //findViewById for widget
        edt_message = findViewById(R.id.edt_message);
        img_send = findViewById(R.id.img_send);
        Recycler_chat = findViewById(R.id.Recycler_chat);
        imgBack = findViewById(R.id.imgBack);



    }


    private void SetupView()
    {

        Recycler_chat.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        List_data = new ArrayList<>();

    }


    private void SetupListener()
    {
        //click for ImageView send message
        img_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                if(!edt_message.getText().toString().equals("") )
                {
                    //add message to model
                    List_data.add(new model_list_chat(edt_message.getText().toString())); //add data to model

                    //set modelData for adapter
                    ap_chat = new Adapter_List_Chat("David", MainActivity.this, List_data);
                    Recycler_chat.setAdapter(ap_chat);
                    edt_message.setText("");
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Pleas Enter Message",Toast.LENGTH_LONG).show();
                }
            }
        });



        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Exit from app
                finish();
            }
        });

    }

}