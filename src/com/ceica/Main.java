package com.ceica;

import com.ceica.Controladores.AlmacenController;

public class Main {
    public static void main(String[] args) {

        AlmacenController almacen=new AlmacenController();
        almacen.nuevoProveedor("a","nombre","dir","loc","pro");
        System.out.println(almacen.toString());
    }
}