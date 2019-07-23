package telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Cliente;
import javax.swing.JTextArea;
//implementar.. classe crua
public class TelaListaClientes extends JFrame {

	private JPanel contentPane;
	private ArrayList<Cliente> clientes = new ArrayList();
	private String dados = "";
	private	JTextArea txtArea = new JTextArea();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaClientes frame = new TelaListaClientes();
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
	
	public TelaListaClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Cliente cliente : clientes) {
					//dados = "<html>Nome: Smile<br> Idade: da pedra</html>";
					dados =  dados + cliente.getNome() + "\n";
					//não esta quebrando linha
				}
				
				txtArea.setText(dados);
				dados = "";
				txtArea.setEditable(false);
			}
		});
		btnAtualizar.setBounds(75, 189, 97, 25);
		contentPane.add(btnAtualizar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnFechar.setBounds(223, 189, 97, 25);
		contentPane.add(btnFechar);
		
		
		txtArea.setBounds(26, 13, 380, 145);
		contentPane.add(txtArea);
	}
	
	public void importarClientes(ArrayList<Cliente> clientes) {
		this.clientes.addAll(clientes);
	}
}
