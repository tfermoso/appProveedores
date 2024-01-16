package com.ceica;

import com.ceica.Controladores.AlmacenController;

public class Main {
    public static void main(String[] args) {

        AlmacenController almacen=new AlmacenController();
        almacen.nuevoProveedor("a","nombre","dir","loc","pro");
        almacen.nuevoProveedor("b","nombreb","dir","loc","pro");
        System.out.println(almacen.toString());
        System.out.println(almacen.editarNombreProveedor("a","AlmacenA"));
        System.out.println(almacen.toString());

    }
}