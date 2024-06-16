/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mymovie;

import java.io.Serializable;

/**
 *
 * @author pedro
 */
public class Filme implements Serializable {
    private String nome;
    private String genero;
    private String diretor;
    private int ano;
    private boolean assistido;
    private boolean favorito;
    private int avaliacao;

    /**
     *
     * @param nome
     * @param genero
     * @param diretor
     * @param ano
     * @param assistido
     * @param favorito
     */
    public Filme(String nome, String genero, String diretor, int ano, boolean assistido, boolean favorito) {
        this.nome = nome;
        this.genero = genero;
        this.diretor = diretor;
        this.ano = ano;
        this.assistido = assistido;
        this.favorito = favorito;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return
     */
    public String getGenero() {
        return genero;
    }

    /**
     *
     * @return
     */
    public String getDiretor() {
        return diretor;
    }

    /**
     *
     * @return
     */
    public int getAno() {
        return ano;
    }

    /**
     *
     * @return
     */
    public boolean isAssistido() {
        return assistido;
    }

    /**
     *
     */
    public void marcarComoAssistido() {
        this.assistido = true;
    }

    /**
     *
     */
    public void desmarcarComoAssistido() {
        this.assistido = false;
    }

    /**
     *
     * @return
     */
    public boolean isFavorito() {
        return favorito;
    }

    /**
     *
     */
    public void adicionarAosFavoritos() {
        this.favorito = true;
    }

    /**
     *
     */
    public void removerDosFavoritos() {
        this.favorito = false;
    }

    /**
     *
     * @return
     */
    public int getAvaliacao() {
        return avaliacao;
    }

    /**
     *
     * @param avaliacao
     */
    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("   %s (%d)\n Diretor: %s\n Gênero: %s", nome, ano, diretor, genero);
    }
}
