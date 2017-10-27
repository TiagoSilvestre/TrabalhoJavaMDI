/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.listener;

import auxiliares.Log;
import br.com.sistema.cadastro.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import trabalhomdi.JInternalFrameClientes;

/**
 *
 * @author ts
 */
public class ClienteActionListener implements ActionListener{

    private final JInternalFrameClientes janelacliente;
    Cliente cliente = null;
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if("salvar".equals(e.getActionCommand())) {
            this.cliente = janelacliente.getCliente();
            try{
                Log.getCurrentInstance().saveInLogFile("salvou um cliente");
            } catch (Exception erro){
                System.out.print(erro); 
            }
            //this.log.saveInLogFile(this.user, "entrou no sistema");
            System.out.print("\nId: "+ cliente.getId() 
                    + "\nNome: "+ cliente.getNome() 
                    + "\nNascimento: " + cliente.getNascimento()
                    + "\nCpf: " + cliente.getCpf()
                    + "\nEndereco: " + cliente.getEndereco()
                    + "\nTelefone: " + cliente.getTelefone()
            );
        } else if("excluir".equals(e.getActionCommand())) {
            if(this.cliente != null){
                System.out.print("\n\nExcluindo cadastro de: \n\nId: "+ this.cliente.getId() 
                        + "\nNome: "+ this.cliente.getNome() 
                        + "\nNascimento: " + this.cliente.getNascimento()
                        + "\nCpf: " + this.cliente.getCpf()
                        + "\nEndereco: " + this.cliente.getEndereco()
                        + "\nTelefone: " + this.cliente.getTelefone()
                );
                try {
                    Log.getCurrentInstance().saveInLogFile("excluiu um cliente");
                } catch (IOException erro) {
                    System.out.print(erro); 
                }
            }else{
                System.out.print("Nenhum cliente cadastrado");
            }
        }
        
      
    }

    public ClienteActionListener(JInternalFrameClientes janela) {
        this.janelacliente = janela;
    }
}
