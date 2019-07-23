package telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logica.Produto;

public class TelaAdicionaProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuantidade;
	private JTextField txtCodigo;
	private ArrayList<Produto> produtos = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdicionaProduto frame = new TelaAdicionaProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAdicionaProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInformeAQuantidade = new JLabel("Informe a quantidade a adicionar:");
		lblInformeAQuantidade.setBounds(12, 109, 201, 16);
		contentPane.add(lblInformeAQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(226, 106, 116, 22);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblInformeOCdigo = new JLabel("Informe o c\u00F3digo do produto:");
		lblInformeOCdigo.setBounds(12, 47, 201, 16);
		contentPane.add(lblInformeOCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(226, 44, 116, 22);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean t = false;
				int cod = Integer.parseInt(txtCodigo.getText());
				int quantidade = Integer.parseInt(txtQuantidade.getText());
				
				for (Produto produto : produtos) {
					if( cod == produto.getCodigo()) {
						t = true;
					}
				}
				
				if(t) {
					TelaPrincipal.loja.addQuantidade(cod, quantidade);
					JOptionPane.showMessageDialog(null, "Chamou metodo na loja!");
				}else {
					JOptionPane.showMessageDialog(null, "Não chamou metodo na loja!");
				}
			}
		});
		btnAdicionar.setBounds(67, 181, 97, 25);
		contentPane.add(btnAdicionar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(226, 181, 97, 25);
		contentPane.add(btnFechar);
	}
	
	public void importarProdutos(ArrayList<Produto> prods) {
		produtos.addAll(prods);
	}
}
