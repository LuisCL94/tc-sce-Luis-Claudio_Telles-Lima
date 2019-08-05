import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Product implements ActionListener {
  private JFrame frame = new JFrame();
  private JLayeredPane layeredPane = new JLayeredPane();
  private JPanel contentPane = new JPanel();
  private JPanel stockViewPanel = new JPanel();
  private JPanel productRegisterEditPanel = new JPanel();
  private JLabel lblSistemaDeControle = new JLabel();
  private JScrollPane scrollPane = new JScrollPane();
  private JTable table = new JTable();
  private DefaultTableModel model = new DefaultTableModel();
  private JButton registerButton = new JButton();
  private JButton editButton = new JButton();
  private JButton deleteButton = new JButton();
  private JButton addStockButton = new JButton();
  private JButton removeStockButton = new JButton();
  private JButton updateProductStockButton = new JButton();
  private JButton RegisterEditSaveButton = new JButton();
  private JButton backButton = new JButton();
  private JButton outButton = new JButton();
  private JLabel idLabel = new JLabel();
  private JLabel productLabel = new JLabel();
  private JTextField productTextField;
  private JLabel quantityLabel = new JLabel();
  private JSpinner quantitySpinner = new JSpinner();
  private JLabel priceLabel = new JLabel();
  private final JLabel R$Label = new JLabel();
  private JTextField priceTextField = new JTextField();
  private TitledBorder border = new TitledBorder("");
  private JPanel borderRegisterEditPanel = new JPanel();

  DataBaseConnect connection = new DataBaseConnect();

  public void switchPanels(JPanel panel) {
    layeredPane.removeAll();
    layeredPane.add(panel);
    layeredPane.repaint();
    layeredPane.revalidate();
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Product frame = new Product();

        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public Product() {
    connection.connect();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(100, 100, 652, 554);
    frame.setTitle("Sistema de Controle de Estoque");
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    frame.setContentPane(contentPane);
    contentPane.setLayout(null);

    layeredPane.setBounds(0, 0, 636, 515);
    contentPane.add(layeredPane);
    layeredPane.setLayout(new CardLayout(0, 0));

    layeredPane.add(stockViewPanel, "name_1115393068688");
    stockViewPanel.setLayout(null);

    lblSistemaDeControle.setText("Produtos Cadastrados");
    lblSistemaDeControle.setBounds(230, 29, 245, 14);
    stockViewPanel.add(lblSistemaDeControle);

    scrollPane.setBounds(10, 59, 616, 302);
    stockViewPanel.add(scrollPane);

    Object[] columns = {"ID", "Produto", "Estoque", "R$ Preco Unitario"};
    model.setColumnIdentifiers(columns);
    table.setDefaultEditor(Object.class, null);
    table.setFocusable(false);
    table.setModel(model);

    DefaultTableCellRenderer renderer =
        (DefaultTableCellRenderer) table.getDefaultRenderer(Object.class);
    renderer.setHorizontalAlignment(SwingConstants.CENTER);

    scrollPane.setViewportView(table);

    registerButton.setToolTipText("Cadastrar novo produto");

    registerButton.setText("CADASTRAR");
    registerButton.setBounds(41, 422, 115, 23);
    stockViewPanel.add(registerButton);
    editButton.setToolTipText("Editar produto");

    editButton.setText("EDITAR");;
    editButton.setBounds(182, 422, 115, 23);
    stockViewPanel.add(editButton);
    deleteButton.setToolTipText("Deletar produto");

    deleteButton.setText("EXCLUIR");
    deleteButton.setBounds(320, 422, 115, 23);
    stockViewPanel.add(deleteButton);

    addStockButton.setIcon(new ImageIcon("Icons/add2.png"));
    addStockButton.setToolTipText("adicionar estoque");

    addStockButton.setBounds(470, 413, 55, 23);
    stockViewPanel.add(addStockButton);

    removeStockButton.setIcon(new ImageIcon("Icons/minus2.png"));
    removeStockButton.setToolTipText("revomer estoque");

    removeStockButton.setBounds(530, 413, 55, 23);
    stockViewPanel.add(removeStockButton);
    updateProductStockButton.setToolTipText("Atualizar estoque");

    updateProductStockButton.setText("SALVAR");
    updateProductStockButton.setBounds(470, 443, 115, 23);
    stockViewPanel.add(updateProductStockButton);

    outButton.setText("Sair");
    outButton.setBounds(10, 481, 89, 23);
    stockViewPanel.add(outButton);

    layeredPane.add(productRegisterEditPanel, "name_1131935827357");
    productRegisterEditPanel.setLayout(null);
    borderRegisterEditPanel.setBounds(12, 30, 628, 291);

    productRegisterEditPanel.add(borderRegisterEditPanel);

    border.setTitleJustification(TitledBorder.CENTER);
    border.setTitlePosition(TitledBorder.TOP);

    borderRegisterEditPanel.setBorder(border);
    borderRegisterEditPanel.setLayout(null);
    R$Label.setText("R$");
    R$Label.setBounds(289, 203, 32, 15);
    borderRegisterEditPanel.add(R$Label);
    priceTextField.setBounds(310, 200, 114, 20);
    borderRegisterEditPanel.add(priceTextField);
    priceTextField.setColumns(10);
    quantitySpinner.setBounds(145, 200, 87, 20);
    borderRegisterEditPanel.add(quantitySpinner);
    quantitySpinner.setModel(new SpinnerNumberModel(0, 0, 9999, 1));

    productTextField = new JTextField();
    productTextField.setBounds(145, 114, 279, 20);
    borderRegisterEditPanel.add(productTextField);
    productTextField.setColumns(10);
    productLabel.setBounds(145, 94, 243, 15);
    borderRegisterEditPanel.add(productLabel);

    productLabel.setText("Produto");
    idLabel.setBounds(227, 45, 70, 15);
    borderRegisterEditPanel.add(idLabel);
    priceLabel.setBounds(310, 180, 112, 15);
    borderRegisterEditPanel.add(priceLabel);
    priceLabel.setText("Preco Unitario");
    quantityLabel.setBounds(145, 180, 98, 15);
    borderRegisterEditPanel.add(quantityLabel);

    quantityLabel.setText("Quantidade");

    RegisterEditSaveButton.setText("SALVAR");
    RegisterEditSaveButton.setBounds(255, 374, 117, 25);
    productRegisterEditPanel.add(RegisterEditSaveButton);
    RegisterEditSaveButton.addActionListener(this);

    backButton.setText("VOLTAR");
    backButton.setBounds(255, 419, 117, 25);
    productRegisterEditPanel.add(backButton);

    registerButton.addActionListener(this);
    editButton.addActionListener(this);
    backButton.addActionListener(this);
    deleteButton.addActionListener(this);
    addStockButton.addActionListener(this);
    removeStockButton.addActionListener(this);
    updateProductStockButton.addActionListener(this);
    outButton.addActionListener(this);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  String statusSaveRegisterEditButton;

  public void actionPerformed(ActionEvent e) {

    if (e.getSource().equals(registerButton)) {
      statusSaveRegisterEditButton = "register";
      idLabel.setText("");
      border.setTitle("Cadastro de Produto");
      productTextField.setText(null);
      quantitySpinner.setValue(0);
      priceTextField.setText(null);

      switchPanels(productRegisterEditPanel);
    }

    if (e.getSource().equals(editButton)) {

      statusSaveRegisterEditButton = "edit";
      int i = table.getSelectedRow();

      if (i >= 0) {
        border.setTitle("Edicao de Produto");

        idLabel.setText("Cod: " + model.getValueAt(i, 0).toString());
        productTextField.setText(model.getValueAt(i, 1).toString());
        quantitySpinner.setValue(model.getValueAt(i, 2));
        priceTextField.setText(model.getValueAt(i, 3).toString());

        switchPanels(productRegisterEditPanel);

      } else
        JOptionPane.showMessageDialog(null, "Selecione o produto que deseja editar", "",
            JOptionPane.WARNING_MESSAGE);
    }

    if (e.getSource().equals(deleteButton)) {
      int i = table.getSelectedRow();

      if (i >= 0) {
        PreparedStatement pst;
        try {
          pst = connection.conn.prepareStatement("delete from products where product_name=?");
          pst.setString(1, (String) model.getValueAt(i, 1));
          pst.execute();
          JOptionPane.showMessageDialog(null,
              (String) model.getValueAt(i, 1) + "excluido com sucesso!", "Banco de Dados",
              JOptionPane.INFORMATION_MESSAGE);
          model.removeRow(i);
        } catch (SQLException e1) {
          JOptionPane.showMessageDialog(null, "Erro ao executar SQL\nERRO: " + e1.getMessage(),
              "Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }

      } else
        JOptionPane.showMessageDialog(null, "Selecione o produto que deseja excluir", "",
            JOptionPane.WARNING_MESSAGE);
    }

    if (e.getSource().equals(RegisterEditSaveButton)) {
      // int value = Integer.parseInt(priceTextField.getText());
      // int stock = (Integer)quantitySpinner.getValue();
      // int result = value * stock;


      if (statusSaveRegisterEditButton == "register") {
        if (productTextField.getText().isEmpty() || priceTextField.getText().isEmpty()) {
          JOptionPane.showMessageDialog(null, "Campos Vazios", "", JOptionPane.ERROR_MESSAGE);
        } else {
          try {
            PreparedStatement pst = connection.conn.prepareStatement(
                "insert into products (product_name,product_stock,product_price)values(?,?,?)");
            pst.setString(1, productTextField.getText());
            pst.setInt(2, (int) quantitySpinner.getValue());
            pst.setString(3, priceTextField.getText());
            pst.execute();
            int i = table.getSelectedRow();

            JOptionPane.showMessageDialog(null, "Cadastro de produto realizado", "Banco de Dados",
                JOptionPane.INFORMATION_MESSAGE);

            connection.runSQL("select * from products");
            connection.rs.last();

            Object[] row = {connection.rs.getInt("product_id"), productTextField.getText(),
                quantitySpinner.getValue(), priceTextField.getText()};
            model.addRow(row);

            switchPanels(stockViewPanel);
          } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "" + e1, "", JOptionPane.ERROR_MESSAGE);
          }
        }
      } else {

        try {

          PreparedStatement pst = connection.conn.prepareStatement(
              "update products set product_name=?, product_stock=?, product_price=? where product_id=?");
          pst.setString(1, productTextField.getText());
          pst.setInt(2, (int) quantitySpinner.getValue());
          pst.setString(3, priceTextField.getText());
          pst.setInt(4, connection.rs.getInt("product_id"));
          pst.execute();
          JOptionPane.showMessageDialog(null, "Produto " + "editado com sucesso!", "Banco de Dados",
              JOptionPane.INFORMATION_MESSAGE);

          int i = table.getSelectedRow();

          model.setValueAt(productTextField.getText(), i, 1);
          model.setValueAt(quantitySpinner.getValue(), i, 2);
          model.setValueAt(priceTextField.getText(), i, 3);

          switchPanels(stockViewPanel);
        } catch (SQLException e1) {
          JOptionPane.showMessageDialog(null,
              "Erro na edicao do produto!\nERRO: " + e1.getMessage(), "Banco de Dados",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    }

    if (e.getSource().equals(backButton)) {
      switchPanels(stockViewPanel);
    }

    if (e.getSource().equals(addStockButton)) {
      int i = table.getSelectedRow();
      if (i >= 0) {
        int num = Integer.parseInt(model.getValueAt(i, 2).toString());
        model.setValueAt(++num, i, 2);
      } else
        JOptionPane.showMessageDialog(null, "Escolha o produto para adicionar estoque", "",
            JOptionPane.WARNING_MESSAGE);
    }

    if (e.getSource().equals(removeStockButton)) {
      int i = table.getSelectedRow();

      if (i >= 0) {
        int num = Integer.parseInt(model.getValueAt(i, 2).toString());
        if (num >= 1)
          model.setValueAt(--num, i, 2);
      } else
        JOptionPane.showMessageDialog(null, "Escolha o produto para dar baixa em estoque", "",
            JOptionPane.WARNING_MESSAGE);
    }
    if (e.getSource().equals(updateProductStockButton)) {
      // verificar primeiramente se ouve alteracao do banco de dados (verificar se os valores de
      // estoque na tabela estao diferentes do qu esta no banco)
      JOptionPane.showMessageDialog(null, "Estoque de produtos atualizado!", "",
          JOptionPane.INFORMATION_MESSAGE);
    }
    if (e.getSource().equals(outButton)) {
      connection.disconnect();
      System.exit(0);
    }
  }
}
