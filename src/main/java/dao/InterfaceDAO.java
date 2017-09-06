package dao;

import java.util.List;

public interface InterfaceDAO<T> {
	public List<T> buscarTodos();
	public T buscar(T elemento);
	public void inserir(T novo);
	public void atualizar(T elemento);
	public void remover(T elemento);
}
