package model;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TableModel extends JTable {

  private DefaultTableModel model = new DefaultTableModel();

  public TableModel() {
    Object[] columns = {"ID", "Produto", "Estoque", "R$ Preco Unitario"};
    model.setColumnIdentifiers(columns);
    setDefaultEditor(Object.class, null);
    setFocusable(false);
    setModel(model);
    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) getDefaultRenderer(Object.class);
    renderer.setHorizontalAlignment(SwingConstants.CENTER);
  }

  public void addRow(Object id, Object product, Object estoque, Object preco) {
    Object[] row = {id, product, estoque, preco};
    model.addRow(row);
  }

  public void removeRow(int i) {
    model.removeRow(i);
  }

  public int getRowCount() {
    return model.getRowCount();
  }

  public Object getValueAt(int i, int j) {
    return model.getValueAt(i, j);
  }

  public void loadTable(DataBaseConnect connection) {
    connection.runSQL("select * from products order by product_id");
    try {
      connection.rs.first();
      do {
        this.addRow(connection.rs.getInt("product_id"), connection.rs.getString("product_name"),
            connection.rs.getInt("product_stock"), connection.rs.getString("product_price"));
      } while (connection.rs.next());
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "ERRO ao preecher Arr " + ex, "",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  public void reloadTable(DataBaseConnect connection) {
    int rowCount = this.getRowCount();
    for (int i = rowCount - 1; i >= 0; i--) {
      this.removeRow(i);
    }
    this.loadTable(connection);
  }


}

