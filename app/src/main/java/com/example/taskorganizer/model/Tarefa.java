package com.example.taskorganizer.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Data;

@Data
@Entity
public class Tarefa {

    @PrimaryKey(autoGenerate = true)
    private Long idTarefa;
    /*@ColumnInfo()*/
    private String titulo;
    private String descricao;

    //puxando as datas
    //long do tipo primitivo
    private long dataCriacao;
    private long dataPrevista;
    private long dataFinalizada;

    //para puxar todos os gets e sets apertei o (ALT + INSERT)

    public Long getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Long idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(long dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public long getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(long dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public long getDataFinalizada() {
        return dataFinalizada;
    }

    public void setDataFinalizada(long dataFinalizada) {
        this.dataFinalizada = dataFinalizada;
    }
}
