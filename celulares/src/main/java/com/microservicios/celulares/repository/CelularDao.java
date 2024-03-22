package com.microservicios.celulares.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservicios.celulares.entity.Celular;

public interface CelularDao extends CrudRepository<Celular, Long>{}
