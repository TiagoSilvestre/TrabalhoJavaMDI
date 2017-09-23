/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.listener;

import br.com.sistema.cadastro.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import trabalhomdi.JInternalFrameClientes;

/**
 *
 * @author ts
 */
public class ClienteActionListener implements ActionListener{

    private final JInternalFrameClientes janelacliente;
    Cliente cliente;
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if("salvar".equals(e.getActionCommand())) {
            this.cliente = janelacliente.getCliente();
            
            System.out.print("Id: "+ cliente.getId() 
                    + "\nNome: "+ cliente.getNome() 
                    + "\nNascimento: " + cliente.getNascimento()
                    + "\nCpf: " + cliente.getCpf()
                    + "\nEndereco: " + cliente.getEndereco()
                    + "\nTelefone: " + cliente.getTelefone()
            );
        }
        
        if("excluir".equals(e.getActionCommand())) {
            if(this.cliente != null){
                System.out.print("Id: "+ this.cliente.getId() 
                        + "\nNome: "+ this.cliente.getNome() 
                        + "\nNascimento: " + this.cliente.getNascimento()
                        + "\nCpf: " + this.cliente.getCpf()
                        + "\nEndereco: " + this.cliente.getEndereco()
                        + "\nTelefone: " + this.cliente.getTelefone()
                );
            }
            if(this.cliente != null){
                System.out.print("Nao cadastrado");
            }
        }
        
      
    }

    public ClienteActionListener(JInternalFrameClientes janela) {
        this.janelacliente = janela;
    }
}