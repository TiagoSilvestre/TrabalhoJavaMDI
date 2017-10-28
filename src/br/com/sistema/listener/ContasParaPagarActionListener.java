/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.listener;

import auxiliares.Log;
import br.com.sistema.cadastro.ContasParaPagar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import trabalhomdi.JInternalFrameContasParaPagar;

/**
 *
 * @author ts
 */
public class ContasParaPagarActionListener implements ActionListener{

    private final JInternalFrameContasParaPagar janelaContasParaPagar;
    ContasParaPagar contasParaPagar = null;
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if("salvar".equals(e.getActionCommand())) {
           this.contasParaPagar = janelaContasParaPagar.getContasParaPagar();
           try{
                Log.getCurrentInstance().saveInLogFile("salvou uma conta para pagar");
            } catch (Exception erro){
                System.out.print(erro); 
            }

            System.out.print("\nId: "+ contasParaPagar.getDescricao() 
                    + "\nNome: "+ contasParaPagar.getValor() 
                    + "\nNascimento: " + contasParaPagar.getVencimento()
            );
        }
        
        if("excluir".equals(e.getActionCommand())) {
            if(this.contasParaPagar != null){
                try{
                    Log.getCurrentInstance().saveInLogFile("excluiu uma conta para pagar");
                } catch (Exception erro){
                    System.out.print(erro); 
                }
                System.out.print("\n\nExcluindo cadastro de: \n\nId: "+ this.contasParaPagar.getDescricao() 
                        + "\nNome: "+ this.contasParaPagar.getValor() 
                        + "\nNascimento: " + this.contasParaPagar.getVencimento()
                );
            }else{
                System.out.print("Nenhum cliente cadastrado");
            }
        }
        
      
    }

    public ContasParaPagarActionListener(JInternalFrameContasParaPagar janela) {
        this.janelaContasParaPagar = janela;
    }

}
