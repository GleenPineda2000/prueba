package com.example.prueba;

public class Clientes {

   private  int idagentecliente;
    private String nombre;
    private String telefono;
    private String apellido;
    private  int subtotal;
    private int total;
    private int Estado_pedido;
    private  String fecha;

    public Clientes(int idagentecliente, String nombre, String telefono, String apellido, int subtotal, int total, int estado_pedido, String fecha) {
        this.idagentecliente = idagentecliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.apellido = apellido;
        this.subtotal = subtotal;
        this.total = total;
        Estado_pedido = estado_pedido;
        this.fecha = fecha;
    }




    public int getIdagentecliente() {
        return idagentecliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public int getTotal() {
        return total;
    }

    public int getEstado_pedido() {
        return Estado_pedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setIdagentecliente(int idagentecliente) {
        this.idagentecliente = idagentecliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setEstado_pedido(int estado_pedido) {
        Estado_pedido = estado_pedido;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
