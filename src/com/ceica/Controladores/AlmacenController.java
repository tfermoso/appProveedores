package com.ceica.Controladores;

import com.ceica.Modelos.Pedido;
import com.ceica.Modelos.Pieza;
import com.ceica.Modelos.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class AlmacenController {
    private List<Proveedor> proveedorList;
    private List<Pieza> piezaList;
    private List<Pedido> pedidoList;

    public AlmacenController() {
        proveedorList=new ArrayList<>();
        pedidoList=new ArrayList<>();
        piezaList=new ArrayList<>();
    }

    public boolean nuevoProveedor(String cif,String nombre,String direccion,String localidad,String provincia){
        Proveedor proveedor=new Proveedor(cif,nombre);
        proveedor.setDireccion(direccion);
        proveedor.setLocalidad(localidad);
        proveedor.setProvincia(provincia);
        return proveedorList.add(proveedor);
    }

    @Override
    public String toString() {
        return "AlmacenController{" + "\n"+
                "proveedorList=" + proveedorList + "\n"+
                ", piezaList=" + piezaList + "\n"+
                ", pedidoList=" + pedidoList + "\n"+
                '}';
    }
}
