/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BD.CUsuario;

public class Sesion {
    private static CUsuario usuarioActual;

    public static void setUsuarioActual(CUsuario usuario) {
        usuarioActual = usuario;
    }

    public static CUsuario getUsuarioActual() {
        return usuarioActual;
    }
}
