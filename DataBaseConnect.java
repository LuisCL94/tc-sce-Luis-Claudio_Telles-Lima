import java.sql.*;
// import java.util.logging.Logger;

import javax.swing.JOptionPane;

// para conectar com outro banco de dados so sera preciso trocar os valore das variaveis declarados com privados
public class DataBaseConnect {
    public Statement stm; // responsavel por prepara e realizar pesquisas no banco de dados
    public ResultSet rs; // responsavel por armazenar o resultado de uma pesquisa passada para o statment
    private String driver = "org.postgresql.Driver"; // responsvel por identificar o serviço de banco de dados
    private String path = "jdbc:postgresql://localhost:5432/stockcontrolsystem"; //responsavel por setar o local do banco de dados
    private String user = "postgres";
    private String password = "luisclaudio";
    public Connection conn; // reponsavel por realizar a conexao com o banco de dados

    public void connect()  { 
        try {
            System.setProperty("jdbc.Drivers", driver); // Seta a propriedade do driver de conexão;
            conn = DriverManager.getConnection(path, user, password); // Realiza a conexão com o banco;
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!", "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão!\nERRO: " + ex.getMessage(), "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        }
    } 
    
    public void disconnect()  { //metodo para fechar a conexao com o banco de dados
        try {
            conn.close(); //fecha a conexao
            JOptionPane.showMessageDialog(null, "Conexão fechada com sucesso!", "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\nERRO: " + ex.getMessage(), "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

