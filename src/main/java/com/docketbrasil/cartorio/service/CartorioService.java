package com.docketbrasil.cartorio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.docketbrasil.cartorio.entities.Cartorio;
import com.docketbrasil.cartorio.repository.CartorioRepository;

@Service
public class CartorioService {

	@Autowired
	private CartorioRepository repository;

	@Transactional(readOnly = true)
	public List<Cartorio> findAll() {
		List<Cartorio> result = repository.findAll();	
		return result;
	}
	
	@Transactional(readOnly = true)
	public Optional<Cartorio> findById(long id) {
		return repository.findById(id);
	} 
	
	public Cartorio save(Cartorio cartorio) {
		return repository.save(cartorio);
	}
	
	public void delete(Cartorio cartorio) {
		repository.delete(cartorio);
	}
	
}
