package logica;

import java.math.BigDecimal;

public class Produto {
	private String nome;
	private BigDecimal valor;
	private int quantidade;
	private int codigo;
	private static int sequencia = 1;
	
	public Produto (String nome, int quantidade, BigDecimal valor) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
		this.codigo = sequencia++;
	}
	
	public Produto (String nome, String valor) {
		this.nome = nome;
		this.valor = new BigDecimal(valor);
		this.codigo = sequencia++;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
