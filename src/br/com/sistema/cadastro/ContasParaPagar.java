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
public class ContasParaPagar {

    private String descricao;
    private String valor;
    private String vencimento;

    public ContasParaPagar(String descricao, String valor, String vencimento) {
        this.descricao = descricao;
        this.valor = valor;
        this.vencimento = vencimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }
    
}
