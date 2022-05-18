package com.example.taskorganizer.fragment;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

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
            //fazendo a busca das tarefas no banco de dados
        });

        //instanciando a dataBase
        database = AppDatabase.getDatabase(getContext());

        //define o leyout manager do recycler
        //LinearLayoutManager componente que por padrao não exibe os itens em formato de lista, ele consegue exibir de diversas formas (grade, grafico, listagem...etc)
        bindingPrincipal.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        //buscando itens na lista, executar a asynctask
        new ReadTarefa().execute();

        return bindingPrincipal.getRoot();
    }

    class ReadTarefa extends AsyncTask<Void, Void, List<Tarefa>> {

        @Override
        protected List<Tarefa> doInBackground(Void... voids) {

            //buscando os dados no BD
            tarefas = database.getTarefaDao().getAll();
            return tarefas;

        }

        @Override
        //a busca de cima sera enviada para cá
        protected void onPostExecute(List<Tarefa> tarefas) {

            //instancia o adapter
            adapter = new TarefaAdapter(tarefas, getContext(), listenerClick);
            //aplica o adapter no recycler
            bindingPrincipal.recycler.setAdapter(adapter);

        }
    }

    //criando uma implementação da interface (Listener para o click nas tarefas)
    private TarefaAdapter.onTarefaClickListener listenerClick = (view, tarefa) -> {
        //criando uma variavel para 'pendurar' a tarefa
        Bundle bundle = new Bundle();

        //'pendura' a tarefa no bundle
        bundle.putSerializable("tarefa", tarefa);

        //navegando para o fragment de detalhes e enviando a tarefa no bundle
        NavHostFragment.findNavController(PrincipalFragment.this).navigate(R.id.action_principalFragment_to_detalheFragment, bundle);
    };

}