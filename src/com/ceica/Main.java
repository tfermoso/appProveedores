package com.ceica;

import com.ceica.Controladores.AlmacenController;

public class Main {
    public static void main(String[] args) {

        AlmacenController almacen=new AlmacenController();
        almacen.nuevoProveedor("a","nombre","dir","loc","pro");
        almacen.nuevaPieza("piezaA","verde",45.5,1);
        System.out.println(almacen.toString());

    }
}