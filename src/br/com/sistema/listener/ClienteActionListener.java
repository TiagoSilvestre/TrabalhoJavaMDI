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

    private final JInternalFrameClientes Janelacliente;
    private final Cliente cliente;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if("salvar".equals(e.getActionCommand())) {
            cliente.setNome(Janelacliente.getjTextFieldNome().getText());
            cliente.setNascimento(Janelacliente.getjTextFieldNascimento().getText());
            cliente.setCpf(Janelacliente.getjTextFieldCpf().getText());
            cliente.setEndereco(Janelacliente.getjTextFieldEndereco().getText());
            cliente.setTelefone(Janelacliente.getjTextFieldTelefone().getText());
            
            
            System.out.print("Nome: "+ cliente.getNome() 
                    + "\nNascimento: " + cliente.getNascimento()
                    + "\nCpf: " + cliente.getCpf()
                    + "\nEndereco: " + cliente.getEndereco()
                    + "\nTelefone: " + cliente.getTelefone()
            );
        }
        
      
    }

    public ClienteActionListener(Cliente cliente, JInternalFrameClientes janela) {
        this.cliente = cliente;
        this.Janelacliente = janela;
        
    }
    
    
}
