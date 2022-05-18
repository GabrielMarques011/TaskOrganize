package com.example.taskorganizer.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskorganizer.R;
import com.example.taskorganizer.databinding.FragmentDetalheBinding;
import com.example.taskorganizer.model.Tarefa;

import java.text.Format;
import java.text.SimpleDateFormat;

public class DetalheFragment extends Fragment {

    private FragmentDetalheBinding bindingDetalhe;

    //variavel para tarefa
    Tarefa tarefa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        bindingDetalhe = FragmentDetalheBinding.inflate(getLayoutInflater(), container, false);

        bindingDetalhe.btNovaSubTarefa.setOnClickListener(v -> {
            //criando uma variavel para 'pendurar' a tarefa
            Bundle bundle = new Bundle();

            //'pendura' a tarefa no bundle
            bundle.putSerializable("tarefa", tarefa);

            NavHostFragment.findNavController(DetalheFragment.this).navigate(R.id.action_detalheFragment_to_subtarefaFragment);
        });

        //verifica se foi passado algo no bundle
        if (getArguments() != null){
            //recupera a tarefa do bundle
            tarefa = (Tarefa) getArguments().getSerializable("tarefa");
            //popular as informações da tarefa
            bindingDetalhe.titleDetalhe.setText(tarefa.getTitulo());
            bindingDetalhe.descriptionDetalhe.setText(tarefa.getDescricao());
            //formatando a data
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            //trazendo a data formatada e com a data prevista
            bindingDetalhe.dataDetalhe.setText(format.format(tarefa.getDataPrevista()));
        }

        //retorna a view raiz do binding
        return bindingDetalhe.getRoot();
    }
}