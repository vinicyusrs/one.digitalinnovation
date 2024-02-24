package com.one.digitalinnoovation.gof.service;

import com.one.digitalinnoovation.gof.model.Cliente;

public interface ClienteService {
	
	Iterable<Cliente> buscarTodos();
	
	Cliente buscarPorId(Long Id);
	
	void inserir(Cliente cliente);
	
	void atualizar (Long id, Cliente cliente);
	
	void deletar (Long id);

}
