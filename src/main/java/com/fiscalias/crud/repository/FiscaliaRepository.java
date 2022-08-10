package com.fiscalias.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiscalias.crud.model.Fiscalia;

public interface FiscaliaRepository extends JpaRepository<Fiscalia, Long> {
	List<Fiscalia> findByAgencia(String agencia);
}