import javax.swing.*;
import javax.swing.event.*; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
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
	private JLabel idLabel = new JLabel();
	private JTextField idTextField;
  private JLabel productLabel = new JLabel();
	private JTextField productTextField;
	private JLabel quantityLabel = new JLabel();
	private JSpinner quantitySpinner = new JSpinner();
	private JLabel priceLabel = new JLabel();
	private JTextField priceTextField = new JTextField();
	private TitledBorder border = new TitledBorder("");
	private JPanel borderRegisterEditPanel = new JPanel();
	
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
		priceTextField.setBounds(306, 183, 114, 20);
		priceTextField.setColumns(10);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 652, 554);
		frame.setTitle("Sistema de Controle de Estoque");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane.setBounds(0, 0, 652, 515);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		layeredPane.add(stockViewPanel, "name_1115393068688");
		stockViewPanel.setLayout(null);
		
		lblSistemaDeControle.setText("Produtos Cadastrados");
		lblSistemaDeControle.setBounds(230, 29, 245, 14);
		stockViewPanel.add(lblSistemaDeControle);
		
		scrollPane.setBounds(10, 59, 632, 302);
		stockViewPanel.add(scrollPane);
		
    Object[] columns = {"ID", "Produto", "Quantidade em Estoque", "Preco Unitario"};
    model.setColumnIdentifiers(columns);
    table.setDefaultEditor(Object.class, null);
		table.setFocusable(false);
    table.setModel(model);
    scrollPane.setViewportView(table);

		registerButton.setToolTipText("Cadastrar novo produto");
		
		registerButton.setText("CADASTRAR"); 
		registerButton.setBounds(71, 419, 115, 23);
		stockViewPanel.add(registerButton);
		editButton.setToolTipText("Editar produto");
		
		editButton.setText("EDITAR");;
		editButton.setBounds(212, 419, 115, 23);
		stockViewPanel.add(editButton);
		deleteButton.setToolTipText("Deletar produto");
		
		deleteButton.setText("EXCLUIR");
		deleteButton.setBounds(350, 419, 115, 23);
		stockViewPanel.add(deleteButton);
		addStockButton.setIcon(new ImageIcon("Icons/add2.png"));
		addStockButton.setToolTipText("adicionar estoque");
		
		addStockButton.setBounds(500, 410, 55, 23);
		stockViewPanel.add(addStockButton);
		removeStockButton.setIcon(new ImageIcon("Icons/minus2.png"));
		removeStockButton.setToolTipText("revomer estoque");
		
		removeStockButton.setBounds(560, 410, 55, 23);
		stockViewPanel.add(removeStockButton);
		updateProductStockButton.setToolTipText("Atualizar estoque");
		
		updateProductStockButton.setText("SALVAR");
		updateProductStockButton.setBounds(500, 440, 115, 23);
		stockViewPanel.add(updateProductStockButton);
		
		layeredPane.add(productRegisterEditPanel, "name_1131935827357");
		productRegisterEditPanel.setLayout(null);
		
		RegisterEditSaveButton.setText("SALVAR");
		RegisterEditSaveButton.setBounds(255, 374, 117, 25);
		productRegisterEditPanel.add(RegisterEditSaveButton);
		
		idLabel.setBounds(110, 94, 70, 15);
		idLabel.setText("Codigo:");
		
		productRegisterEditPanel.add(idLabel);
		
		idTextField = new JTextField();
		idTextField.setBounds(110, 110, 114, 20);
		productRegisterEditPanel.add(idTextField);
		idTextField.setColumns(10);
		
		productLabel.setText("Produto"); 
		productLabel.setBounds(293, 94, 243, 15);
		productRegisterEditPanel.add(productLabel);
		
		productTextField = new JTextField();
		productTextField.setBounds(293, 110, 243, 20);
		productRegisterEditPanel.add(productTextField);
		productTextField.setColumns(10);
		quantityLabel.setBounds(126, 165, 98, 15);
		
		quantityLabel.setText("Quantidade");
		
		productRegisterEditPanel.add(quantityLabel);
		quantitySpinner.setModel(new SpinnerNumberModel(0, 0, 9999, 1));
		quantitySpinner.setBounds(126, 183, 87, 20);
		
		productRegisterEditPanel.add(quantitySpinner);
		
		priceLabel.setBounds(308, 165, 112, 15);
		priceLabel.setText("Preco Unitario");
		
		productRegisterEditPanel.add(priceLabel);
		
		productRegisterEditPanel.add(priceTextField);
		borderRegisterEditPanel.setBounds(12, 30, 628, 291);
		
		productRegisterEditPanel.add(borderRegisterEditPanel);
		
		border.setTitleJustification(TitledBorder.CENTER);
		border.setTitlePosition(TitledBorder.TOP);
	   
		borderRegisterEditPanel.setBorder(border);
		
    backButton.setText("VOLTAR");
		backButton.setBounds(255, 419, 117, 25);
		productRegisterEditPanel.add(backButton);
		
		registerButton.addActionListener(this);
		editButton.addActionListener(this);
		RegisterEditSaveButton.addActionListener(this);
    backButton.addActionListener(this);
    deleteButton.addActionListener(this);
    addStockButton.addActionListener(this);
    removeStockButton.addActionListener(this);
    updateProductStockButton.addActionListener(this);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
  String statusSaveRegisterEditButton;
	public void actionPerformed(ActionEvent e) {
    
		if(e.getSource().equals(registerButton)) {
      statusSaveRegisterEditButton="register";
			border.setTitle("Cadastro de Produto");

      idTextField.setText(null);
      productTextField.setText(null);
      quantitySpinner.setValue(0);
      priceTextField.setText(null);
			
      switchPanels(productRegisterEditPanel);
		}
		
		if(e.getSource().equals(editButton)) {
      statusSaveRegisterEditButton = "edit";
      int i = table.getSelectedRow();
      if(i>=0) {
        border.setTitle("Edicao de Produto");

        idTextField.setText(model.getValueAt(i, 0).toString());
        productTextField.setText(model.getValueAt(i, 1).toString());
        quantitySpinner.setValue(model.getValueAt(i, 2));
        priceTextField.setText(model.getValueAt(i, 3).toString());

        switchPanels(productRegisterEditPanel);
      }
      else 
        JOptionPane.showMessageDialog(null,
          "Selecione o produto que deseja editar", "",
          JOptionPane.WARNING_MESSAGE);
		}

    if(e.getSource().equals(deleteButton)) {
			int i = table.getSelectedRow();
      if(i>=0)
        model.removeRow(i);
      else
        JOptionPane.showMessageDialog(null,
          "Selecione o produto que deseja excluir", "",
          JOptionPane.WARNING_MESSAGE);
    }
		
    if(e.getSource().equals(RegisterEditSaveButton)) {
			Object[] row = {idTextField.getText(), productTextField.getText(), 
        quantitySpinner.getValue(), priceTextField.getText()};
      
      if(statusSaveRegisterEditButton=="register") {
        if(idTextField.getText().isEmpty() || productTextField.getText().isEmpty()
         || priceTextField.getText().isEmpty()) {
          
          JOptionPane.showMessageDialog(null, "Campos Vazios",
           "",JOptionPane.ERROR_MESSAGE);
        }
        else {
        JOptionPane.showMessageDialog(null,
          "Cadastro de produto realizado", "",
          JOptionPane.INFORMATION_MESSAGE);

          model.addRow(row);
          switchPanels(stockViewPanel);
        }
      }
      else {
        JOptionPane.showMessageDialog(null,
          "Edicao de produto realizada", "",
          JOptionPane.INFORMATION_MESSAGE);
        
          int i = table.getSelectedRow();
          model.setValueAt(idTextField.getText(), i, 0);
          model.setValueAt(productTextField.getText(), i, 1);
          model.setValueAt(quantitySpinner.getValue(), i, 2);
          model.setValueAt(priceTextField.getText(), i, 3);
          
          switchPanels(stockViewPanel);
      }  
		}
    
    if(e.getSource().equals(backButton)) {
      switchPanels(stockViewPanel);
		}
    
    if(e.getSource().equals(addStockButton)) {
      int i = table.getSelectedRow();
      if(i>=0) {
        int value = Integer.parseInt(model.getValueAt(i, 2).toString());
        model.setValueAt(++value, i, 2);
      }
      else
        JOptionPane.showMessageDialog(null,
        "Escolha o produto para adicionar estoque", "",
        JOptionPane.WARNING_MESSAGE);  
		}
    
    if(e.getSource().equals(removeStockButton)) {
      int i = table.getSelectedRow();

      if(i>=0) {
        int value = Integer.parseInt(model.getValueAt(i, 2).toString());
        if(value>=1)
          model.setValueAt(--value, i, 2);
      }
      else 
        JOptionPane.showMessageDialog(null,
        "Escolha o produto para dar baixa em estoque", "",
        JOptionPane.WARNING_MESSAGE);
    }
    if(e.getSource().equals(updateProductStockButton)) {
        // verificar primeiramente se ouve alteracao do banco de dados (verificar se os valores de estoque na tabela estao diferentes do qu esta no banco)
        JOptionPane.showMessageDialog(null,
        "Estoque de produtos atualizado!", "",
        JOptionPane.INFORMATION_MESSAGE);
    }

  }
}
