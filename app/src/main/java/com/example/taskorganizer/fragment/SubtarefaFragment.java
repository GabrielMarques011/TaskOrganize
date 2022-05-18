package com.example.taskorganizer.fragment;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskorganizer.R;
import com.example.taskorganizer.databinding.FragmentSubtarefaBinding;
import com.example.taskorganizer.model.Tarefa;

public class SubtarefaFragment extends Fragment {

    private FragmentSubtarefaBinding bindingSubtarefa;

    private Tarefa tarefa;

    //variavel para o dialog da foto
    private AlertDialog dialogFoto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        bindingSubtarefa = FragmentSubtarefaBinding.inflate(getLayoutInflater(), container, false);

        if (getArguments() != null){

            tarefa = (Tarefa) getArguments().getSerializable("tarefa");

            bindingSubtarefa.tituloSub.setText(tarefa.getTitulo());
            bindingSubtarefa.DescricaoSub.setText(tarefa.getDescricao());

        }

        //instanciando o AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.origem_img);
        //vetor de strings
        String[] opcoes = {getString(R.string.camera), getString(R.string.galeria)};
        builder.setItems(opcoes, listenerDialog);
        dialogFoto = builder.create();

        //listener do click da imagem
        bindingSubtarefa.imagemSub.setOnClickListener(v -> {
            dialogFoto.show();
        });

        //habilita o menu
        setHasOptionsMenu(true);

        return bindingSubtarefa.getRoot();
    }

    private DialogInterface.OnClickListener listenerDialog = (dialog, i) -> {

    };

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_subtarefa, menu);
    }
}