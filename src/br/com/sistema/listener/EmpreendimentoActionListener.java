/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.listener;

import auxiliares.Log;
import br.com.sistema.cadastro.Empreendimento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import trabalhomdi.JInternalFrameEmpreendimentos;

/**
 *
 * @author ts
 */
public class EmpreendimentoActionListener  implements ActionListener{
    
    private final JInternalFrameEmpreendimentos janelaemp;
    Empreendimento emp = null;

    public EmpreendimentoActionListener(JInternalFrameEmpreendimentos janela) {
        this.janelaemp = janela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if("salvar".equals(e.getActionCommand())) {
            this.emp = janelaemp.getEmp();
            
            try{
                Log.getCurrentInstance().saveInLogFile("salvou um empreendimento");
            } catch (Exception erro){
                System.out.print(erro); 
            }
            System.out.print("\nId: "+ emp.getId() 
                    + "\nTitulo: "+ emp.getTitulo() 
                    + "\nDescricao: " + emp.getDescricao()
                    + "\nEndereco: " + emp.getEndereco()
                    + "\nValor Aluguel: " + emp.getValorAluguel()
                    + "\nValor Venda: " + emp.getValorVenda()
                    + "\nContato: " + emp.getContato()
            );
            
        }
        
        if("excluir".equals(e.getActionCommand())) {
            if(this.emp != null){
                try{
                    Log.getCurrentInstance().saveInLogFile("excluiu um empreendimento");
                } catch (Exception erro){
                    System.out.print(erro); 
                }

                System.out.print("\n\nExcluindo cadastro de:" + 
                        "\n\nId: "+ emp.getId() 
                        + "\nTitulo: "+ emp.getTitulo() 
                        + "\nDescricao: " + emp.getDescricao()
                        + "\nEndereco: " + emp.getEndereco()
                        + "\nValor Aluguel: " + emp.getValorAluguel()
                        + "\nValor Venda: " + emp.getValorVenda()
                        + "\nContato: " + emp.getContato()
                );
            }else{
                System.out.print("Nenhum empreendimento cadastrado");
            }
        }   
    }
}
