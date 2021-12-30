package br.com.dio.desafio.dominio;

import java.util.ArrayList;

public class Administrador {
    private String nome = "admin";
    private int senha= 999123;
    public ArrayList<Conteudo> conteudos;
    public ArrayList<Bootcamp> bootcamps;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public void adicionarConteudo(Curso curso){
        conteudos.add(curso);
    }
    public void adicionarConteudo(Mentoria mentoria){
        conteudos.add(mentoria);
    }

    public void adicionarBootcamp(Bootcamp bootcamp){
        bootcamps.add(bootcamp);
    }
}
