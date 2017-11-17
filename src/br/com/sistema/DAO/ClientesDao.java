/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.DAO;

import auxiliares.Conexao;
import auxiliares.Tratamentos;
import br.com.sistema.cadastro.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ts
 */
public class ClientesDao {
    
    public void insert(Cliente cliente) throws Tratamentos {
        Connection conn = null;
        PreparedStatement ps = null;
        System.out.println("Entroy");
        try {
            conn = Conexao.getConnection();
            String sql = "insert into clientes (id, nome, nascimento, cpf, endereco, telefone) values(?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getId());
            ps.setString(2, cliente.getNascimento());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getTelefone());
            ps.setString(5, cliente.getTelefone());
            ps.setString(6, cliente.getTelefone());
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
