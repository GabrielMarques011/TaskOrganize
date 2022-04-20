package com.example.taskorganizer.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.example.taskorganizer.R;
import com.example.taskorganizer.databinding.FragmentPrincipalBinding;

import java.util.Calendar;

public class PrincipalFragment extends Fragment {

    //trazendo o binding para o fragment
    private FragmentPrincipalBinding bindingPrincipal;
    //trazendo o date para o fragment
    private DatePickerDialog datePicker;
    //variaveis para o dia, mes e ano
    int year, month, day;
    //variavel para obter a data atual
    Calendar dataAtual;
    //variavel para a data formatada
    String dataFormatada;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //instanciando o binding
        bindingPrincipal = FragmentPrincipalBinding.inflate(getLayoutInflater(), container, false);

        //instanciando a data atual
        dataAtual = Calendar.getInstance();

        //obter ano, mes e dia
        year = dataAtual.get(Calendar.YEAR);
        month = dataAtual.get(Calendar.MONTH);
        day = dataAtual.get(Calendar.DAY_OF_MONTH);

        //instanciando o datePicker
        //aplicamos expressao lambida no datePicker
        //new DatePickerDialog.OnDateSetListener() {
        //    @Override
        //    public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
        //
        //
        //
        //    }
        //}
        datePicker = new DatePickerDialog(getContext(), (datePicker, ano, mes, dia)->{

            //ao escolher uma data no datePicker, vem ate aqui

        }, year,month,day);

        //ação do click do botão de seleção da data
        //usando expressao lambida
        bindingPrincipal.btData.setOnClickListener(v ->{

            //fazendo ele aparecer
            datePicker.show();

        });

        //retorna a view raiz do binding
        return bindingPrincipal.getRoot();
    }
}