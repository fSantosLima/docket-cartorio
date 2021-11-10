package com.docketbrasil.cartorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docketbrasil.cartorio.entities.Cartorio;

public interface CartorioRepository extends JpaRepository<Cartorio, Long> {

}
