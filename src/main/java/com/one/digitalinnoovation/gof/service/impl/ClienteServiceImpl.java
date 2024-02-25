package com.one.digitalinnoovation.gof.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.digitalinnoovation.gof.model.Cliente;
import com.one.digitalinnoovation.gof.model.Endereco;
import com.one.digitalinnoovation.gof.model.ClienteRepository;
import com.one.digitalinnoovation.gof.model.EnderecoRepository;
import com.one.digitalinnoovation.gof.service.ClienteService;
import com.one.digitalinnoovation.gof.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	//  Singleton: Injetar os componentes do Spring com @Autowried
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	//  Strategy: Implementar os métodos definidos na interface
	//  Facade: Abstrair integrações com subsistemas, provendo uma interface simples
	
	@Override
	public Iterable<Cliente> buscarTodos(){
	// FIXME Buscar todos os clientes
		return clienteRepository.findAll();
	}
	
	@Override
	public Cliente buscarPorId(Long id) {
		//  Buscar Cliente por ID
		Optional<Cliente> cliente = clienteRepository.findById(id); 
		return cliente.get();
	}
	
	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComCep(cliente);
	}
	
	@Override
	public void atualizar(Long id, Cliente cliente) {
		// buscar Cliente por ID, caso Exista
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
		}
	}
	
	@Override
	public void deletar(Long id) {
		//  deletar Cliente por ID
		clienteRepository.deleteById(id);
	}
	
	private void salvarClienteComCep(Cliente cliente) {
		// verificar se o Endereco do Cliente já existe (pelo CEP)
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
		//  Caso não exista, integrar com o ViaCEP e persistir o retorno
		Endereco novoEndereço = viaCepService.consultarCep(cep);
		enderecoRepository.save(novoEndereço);
		return novoEndereço;
		});
		cliente.setEndereco(endereco);
		//  Inserir Cliente, vinculando o endereço (novo ou existente)
		clienteRepository.save(cliente);
	}
	
}
