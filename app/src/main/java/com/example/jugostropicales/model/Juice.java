package com.example.jugostropicales.model;

import com.google.gson.annotations.Expose;

public class Juice {

    @Expose
    private int id;

    @Expose
    private String nombre;

    @Expose
    private int precio;

    @Expose
    private int imagen;

    public Juice(int id, String nombre, int precio, int imagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
