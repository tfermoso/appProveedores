package com.ceica.Controladores;

import com.ceica.Modelos.*;

import java.time.LocalDate;
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

    public boolean nuevaPieza(String nombre, Color color, Double precio, int idcategoria){
            Pieza pieza=new Pieza(nombre,color.toString(),precio);
            pieza.setCategoria(getCategoriaById(idcategoria));
            piezaList.add(pieza);
            return true;
    }

    private Categoria getCategoriaById(int id){
        return categorias.stream()
                .filter(c->c.getId()==id).
                findFirst().get();
    }

    public String nuevoPedido(String cif,int idPieza,int cantidad){
        Proveedor proveedor=getProveedorByCIF(cif);
        if(proveedor!=null){
           Pieza pieza=getPiezaByID(idPieza);
           if(pieza!=null){
               Pedido pedido1 = new Pedido(proveedor,pieza);
               pedido1.setCantidad(cantidad);
               pedido1.setFecha(LocalDate.now());
               pedidoList.add(pedido1);
               return "Pedido creado";
           }else{
               return "Error al crear el pedido, Pieza no existe";
           }
        }else{
            return "Error al crear el pedido, Proveedor no existe";
        }
    }
    private Pieza getPiezaByID(int id){
        for (int i = 0; i < piezaList.size(); i++) {
            if(piezaList.get(i).getId()==id){
                return piezaList.get(i);
            }
        }
        return null;
    }
    private Proveedor getProveedorByCIF(String cif){
        for (Proveedor p:proveedorList){
            if(cif.equals(p.getCif())){
                return p;
            }
        }
        return null;
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
