import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DataBaseConnect {
  public Statement stm;
  public ResultSet rs;
  private String driver = "org.postgresql.Driver";
  private String path = "jdbc:postgresql://localhost:5432/stockcontrolsystem";
  private String user = "postgres";
  private String password = "luisclaudio";
  public Connection conn;

  public void connect() {
    try {
      System.setProperty("jdbc.Drivers", driver);
      conn = DriverManager.getConnection(path, user, password);
      JOptionPane.showMessageDialog(null, "Conectado com sucesso!", "Banco de Dados",
          JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro de conexao!\nERRO: " + ex.getMessage(),
          "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void disconnect() {
    try {
      conn.close();
      JOptionPane.showMessageDialog(null, "Conexao fechada com sucesso!", "Banco de Dados",
          JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao fechar a conexao!\nERRO: " + ex.getMessage(),
          "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void runSQL(String sql) {
    try {
      stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
      rs = stm.executeQuery(sql);
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, "Erro ao executar SQL\nERRO: " + e.getMessage(),
          "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void fill(TableModel table) {
    runSQL("select * from products order by product_id");
    try {
      rs.first();
      do {
        table.addRow(rs.getInt("product_id"), rs.getString("product_name"),
            rs.getInt("product_stock"), rs.getString("product_price"));
      } while (rs.next());
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "ERRO ao preecher Arr " + ex, "",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  public void refill(TableModel table) {
    int rowCount = table.getRowCount();
    for (int i = rowCount - 1; i >= 0; i--) {
      table.removeRow(i);
    }
    this.fill(table);
  }
}

