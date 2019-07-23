package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Loja;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	public static Loja loja = new Loja();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 432, 26);
		contentPane.add(menuBar);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmCadastro = new JMenuItem("Cadastro");
		mntmCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
				telaCadastroCliente.setVisible(true);
			}
		});
		mnClientes.add(mntmCadastro);
		
		JMenuItem mntmLista = new JMenuItem("Lista");
		mntmLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaClientes telaListaClientes = new TelaListaClientes();
				telaListaClientes.importarClientes(loja.getClientes());
				telaListaClientes.setVisible(true);
			}
		});
		mnClientes.add(mntmLista);
		
		JMenu mnProdutos = new JMenu("Produtos");
		menuBar.add(mnProdutos);
		
		JMenuItem mntmCadastro_1 = new JMenuItem("Cadastro");
		mntmCadastro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto();
				telaCadastroProduto.setVisible(true);
			}
		});
		mnProdutos.add(mntmCadastro_1);
		
		JMenuItem mntmLista_1 = new JMenuItem("Lista");
		mntmLista_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaProdutos telaListaProdutos = new TelaListaProdutos();
				telaListaProdutos.importarProdutos(loja.getProdutos());
				telaListaProdutos.atualizarLista();
				telaListaProdutos.setVisible(true);
				telaListaProdutos.limpaArray();
			}
		});
		mnProdutos.add(mntmLista_1);
		
		JMenuItem mntmAdiciona = new JMenuItem("Adiciona");
		mntmAdiciona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdicionaProduto telaAdicionaProduto = new TelaAdicionaProduto();
				telaAdicionaProduto.importarProdutos(loja.getProdutos());
				telaAdicionaProduto.setVisible(true);
			}
		});
		mnProdutos.add(mntmAdiciona);
		
		JButton btnRealizarVenda = new JButton("Realizar venda");
		btnRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRealizaVenda telaRealizaVenda = new TelaRealizaVenda();
				telaRealizaVenda.importarDados(loja.getClientes(), loja.getProdutos());
				telaRealizaVenda.identificarCliente();
				telaRealizaVenda.setVisible(true);
			}
		});
		btnRealizarVenda.setBounds(12, 58, 117, 44);
		contentPane.add(btnRealizarVenda);
		
		JButton btnGerarNf = new JButton("Gerar NF");
		btnGerarNf.setBounds(159, 58, 101, 44);
		contentPane.add(btnGerarNf);
	}
}
