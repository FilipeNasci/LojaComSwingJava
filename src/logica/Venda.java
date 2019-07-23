package logica;

import java.util.ArrayList;

public class Venda {
	private Cliente cliente;
	private int codigo;
	private static int sequencia = 99;
	private ArrayList<Produto> produtos = new ArrayList();
	
	public Venda(Cliente cliente, ArrayList<Produto> produtos) {
		this.cliente = cliente;
		this.produtos = produtos;
		this.codigo = sequencia++;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
}
