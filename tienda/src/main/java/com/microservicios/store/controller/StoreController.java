package com.microservicios.store.controller;

import org.springframework.web.bind.annotation.RestController;

import com.microservicios.store.modelos.Tienda;
import com.microservicios.store.service.StoreService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class StoreController {
    @Autowired
    @Qualifier("serviceRest")
    private StoreService storeService;  

    @GetMapping("/list")
    public List<Tienda> list(){ return storeService.findAll(); }

    @GetMapping("/store/{id}/cantidad/{cantidad}")
    public Tienda details(@PathVariable Long id, @PathVariable Integer cantidad){
        return storeService.findById(id, cantidad);
    }
    
}
