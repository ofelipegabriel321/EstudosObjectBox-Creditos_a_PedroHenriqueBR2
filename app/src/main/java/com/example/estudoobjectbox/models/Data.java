package com.example.estudoobjectbox.models;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

@Entity
public class Data {
    @Id
    public long id;
    private String data;
    // O ToMany quer dizer que haverá uma ligação com vários Tarefa
    // OBS: é obrigado pôr o Get e Set desse atributo, senão ocorrerá um erro
    private ToMany<Tarefa> tarefas;

    // tem que por um construtor vazio em toda class
    public Data(){}

    public Data(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ToMany<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(ToMany<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

}
