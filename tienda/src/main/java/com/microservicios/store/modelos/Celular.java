package com.microservicios.store.modelos;

import java.sql.Date;

public class Celular {

    private Long id;
    private String nombre;
    private String marca;
    private Date createdat;
    private Integer port;

    public Integer getPort() { return port; }
    public void setPort(Integer port) { this.port = port; }

    public Celular() { }

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getMarca() { return marca; }
    public void setCreatedat(Date createdat) { this.createdat = createdat; }
    public Date getCreatedat() { return createdat; }
}
