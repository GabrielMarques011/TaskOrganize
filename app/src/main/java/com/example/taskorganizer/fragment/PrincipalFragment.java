package com.example.taskorganizer.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskorganizer.R;
import com.example.taskorganizer.adapter.TarefaAdapter;
import com.example.taskorganizer.database.AppDatabase;
import com.example.taskorganizer.databinding.FragmentPrincipalBinding;
import com.example.taskorganizer.model.Tarefa;

import java.util.List;

public class PrincipalFragment extends Fragment {

    private FragmentPrincipalBinding bindingPrincipal;

    private List<Tarefa> tarefas;

    private TarefaAdapter adapter;

    private AppDatabase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        bindingPrincipal = FragmentPrincipalBinding.inflate(getLayoutInflater(), container, false);

        bindingPrincipal.btNovaTarefa.setOnClickListener(v -> {

            NavHostFragment.findNavController(PrincipalFragment.this).navigate(R.id.action_principalFragment_to_cadastroFragment);

        });

        return bindingPrincipal.getRoot();
    }

    class ReadTarefa extends AsyncTask<Void, Void, List<Tarefa>>{

        @Override
        //buscando os dados no BD
        protected List<Tarefa> doInBackground(Void... voids) {
            return null;
        }

        @Override
        //a busca de cima sera enviada para cá
        protected void onPostExecute(List<Tarefa> tarefas) {
            super.onPostExecute(tarefas);
        }
    }

}