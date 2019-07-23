package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Produto;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListaProdutos extends JFrame {

	private JPanel contentPane;
	private ArrayList<Produto> produtos = new ArrayList();
	private String list = "";
	private JTextArea textArea = new JTextArea();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaProdutos frame = new TelaListaProdutos();
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
	public TelaListaProdutos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textArea.setBounds(12, 13, 408, 156);
		contentPane.add(textArea);
		textArea.setEditable(false);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(160, 198, 97, 25);
		contentPane.add(btnFechar);
	}
	public void importarProdutos(ArrayList<Produto> produtos) {
		this.produtos.addAll(produtos);
	}
	public void atualizarLista() {
		for (Produto produto : produtos) {
			list = list + "Produto: " + produto.getNome() + " | Quantidade: " + produto.getQuantidade() + "\n";
		}
		textArea.setText(list);
	}
	public void limpaArray() {
		produtos.clear();
	}
}
