package logica;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Loja {
	private ArrayList<Cliente> clientes = new ArrayList();
	private ArrayList<Produto> produtos = new ArrayList();
	private ArrayList<Venda> vendas = new ArrayList();
	private static Loja loja;
	
	public Loja() {
		
	}
	
	public static synchronized Loja getIntance() {
		if(loja == null) {
			loja = new Loja();
		}
		return loja;
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	public void addCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public void addProduto(Produto produto) {
		produtos.add(produto);
	}
	public void addQuantidade(int codigo, int quantidade) {
		boolean aviso = false;
		for (Produto produto : produtos) {
			if(codigo == produto.getCodigo()) {
				produto.setQuantidade(produto.getQuantidade() + quantidade);
				aviso = true;
				JOptionPane.showMessageDialog(null, produto.getNome() + "adicionado!");
			}
		}
		
		if(!aviso) {
			JOptionPane.showMessageDialog(null, "Não adicionado!");
		}
	}
	public ArrayList<Venda> getVendas() {
		return vendas;
	}
	public void setVendas(ArrayList<Venda> vendas) {
		this.vendas = vendas;
	}
	public void addVenda(Venda venda) {
		vendas.add(venda);
	}
}
