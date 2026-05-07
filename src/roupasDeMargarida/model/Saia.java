package roupasDeMargarida.model;

public class Saia extends Roupas{
	
	private String tipo;

	public Saia(int codigo, byte numeracao, String nome, float preco, int quantidade, String tipo) {
		super(codigo, numeracao, nome, preco, quantidade);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public void visualizar() {
		// TODO Auto-generated method stub
		System.out.println("\n\n***********************************************************");
		System.out.println("Dados do produto:");
		System.out.println("Tipo do produto: " + this.tipo);
		
		super.visualizar();
		
	}
	


}
