package com.docketbrasil.cartorio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.docketbrasil.cartorio.entities.TipoCertidao;
import com.docketbrasil.cartorio.repository.TipoCertidaoRepository;

@Service
public class TipoCertidaoService {
	
	@Autowired
	private TipoCertidaoRepository certidaoRepository;
	
	@Transactional(readOnly = true)
	public List<TipoCertidao> findAll() {
		List<TipoCertidao> result = certidaoRepository.findAll();	
		return result;
	}
	
	public TipoCertidao save(TipoCertidao certidao) {
		return certidaoRepository.save(certidao);
	}
	
}
