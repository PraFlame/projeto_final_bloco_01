package roupasDeMargarida.model;

public abstract class Roupas {
	
	private int codigo;
	private byte numeracao;
	private String nome;
	private float preco;
	private int quantidade;
	
	
	public Roupas(int codigo, byte numeracao, String nome, float preco, int quantidade) {
		this.codigo = codigo;
		this.numeracao = numeracao;
		this.nome = nome;
		this.preco = preco;
		this.quantidade =  quantidade;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getNumeracao() {
		return numeracao;
	}


	public void setNumeracao(byte numeracao) {
		this.numeracao = numeracao;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



	
	public void visualizar() {



		System.out.println("***********************************************************");
		System.out.println("Código do produto: " + this.codigo);
		System.out.println(this.nome);
		System.out.println("TAM: " + this.numeracao);
		System.out.printf("Preço: R$ %.2f \n", this.preco);
		System.out.printf("Quantidade em estoque: " + this.quantidade);

	}
	
	
}
