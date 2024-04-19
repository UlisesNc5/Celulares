package com.microservicios.store.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicios.store.client.CelularClientFeign;
import com.microservicios.store.modelos.Tienda;

@Service("serviceFeign")
public class StoreServiceFeign implements StoreService{

    @Autowired
    private CelularClientFeign clientFeign;

    @Override
    public List<Tienda> findAll() {
        return clientFeign.list().stream().map(c -> new Tienda(c, 5)).collect(Collectors.toList());
    }

    @Override
    public Tienda findById(Long id, Integer cantidad) {
        return new Tienda(clientFeign.detail(id), cantidad);
    }

        
}
