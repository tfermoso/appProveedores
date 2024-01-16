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
    public boolean borrarProveedor(String cif){
        for (int i = 0; i < proveedorList.size(); i++) {
            if(cif.equals(proveedorList.get(i).getCif())){
                proveedorList.remove(i);
                //proveedorList.remove(proveedorList.get(i));
                return true;
            }
        }
        return false;
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
