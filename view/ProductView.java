package view;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import control.ProductControl;
import model.DataBaseConnect;
import model.ProductModel;
import model.TableModel;

public class ProductView implements ActionListener {
  private JFrame frame = new JFrame();
  private JLayeredPane layeredPane = new JLayeredPane();
  private JPanel contentPane = new JPanel();
  private JPanel registeredProductPanel = new JPanel();
  private JPanel productRegisterEditPanel = new JPanel();
  private JLabel registeredProductsLabel = new JLabel();
  private JScrollPane scrollPane = new JScrollPane();
  private TableModel table = new TableModel();
  private JButton registerButton = new JButton();
  private JButton editButton = new JButton();
  private JButton deleteButton = new JButton();
  private JButton addStockButton = new JButton();
  private JButton removeStockButton = new JButton();
  private JButton RegisterEditSaveButton = new JButton();
  private JButton backButton = new JButton();
  private JButton outButton = new JButton();
  private JLabel idLabel = new JLabel();
  private JLabel productLabel = new JLabel();
  private JTextField productTextField;
  private JLabel quantityLabel = new JLabel();
  private JSpinner quantitySpinner = new JSpinner();
  private JLabel priceLabel = new JLabel();
  private JLabel R$Label = new JLabel();
  private JTextField priceTextField = new JTextField();
  private TitledBorder border = new TitledBorder("");
  private JPanel borderRegisterEditPanel = new JPanel();
  private JLabel lblInformacaoDoProduto = new JLabel();
  private JButton backInfoButton = new JButton();

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
          ProductView frame = new ProductView();

        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public ProductView() {
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

    layeredPane.add(registeredProductPanel, "name_1115393068688");
    registeredProductPanel.setLayout(null);

    registeredProductsLabel.setText("Produtos Cadastrados");
    registeredProductsLabel.setBounds(230, 29, 245, 14);
    registeredProductPanel.add(registeredProductsLabel);

    scrollPane.setBounds(10, 59, 616, 302);
    registeredProductPanel.add(scrollPane);

    table.loadTable(connection);

    table.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int i = table.getSelectedRow();
        if (e.getClickCount() == 2) {
          System.out.println("Change panel to info");
          System.out.println(i);
          switchPanels(productInfoPanel);
        }
      }
    });

    scrollPane.setViewportView(table);

    registerButton.setToolTipText("Cadastrar novo produto");

    registerButton.setText("CADASTRAR");
    registerButton.setBounds(41, 422, 115, 23);
    registeredProductPanel.add(registerButton);
    editButton.setToolTipText("Editar produto");

    editButton.setText("EDITAR");;
    editButton.setBounds(182, 422, 115, 23);
    registeredProductPanel.add(editButton);
    deleteButton.setToolTipText("Deletar produto");

    deleteButton.setText("EXCLUIR");
    deleteButton.setBounds(320, 422, 115, 23);
    registeredProductPanel.add(deleteButton);

    addStockButton.setIcon(new ImageIcon("Icons/add2.png"));
    addStockButton.setToolTipText("adicionar estoque");

    addStockButton.setBounds(469, 422, 40, 23);
    registeredProductPanel.add(addStockButton);

    removeStockButton.setIcon(new ImageIcon("Icons/minus2.png"));
    removeStockButton.setToolTipText("revomer estoque");

    removeStockButton.setBounds(530, 422, 40, 23);
    registeredProductPanel.add(removeStockButton);

    outButton.setText("Sair");
    outButton.setBounds(10, 481, 89, 23);
    registeredProductPanel.add(outButton);

    layeredPane.add(productRegisterEditPanel, "name_1131935827357");
    productRegisterEditPanel.setLayout(null);
    borderRegisterEditPanel.setBounds(10, 30, 616, 291);

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

    layeredPane.add(productInfoPanel, "name_65529364681900");
    productInfoPanel.setLayout(null);

    lblInformacaoDoProduto.setText("Informacao do produto");
    lblInformacaoDoProduto.setBounds(265, 47, 129, 14);
    productInfoPanel.add(lblInformacaoDoProduto);

    backInfoButton.setText("VOLTAR");

    backInfoButton.setBounds(277, 467, 89, 23);
    productInfoPanel.add(backInfoButton);

    registerButton.addActionListener(this);
    editButton.addActionListener(this);
    backButton.addActionListener(this);
    deleteButton.addActionListener(this);
    addStockButton.addActionListener(this);
    removeStockButton.addActionListener(this);
    outButton.addActionListener(this);
    backInfoButton.addActionListener(this);

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  String statusSaveRegisterEditButton;
  private final JPanel productInfoPanel = new JPanel();

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

        idLabel.setText("Cod: " + table.getValueAt(i, 0).toString());
        productTextField.setText(table.getValueAt(i, 1).toString());
        quantitySpinner.setValue(table.getValueAt(i, 2));
        priceTextField.setText(table.getValueAt(i, 3).toString());

        switchPanels(productRegisterEditPanel);

      } else
        JOptionPane.showMessageDialog(null, "Selecione o produto que deseja editar", "",
            JOptionPane.WARNING_MESSAGE);
    }

    if (e.getSource().equals(deleteButton)) {
      int i = table.getSelectedRow();

      if (i >= 0) {
        ProductModel mod = new ProductModel();
        mod.setId((int) table.getValueAt(i, 0));
        ProductControl control = new ProductControl();
        control.deleteProduct(mod, connection);
        table.removeRow(i);
      } else
        JOptionPane.showMessageDialog(null, "Selecione o produto que deseja excluir", "",
            JOptionPane.WARNING_MESSAGE);
    }

    if (e.getSource().equals(RegisterEditSaveButton)) {

      if (statusSaveRegisterEditButton == "register") {
        if (productTextField.getText().isEmpty() || priceTextField.getText().isEmpty()) {
          JOptionPane.showMessageDialog(null, "Campos Vazios", "", JOptionPane.ERROR_MESSAGE);

        } else {

          ProductModel mod = new ProductModel();
          mod.setName(productTextField.getText());
          mod.setQuantity((int) quantitySpinner.getValue());
          mod.setPrice(priceTextField.getText());

          ProductControl control = new ProductControl();
          control.registerProduct(mod, connection);

          table.reloadTable(connection);
          switchPanels(registeredProductPanel);
        }

      } else {
        if (productTextField.getText().isEmpty() || priceTextField.getText().isEmpty()) {
          JOptionPane.showMessageDialog(null, "Campos Vazios", "", JOptionPane.ERROR_MESSAGE);

        } else {

          int i = table.getSelectedRow();

          ProductModel mod = new ProductModel();
          mod.setId((int) table.getValueAt(i, 0));
          mod.setName(productTextField.getText());
          mod.setQuantity((int) quantitySpinner.getValue());
          mod.setPrice(priceTextField.getText());

          ProductControl control = new ProductControl();
          control.editProduct(mod, connection);

          table.reloadTable(connection);
          switchPanels(registeredProductPanel);
        }
      }
    }

    if (e.getSource().equals(backButton)) {
      switchPanels(registeredProductPanel);
    }

    if (e.getSource().equals(addStockButton)) {

      int i = table.getSelectedRow();

      if (i >= 0) {
        int id = (int) table.getValueAt(i, 0);
        int num = Integer.parseInt(table.getValueAt(i, 2).toString());

        ProductModel mod = new ProductModel();
        mod.setId(id);
        mod.setQuantity(num);

        ProductControl control = new ProductControl();
        control.addStock(mod, connection);

        table.reloadTable(connection);
        table.setRowSelectionInterval(i, i);

      } else
        JOptionPane.showMessageDialog(null, "Escolha o produto para adicionar estoque", "",
            JOptionPane.WARNING_MESSAGE);
    }

    if (e.getSource().equals(removeStockButton)) {

      int i = table.getSelectedRow();

      if (i >= 0) {
        int id = (int) table.getValueAt(i, 0);
        int num = Integer.parseInt(table.getValueAt(i, 2).toString());

        ProductModel mod = new ProductModel();
        mod.setId(id);
        mod.setQuantity(num);

        ProductControl control = new ProductControl();
        control.removeStock(mod, connection);

        table.reloadTable(connection);
        table.setRowSelectionInterval(i, i);

      } else
        JOptionPane.showMessageDialog(null, "Escolha o produto para remover estoque", "",
            JOptionPane.WARNING_MESSAGE);
    }

    if (e.getSource().equals(outButton)) {
      connection.disconnect();
      System.exit(0);
    }

    if (e.getSource().equals(backInfoButton)) {
      switchPanels(registeredProductPanel);
    }
  }
}
