package com.microservicios.celulares.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Celulares")
public class Celular implements Serializable{
	private static final long serialVersionID = Long.MAX_VALUE; 

	@Transient
	private Integer port;
	public Integer getPort() { return port; }
	public void setPort(Integer port) { this.port = port; }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	private String nombre;
	private String marca;

	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date CreateAt;

	//create getters and setters for all the fields

	public long getId() { return Id; }
	public void setId(long id) { Id = id; }
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public String getMarca() { return marca; }
	public void setMarca(String marca) { this.marca = marca; }
	public void setCreateAt(Date createAt) { CreateAt = createAt; }
	public Date getCreateAt() { return CreateAt; }
} 
