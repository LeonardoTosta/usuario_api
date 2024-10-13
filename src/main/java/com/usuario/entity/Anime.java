package com.usuario.entity;

public class Anime {

    private String nome;
    private Integer episodios[];
    //Aula 61 DevDojo (Bloco de inicialização)
    {
        System.out.print("Bloco de inicialização");
    }

    public Anime(String nome){
        this.nome = nome;
        episodios = new Integer[100];
        for(Integer episodio: episodios){
            System.out.print(episodio);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer[] getEpisodios() {
        return episodios;
    }

    public void setEpisodios(Integer[] episodios) {
        this.episodios = episodios;
    }
}
