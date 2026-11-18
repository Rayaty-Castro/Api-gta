package com.dt2.GTAVI.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Missao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String local;
    private String dificudade;
    private String imagem;
    private String descricao;

    public Missao(String nome, String local, String dificudade, String imagem, String descricao) {
        this.nome = nome;
        this.local = local;
        this.dificudade = dificudade;
        this.imagem = imagem;
        this.descricao = descricao;
    }

    public Missao(int id, String nome, String local, String dificudade, String imagem, String descricao) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.dificudade = dificudade;
        this.imagem = imagem;
        this.descricao = descricao;
    }

    public Missao() {
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLocal() {
        return local;
    }

    public String getDificudade() {
        return dificudade;
    }

    public String getImagem() {
        return imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setDificudade(String dificudade) {
        this.dificudade = dificudade;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
