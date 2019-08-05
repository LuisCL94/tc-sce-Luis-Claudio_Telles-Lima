import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
  private ArrayList rows = null;
  private String[] columns = null;

  public TableModel(ArrayList row, String[] col) {
    setRows(row);
    setColums(columns);
  }

  public ArrayList getRows() {
    return rows;
  }

  public void setRows(ArrayList data) {
    rows = data;
  }

  public String[] getColumns() {
    return columns;
  }

  public void setColums(String[] names) {
    columns = names;
  }

  public int getRowCount() {
    return rows.size();
  }

  public int getColumnCount() {
    return columns.length;
  }

  public String getColumnName(int numCol) {
    return columns[numCol];
  }

  public Object getValueAt(int numRow, int numCol) {
    Object[] row = (Object[]) getRows().get(numRow);
    return row[numCol];
  }
}
