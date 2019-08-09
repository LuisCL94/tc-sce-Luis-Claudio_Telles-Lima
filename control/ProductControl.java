package control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.DataBaseConnect;
import model.ProductModel;

public class ProductControl {

  public void registerProduct(ProductModel product, DataBaseConnect connection) {
    try {

      PreparedStatement pst = connection.conn.prepareStatement(
          "insert into products (product_name,product_stock,product_price)values(?,?,?)");
      pst.setString(1, product.getName());
      pst.setInt(2, product.getQuantity());
      pst.setString(3, product.getPrice());
      pst.execute();

      JOptionPane.showMessageDialog(null, "Cadastro de produto realizado", "Banco de Dados",
          JOptionPane.INFORMATION_MESSAGE);

    } catch (SQLException e1) {
      JOptionPane.showMessageDialog(null, "" + e1, "", JOptionPane.ERROR_MESSAGE);
    }

  }

  public void editProduct(ProductModel product, DataBaseConnect connection) {
    try {

      PreparedStatement pst = connection.conn.prepareStatement(
          "update products set product_name=?, product_stock=?, product_price=? where product_id=?");
      pst.setString(1, product.getName());
      pst.setInt(2, product.getQuantity());
      pst.setString(3, product.getPrice());
      pst.setInt(4, product.getId());
      pst.execute();

      JOptionPane.showMessageDialog(null,
          "Produto " + Integer.toString(product.getId()) + " editado com sucesso!",
          "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);

    } catch (SQLException e1) {
      JOptionPane.showMessageDialog(null, "Erro na edicao do produto!\nERRO: " + e1.getMessage(),
          "Banco de Dados", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void deleteProduct(ProductModel product, DataBaseConnect connection) {
    try {

      PreparedStatement pst =
          connection.conn.prepareStatement("delete from products where product_id=?");
      pst.setInt(1, product.getId());
      pst.execute();

      JOptionPane.showMessageDialog(null,
          "Produto " + Integer.toString(product.getId()) + " excluido com sucesso!",
          "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);

    } catch (SQLException e1) {
      JOptionPane.showMessageDialog(null,
          "Erro ao deletar do banco de dados SQL\nERRO: " + e1.getMessage(), "Banco de Dados",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  public void viewProduct(ProductModel product, DataBaseConnect connection) {

  }

  public void addStock(ProductModel product, DataBaseConnect connection) {

    int num = product.getQuantity();

    try {

      PreparedStatement pst = connection.conn
          .prepareStatement("update products set product_stock=? where product_id=?");
      pst.setInt(1, ++num);
      pst.setInt(2, product.getId());
      pst.execute();

    } catch (SQLException e1) {
      JOptionPane.showMessageDialog(null, "Erro ao adicionar estoque ao\nERRO: " + e1.getMessage(),
          "", JOptionPane.ERROR_MESSAGE);
    }

  }

  public void removeStock(ProductModel product, DataBaseConnect connection) {
    int num = product.getQuantity();

    try {

      PreparedStatement pst = connection.conn
          .prepareStatement("update products set product_stock=? where product_id=?");
      pst.setInt(1, --num);
      pst.setInt(2, product.getId());
      pst.execute();

    } catch (SQLException e1) {
      JOptionPane.showMessageDialog(null, "Erro ao remover estoque ao\nERRO: " + e1.getMessage(),
          "", JOptionPane.ERROR_MESSAGE);
    }

  }
}
