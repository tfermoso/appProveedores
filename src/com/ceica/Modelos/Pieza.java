package com.ceica.Modelos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Pieza extends ModeloBase {
    private static int idPieza=0;
    private int id;
    private String nombre;
    private String color;
    private Double precio;
    private Categoria categoria;

    public Pieza(String nombre, String color, Double precio) {
        this.id=idPieza++;
        this.nombre = nombre;
        this.color = color;
        this.precio = precio;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Pieza\n" +
                "{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                ", categoria=" + categoria +
                '}'+"\n";
    }

    @Override
    protected String getNombreTabla() {
        return "piezas";
    }

    @Override
    protected Object createObjectFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }
}
