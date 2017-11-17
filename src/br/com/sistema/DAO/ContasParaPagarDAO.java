/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.DAO;

import auxiliares.Conexao;
import auxiliares.Tratamentos;
import br.com.sistema.cadastro.Cliente;
import br.com.sistema.cadastro.ContasParaPagar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ts
 */
public class ContasParaPagarDAO {
        
    public void insert(ContasParaPagar contasParaPagar) throws Tratamentos {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "insert into ContasParaPagar (id, descricao, valor, vencimento) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, contasParaPagar.getId());
            ps.setString(2, contasParaPagar.getDescricao());
            ps.setString(3, contasParaPagar.getValor());
            ps.setString(4, contasParaPagar.getVencimento());

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
    
    public void delete(Cliente cliente) throws Tratamentos {
        Connection conn = null;
        PreparedStatement ps = null;
        System.out.println("Entrou Delete");
        try {
            conn = Conexao.getConnection();
            String sql = "delete from ContasParaPagar where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getId());
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
