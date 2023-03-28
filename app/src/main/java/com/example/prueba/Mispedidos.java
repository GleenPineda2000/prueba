package com.example.prueba;

public class Mispedidos {

int idproducto;


int idfactura;


String nombre;

String descripcion;
int precio;
int subtotal;





    public Mispedidos(){

    }

    public Mispedidos(int idproducto, int idfactura, String nombre, String descripcion, int precio, int subtotal) {
        this.idproducto = idproducto;
        this.idfactura = idfactura;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
}
