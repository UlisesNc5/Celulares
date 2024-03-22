package com.microservicios.store.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservicios.store.modelos.Celular;

@FeignClient(name = "service-celulares", url = "localhost:8081")
public interface CelularClientFeign {
    @GetMapping("/list")
    public List<Celular> list();

    @GetMapping("/celular/{id}")
    public Celular detail(@PathVariable long id);




}
