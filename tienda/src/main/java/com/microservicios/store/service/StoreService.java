package com.microservicios.store.service;

import java.util.List;

import com.microservicios.store.modelos.Tienda;

public interface StoreService {

    public List<Tienda> findAll();
    public Tienda findById(Long id, Integer cantidad);
    
}
