import java.sql.*;
// import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class DataBaseConnect {
    public Statement stm;
    public ResultSet rs; 
    private String driver = "org.postgresql.Driver";
    private String path = "jdbc:postgresql://localhost:5432/stockcontrolsystem"; 
    private String user = "postgres";
    private String password = "luisclaudio";
    public Connection conn; 

    public void connect()  { 
        try {
            System.setProperty("jdbc.Drivers", driver); 
            conn = DriverManager.getConnection(path, user, password); 
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!", "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexao!\nERRO: " + ex.getMessage(), "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        }
    } 
    
    public void disconnect()  { 
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "Conexao fechada com sucesso!", "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexao!\nERRO: " + ex.getMessage(), "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

