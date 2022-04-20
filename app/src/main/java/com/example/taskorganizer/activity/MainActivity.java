package com.example.taskorganizer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.taskorganizer.R;
import com.example.taskorganizer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //instanciando o binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        //seta na contentView na raiz (root) do binding
        setContentView(binding.getRoot());
    }
}