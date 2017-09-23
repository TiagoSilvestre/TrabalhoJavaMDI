/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.cadastro;

/**
 *
 * @author comp8
 */
public class Cliente {
    private String id;
    private String nome;
    private String nascimento;
    private String cpf;
    private String endereco;
    private String telefone;

    public Cliente(){
        this.nome = "";
        this.nascimento = "";
        this.cpf = "";
        this.endereco = "";
        this.telefone = "";
    }
    
    public Cliente(String id, String nome, String nascimento, String cpf, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
        
    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
