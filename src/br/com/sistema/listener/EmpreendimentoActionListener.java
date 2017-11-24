/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.listener;

import auxiliares.Log;
import br.com.sistema.DAO.EmpreendimentosDAO;
import br.com.sistema.cadastro.Empreendimento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import trabalhomdi.JInternalFrameEmpreendimentos;

/**
 *
 * @author ts
 */
public class EmpreendimentoActionListener  implements ActionListener{
    
    private final JInternalFrameEmpreendimentos janelaemp;

    public EmpreendimentoActionListener(JInternalFrameEmpreendimentos janela) {
        this.janelaemp = janela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if("salvar".equals(e.getActionCommand())) {
            Empreendimento empreendimento = janelaemp.getEmp();
            
            try{
                EmpreendimentosDAO novoEmpDAO = new EmpreendimentosDAO();
                novoEmpDAO.insert(empreendimento);
                Log.getCurrentInstance().saveInLogFile("salvou um empreendimento");
                JOptionPane.showMessageDialog(null, "Empreendimento salvo com sucesso!");
            } catch (Exception erro){
                    System.out.println("Oops, algo deu errado, consulte o arquivo de log para mais detalhes");
                    try {
                        Log.getCurrentInstance().saveStackTrace(erro);
                    } catch (Exception ex) {
                        System.out.println("Houveram erros: " + ex);
                    }
            }
            System.out.print("\nId: "+ empreendimento.getId() 
                    + "\nTitulo: "+ empreendimento.getTitulo() 
                    + "\nDescricao: " + empreendimento.getDescricao()
                    + "\nEndereco: " + empreendimento.getEndereco()
                    + "\nValor Aluguel: " + empreendimento.getValorAluguel()
                    + "\nValor Venda: " + empreendimento.getValorVenda()
                    + "\nContato: " + empreendimento.getContato()
            );
            
        }
        
        if("excluir".equals(e.getActionCommand())) {
            Empreendimento empreendimento = janelaemp.getEmp();
            if(empreendimento != null){
                try{
                    EmpreendimentosDAO excluirEmpDAO = new EmpreendimentosDAO();
                    excluirEmpDAO.delete(empreendimento);
                    JOptionPane.showMessageDialog(null, "Cliente excluido!");
                    Log.getCurrentInstance().saveInLogFile("excluiu um empreendimento");
                } catch (Exception erro){
                    System.out.println("Oops, algo deu errado, consulte o arquivo de log para mais detalhes");
                    try {
                        Log.getCurrentInstance().saveStackTrace(erro);
                    } catch (Exception ex) {
                        System.out.println("Houveram erros: " + ex);
                    }
                }

                System.out.print("\n\nExcluindo cadastro de:" + 
                        "\n\nId: "+ empreendimento.getId() 
                        + "\nTitulo: "+ empreendimento.getTitulo() 
                        + "\nDescricao: " + empreendimento.getDescricao()
                        + "\nEndereco: " + empreendimento.getEndereco()
                        + "\nValor Aluguel: " + empreendimento.getValorAluguel()
                        + "\nValor Venda: " + empreendimento.getValorVenda()
                        + "\nContato: " + empreendimento.getContato()
                );
            }else{
                System.out.print("Nenhum empreendimento cadastrado");
            }
        }   
    }
}
