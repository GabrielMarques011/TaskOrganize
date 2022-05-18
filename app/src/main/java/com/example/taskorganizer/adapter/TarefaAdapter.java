package com.example.taskorganizer.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskorganizer.R;
import com.example.taskorganizer.model.Tarefa;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.transform.Result;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>{

    //variavel para a lista de Tarefas
    private List<Tarefa> tarefas;

    //variavel para o Context
    private Context context;

    //variavel para o Listener
    private onTarefaClickListener listenerTarefa;

    //construtor que recebe os parametros para o Adapter
    public TarefaAdapter(List<Tarefa> lista, Context cont, onTarefaClickListener listenerTarefa){
        this.listenerTarefa = listenerTarefa;
        this.tarefas = lista;
        this.context = cont;
    }

    @NonNull
    @Override
    //ele cria a viewHolder (instancia o objeto da class viewHolder)
    public TarefaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //inflando a view do viewHolder
        View view = LayoutInflater.from(context).inflate(R.layout.exibe_tarefa, parent, false);

        //retorna uma viewHolder
        return new TarefaViewHolder(view);
    }

    @Override
    //ele passa em todos os itens da tabela (pega o objeto e transforma em item)
    public void onBindViewHolder(@NonNull TarefaViewHolder holder, int position) {

        //irei obter a tarefa atraves da position
        Tarefa t = tarefas.get(position);

        //transportando as informações da tarefa parao hover
        holder.tvTitulo.setText(t.getTitulo());

        //formata a data
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        holder.tvData.setText(format.format(t.getDataPrevista()));

        //verifica se está concluida
        if (t.isConcluida()){
            holder.tvStatus.setText("Finalizada");
            holder.tvStatus.setBackgroundColor(context.getResources().getColor(R.color.verde));
        }else if(t.isAtrasada()){
            holder.tvStatus.setText("Atrasada");
            holder.tvStatus.setBackgroundColor(context.getResources().getColor(R.color.vermelho));
        }else{
            holder.tvStatus.setText("Aberta");
            holder.tvStatus.setBackgroundColor(context.getResources().getColor(R.color.amarelo));
        }

        //implementando o click na tarefa
        holder.itemView.setOnClickListener(v -> {

            //quando eu clico no holder(tarefa), ele dispara para o listener
            listenerTarefa.onClick(v,t);
            //Log.w("Click", "CLICOU NA POSIÇÃO "+position);

        });

    }

    @Override
    //ele ve quantos itens tem na lista
    public int getItemCount() {
        if (tarefas != null){
            return tarefas.size();
        }
        return 0;
    }

    //criando class interna
    class TarefaViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitulo, tvData, tvStatus;

        public TarefaViewHolder(View view){
            //atraves dessa view que vou pegar os componentes da tabela
            super(view);

            //passar da view para os componentes
            tvTitulo = view.findViewById(R.id.tvTitulo);
            tvData = view.findViewById(R.id.tvData);
            tvStatus = view.findViewById(R.id.tvStatus);

        }

    }

    //interface para o click na tarefa
    public interface onTarefaClickListener{

        void onClick(View view, Tarefa tarefa);

    }

}