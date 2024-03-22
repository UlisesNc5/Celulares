package com.microservicios.store.modelos;

public class Tienda {
    private Celular cel;

    private Integer cantidad;

    public Tienda() {}

    public Tienda(Celular c, int i) {
        this.cel = c;
        this.cantidad = i;
    }

    public void setCel(Celular cel) { this.cel = cel; }
    public Celular getCel() { return cel; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public Integer getCantidad() { return cantidad; }
}
