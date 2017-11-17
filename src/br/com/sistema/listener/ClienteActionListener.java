/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.listener;

import auxiliares.Log;
import br.com.sistema.DAO.ClientesDao;
import br.com.sistema.cadastro.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import trabalhomdi.JInternalFrameClientes;

/**
 *
 * @author ts
 */
public class ClienteActionListener implements ActionListener{

    private final JInternalFrameClientes janelacliente;
    
    public ClienteActionListener(JInternalFrameClientes janela) {
        this.janelacliente = janela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if("salvar".equals(e.getActionCommand())) {
            Cliente cliente = janelacliente.getCliente();
            try{
                ClientesDao novoCliente = new ClientesDao();
                novoCliente.insert(cliente);
                Log.getCurrentInstance().saveInLogFile("salvou um cliente");
                JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
            } catch (Exception err){
                System.out.println("Oops, algo deu errado, consulte o arquivo de log para mais detalhes");
                try {
                    Log.getCurrentInstance().saveStackTrace(err);
                } catch (Exception ex) {
                    System.out.println("Houveram erros: " + ex);
                }
            }

            System.out.print("\nId: "+ cliente.getId() 
                    + "\nNome: "+ cliente.getNome() 
                    + "\nNascimento: " + cliente.getNascimento()
                    + "\nCpf: " + cliente.getCpf()
                    + "\nEndereco: " + cliente.getEndereco()
                    + "\nTelefone: " + cliente.getTelefone()
            );
        } else if("excluir".equals(e.getActionCommand())) {
            Cliente cliente = janelacliente.getCliente();
            if(cliente != null){
                try{
                    ClientesDao excluirCliente = new ClientesDao();
                    excluirCliente.delete(cliente);
                    JOptionPane.showMessageDialog(null, "Cliente excluido!");
                    Log.getCurrentInstance().saveInLogFile("excluiu um cliente");
                } catch (Exception erro){
                    System.out.println("Oops, algo deu errado, consulte o arquivo de log para mais detalhes");
                    try {
                        Log.getCurrentInstance().saveStackTrace(erro);
                    } catch (Exception ex) {
                        System.out.println("Houveram erros: " + ex);
                    }
                }
                System.out.print("\n\nExcluindo cadastro de: \n\nId: "+ cliente.getId() 
                        + "\nNome: "+ cliente.getNome() 
                        + "\nNascimento: " + cliente.getNascimento()
                        + "\nCpf: " + cliente.getCpf()
                        + "\nEndereco: " + cliente.getEndereco()
                        + "\nTelefone: " + cliente.getTelefone()
                );
            }else{
                System.out.print("Nenhum cliente cadastrado");
            }
        }
    }


}
