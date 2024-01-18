package com.ceica.Controladores;

import com.ceica.Modelos.Categoria;
import com.ceica.Modelos.Pedido;
import com.ceica.Modelos.Pieza;
import com.ceica.Modelos.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class AlmacenController {

    private List<Proveedor> proveedorList;
    private List<Pieza> piezaList;
    private List<Pedido> pedidoList;
    private List<Categoria> categorias;

    public AlmacenController() {

        proveedorList=new ArrayList<>();
        pedidoList=new ArrayList<>();
        piezaList=new ArrayList<>();
        categorias=new ArrayList<>();
        Categoria categoria=new Categoria(1,"pequeño");
        categorias.add(categoria);
        categorias.add(new Categoria(2,"mediano"));
        categorias.add(new Categoria(3,"grande"));

    }

    public boolean nuevoProveedor(String cif,String nombre,String direccion,String localidad,String provincia){
        Proveedor proveedor=new Proveedor(cif,nombre);
        proveedor.setDireccion(direccion);
        proveedor.setLocalidad(localidad);
        proveedor.setProvincia(provincia);
        return proveedorList.add(proveedor);
    }
    /*
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

     */
    public boolean borrarProveedor(String cif){
        return proveedorList.removeIf(proveedor -> cif.equals(proveedor.getCif()));
    }

    public boolean editarNombreProveedor(String cif, String nombre){
        /*
        for (int i = 0; i < proveedorList.size(); i++) {
            if(cif.equals(proveedorList.get(i).getCif())){
                proveedorList.get(i).setNombre(nombre);
                return true;
            }
        }
        return false;
         */
        /*
        for(Proveedor proveedor : proveedorList){
            if(cif.equals(proveedor.getCif())){
                proveedor.setNombre(nombre);
                return true;
            }
        }
        return false;
         */
         return proveedorList.stream()
                .filter(p->cif.equals(p.getCif()))
                 .findFirst()
                .map(p -> {
                    p.setNombre(nombre);
                    return true;
                })
                .orElse(false);

    }
    public boolean editarPrecioPieza(int id,Double precio){
        return piezaList.stream()
                .filter(pieza -> pieza.getId()==id)
                .findFirst()
                .map(pieza -> {
                    pieza.setPrecio(precio);
                    return true;
                })
                .orElse(false);
    }

    public boolean nuevaPieza(String nombre,String color,Double precio, int idcategoria){
            Pieza pieza=new Pieza(nombre,color,precio);
            pieza.setCategoria(getCategoriaById(idcategoria));
            piezaList.add(pieza);
            return true;
    }

    private Categoria getCategoriaById(int id){
        return categorias.stream()
                .filter(c->c.getId()==id).
                findFirst().get();
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
