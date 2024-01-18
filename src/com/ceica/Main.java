package com.ceica;

import com.ceica.Controladores.AlmacenController;
import com.ceica.Modelos.Color;

public class Main {
    public static void main(String[] args) {

        AlmacenController almacen=new AlmacenController();
        almacen.nuevoProveedor("a","nombre","dir","loc","pro");
        almacen.nuevaPieza("piezaA", Color.AZUL,45.5,1);
        almacen.nuevaPieza("piezaB", Color.NEGRO,5.5,2);
        System.out.println(almacen.nuevoPedido("a",1,50));
        System.out.println(almacen.nuevoPedido("a",1,10));
        System.out.println(almacen.nuevoPedido("j",0,30));
        System.out.println(almacen.getPedidosByProveedor("a"));
    }
}