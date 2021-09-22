/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
/**
 *
 * @author olive
 */

public class Marca {
    private int id_Marca;
    private String marca;
    Conexion cn;
    public Marca(){}
    public Marca(int id_Marca, String marca) {
        this.id_Marca = id_Marca;
        this.marca = marca;
    }

    public int getId_Marca() {
        return id_Marca;
    }

    public void setId_Marca(int id_Marca) {
        this.id_Marca = id_Marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public HashMap drop_sangre(){
        HashMap<String,String> drop = new HashMap();
        
        try{
            String query ="SELECT id_Marcas as id,Marca from marcas;";
       cn= new Conexion();
        cn.abrir_conexion();
       ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
       while(consulta.next()){
       drop.put(consulta.getString("id"),consulta.getNString("Marca"));
       
       }
        cn.cerrar_conexion();
        }catch(SQLException ex) {
            
            System.out.println(ex.getMessage());
        }
        
        
        
        return drop;
    }
    
}
