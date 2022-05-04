package com.example.taskorganizer.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.taskorganizer.R;
import com.example.taskorganizer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    //Variaveis para configurar a navegação com o AppBar
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //instanciando o binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        //seta na contentView na raiz (root) do binding
        setContentView(binding.getRoot());

        //instanciando as variaveis
        //configurando a navegation com o appBar
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);//indicando o primeiro fragment que indiquei la no nav_graph
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    @Override
    public boolean onSupportNavigateUp() {
        //executa um ou executa outro
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }
}