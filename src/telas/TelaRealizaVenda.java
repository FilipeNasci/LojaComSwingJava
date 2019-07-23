package telas;

import java.awt.Component;
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

import logica.Cliente;
import logica.Produto;
import logica.Venda;

public class TelaRealizaVenda extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtQuantidade;
	private JButton btnAdicionarProduto;
	private JButton btnEncerrarVenda;
	private JButton btnFechar;
	private String cpfCliente = "";
	private ArrayList<Cliente> clientes = new ArrayList();
	private ArrayList<Produto> produtos = new ArrayList();
	private ArrayList<Produto> prodClientes = new ArrayList();
	private Cliente cliente;
	private Venda v;
	private boolean t = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRealizaVenda frame = new TelaRealizaVenda();
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
	public TelaRealizaVenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodigoDoProduto = new JLabel("Codigo do produto:");
		lblCodigoDoProduto.setBounds(12, 35, 123, 16);
		contentPane.add(lblCodigoDoProduto);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(159, 32, 116, 22);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblQuantidadeAComprar = new JLabel("Quantidade a comprar:");
		lblQuantidadeAComprar.setBounds(12, 95, 142, 16);
		contentPane.add(lblQuantidadeAComprar);

		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(159, 92, 116, 22);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);

		btnAdicionarProduto = new JButton("Adicionar produto");
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//cadastra produto em vendas e popup mandando digitar novo produto
				int cod = Integer.parseInt(txtCodigo.getText());
				int qnt = Integer.parseInt(txtQuantidade.getText());
				checkProduto(cod, qnt);

				//limpa os campos

				for (int i=0; i < getContentPane().getComponentCount(); i++) {
					//varre todos os componentes

					Component c = getContentPane().getComponent(i);

					if (c instanceof JTextField) {
						//apaga os valores
						JTextField field = (JTextField) c;
						field.setText("");
						//System.out.println("apagando campo " + i);
					}
				}
			}
		}
				);
		btnAdicionarProduto.setBounds(12, 171, 142, 37);
		contentPane.add(btnAdicionarProduto);

		btnEncerrarVenda = new JButton("Encerrar venda");
		btnEncerrarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(t) {
					Venda venda = new Venda(cliente, produtos);
					TelaPrincipal.loja.addVenda(venda);
					JOptionPane.showMessageDialog(null, "Venda realizada! Código:" + venda.getCodigo());
				}else {
					JOptionPane.showMessageDialog(null, "Algo errado! Venda não realizada!");
				}
			}
		});
		btnEncerrarVenda.setBounds(166, 171, 132, 37);
		contentPane.add(btnEncerrarVenda);

		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnFechar.setBounds(310, 171, 97, 37);
		contentPane.add(btnFechar);

	}
	public void importarDados(ArrayList<Cliente> clientes, ArrayList<Produto> produtos) {
		this.clientes = clientes;
		this.produtos = produtos;
	}
	public void identificarCliente() {
		//metodo ok
		cpfCliente = JOptionPane.showInputDialog(null, "Informe o cpf do cliente!");
		t = false;

		for (Cliente cliente : clientes) {
			if(cpfCliente.equals(cliente.getCpf())) {
				this.cliente = cliente;
				t = true;
			}
		}

		if(t) {
			JOptionPane.showMessageDialog(null, "Cliente identificado!");
		}else {
			JOptionPane.showMessageDialog(null, "Cliente não identificado!");
		}
	}
	public void checkProduto(int cod, int qnt){
		boolean i = false;

		for (Produto produto : produtos) {
			if(cod == produto.getCodigo()) {
				JOptionPane.showMessageDialog(null, "Produto identificado!");
				prodClientes.add(produto);
				i = true;
				if(qnt <= produto.getQuantidade()) {
					JOptionPane.showMessageDialog(null, "Temos essa quantidade em estoque!");
				}else {
					JOptionPane.showMessageDialog(null, "Não temos essa quantidade em estoque!");
				}
			}
		}

		if(!i) {
			JOptionPane.showMessageDialog(null, "Produto não identificado!");
		}
	}
}
