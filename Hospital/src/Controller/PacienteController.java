/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Bd.Conexion;
import Models.Paciente;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;



/**
 *
 * @author Joaqu
 */
public class PacienteController {
    HelperController helper = new HelperController();
    Conexion cx;
    
    
    public PacienteController(){
        cx = new Conexion();
        cx.conectar();
    
    }
    
    public List<Paciente> ObtenerPaciente(){
        List<Paciente> pacientes = new ArrayList<>();
        
        try {
            ResultSet rs = cx.EjecutarQuery("SELECT * FROM paciente ;");
            
            while(rs.next()){
                pacientes.add(new Paciente(
                        rs.getInt("rut"),
                        rs.getString("nombre"),
                        rs.getString("fechaDeNacimiento"),
                        rs.getString("direccion"),
                        rs.getInt("telefono")  
                        
                                ));
            }
            
          
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }
        return pacientes;
    }
    
    
    
    
    
   public void agregarPaciente(int rut, String nombre, String fechaDeNacimiento, String direccion, int telefono){
       String sql = "INSERT INTO `paciente` (rut,nombre,fechaDeNacimiento,direccion,telefono) VALUES(?,?,?,?,?) ";
       
       try {
           PreparedStatement st = cx.getConnection().prepareStatement(sql);
           st.setInt(1, rut);
           st.setString(2, nombre);
           st.setString(3, fechaDeNacimiento);
           st.setString(4, direccion);
           st.setInt(5, telefono);
           st.executeUpdate();
            helper.showInformation("Paciente Agregado.");
       } catch (Exception e) {
        helper.showError(e.getMessage());
       }
    

   }
   
   
   public Paciente buscarPacientePorId(int rut ){
       Paciente pacienteEncontrado = new Paciente();
       
       pacienteEncontrado = null;
       String sql = "SELECT * FROM paciente WHERE rut = " + rut+";";
       
       try {
           ResultSet rs = cx.EjecutarQuery(sql);
           if(rs.next()){
           pacienteEncontrado = new Paciente();
           pacienteEncontrado.setRut(rs.getInt("rut"));
           pacienteEncontrado.setNombre(rs.getString("nombre"));
           pacienteEncontrado.setDireccion(rs.getString("fechaDeNacimiento"));
           pacienteEncontrado.setFechaDeNacimiento(rs.getString("direccion"));
           pacienteEncontrado.setTelefono(rs.getInt("telefono"));
                
           
           
        }
           
       } catch (Exception e) {
           helper.showError("ERROR PACIENTE NO ENCONTRADO");
       }
       return pacienteEncontrado;
   }

  
  
   
    
    
    public boolean editarPaciente(int rut, String nombre, String fechaDeNacimiento, String direccion, int telefono){
        String query = "UPDATE paciente SET rut = '" + rut +
                        "', nombre = ' " + nombre+ 
                        "', fechaDeNacimiento =' " + fechaDeNacimiento   +
                        "', direccion =' " + direccion      + 
                        "', telefono =' " +  telefono  +
                        "' WHERE rut = " + rut+ ";";
        
        try {
            Paciente pacienteEncontrado = buscarPacientePorId(rut);
            if(pacienteEncontrado != null){
               Statement ps = cx.getConnection().createStatement();
               
               int filasafectadas = ps.executeUpdate(query);
               helper.showInformation("Paciente actualizado.");
                return filasafectadas > 0 ;
                
                
            }else{
            helper.showError("Paciente no encontrado");
            return false;    
            }
            
        }catch (Exception e){
            helper.showError("ERROR"+ e.getMessage());
        }
        return false;
    }
    
    
    
    
    
    
    
    public boolean eliminarPaciente(int rut){
        String query = "DELETE FROM paciente WHERE rut = " + rut + ";";
        
        Paciente pacienteEncontrado = buscarPacientePorId(rut);
        
        try {
            if(pacienteEncontrado != null){
            PreparedStatement st = cx.getConnection().prepareStatement(query);
            int filasafectadas = st.executeUpdate(query);
            
            
             helper.showInformation("Paciente eliminado.");
                return filasafectadas > 0 ;
                
                
            }else{
            helper.showError("Paciente no encontrado");
            return false;    
            }
            
            
        }catch (Exception e) {
        helper.showError("error");
        }
        return false;
    }
    
    
    
    
}//lavefinal


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
        
    
    
    
    
    


