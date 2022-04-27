package com.example.taskorganizer.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.taskorganizer.model.Tarefa;

import java.util.List;

//Mapeando a class
@Dao
public interface TarefaDao {

    @Insert
    void insert(Tarefa t);

    @Update
    void update(Tarefa t);

    @Delete
    void delete(Tarefa t);

    @Query("SELECT * FROM tarefa ORDER BY titulo")
    List<Tarefa> getAll();

}
