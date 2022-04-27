package com.example.taskorganizer.fragment;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.taskorganizer.R;
import com.example.taskorganizer.database.AppDatabase;
import com.example.taskorganizer.databinding.FragmentPrincipalBinding;
import com.example.taskorganizer.model.Tarefa;

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
    //variavel para Database
    AppDatabase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //instancia a database
        database = AppDatabase.getDatabase(getContext());

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
            //passar para as variaveis globais
            year = ano;
            month = mes;
            day = dia;

            //formatando a data
            dataFormatada = String.format("%02d/%02d/%04d", day, month + 1, year);

            //aplicando a data formatada no botão
            bindingPrincipal.btData.setText(dataFormatada);

        }, year,month,day);

        //ação do click do botão de seleção da data
        //usando expressao lambida
        bindingPrincipal.btData.setOnClickListener(v ->{

            //fazendo ele aparecer
            datePicker.show();

        });

        //criando o listener do botao salvar
        bindingPrincipal.btSalvar.setOnClickListener(v ->{

            if (dataFormatada == null){
                Toast.makeText(getContext(), "Selecione uma Data", Toast.LENGTH_LONG).show();
            }else if (bindingPrincipal.editText.getText().toString().equals("")){
                Toast.makeText(getContext(), "Escreva um titulo", Toast.LENGTH_LONG).show();
            }else if(bindingPrincipal.editTextTextPersonName2.getText().toString().equals("")){
                Toast.makeText(getContext(), "Escreva uma descrição", Toast.LENGTH_LONG).show();
            }else {

                //criar uma tarefa
                Tarefa tarefa = new Tarefa();

                //populando o objeto tarefa
                tarefa.setTitulo(bindingPrincipal.editText.getText().toString());
                tarefa.setDescricao(bindingPrincipal.editTextTextPersonName2.getText().toString());

                //pegando a data atual em milisegundos
                tarefa.setDataCriacao(dataAtual.getTimeInMillis());

                //criar um Calendar
                Calendar dataPrevista = Calendar.getInstance();

                //muda a data para data escolhida no datePicker
                dataPrevista.set(year, month, day);

                //passa os milisegundos da data para a data prevista
                tarefa.setDataPrevista(dataPrevista.getTimeInMillis());

                //salva a tarefa
                new insertTarefa().execute(tarefa);

            }

        });

        //retorna a view raiz do binding
        return bindingPrincipal.getRoot();
    }

    //criando as AsyncTask para inserir Tarefa
    //class Void representa o vazio
    private class insertTarefa extends AsyncTask<Tarefa, Void, String> {

        //esse aqui é para que consiga visualizar um carregamento
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        //'...' é um numero variado de parametros, por isso os pontos
        @Override
        protected String doInBackground(Tarefa... tarefas) {
            //pegar a tarefa a partir do vetor
            Tarefa t = tarefas[0];
            try {
                //chamar o metodo da database, metedo para salvar a tarefa
                database.getTarefaDao().insert(t);
                return "OK!!";
            }catch (Exception erro){
                erro.printStackTrace();
                return erro.getMessage();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        //metodo para exibir o resultado final, com return do metodo do onPreExecute()
        @Override
        protected void onPostExecute(String result) {
            if (result.equals("OK!!")){
                Log.w("RESULT", "onPostExecute: TAREFA INSERIDA COM SUCESSO");
                Toast.makeText(getContext(), "Parabéns Você foi adicionado", Toast.LENGTH_LONG).show();
            }else{
                Log.w("RESULT", result);
            }
        }
    }

}

//UI - user interface
//thread - seria como se fosse uma linha