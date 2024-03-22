package com.microservicios.store.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservicios.store.modelos.Celular;
import com.microservicios.store.modelos.Tienda;

@Service("serviceRest")
public class StoreServiceCrudImpl implements StoreService{
    @Autowired
    private RestTemplate clientRest;

    @Override
    public List<Tienda> findAll() {
        List<Celular> celulares = Arrays.asList(clientRest.getForObject("http://localhost:8081/list",Celular[].class));
        return celulares.stream().map(c -> new Tienda(c, 5)).collect(Collectors.toList());
    }

    @Override
    public Tienda findById(Long id, Integer cantidad) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());

        Celular celular = clientRest.getForObject("http://localhost:8081/celular/{id}", Celular.class, pathVariables);
        return new Tienda(celular, cantidad);
    }
}
