/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.listener;

import auxiliares.Log;
import auxiliares.Tratamentos;
import br.com.sistema.DAO.ContasParaPagarDAO;
import br.com.sistema.cadastro.ContasParaPagar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import trabalhomdi.JInternalFrameContasParaPagar;

/**
 *
 * @author ts
 */
public class ContasParaPagarActionListener implements ActionListener{

    private final JInternalFrameContasParaPagar janelaContasParaPagar;
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if("salvar".equals(e.getActionCommand())) {
            ContasParaPagar contasParaPagar = janelaContasParaPagar.getContasParaPagar();
            try {    
                ContasParaPagarDAO novoContaParaPagarDAO = new ContasParaPagarDAO();
                novoContaParaPagarDAO.insert(contasParaPagar);
                JOptionPane.showMessageDialog(null, "Conta para pagar salvo com sucesso!");
            }catch(Tratamentos t){
               JOptionPane.showMessageDialog(null, t.getMessage());
            }
           try{
                Log.getCurrentInstance().saveInLogFile("salvou uma conta para pagar");
            } catch (Exception erro){
                System.out.println("Oops, algo deu errado, consulte o arquivo de log para mais detalhes");
                try {
                    Log.getCurrentInstance().saveStackTrace(erro);
                } catch (Exception ex) {
                    System.out.println("Houveram erros: " + ex);
                }
            }

            System.out.print("\nDescricao: "+ contasParaPagar.getDescricao() 
                    + "\nValor: "+ contasParaPagar.getValor() 
                    + "\nVencimento: " + contasParaPagar.getVencimento()
            );
        }
        
        if("excluir".equals(e.getActionCommand())) {
            ContasParaPagar contasParaPagar = janelaContasParaPagar.getContasParaPagar();
            if(contasParaPagar != null){
                try{
                    ContasParaPagarDAO excluirContaParaPagarDAO = new ContasParaPagarDAO();
                    excluirContaParaPagarDAO.delete(contasParaPagar);
                    JOptionPane.showMessageDialog(null, "Conta excluida!");
                    Log.getCurrentInstance().saveInLogFile("excluiu uma conta para pagar");
                } catch (IOException erro){
                    System.out.println("Oops, algo deu errado, consulte o arquivo de log para mais detalhes");
                    try {
                        Log.getCurrentInstance().saveStackTrace(erro);
                    } catch (Exception ex) {
                        System.out.println("Houveram erros: " + ex);
                    }
                } catch (Tratamentos ex) {
                    Logger.getLogger(ContasParaPagarActionListener.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.print("\n\nExcluindo cadastro de: \n\nDescricao: "+ contasParaPagar.getDescricao() 
                        + "\nValor: "+ contasParaPagar.getValor() 
                        + "\nVencimento: " + contasParaPagar.getVencimento()
                );
            }else{
                System.out.print("Nenhuma conta cadastrada");
            }
        }
        
      
    }

    public ContasParaPagarActionListener(JInternalFrameContasParaPagar janela) {
        this.janelaContasParaPagar = janela;
    }

}
