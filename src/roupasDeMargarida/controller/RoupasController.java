package roupasDeMargarida.controller;

import java.util.ArrayList;
import java.util.List;

import roupasDeMargarida.model.Roupas;
import roupasDeMargarida.repository.roupasRepository;

public class RoupasController implements roupasRepository {

	private List<Roupas> listaRoupas = new ArrayList<Roupas>();
	int num = 0;
			
	@Override
	public void listarTodas() {
		for(var roupa : listaRoupas) {
			roupa.visualizar();
		}
	}

	@Override
	public void cadastrar(Roupas roupa) {
		listaRoupas.add(roupa);
		System.out.println("Novo intem adicionado com sucesso! Código: " + roupa.getCodigo());
		
	}

	@Override
	public void atualizar(Roupas roupa) {
		var buscaRoupa = buscarNaCollection(roupa.getCodigo());
		if(buscaRoupa != null) {
			listaRoupas.set(listaRoupas.indexOf(buscaRoupa), roupa);
			System.out.println("Produto de código " + roupa.getCodigo() + " foi atualizado com sucesso.");
		}
		else {
			System.out.println("Código do produto não foi encontrado, favor cadastrar.");
		}
		
		
	}

	@Override
	public void deletar(int codigo) {
		var roupa = buscarNaCollection(codigo);
		
		if(roupa != null) {
			if(listaRoupas.remove(roupa) == true) {
				System.out.println("Produto de código " + roupa.getCodigo() + " excluído do sistema.");
			}
			
		}
		else {
			System.out.println("Produto de código " + roupa.getCodigo() + " não foi encontrado.");
		}
	}
	//Adicionando ferramentas auxiliares às funções
	//Gerador de codigo de produtos
	public int gerarCodigo() {
		return ++ num;
	}
	//Verificando o a presença do produto no cadastro
	public Roupas buscarNaCollection(int numero) {
		for(var roupa : listaRoupas) {
			if(roupa.getCodigo() == numero) {
				return roupa;
			}
		}
		return null;
	}
	
	
}
