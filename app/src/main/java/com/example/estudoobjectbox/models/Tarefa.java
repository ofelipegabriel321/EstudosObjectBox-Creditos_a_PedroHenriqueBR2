package com.example.estudoobjectbox.models;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class Tarefa {

    // ID de  identificação da classe serve para que o objectBox possa destinguir os objetos
    @Id
    public long id;
    private String titulo;
    // O ToOne quer dizer que haverá uma ligação com apenas um único Data
    // OBS: é obrigado pôr o Get e Set desse atributo, senão ocorrerá um erro
    private ToOne<Data> data;

    public Tarefa() {}

    public Tarefa(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ToOne<Data> getData() {
        return data;
    }

    public void setData(ToOne<Data> data) {
        this.data = data;
    }
}
