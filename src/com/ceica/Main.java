package com.ceica;

import com.ceica.Controladores.AlmacenController;
import com.ceica.Controladores.LoginController;
import com.ceica.Modelos.Color;

import javax.script.ScriptContext;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String usr,pass;
        AlmacenController almacen=new AlmacenController();
        Scanner leer=new Scanner(System.in);
        System.out.println("Bienvenido a AppAlmacen");
        System.out.println(".... Enter para empezar");
        leer.nextLine();
        do{
            System.out.println("Login de AppAlmacen");
            System.out.print("Introduce Usuario: ");
            usr=leer.nextLine();
            System.out.print("Introduce password");
            pass=leer.nextLine();
            if(LoginController.login(usr,pass)){
                System.out.println("Estoy en AppAlmacen");
                menuPrincipalAlmacen(leer,almacen);

            }else{
                System.out.println("Usuario o Contraseña incorrecta");
            }
        }while(true);
    }

    private static void menuPrincipalAlmacen(Scanner leer, AlmacenController almacen) {
        String op="";
        String menuPrincipal= """
                1. Proveedores
                2. Piezas
                3. Pedidos
                4. Salir
                """;
        do{
            System.out.println(menuPrincipal);
            op=leer.nextLine();
            switch (op){
                case "1":
                    subMenuProveedores(leer,almacen);
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }while(! "4".equals(op));
    }

    private static void subMenuProveedores(Scanner leer, AlmacenController almacen) {
        String op,cif,nombre;
        String menuProveedores= """
                1. Nuevo proveedor
                2. Editar proveedor
                3. Ver proveedores
                4. Eliminar proveedor
                5. Volver al menú principal
                """;
        do {
            System.out.println(menuProveedores);
            op=leer.nextLine();
            switch (op){
                case "1":
                    System.out.print("CIF: ");
                    cif=leer.nextLine();


                    break;
                case "2":

                    break;
                case "3":
                    System.out.println(almacen.verProveedores());
                    break;
                case "4":
                    break;
                case "5":
                    System.out.println("Volviendo al menú principal...");
                default:
                    System.out.println("Opción no válida");
            }

        }while(! "5".equals(op));
    }
}