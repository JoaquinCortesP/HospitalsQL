/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Cetecom
 */
public class Conexion {
    String bd = "hospital";
    String url = "jdbc:mysql://localhost:3306/" + bd;
    String user = "root";
    String pass = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    
    
    Connection cx;
    
    
    
    public void conectar() {
    try {
      Class.forName(driver);
      cx = DriverManager.getConnection(url, user, pass);
      System.out.println("Conexión exitosa");
    }catch (ClassNotFoundException | SQLException e) {
      System.out.println("Error de conexión: " + e.getMessage());
    }

   }





  public void desconectar(){
    try {
      cx.close();
      System.out.println("Desconexión exitosa");
    } catch (Exception e) {
      System.out.println("Error desconectando de la BD: - " );
    }

  }



  
  
  
  
  //ITEM EVENT =  getItem() = devolver un elemento
  // ITEM EVENT = getStatementChange() = indicar si el elemento fue seleccionado o no
  //Statement = ejecuta consultas sin parametros
  //Result Set = manejar resultados sql que devuelve datos 
  //prepared statement =  Se ejecuta 
  
  

  public ResultSet EjecutarQuery(String query) throws SQLException {
      Statement st = cx.createStatement();
      return st.executeQuery(query);

  }



   

  public Connection getConnection(){
    return cx;
  }

   
    
}
