//Benjamin Gagnon
//12/3/22
//This is the first portion of an inventory management application.
//This contains the general UI for the application but lacks most of the functionality as of now.
package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;

import com.example.project_1.ui.login.LoginViewModelFactory;

public class MainActivity extends AppCompatActivity {
    private InventoryFragment mInventory;
    private EditText mItemEditText;
    private RecyclerView mItemInventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void loginScreen(View view){
        startActivity(new Intent(getApplicationContext(), LoginViewModelFactory.class));
        finish();
    }
}