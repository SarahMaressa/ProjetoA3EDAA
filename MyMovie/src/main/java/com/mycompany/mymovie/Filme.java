/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mymovie;

import java.io.Serializable;

/**
 * Armazena os dados dos filmes
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
     * Construtor
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
     * Para obter o nome do filme
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Para obter o genero do filme
     * @return genero.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Para obter o diretor do filme
     * @return diretor
     */
    public String getDiretor() {
        return diretor;
    }

    /**
     * Para obter o ano do filme
     * @return ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * Retorna se o filme foi assistido
     * @return assistido
     */
    public boolean isAssistido() {
        return assistido;
    }

    /**
     * Marca o filme como assistido
     */
    public void marcarComoAssistido() {
        this.assistido = true;
    }

    /**
     * Desmarca o filme como assistido
     */
    public void desmarcarComoAssistido() {
        this.assistido = false;
    }

    /**
     * Retorna se o filme foi marcado como favorito
     * @return favorito
     */
    public boolean isFavorito() {
        return favorito;
    }

    /**
     * Marca o filme como favorito
     */
    public void adicionarAosFavoritos() {
        this.favorito = true;
    }

    /**
     * Desmarca o filme como favorito
     */
    public void removerDosFavoritos() {
        this.favorito = false;
    }

    /**
     * Retorno a avaliação
     * @return avaliacao
     */
    public int getAvaliacao() {
        return avaliacao;
    }

    /**
     * Atribui a avaliação
     * @param avaliacao
     */
    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    /**
     * Metodo toString
     * @return
     */
    @Override
    public String toString() {
        return String.format("   %s (%d)\n Diretor: %s\n Gênero: %s", nome, ano, diretor, genero);
    }
}
