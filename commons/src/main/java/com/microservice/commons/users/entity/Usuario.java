package com.microservice.commons.users.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{
    public static final long serialVersionUID = 0x1fee1deadL;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String username;

    @Column(unique = true, length = 100)
    private String email;
    private String password;
    private String nombre;
    private String apellido;
    private Boolean enabled;

    public void setPassword(String password){ this.password = password; }
    public String getPassword(){ return password; }

    public void setEnaled(Boolean enabled){ this.enabled = enabled; }
    public Boolean getEnabled(){ return enabled; }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "usuarios_to_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "roles_id"),
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "roles_id"})}
    )
    private List<Role> roles;

    public void setRoles(List<Role> roles){ this.roles = roles; }
    public List<Role> getRoles(){ return this.roles; }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
