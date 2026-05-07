package roupasDeMargarida.repository;

import roupasDeMargarida.model.Roupas;

public interface roupasRepository {
	//CRUD dos Produtos
	public void listarTodas();
	public void cadastrar(Roupas roupa);
	public void atualizar(Roupas roupa);
	public void deletar(int codigo);
	
}
