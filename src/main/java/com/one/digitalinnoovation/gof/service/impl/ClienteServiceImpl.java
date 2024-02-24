package com.one.digitalinnoovation.gof.service.impl;


import org.springframework.stereotype.Service;

import com.one.digitalinnoovation.gof.model.Cliente;
import com.one.digitalinnoovation.gof.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Override
	public Iterable<Cliente> buscarTodos(){
	// FIXME Buscar todos os clientes
		return null;
	}
	
	@Override
	public Cliente buscarPorId(Long id) {
		// FIXME Buscar Cliente por ID
		return null;
	}
	
	@Override
	public void inserir(Cliente cliente) {
		//FIXME verificar se o Endereco do Cliente já existe (pelo CEP)
		// FIXME Caso não exista, integrar com o ViaCEP e persistir o retorno
		//FIXME  Inserir Cliente, vinculando o endereço (novo ou existente)
	}
	
	@Override
	public void atualizar(Long id, Cliente cliente) {
		//FIXME buscar Cliente por ID, caso Exista
		//FIXME verificar se o Endereço do Cliente já exista(pelo CEP)
		//FIXME Caso não exista, Integrar com o ViaCEP e persistir o retorno
		//FIXME Alterar Cliente, vinculando o Endereço (novo ou existente)
	}
	
	@Override
	public void deletar(Long id) {
		// FIXME deletar Cliente por ID
	}
	
}
