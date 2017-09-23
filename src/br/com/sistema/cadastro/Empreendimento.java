/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.cadastro;

/**
 *
 * @author ts
 */
public class Empreendimento {
    
    private String id;
    private String titulo;
    private boolean aluguel;
    private String valorAluguel;
    private boolean venda;
    private String valorVenda;
    private String endereco;
    private String descricao;
    private String contato;

    public Empreendimento() {
        this.id = "";
        this.titulo = "";
        this.aluguel = false;
        this.valorAluguel = "";
        this.venda = false;
        this.valorVenda = "";
        this.endereco = "";
        this.descricao = "";
        this.contato = "";
    }
    
    public Empreendimento(String id, String titulo, boolean aluguel, String valorAluguel, boolean venda, String valorVenda, String endereco, String descricao, String contato) {
        this.id = id;
        this.titulo = titulo;
        this.aluguel = aluguel;
        this.valorAluguel = valorAluguel;
        this.venda = venda;
        this.valorVenda = valorVenda;
        this.endereco = endereco;
        this.descricao = descricao;
        this.contato = contato;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isAluguel() {
        return aluguel;
    }

    public void setAluguel(boolean aluguel) {
        this.aluguel = aluguel;
    }

    public String getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(String valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public boolean isVenda() {
        return venda;
    }

    public void setVenda(boolean venda) {
        this.venda = venda;
    }

    public String getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
