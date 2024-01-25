package com.ceica.Modelos;

import com.ceica.bbdd.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Proveedor extends ModeloBase {
    private int id;
    private String cif;
    private String nombre;
    private String direccion;
    private String localidad;
    private String provincia;

    public Proveedor() {
    }

    public Proveedor(String cif, String nombre) {
        this.cif = cif;
        this.nombre = nombre;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getCif() {
        return cif;
    }

    public void setCif(java.lang.String cif) {
        this.cif = cif;
    }

    public java.lang.String getNombre() {
        return nombre;
    }

    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }

    public java.lang.String getDireccion() {
        return direccion;
    }

    public void setDireccion(java.lang.String direccion) {
        this.direccion = direccion;
    }

    public java.lang.String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(java.lang.String localidad) {
        this.localidad = localidad;
    }

    public java.lang.String getProvincia() {
        return provincia;
    }

    public void setProvincia(java.lang.String provincia) {
        this.provincia = provincia;
    }


/*
    public static boolean eliminarProveedor(String cif) {
        Connection conn = Conexion.conectar();
        String sql = "delete from proveedores where cif=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cif);
            if (pst.executeUpdate() > 0) {
                conn.close();
                return true;
            } else {
                conn.close();
                return false;
            }
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            return false;
        }

    }
*/
    /*
    public static boolean editarNombreProveedor(String cif, String nombre) {
        Connection conn = Conexion.conectar();
        String sql = "update proveedores set nombre = ? where cif = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, cif);
            if (pst.executeUpdate() > 0) {
                conn.close();
                return true;
            } else {
                conn.close();
                return false;
            }
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            return false;
        }

    }
*/

    public static List<Proveedor> getProveedores() {
        List<Proveedor> proveedorList = new ArrayList<>();
        Connection conn = Conexion.conectar();
        String sql = "select * from proveedores";
        try {
            Statement stm = conn.createStatement();
            ResultSet respuesta = stm.executeQuery(sql);
            while (respuesta.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId(respuesta.getInt("idProveedor"));
                proveedor.setCif(respuesta.getString("cif"));
                proveedor.setNombre(respuesta.getString("nombre"));
                proveedor.setDireccion(respuesta.getString("direccion"));
                proveedor.setLocalidad(respuesta.getString("localidad"));
                proveedor.setProvincia(respuesta.getString("provincia"));
                proveedorList.add(proveedor);
            }

        } catch (SQLException e) {
            //throw new RuntimeException(e);

            return proveedorList;
        }
        try {
            conn.close();
        } catch (SQLException e) {
            //throw new RuntimeException(e);
        }
        return proveedorList;
    }


    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", cif='" + cif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' + "\n" +
                '}';
    }

    @Override
    protected String getNombreTabla() {
        return "proveedores";
    }

    @Override
    protected Object createObjectFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }
}
