package telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logica.Produto;

public class TelaCadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtValor;
	private JTextField txtQuantidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProduto frame = new TelaCadastroProduto();
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
	public TelaCadastroProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoProduto = new JLabel("Nome do produto:");
		lblNomeDoProduto.setBounds(12, 42, 115, 16);
		contentPane.add(lblNomeDoProduto);
		
		txtNome = new JTextField();
		txtNome.setBounds(135, 39, 116, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblValorDoProduto = new JLabel("Valor do produto:");
		lblValorDoProduto.setBounds(12, 133, 115, 16);
		contentPane.add(lblValorDoProduto);
		
		txtValor = new JTextField();
		txtValor.setBounds(135, 130, 116, 22);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quantidade = Integer.parseInt(txtQuantidade.getText());
				if(txtNome != null && quantidade > 0 && txtValor != null) {
					//linha abaixo troca virgula por ponto
					BigDecimal valor = new BigDecimal(txtValor.getText().replace(",","."));
					Produto produto = new Produto(txtNome.getText(), quantidade, valor);
					TelaPrincipal.loja.addProduto(produto);
					JOptionPane.showMessageDialog(null, produto.getNome() + " cadastrado! Código: " + produto.getCodigo());
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Não cadastrado!");
				}
			}
		});
		btnCadastrar.setBounds(30, 180, 97, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(154, 180, 97, 25);
		contentPane.add(btnFechar);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(12, 90, 104, 16);
		contentPane.add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(135, 87, 116, 22);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);
	}

}
