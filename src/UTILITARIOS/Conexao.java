/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTILITARIOS;

import java.sql.*;
import javax.swing.*;

public class Conexao {

    private final String url = "jdbc:mysql://localhost:3306/agendamento";
    private final String driver = "com.mysql.cj.jdbc.Driver"; // Driver atualizado
    private final String usuario = "root"; // Usuário padrão do XAMPP
    private final String senha = "";       // Senha padrão do XAMPP (geralmente em branco)
    private Connection conexao;
    public Statement statement;
    public ResultSet resultset;

    public void conecta() {
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            JOptionPane.showMessageDialog(null, "Conectado com sucesso ao banco de dados!");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver não localizado: " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com MySQL: " + e.getMessage());
        }
    }

    public void desconecta() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                JOptionPane.showMessageDialog(null, "Conexão encerrada!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
        }
    }

    public void executaSQL(String sql) {
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar SQL: " + e.getMessage() + "\nComando: " + sql);
        }
    }

    public Connection getConexao() {
        return conexao;
    }
    
}


