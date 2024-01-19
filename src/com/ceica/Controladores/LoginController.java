package com.ceica.Controladores;

public class LoginController {
    public static boolean login(String usuario,String password){
        if("admin".equals(usuario) & "1234".equals(password)){
            return true;
        }else{
            return false;
        }
    }
}
