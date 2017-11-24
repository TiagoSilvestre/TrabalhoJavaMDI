/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.DAO;

import auxiliares.Conexao;
import auxiliares.Tratamentos;
import br.com.sistema.cadastro.Empreendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ts
 */
public class EmpreendimentosDAO {
      
    public void insert(Empreendimento empreendimento) throws Tratamentos {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = Conexao.getConnection();
            String sql = "insert into Empreendimentos (id, titulo , valorAluguel, valorVenda, endereco, descricao, contato) values(?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, empreendimento.getId());
            ps.setString(2, empreendimento.getTitulo());
            ps.setString(3, empreendimento.getEndereco());
            ps.setString(4, empreendimento.getValorAluguel());
            ps.setString(5, empreendimento.getValorVenda());
            ps.setString(6, empreendimento.getContato());
            ps.setString(7, empreendimento.getDescricao());
            ps.execute();

            conn.commit();

        } catch(SQLException e) {
            System.out.println("ERRO: " + e.getMessage());

            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
    }
    
    public void delete(Empreendimento empreendimento) throws Tratamentos {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = Conexao.getConnection();
            String sql = "delete from Empreendimentos where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, empreendimento.getId());
            ps.execute();

            conn.commit();
        } catch(SQLException e) {
            System.out.println("ERRO: " + e.getMessage());

            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }


        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
    }    
    
}
