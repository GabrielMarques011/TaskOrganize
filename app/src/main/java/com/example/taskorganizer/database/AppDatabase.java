package com.example.taskorganizer.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.taskorganizer.model.Tarefa;

//class cabeça de tudo do banco de dados
@Database(entities = {Tarefa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    //variavel para acessar o banco
    private static AppDatabase database;

    //metodo para TarefaDAO
    public abstract TarefaDao getTarefaDao();

    public static AppDatabase getDatabase(Context context){

        //verifica se a database é nula
        if (database == null){
            //instancia a database
            //criando a conexao com o banco (database)
            database = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "taskorganizer").build();
        }

        return database;
    }

}
