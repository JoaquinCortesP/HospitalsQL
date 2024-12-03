/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospital;

import Bd.Conexion;
import Controller.PacienteController;
import Views.MenuPrincipal;
/**
 *
 * @author Joaqu
 */
public class Hospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion cx = new Conexion();
        
        cx.conectar();
        
        MenuPrincipal m = new MenuPrincipal();
        m.setLocationRelativeTo(null); 
        m.setVisible(true);
        
        
        
        
        
        PacienteController lc = new PacienteController();
        System.out.println(lc.ObtenerPaciente());
    }
    
}
