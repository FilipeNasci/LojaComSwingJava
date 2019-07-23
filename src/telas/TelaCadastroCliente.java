package telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logica.Cliente;

public class TelaCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do cliente:");
		lblNomeDoCliente.setBounds(26, 45, 104, 16);
		contentPane.add(lblNomeDoCliente);
		
		txtNome = new JTextField();
		txtNome.setBounds(163, 42, 116, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpfDoCliente = new JLabel("Cpf do cliente:");
		lblCpfDoCliente.setBounds(26, 111, 104, 16);
		contentPane.add(lblCpfDoCliente);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(163, 108, 116, 22);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtNome != null && txtCpf != null) {
					Cliente cliente = new Cliente(txtNome.getText(), txtCpf.getText());
					TelaPrincipal.loja.addCliente(cliente);
					JOptionPane.showMessageDialog(null, cliente.getNome() + " cadastrado!");
					dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Deu ruim!");
				}
			}
		});
		btnCadastrar.setBounds(51, 178, 97, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(182, 178, 97, 25);
		contentPane.add(btnFechar);
	}
}
