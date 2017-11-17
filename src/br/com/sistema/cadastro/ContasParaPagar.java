/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.cadastro;

import java.math.BigDecimal;

/**
 *
 * @author ts
 */
public class ContasParaPagar {

    //private BigDecimal valor;
    private String id;
    private String descricao;
    private String valor;
    private String vencimento;

    public ContasParaPagar() {
        this.id = "";
        this.descricao = "";
        this.valor = "";
        this.vencimento = "";
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
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
